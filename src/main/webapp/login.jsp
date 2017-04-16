<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page isELIgnored="false" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="es">
<head>
    <%@include file="head.jsp" %>
</head>
<body>
<%@include file="navbar.jsp" %>
<div class="access-container">
    <h1>Iniciar sesión</h1>
    <form class="register-form" action="shop" method="post" id="register-form">
        <input type="hidden" name="route" value="login">
        <fieldset>
            <legend>Datos generales</legend>
            <label for="email">Correo electrónico</label>
            <input type="email" id="email" name="email" value="" required>
            <label for="pass">Contraseña</label>
            <input type="password" id="pass" name="pass" value=""required>
        </fieldset>
        <div>
            <input class="register-button" type="submit" value="Acceder">
        </div>
    </form>
</div>
<%--<script src="../js/passwordCheck.js"></script>--%>
</body>
</html>
