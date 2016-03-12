/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package enchere.servlet;

import enchere.entity.Article;
import static enchere.entity.Article_.utilisateur;
import enchere.entity.Categorie;
import enchere.entity.Utilisateur;
import enchere.service.ArticleService;
import enchere.service.CategorieService;
import enchere.service.UtilisateurService;
import enchere.spring.AutowireServlet;
import java.io.IOException;
import java.lang.annotation.Documented;
import java.util.ArrayList;
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
@WebServlet(name = "RechercherArticleServlet", urlPatterns = {"/RechercherArticleServlet"})
public class RechercherArticleServlet extends AutowireServlet {

    @Autowired
    private ArticleService articleService;

    @Autowired
    private CategorieService categorieService;

    @Autowired
    private UtilisateurService utilisateurService;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Utilisateur u = utilisateurService.findByLogin((String) req.getSession().getAttribute("login"));
        List<Article> listeArticle = articleService.findByUtilisateur(u);
        Boolean listevide=false;
        if(listeArticle.isEmpty()){
            listevide=true;
        }
        req.setAttribute("listevide", listevide);
        req.setAttribute("listeArticle", listeArticle);
        req.getRequestDispatcher("liste_article.jsp").forward(req, resp);
    }
    
    

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<Article> listeArticle = new ArrayList<>();
        //Recherche par Categorie
        if (!"".equals(req.getParameter("categorie"))) {
            Categorie c = categorieService.findByNom(req.getParameter("categorie"));
            listeArticle = articleService.findByCategorie(c);
        }
        //Recherche par Utilisateur
        if (!"".equals(req.getParameter("utilisateur"))) {
            Utilisateur u = utilisateurService.findByLogin(req.getParameter("utilisateur"));
            listeArticle = articleService.findByUtilisateur(u);
        }
        //Recherche par Nom
        if (!"".equals(req.getParameter("nom"))) {
            if (articleService.findByNom(req.getParameter("nom")) != null) {
                listeArticle.add(articleService.findByNom(req.getParameter("nom")));
            }
        }
        System.out.println(listeArticle);
        Boolean listevide = false;
        if (listeArticle.isEmpty()) {
            listevide = true;
        }
        
        req.setAttribute("listevide", listevide);
        req.setAttribute("listeArticle", listeArticle);
        req.getRequestDispatcher("liste_article.jsp").forward(req, resp);

    }

}
