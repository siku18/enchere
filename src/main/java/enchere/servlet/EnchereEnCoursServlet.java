/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package enchere.servlet;

import enchere.entity.Article;
import enchere.entity.Utilisateur;
import enchere.service.ArticleService;
import enchere.service.ArticlesEncheriesService;
import enchere.service.RafraichiDisponibleService;
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
@WebServlet(name = "EnchereEnCoursServlet", urlPatterns = {"/EnchereEnCoursServlet"})
public class EnchereEnCoursServlet extends AutowireServlet {

    @Autowired
    private ArticleService articleService;

    @Autowired
    private ArticlesEncheriesService articlesEncheriesService;

    @Autowired
    private UtilisateurService utilisateurService;
    
    @Autowired
    private RafraichiDisponibleService rafraichiDisponibleService;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<Article> listeArticles=(List<Article>) articleService.findAll();
        for (Article a :listeArticles){
            rafraichiDisponibleService.ActualisDisponnible(a);
        }
        
        
        Utilisateur u = utilisateurService.findByLogin((String) req.getSession().getAttribute("login"));
        List<Article> listeArticlesUtil = articlesEncheriesService.articlesEncheries(u);
        req.setAttribute("listeArticlesUtil", listeArticlesUtil);
        req.getRequestDispatcher("liste_articles_encheris.jsp").forward(req, resp);
    }
}
