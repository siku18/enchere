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
        Long id = Long.parseLong(req.getParameter("id"));

        System.out.println((String) req.getSession().getAttribute("login"));
        
        List<Utilisateur> util=utilisateurService.findByLogin((String) req.getSession().getAttribute("login"));
        Utilisateur u = util.get(0);

        List<Article> listeArticle = articleService.findByUtilisateur(u);

        Article article = new Article();
        for (Article a : listeArticle) {
            if (a.getId() == id) {
                article = a;
            }
        }
        
        Categorie c = article.getCategorie();
        Utilisateur u1 = article.getUtilisateur();
        
        req.setAttribute("Utilisateur", u1);
        req.setAttribute("Categorie", c);
        req.setAttribute("article", article);
        req.getRequestDispatcher("detail_article.jsp").forward(req, resp);
    }
}
