/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package enchere.filter;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;


/**
 *
 * @author admin
 */
@WebFilter(filterName = "UtilConnecteFilter", urlPatterns = {"/supprimerServlet","/AjouterServlet"})
public class PageAccessibleLoggerFilter implements Filter {
       @Override
    public void init(FilterConfig fc) throws ServletException {
    }

    @Override
    public void doFilter(ServletRequest sr, ServletResponse sr1, FilterChain fc) throws IOException, ServletException {
        System.out.println(sr.getLocalAddr());
        HttpServletRequest req= (HttpServletRequest)sr;
        
        boolean accesAutoriser= true;
        if (req.getSession().getAttribute("login") == null){
            accesAutoriser= false;
            req.setAttribute("accesAutoriser", accesAutoriser);
            req.getRequestDispatcher("login.jsp").forward(req, sr1);
        }
        else{
            fc.doFilter(sr, sr1);
        }
    }

    @Override
    public void destroy() {
    }
}
