/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package enchere.servlet;

import enchere.entity.Article;
import enchere.entity.Utilisateur;
import enchere.service.InscriptionService;
import enchere.spring.AutowireServlet;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;

/**
 *
 * @author admin
 */
@WebServlet(name = "AjouterUtilisateurServlet", urlPatterns = {"/AjouterUtilisateurServlet"})
public class AjouterUtilisateurServlet extends AutowireServlet {

    @Autowired
    private InscriptionService inscriptionService;

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("***********************");
        
        
        Utilisateur u = new Utilisateur();
        u.setNom((String) req.getAttribute("nom"));
        u.setPrenom((String) req.getAttribute("prenom"));
        u.setLogin((String) req.getAttribute("login"));
        u.setMdp((String) req.getAttribute("mdp"));
        u.setEmail((String) req.getAttribute("email"));

        String EtatInscription = inscriptionService.inscription(u);
        
        System.out.println("00000000000000000000000000");
        req.setAttribute(EtatInscription, EtatInscription);
        
        System.out.println(EtatInscription);
        req.setAttribute("Utilisateur", u);
        req.getRequestDispatcher("home.jsp").forward(req, resp);
    }
}
