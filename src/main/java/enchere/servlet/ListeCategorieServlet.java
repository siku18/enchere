/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package enchere.servlet;

import enchere.entity.Categorie;
import enchere.service.CategorieService;
import enchere.spring.AutowireServlet;
import java.io.IOException;
import java.time.Instant;
import java.util.Date;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
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
        
        //Pour obliger une valeur minimum de la date lors de la saisie de la creation de l'article
        Date date= new Date().from(Instant.now());
        req.setAttribute("date", date);
        if (req.getParameter("url").equals("ajouterArticle")) {
            req.getRequestDispatcher("ajouter_article.jsp").forward(req, resp);
        }
        if (req.getParameter("url").equals("rechercherArticle")) {
            req.getRequestDispatcher("rechercher_article.jsp").forward(req, resp);
        }
    }
}
