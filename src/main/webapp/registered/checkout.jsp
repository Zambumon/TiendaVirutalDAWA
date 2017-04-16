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
<%--@elvariable id="address" type="dawa.model.VOs.Address"--%>

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
    <c:forEach var="lineItem" items="${cart.lines}">
        <tr>
            <td>${lineItem.item.name}</td>
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
    <form action="shop" method="post">
        <input type="hidden" name="route" value="confirm">
        <p>Primera linea: ${address.firstLine}</p>
        <p>Segunda linea: ${address.secondLine}</p>
        <p>Codigo postal: ${address.postCode}</p>
        <p>Pais: ${address.country}</p>

        <input type="hidden" name="user" value="${user.email}">
        <input type="submit" value="Confirmar compra">
    </form>
</div>

</body>
</html>