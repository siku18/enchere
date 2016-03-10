<%-- 
    Document   : Ajouter_utilisateur
    Created on : 10 mars 2016, 15:13:23
    Author     : admin
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<c:import url="_TITRE.jsp"/>
<c:import url="_MENU.jsp"/>
<form action="AjouterUtilisateurServlet" method="post">
    <label>Nom</label>
    <input type="text" name="nom"/>
    <br>
    <label>Prenom</label>
    <input type="text" name="prenom"/>
    <br>
    <label>Login</label>
    <input type="text" name="login"/>
    <br>
    <label>Mot de passe</label>
    <input type="text" name="mdp"/>
    <br>
    <label>Adresse email</label>
    <input type="text" name="email"/>
    <br>
    <input type="submit"/>
</form>

<c:import url="_PIED.jsp"/>
