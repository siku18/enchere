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
        
        if (!req.getRequestURI().equals("/enchere/AjouterArticleServlet")) {
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
                categorieService.save(c);
                categorie = categorieService.findByNom(ajoutcat);
                System.out.println("99999999999999999999999999999999");
            }

            //Récupération de l'utilisateur qui crée l'article
            List<Utilisateur> util = utilisateurService.findByLogin((String) req.getSession().getAttribute("login"));
            Utilisateur u = util.get(0);

            //Sauvegarde de l'utilisateur (et de l'article)
            u.getArticles().add(a);
            a.setUtilisateur(u);

            //Sauvegrde de la categorie (et de l'article)
            categorieService.save(categorie);
            utilisateurService.save(u);
//        articleService.save(a);
        }
        List<Categorie> listeCategorie = (List<Categorie>) categorieService.findAll();
        System.out.println("******************************");
        System.out.println(listeCategorie);
        System.out.println("******************************");
        req.setAttribute("listeCategorie", listeCategorie);

        req.getRequestDispatcher("article_ajouter.jsp").forward(req, resp);

    }
}
