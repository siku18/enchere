/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package enchere.servlet;

import enchere.entity.Article;
import enchere.entity.Categorie;
import enchere.entity.Utilisateur;
import enchere.service.ArticleService;
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
@WebServlet(name = "DetailArticleServlet", urlPatterns = {"/DetailArticleServlet"})
public class DetailArticleServlet extends AutowireServlet {

    @Autowired
    private ArticleService articleService;

    @Autowired
    private UtilisateurService utilisateurService;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        List<Article> listeArticle = (List<Article>) articleService.findAll();
        
        Article article = new Article();
        Long id = Long.parseLong(req.getParameter("id"));
        System.out.println("*********************************");
        System.out.println(id);
        for (Article a : listeArticle) {
            if (a.getId().equals(id)) {
                article = a;
                System.out.println("*********************************");
                System.out.println(article.getNom());
            }
        }
        
        String utilLoger = (String) req.getSession().getAttribute("login");
        Utilisateur u2 = article.getUtilisateur();
        System.out.println("*********************************");
        System.out.println(utilLoger);
        System.out.println(u2.getLogin());
        Boolean droitEncherir=false;
        if (!utilLoger.equals(u2.getLogin())){
            droitEncherir=true;
        }
        Categorie c = article.getCategorie();
        req.setAttribute("categorie", c);
        req.setAttribute("utilisateur", u2);
        req.setAttribute("droitEncherir", droitEncherir);
        req.setAttribute("article", article);
        req.getRequestDispatcher("detail_article.jsp").forward(req, resp);
    }
}
