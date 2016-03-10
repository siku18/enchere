<%-- 
    Document   : _MENU
    Created on : 8 mars 2016, 14:50:41
    Author     : admin
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>

<body class="menu">
    <div style="text-align: center">
        <a href="Ajouter_utilisateur.jsp">S'inscrire</a> 
        <br>
        <a href="choix_style.jsp">Choisis ton style</a> 
        <br>
    <c:if test="${sessionScope.login==null}">
        <a href="login.jsp">Se connecter</a>
    </c:if>
    <c:if test="${sessionScope.login!=null}">
        <a href="se_deconnecter">Se deconnecter</a>
    </c:if>

        
    </div>


