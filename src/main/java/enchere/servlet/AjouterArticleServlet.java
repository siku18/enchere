/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package enchere.servlet;

import enchere.entity.Article;
import enchere.entity.Categorie;
import enchere.entity.Utilisateur;
import enchere.service.CategorieService;
import enchere.service.UtilisateurService;
import enchere.spring.AutowireServlet;
import java.io.IOException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;

/**
 *
 * @author admin
 */
@WebServlet(name = "AjouterArticleServlet", urlPatterns = {"/AjouterArticleServlet"})
public class AjouterArticleServlet extends AutowireServlet {

    @Autowired
    private CategorieService categorieService;

    @Autowired
    private UtilisateurService utilisateurService;

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        Article a = new Article();
        a.setNom((String) req.getParameter("nom"));
        a.setPrix(Long.parseLong(req.getParameter("prix")));
        a.setDescription((String) req.getParameter("description"));
        a.setDescription((String) req.getParameter("dateExpiration"));

        String cat = req.getParameter("categorie");
        String ajoutcat = (String) req.getParameter("ajoutCategorie");

        //recuperation de la categorie
        Categorie categorie = categorieService.findByNom(cat);

        //Cas ou l'on crée une nouvelle categorie
        Categorie c = new Categorie();
        if (!"".equals(ajoutcat)) {
            if (categorieService.findByNom(cat) == null) {
                c.setNom(ajoutcat);
                //Récupération de la objet de classe Categorie ajouter
                categorie = c;
                //Sauvegarde de la categorie pour attribution d'un id
                categorieService.save(c);
            }
        }
        //Récupération de l'utilisateur qui crée l'article
        Utilisateur u = utilisateurService.findByLogin((String) req.getSession().getAttribute("login"));

        //Set de l'utilisateur associer
        u.getArticles().add(a);
        a.setUtilisateur(u);

        //Sauvegarde de la categorie (de l'article, et de l'utilisateur)
        System.out.println(c);
        categorie.getArticles().add(a);
        a.setCategorie(categorie);
        categorieService.save(categorie);

//        articleService.save(a);
        req.getRequestDispatcher("article_ajouter.jsp").forward(req, resp);

    }
}
