/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package enchere.servlet;

import enchere.entity.Article;
import enchere.entity.Enchere;
import enchere.service.ArticleService;
import enchere.service.EnchereService;
import enchere.spring.AutowireServlet;
import java.io.IOException;
import java.util.Date;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;

/**
 *
 * @author ok
 */
@WebServlet(name = "EnchereServlet", urlPatterns = {"/EnchereServlet"})
public class EnchereServlet extends AutowireServlet {

    @Autowired
    private ArticleService articleService;

    @Autowired
    private EnchereService enchereService;

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Long montant = Long.parseLong((String) req.getParameter("enchere"));
        Long id = Long.parseLong((String) req.getParameter("id"));
        Article a = articleService.findOne(id);
        Enchere enchere = new Enchere();
        Date aujourdhui = new Date();
        System.out.println("******************************");
        System.out.println(aujourdhui);
        System.out.println(aujourdhui.getTime());

        boolean montantInsuffisant = false;
        boolean enchereEffectue = false;
        if (a.getDateExpirationEnchere().before(aujourdhui)) {
            System.out.println("0000000000000000000000000000");
            a.setDisponible(false);
            articleService.save(a);
            System.out.println("11111111111111111111111111111");
        } else if (montant < a.getPrix()) {
            System.out.println("22222222222222222222222222222");
            enchereEffectue = true;
            a.setPrix(montant);
            a.getEnchere().add(enchere);
            enchere.setArticle(a);
            enchereService.save(enchere);
            System.out.println("33333333333333333333333333");
            req.setAttribute("enchereEffectue", enchereEffectue);
            req.getRequestDispatcher("DetailArticleServlet?id=" + id);
        } else {
            montantInsuffisant = true;
            System.out.println("44444444444444444444444444444444");
            req.setAttribute("enchereEffectue", enchereEffectue);
            req.setAttribute("montantInsuffisant", montantInsuffisant);
            req.getRequestDispatcher("DetailArticleServlet?id=" + id);
        }
    }
}
