<%-- 
    Document   : login
    Created on : 9 mars 2016, 16:20:20
    Author     : admin
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>

<c:import url="_TITRE.jsp"/>
<c:import url="_MENU.jsp"/>

<form action="loginServlet" method="post">
    <c:if test="${estLogger==false}">
        <div>Login ou mot de passe Errone, veuillez reessayer</div>
    </c:if>
    <c:if test="${accesAutoriser==false}">
        <div>Vous n'avez pas acces a cette page ! Logger vous pour y acceder</div>
    </c:if>
    <label>login</label>
    <input type="text" name="login"/>
    <br>
    <label>mdp</label>
    <input type="text" name="mdp"/>
    <br>
    <input type="submit"/>
</form>

<c:import url="_PIED.jsp"/>