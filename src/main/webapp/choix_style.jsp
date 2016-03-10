<%-- 
    Document   : choix_style
    Created on : 9 mars 2016, 14:54:54
    Author     : admin
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<c:import url="_TITRE.jsp"/>
<c:import url="_MENU.jsp"/>

        <div>
            <a href="Choix_styleServlet?style=blue">Style blue</a>
        </div>
        <div>
            <a href="Choix_styleServlet?style=red">Style red</a>
        </div>
        <div>
            <a href="Choix_styleServlet?style=yellow">Style yellow</a>
        </div>
<c:import url="_PIED.jsp"/>
