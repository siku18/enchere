/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package enchere.servlet;

import enchere.entity.Article;
import enchere.entity.Categorie;
import enchere.entity.Enchere;
import enchere.entity.Utilisateur;
import enchere.service.ArticleService;
import enchere.service.EnchereService;
import enchere.service.RafraichiDisponibleService;
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
    private EnchereService enchereService;
    
    @Autowired
    private RafraichiDisponibleService rafraichiDisponibleService;

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doGet(req, resp);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //Raffraichi la liste des article (set disponnible)
        List<Article> listeArticle = (List<Article>) articleService.findAll();
        for (Article a :listeArticle){
            rafraichiDisponibleService.ActualisDisponnible(a);
        }
        Article article = new Article();
        Long id = Long.parseLong(req.getParameter("id"));
        System.out.println(id);
        for (Article a : listeArticle) {
            if (a.getId().equals(id)) {
                article = a;
                System.out.println(article.getNom());
            }
        }

        String utilLoger = (String) req.getSession().getAttribute("login");
        Utilisateur u2 = article.getUtilisateur();
        Boolean droitEncherir = false;
        if (!utilLoger.equals(u2.getLogin())) {
            droitEncherir = true;
        }
        Utilisateur encherisseur= new Utilisateur();
        System.out.println(article.getEnchere());
        encherisseur.setLogin("Aucun");
        List<Enchere> listeEnchere = enchereService.findByArticle(article);
        if (!listeEnchere.isEmpty()) {
            System.out.println("8888888888888888999999999999999999999111111111111111111");
            encherisseur = listeEnchere.get(listeEnchere.size()-1).getUtilisateur();
        }
        Categorie c = article.getCategorie();
        req.setAttribute("encherisseur", encherisseur);
        req.setAttribute("categorie", c);
        req.setAttribute("utilisateur", u2);
        req.setAttribute("droitEncherir", droitEncherir);
        req.setAttribute("article", article);
        req.getRequestDispatcher("detail_article.jsp").forward(req, resp);
    }
}
