<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
    <%@include file="/utils/head.jsp" %>
</head>
<body>
<%@include file="/utils/navbar.jsp" %>
<div class="profile-wrapper">
    <h1>Perfil de usuario</h1>
    <form action="shop" method="post">
        <%--TODO --%>
        <input type="hidden" name="todo" value="todo">
        <fieldset>
            <legend>Datos generales</legend>
            <label for="user-email">Correo electrónico</label>
            <input type="text" id="user-email" name="user-email" value="${user.email}" readonly>
            <label for="user-name">Nombre de usuario</label>
            <input type="text" id="user-name" name="user-name" value="${user.name}">
            <label for="user-type">Tipo de cuenta de usuario</label>
            <input type="text" id="user-type" value="${user.type}" readonly>
        </fieldset>
        <c:if test="${user.registered && user.type == 'ADMIN'}">
            <fieldset>
                <legend>Editar tipo de cuenta</legend>
                <select name="role" id="role">
                    <option value="basic">Básico</option>
                    <option value="vip">VIP</option>
                    <option value="admin">Administrador</option>
                </select>
            </fieldset>
        </c:if>
        <fieldset>
            <legend>Cambiar contraseña</legend>
            <label for="pass">Nueva contraseña</label>
            <input type="password" id="pass" name="pass" value="" placeholder="Contraseña">
            <label for="pass">Confirmar nueva contraseña</label>
            <input type="password" id="passcheck" name="passcheck" value="" placeholder="Confirmar contraseña">
        </fieldset>
        <fieldset>
            <legend>Dirección de envío</legend>
            <input type="text" id="addressFirstLine" name="addressFirstLine" value="${address.firstline}" readonly>
            <input type="text" id="addressSecondLine" name="addressSecondLine" value="${address.secondline}" readonly>
            <input type="text" id="addressPostcode" name="addressPostcode" value="${address.postcode}" readonly>
            <input type="text" id="country" name="country" value="${address.country}" readonly>
        </fieldset>
        <div class="centered-form-input">
            <input type="submit" class="register-button" value="Modificar cuenta">
        </div>
    </form>



    <div>
        <form action="deleteAccount" method="post">
            <input type="hidden" name="userId" value="${user}">
            <div class="centered-form-input">
                <input type="submit" class="ok-bye" value="Eliminar cuenta de usuario">
            </div>

        </form>
    </div>
</div>

<script src="js/password.js"></script>
</body>
</html>