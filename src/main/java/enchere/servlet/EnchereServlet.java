/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package enchere.servlet;

import enchere.entity.Article;
import enchere.entity.Enchere;
import enchere.entity.Utilisateur;
import enchere.service.ArticleService;
import enchere.service.EnchereService;
import enchere.service.UtilisateurService;
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
    
    @Autowired 
     private UtilisateurService utilisateurService;

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Long montant = Long.parseLong((String) req.getParameter("enchere"));
        Long id = Long.parseLong((String) req.getParameter("id"));
        Article a = articleService.findOne(id);
        Date aujourdhui = new Date();
        System.out.println(aujourdhui);
        System.out.println(aujourdhui.getTime());

        Utilisateur encherisseur;
        encherisseur = utilisateurService.findByLogin((String)req.getSession().getAttribute("login"));
        boolean montantInsuffisant = false;
        boolean enchereEffectue = false;
        //Cas ou la date d expiration est dépassé
        if ((a.getDateExpirationEnchere().getTime())-(aujourdhui.getTime())<0) {
            a.setDisponible(false);
            enchereEffectue=false;
            articleService.save(a);
        }
        else if (montant > a.getPrix()) {
            //Sauvegarde du nouveau prix
            enchereEffectue = true;
            a.setPrix(montant);
            articleService.save(a);
            
            //Creation de l'enchere
            Enchere enchere = new Enchere();
            a.getEnchere().add(enchere);
            enchere.setArticle(a);
            enchere.setDate(aujourdhui);
            encherisseur.getEncheres().add(enchere);
            enchere.setUtilisateur(encherisseur);
            
            enchereService.save(enchere);
            req.setAttribute("enchereEffectue", enchereEffectue);
            req.getRequestDispatcher("DetailArticleServlet?id="+id).forward(req, resp);
        } else {
            montantInsuffisant = true;
            enchereEffectue=false;
            req.setAttribute("enchereEffectue", enchereEffectue);
            req.setAttribute("montantInsuffisant", montantInsuffisant);
            req.getRequestDispatcher("DetailArticleServlet?id=" + id).forward(req, resp);
        }
    }
}
