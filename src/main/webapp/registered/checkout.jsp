<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
    <%@include file="/utils/head.jsp" %>
</head>
<body>
<%@include file="/utils/navbar.jsp" %>
<%--@elvariable id="cart" type="dawa.model.VOs.Cart"--%>
<%--@elvariable id="user" type="dawa.model.VOs.Registered"--%>
<%--@elvariable id="discount" type="java.lang.String"--%>
<%--@elvariable id="total" type="java.lang.String"--%>

<h1>Datos del pedido</h1>
<table>
    <thead>
    <tr>
        <th>Nombre</th>
        <th>Precio</th>
        <th>Cantidad</th>
        <th>IVA</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach var="lineItem" items="${cart}">
        <tr>
            <td>${lineItem.name}</td>
            <td>${lineItem.price}</td>
            <td>${lineItem.amount}</td>
            <td>${lineItem.taxes}</td>
            <td>${lineItem.price * lineItem.taxes * lineItem.amount}</td>
        </tr>
    </c:forEach>

    </tbody>
</table>
<div>
    <p>Subtotal: ${cart.price} €</p>
    <c:if test="${user.type == 'VIP'}">
        <p>Descuento: ${discount} %</p>
    </c:if>
    <p>Total (IVA Incluido): ${total} €</p>
</div>

<div>
    <h2>Dirección de envío</h2>
    <c:choose>
        <c:when test="${addressList}">
            <form action="addShippingAddress">
                <input type="hidden" name="userId" value="${user.getId()}">
                <input type="text" name="addressFirstLine" value="" required>
                <input type="text" name="addressSecondLine" value="" required>
                <input type="text" name="addressPostcode" value="" required>
                <input type="text" name="country" value="" required>
                <input type="submit" value="Añadir dirección">
            </form>
        </c:when>
        <c:otherwise>
            <form action="confirmOrder" method="post"></form>
            <select name="cars">
                <c:forEach var="address" items="${addressList}">
                    <option value="${address}">${address.getFirstLine()} ${address.getSecondLine()} ${address.getPostCode()}
                            ${address.getCountry()}</option>
                </c:forEach>
            </select>
            <input type="hidden" name="user" value="${sessionScope.user}">
            <input type="hidden" name="orderCart" value="${sessionScope.cart}">
            <input type="submit" value="Confirmar compra">
        </c:otherwise>
    </c:choose>

</div>


</body>
</html>