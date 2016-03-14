<%-- 
    Document   : liste_articles_encheris
    Created on : 14 mars 2016, 15:17:16
    Author     : admin
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>

<c:import url="_TITRE.jsp"/>
<c:import url="_MENU.jsp"/>
<c:forEach items="${listeArticlesUtil}" var="monArticle">
    <BR>
        <DIV>
            Nom de l'article = <a href="DetailArticleServlet?id=${monArticle.id}">${monArticle.nom}</a>
        </DIV>
    <BR>
</c:forEach>
<c:import url="_PIED.jsp"/>