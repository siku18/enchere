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
import java.io.PrintWriter;
import java.time.Instant;
import java.util.Date;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;

/**
 *
 * @author ok
 */
@WebServlet(name = "ListeCategorieServlet", urlPatterns = {"/ListeCategorieServlet"})
public class ListeCategorieServlet extends AutowireServlet {

    @Autowired
    private CategorieService categorieService;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        List<Categorie> listeCategorie = (List<Categorie>) categorieService.findAll();
        System.out.println(listeCategorie);
        if (listeCategorie.isEmpty()) {
            Categorie c = new Categorie();
            c.setNom("Livres");
            categorieService.save(c);
            listeCategorie.add(c);
        }
        req.setAttribute("listeCategorie", listeCategorie);
        Date date= new Date().from(Instant.now());
        System.out.println("**************************");
        System.out.println(date);
        req.setAttribute("date", date);
        if (req.getParameter("url").equals("ajouterArticle")) {
            req.getRequestDispatcher("ajouter_article.jsp").forward(req, resp);
        }
        if (req.getParameter("url").equals("rechercherArticle")) {
            req.getRequestDispatcher("rechercher_article.jsp").forward(req, resp);
        }
    }
}
