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
            <Br>
            <a href="home.jsp">Menu</a> 
        </div>
    </c:if>
    <!--Utilisateur deconnecte-->
    <c:if test="${sessionScope.login!=null}">
        <br>
        <br>
        <div>
            <a href="ListeCategorieServlet?url=ajouterArticle">Mettre un article aux encheres</a<!--ajout d'un article-->
        </div
        <br>
        <br>
        <div>
            <a href="RechercherArticleServlet?url=mesArticles">Mes articles mis en vente</a<!--ajout d'un article-->
        </div
        <br>
        <br>
        <div>
            <a href="ListeCategorieServlet?url=rechercherArticle">Rechercher un Article</a><!--Recherche par categorie + Nom d'article + Possibilité encherir-->
        </div>
        <br>
        <br>
        <div>
            <a href="EnchereEnCoursServlet">Mes encheres en cours</a><!--Liste des enchère + Possibilité de sur-encherir-->
        </div>
        <br>
        <br>
        <div>
            <a href="EnchereRemporteServlet">Encheres remportees</a><!--Liste des enchère + Possibilité de payé les enchere-->
        </div>
        <br>
        <br>
        <div>
            <a href="se_deconnecter">Se deconnecter</a>
        </div>
        <br>
        <br>
    </c:if>



