/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package enchere.servlet;

import enchere.spring.AutowireServlet;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author admin
 */
@WebServlet(name = "Choix_styleServlet", urlPatterns = {"/Choix_styleServlet"})
public class ChoixStyleServlet extends AutowireServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Cookie styleCookie = new Cookie("style", "");
        String style = req.getParameter("style");
        
        if (style.equals("blue")) {
            styleCookie.setValue("blue");
            System.out.println("On est rentré dans le blue");
        }
        else if(style.equals("red")){
            styleCookie.setValue("red");
        }
        else if(style.equals("yellow")){
            styleCookie.setValue("yellow");
        }
        resp.addCookie(styleCookie);
        
        req.getRequestDispatcher("home.jsp").forward(req, resp);
    }
}
