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
    <h1>Cuenta de ${user.getEmail()}</h1>
</div>
<div>
    <h2>Datos personales</h2>
    <p>ID: ${otherUser.getId()}</p>
    <p>Email: ${otherUser.getEmail()}</p>
    <p>Tipo de cuenta: ${otherUser.getType()}</p>
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
        <p>Cambiar contraseña</p>
        <form action="changePassword" method="post">
            <input type="hidden" name="userId" value="${otherUser.getId()}">
            <input type="password" id="pass" name="pass" value="" placeholder="Contraseña" required>
            <input type="text">
        </form>
    </div>
    <div>
        <form action="deleteAccount" method="post">
            <input type="hidden" name="userId" value="${otherUser}">
            <input type="submit" value="Eliminar cuenta">
        </form>
    </div>
</div>

</body>
</html>