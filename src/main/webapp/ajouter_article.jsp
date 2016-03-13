<%-- 
    Document   : ajouter_article
    Created on : 11 mars 2016, 09:58:52
    Author     : admin
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>

<c:import url="_TITRE.jsp"/>
<c:import url="_MENU.jsp"/>

<form action="AjouterArticleServlet" method="post">
    <label>Nom</label>
    <input type="text" name="nom"/>
    <br>
    <label>Prix de debut d'enchere</label>
    <input type="text" name="prix"/>
    <br>
    <label>Description de l'article</label>
    <textarea name="description"></textarea>
    <br>
    <label>Categorie</label>
    <SELECT name="categorie" id='style'>
        <option selected="Aucune">Aucune</option>
        <c:forEach items="${listeCategorie}" var="Categorie">
            <OPTION>${Categorie.nom}
        </c:forEach>
    </SELECT>
    <br>
    <label>Categorie inexistante, ajouter une categorie ?</label>
    <br>
    <input type="text" name="ajoutCategorie"/>
    <br>
    <label>Date d expiration de l enchere</label>
    <br>
    <input type="datetime" name="dateExpiration" min="${date}"/>
    <br>
    <input type="submit"/>
</form>

<c:import url="_PIED.jsp"/>
