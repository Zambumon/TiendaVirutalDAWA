<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
    <%@include file="/utils/head.jsp" %>
</head>
<body>
<%@include file="/utils/navbar.jsp" %>
<h1>Carrito de la compra</h1>
<table>
    <thead>
    <tr>
        <th>Nombre</th>
        <th>Precio</th>
        <th>Cantidad</th>
        <th>IVA</th>
        <th>Subtotal</th>
        <th>Eliminar</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach var="cartItem" items="${cart}">
        <tr>
            <td>${cartItem.getName()}</td>
            <td>${cartItem.getPrice()}</td>
            <td>${cartItem.getAmount()}</td>
            <td>${cartItem.getTaxes()}</td>
            <%--TODO--%>
            <td>${cartItem.getTaxes()}</td>
            <td>
                <form action="removeFromCart" method="post">
                    <input type="submit" value="remove">
                    <input type="hidden" name="itemId" value="${cartItem.getName()}">
                </form>
            </td>
        </tr>
    </c:forEach>

    </tbody>
</table>
<div>
    <p>Subtotal: ${subtotal} €</p>
    <p>Total (IVA Incluido): ${total} €</p>
    <a href="index.jsp">Añadir más productos al carrito</a>
    <c:choose>
        <c:when test="${user.type == 'REGISTERED'}">
            <a href="registered/checkout.jsp">Ir a la caja</a>
        </c:when>
        <c:otherwise>"
            <p>Debe <a href="access/login.jsp">iniciar sesión</a> para poder continuar</p>

        </c:otherwise>
    </c:choose>
</div>


</body>
</html>
