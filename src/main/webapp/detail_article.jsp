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
    Description : ${article.description}
</div>
<div>
    Categorie : ${categorie.nom}
</div>
    Vendeur : ${utilisateur.login}
<div>
    Montant de la derniere enchere : ${article.prix}
</div>
<div>
    Date d'expiration de l'enchere : ${article.dateExpirationEnchere}
</div>
<c:if test="${enchereEffectue==true}">
<div>
    Dernier encherisseur : ${encherisseur.login}
</div>
</c:if>
<c:if test="${droitEncherir==true}">
    <div>
        Encherir:
        <form action="EnchereServlet" method="post">
            <input type="text" name="enchere"/>
            <input type="hidden" name="id" value="${article.id}">
            <br>
            <input type="submit"/>
        </form>
    </div>
</c:if>
    
<c:if test="${article.disponible==false}">
    <div>
        L'article n'est plus disponible a la vente !
    </div>
</c:if>
<c:if test="${montantInsuffisant==true}">
    <div>
        Montant de l'enchere Insuffisant ! Le montant de l'enchere doit etre superieur au montant de l'enchere precedente
    </div>
</c:if>
<c:import url="_PIED.jsp"/>