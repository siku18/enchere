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
        System.out.println("******************************");
        System.out.println(listeCategorie);
        System.out.println("******************************");
        if (listeCategorie.isEmpty()){
            Categorie c = new Categorie();
            c.setNom("Livres");
            categorieService.save(c);
            listeCategorie.add(c);
        }
        req.setAttribute("listeCategorie", listeCategorie);

        req.getRequestDispatcher("ajouter_article.jsp").forward(req, resp);
    }
}
