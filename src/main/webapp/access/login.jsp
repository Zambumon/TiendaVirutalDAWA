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
<form action="" method="post" id="login-form">
    <input type="email" id="email" name="email" value="" placeholder="E-mail" required>
    <input type="password" id="pass" name="email" value="" placeholder="Contraseña" required>
    <input type="password" id="passcheck" name="email" value="" placeholder="Confirmar constraseña" required>

    <input type="submit" value="Acceder">

</form>
<script src="js/password.js"></script>
</body>
</html>
