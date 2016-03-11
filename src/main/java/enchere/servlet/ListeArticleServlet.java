/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package enchere.servlet;

import enchere.entity.Article;
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
@WebServlet(name = "ListeArticleServlet", urlPatterns = {"/ListeArticleServlet"})
public class ListeArticleServlet extends AutowireServlet {

    @Autowired
    private ArticleService articleService;
    
    @Autowired
    private UtilisateurService utilisateurService;
    
    
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
                
        List<Utilisateur> util=utilisateurService.findByLogin((String) req.getSession().getAttribute("login"));
        
        Utilisateur u = util.get(0);
        
        List<Article> listeArticle = articleService.findByUtilisateur(u);
        
        req.setAttribute("listeArticle", listeArticle);
        
//        req.getRequestDispatcher("DetailArticleServlet").include(req, resp);
        
        req.getRequestDispatcher("liste_article.jsp").forward(req, resp);
    }


}
