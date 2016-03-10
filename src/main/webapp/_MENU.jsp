<%-- 
    Document   : _MENU
    Created on : 8 mars 2016, 14:50:41
    Author     : admin
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>

<body class="menu">
    <!--Utilisateur connecte-->
    <c:if test="${sessionScope.login==null}">
        <div>
            <a href="login.jsp">Se connecter</a> 
            <a href="Ajouter_utilisateur.jsp">S'inscrire</a>
        </div>
    </c:if>
    <!--Utilisateur deconnecte-->
    <c:if test="${sessionScope.login!=null}">
        <br>
        <div>
            <a href="AjouterArticleServlet">Mettre un article aux encheres</a<!--ajout d'un article-->
        </div
        <br>
        <div>
            <a href="RechercherArticleServlet">Rechercher un Article</a><!--Recherche par categorie + Nom d'article + Possibilité encherir-->
        </div>
        <br>
        <div>
            <a href="EnchereEnCoursServlet">Mes encheres en cours</a><!--Liste des enchère + Possibilité de sur-encherir-->
        </div>
        <br>
        <div>
            <a href="EnchereRemporteServlet">Encheres remportees</a><!--Liste des enchère + Possibilité de payé les enchere-->
        </div>
        <br>
        <div>
            <a href="se_deconnecter">Se deconnecter</a>
        </div>

    </c:if>



