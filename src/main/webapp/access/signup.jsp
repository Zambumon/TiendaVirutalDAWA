<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page isELIgnored="false" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="es">
<head>
    <%@include file="/utils/head.jsp" %>
</head>
<body>
<%@include file="/utils/navbar.jsp" %>
<div class="access-container">
    <h1>Crear cuenta</h1>
    <form class="register-form" action="../shop" method="post" id="register-form">
        <input type="hidden" name="route" value="signup">
        <fieldset>
            <legend>Datos generales</legend>
            <label for="email">Correo electrónico</label>
            <input type="email" id="email" name="email" value="" required>
            <label for="username">Nombre de usuario</label>
            <input type="text" id="username" name="username" value="" required>
            <label for="pass">Contraseña</label>
            <input type="password" id="pass" name="pass" value=""required>
            <label for="passcheck">Confirmar contraseña</label>
            <input type="password" id="passcheck" name="passcheck" value="" required>
        </fieldset>
        <fieldset>
            <legend>Dirección de envío</legend>
            <label for="addressFirstLine">Primera línea</label>
            <input type="text" id="addressFirstLine" name="addressFirstLine" value="" required>
            <label for="addressSecondLine">Segunda línea</label>
            <input type="text" id="addressSecondLine" name="addressSecondLine" value="" required>
            <label for="addressSecondLine">Código postal</label>
            <input type="text" id="addressPostcode" name="addressPostcode" value="" required>
            <label for="addressSecondLine">País</label>
            <input type="text" id="country" name="country" value="" required>
        </fieldset>
        <div>
            <input class="register-button" type="submit" value="Registrarse">
        </div>
    </form>
</div>
<%--<script src="../js/passwordCheck.js"></script>--%>
</body>
</html>
