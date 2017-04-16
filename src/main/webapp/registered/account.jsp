<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
    <%@include file="/utils/head.jsp" %>
</head>
<body>
<%@include file="/utils/navbar.jsp" %>
<div>
    <h1>Mi cuenta</h1>
</div>
<div>
    <h2>Datos personales</h2>
    <p>Email: ${user.getEmail()}</p>
    <p>Tipo de cuenta: ${user.getType()}</p>
    <div>
        <p>Cambiar contraseña</p>
        <form action="changePassword" method="post">
            <input type="password" id="oldPass" name="oldPass" value="" placeholder="Antigua contraseña" required>
            <input type="password" id="pass" name="pass" value="" placeholder="Contraseña" required>
            <input type="password" id="passcheck" name="passcheck" value="" placeholder="Confirmar constraseña" required>
            <input type="submit" value="Confirmar">
        </form>
    </div>
    <div>
        <p>Editar rol de usuario</p>
        <form action="changeRole" method="post">
            <input type="hidden" name="userId" value="${otherUser.getId()}">
            <select name="role" id="role">
                <option value="basic">Básico</option>
                <option value="vip">VIP</option>
                <option value="admin">Administrador</option>
            </select>
        </form>
    </div>
    <div>
        <p>Direcciones de envio</p>
                        <div class="address">
                            <p>${address.getFirstLine()}</p>
                            <p>${address.getSecondLine()}</p>
                            <p>${address.getPostCode()}</p>
                            <p>${address.getCountry()}</p>
                        </div>
    </div>
    <div>
        <form action="deleteAccount" method="post">
            <input type="hidden" name="userId" value="${user}">
            <input type="submit" value="Eliminar cuenta">
        </form>
    </div>
</div>


<script src="js/password.js"></script>
</body>
</html>