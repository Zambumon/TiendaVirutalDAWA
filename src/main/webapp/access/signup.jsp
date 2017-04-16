<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page isELIgnored="false" %>
<%@ page contentType="text/html; charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="es">
<head>
    <%@include file="/utils/head.jsp" %>
</head>
<body>
<%@include file="/utils/navbar.jsp" %>
<h1>Iniciar sesión</h1>
<form action="../shop" method="post" id="login-form">
    <input type="hidden" name="route" value="signup">
    <input type="email" id="email" name="email" value="" placeholder="E-mail" required>
    <input type="email" id="username" name="username" value="" placeholder="Nombre de usuario" required>
    <input type="password" id="pass" name="pass" value="" placeholder="Contraseña" required>
    <input type="password" id="passcheck" name="passcheck" value="" placeholder="Confirmar constraseña" required>

    <input type="text" name="addressFirstLine" value="" placeholder="Primera línea" required>
    <input type="text" name="addressSecondLine" value="" placeholder="Segunda línea" required>
    <input type="text" name="addressPostcode" value="" placeholder="Código postal" required>
    <input type="text" name="country" value="" placeholder="País" required>

    <input type="submit" value="Acceder">
</form>
<%--<script src="../js/passwordCheck.js"></script>--%>
</body>
</html>
