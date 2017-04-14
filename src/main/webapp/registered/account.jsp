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
        <p>Direcciones de envio</p>
            <c:if test="${addressList.isEmpty() == false}">
                    <c:forEach var="address" items="${addressList}">
                        <div class="address">
                            <p>${address.getFirstLine()}</p>
                            <p>${address.getSecondLine()}</p>
                            <p>${address.getPostCode()}</p>
                            <p>${address.getCountry()}</p>
                        </div>
                    </c:forEach>
            </c:if>
        <div>
            <form action="addShippingAddress">
                <input type="hidden" name="userId" value="${user.getId()}">
                <input type="text" name="addressFirstLine" value="" required>
                <input type="text" name="addressSecondLine" value="" required>
                <input type="text" name="addressPostcode" value="" required>
                <input type="text" name="country" value="" required>
                <input type="submit" value="Añadir dirección">
            </form>
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