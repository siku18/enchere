/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package enchere.servlet;

import enchere.entity.Utilisateur;
import enchere.service.UtilisateurService;
import enchere.spring.AutowireServlet;
import java.io.IOException;
import java.util.ArrayList;
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
@WebServlet(name = "loginServlet", urlPatterns = {"/loginServlet"})
public class SessionLoginServlet extends AutowireServlet {

    @Autowired
    private UtilisateurService utilisateurService;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        //Creation d'utilisateurs
        List<Utilisateur> listeUtil = new ArrayList<>();

        if (listeUtil.size() == 0) {
            Utilisateur u1 = new Utilisateur();
            Utilisateur u2 = new Utilisateur();
            Utilisateur u3 = new Utilisateur();
            Utilisateur u4 = new Utilisateur();

            u1.setEmail("yo@yeah.com");
            u1.setId(1L);
            u1.setLogin("Utitil1");
            u1.setMdp("Utitil1");

            u2.setEmail("yahooch@yahoo.com");
            u2.setId(2L);
            u2.setLogin("Utitil2");
            u2.setMdp("Utitil2");

            u3.setEmail("Wrap@bimbamboum.com");
            u3.setId(3L);
            u3.setLogin("Utitil3");
            u3.setMdp("Utitil3");

            u4.setEmail("Wrap@bimbamboum.com");
            u4.setId(4L);
            u4.setLogin("Logger_man");
            u4.setMdp("Logger_man");

            listeUtil.add(u1);
            listeUtil.add(u2);
            listeUtil.add(u3);
        }

//         = new ArrayList<>();
//        listeUtilLogger.add(u4);
        List<Utilisateur> listeUtilLogger = (List<Utilisateur>) req.getSession().getAttribute("listeUtilLogger");
        if (listeUtilLogger == null) {
            listeUtilLogger = new ArrayList<>();
        }
        
        System.out.println(listeUtilLogger);
        // Est logger celui qui a le bon mdp et le bon loggin

        Boolean b = false;

        for (Utilisateur u : listeUtil) {
            System.out.println(u.getLogin());
            if ((u.getLogin().equals(req.getParameter("login"))) & ((u.getMdp().equals(req.getParameter("mdp"))))) {
                req.getSession().setAttribute("login", req.getParameter("login"));
                req.getSession().setAttribute("mdp", req.getParameter("mdp"));
                System.out.println("on a reconnu les login et mdp");
                listeUtilLogger.add(u);
                b = true;
            }
        }
        if (b == false) {
            System.out.println("on a PAS reconnu les login et mdp");
            req.setAttribute("b", b);
            req.getRequestDispatcher("login.jsp").forward(req, resp);
        }
        
        req.getSession().setAttribute("listeUtilLogger", listeUtilLogger);

        req.getRequestDispatcher("loger.jsp").forward(req, resp);
    }

}
