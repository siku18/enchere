/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package enchere.servlet;

import enchere.entity.Utilisateur;
import enchere.service.InscriptionService;
import enchere.spring.AutowireServlet;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
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

        Utilisateur u = new Utilisateur();
        u.setNom((String) req.getParameter("nom"));
        u.setPrenom((String) req.getParameter("prenom"));
        u.setLogin((String) req.getParameter("login"));
        u.setMdp((String) req.getParameter("mdp"));
        u.setEmail((String) req.getParameter("email"));


        Boolean etatInscription = inscriptionService.inscription(u);

        req.setAttribute("etatInscription", etatInscription);

        if (etatInscription == false) {
            req.getRequestDispatcher("Ajouter_utilisateur.jsp").forward(req, resp);
        } else {
            req.getRequestDispatcher("inscrit.jsp").forward(req, resp);
        }
    }
}
