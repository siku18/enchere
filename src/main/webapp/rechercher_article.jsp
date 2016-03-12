<%-- 
    Document   : rechercher_article
    Created on : 12 mars 2016, 18:11:56
    Author     : ok
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>

<c:import url="_TITRE.jsp"/>
<c:import url="_MENU.jsp"/>

<form action="RechercherArticleServlet" method="post">
    <label>Rechercher un article par son nom :</label>
    <input type="text" name="nom"/>
    <br>
    <label>Rechercher d'article par categorie :</label>
    <SELECT name="categorie">
        <option selected="Aucune">Aucune</option>
        <c:forEach items="${listeCategorie}" var="Categorie">
            <OPTION>${Categorie.nom}
        </c:forEach>
    </SELECT>
    <br>
    <label>Rechercher d'article par utilisateur :</label>
    <input type="text" name="utilisateur"/>
    <br>
    <input type="submit"/>
</form>

<c:import url="_PIED.jsp"/>