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
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doPost(req, resp);
    }
    
    

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("********************************");
        System.out.println(req.getRequestURI());
        System.out.println("********************************");

        Article a = new Article();
        a.setNom((String) req.getParameter("nom"));
        a.setPrix(Long.parseLong(req.getParameter("prix")));
        a.setDescription((String) req.getParameter("description"));

        String cat = req.getParameter("categorie");
        String ajoutcat = (String) req.getParameter("ajoutCategorie");

        //recuperation de la categorie
        Categorie categorie = categorieService.findByNom(cat);

        System.out.println(ajoutcat);

        //Cas ou l'on crée une nouvelle categorie
        Categorie c = new Categorie();
        if (!"".equals(ajoutcat)) {
            c.setNom(ajoutcat);
            //Récupération de la Categorie ajouter
            categorie = c;
        }

        //Récupération de l'utilisateur qui crée l'article
        List<Utilisateur> util = utilisateurService.findByLogin((String) req.getSession().getAttribute("login"));
        Utilisateur u = util.get(0);

        //Sauvegarde de l'utilisateur (et de l'article)
        u.getArticles().add(a);
        a.setUtilisateur(u);
//        utilisateurService.save(u);

        //Sauvegrde de la categorie (et de l'article)
        categorie.getArticles().add(a);
        a.setCategorie(categorie);
        categorieService.save(categorie);

//        articleService.save(a);

        req.getRequestDispatcher("article_ajouter.jsp").forward(req, resp);

    }
}
