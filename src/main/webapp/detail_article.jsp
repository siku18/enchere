<%-- 
    Document   : detail_article
    Created on : 11 mars 2016, 12:21:48
    Author     : admin
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<!DOCTYPE html>

<c:import url="_TITRE.jsp"/>
<c:import url="_MENU.jsp"/>



<div>
    Nom de l'article : ${article.nom}
</div>
<div>
    Description = ${article.description}
</div>
<div>
    Prix = ${article.prix}
</div>
<div>
    Categorie = ${Categorie}
</div>
<c:if test="${sessionScope.login}!=${Utilisateur}">
    <div>
    Utilisateur = ${Utilisateur}
</div>
</c:if>
<c:import url="_PIED.jsp"/>