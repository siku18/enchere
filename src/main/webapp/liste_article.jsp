<%-- 
    Document   : liste_article
    Created on : 11 mars 2016, 11:04:06
    Author     : admin
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>

<c:import url="_TITRE.jsp"/>
<c:import url="_MENU.jsp"/>

<c:forEach items="${listeArticle}" var="monArticle">
    <BR>
    <DIV>
        Nom de l'article = <a href="DetailArticleServlet?id=${monArticle.id}">${monArticle.nom}</a>
    </DIV>
        <BR>
</c:forEach>
<c:import url="_PIED.jsp"/>