<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<!DOCTYPE html>
<html>
<head>
    <%@include file="head.jsp" %>
</head>
<body>
<%--@elvariable id="cart" type="dawa.model.VOs.Cart"--%>
<%--@elvariable id="user" type="dawa.model.VOs.Registered"--%>
<%--@elvariable id="discount" type="java.lang.String"--%>
<%--@elvariable id="total" type="java.lang.String"--%>
<%--@elvariable id="address" type="dawa.model.VOs.Address"--%>

<div class="checkout">

    <h1>Datos del pedido</h1>
    <h2>Productos a comprar</h2>
    <table class="cosa">
        <thead>
        <tr>
            <th>Nombre</th>
            <th>Precio</th>
            <th>Cantidad</th>
            <th>IVA</th>
            <th>Subtotal</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach var="lineItem" items="${cart.lines}">
            <tr>
                <td>${lineItem.item.name}</td>
                <td><fmt:formatNumber value="${lineItem.price}" type="currency"/></td>
                <td>${lineItem.amount}</td>
                <td><fmt:formatNumber value="${lineItem.price * lineItem.taxes}" type="currency"/></td>
                <td><fmt:formatNumber value="${lineItem.price * lineItem.taxes * lineItem.amount}" type="currency"/></td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
    <div class="item-properties">
        <p>Subtotal (sin descuento):  <fmt:formatNumber value="${cart.price}" type="currency"/></p>
        <c:if test="${user.type == 'VIP'}">
            <p>Descuento: <fmt:formatNumber value="${discount}" type="percent"/></p>
        </c:if>
        <p><strong>Total:</strong> <fmt:formatNumber value="${total}" type="currency"/></p>
    </div>

    <div class="item-properties">
        <h2>Dirección de envío</h2>
        <p>Linea 1: ${address.firstLine}</p>
        <p>Linea 2: ${address.secondLine}</p>
        <p>Código postal: ${address.postCode}</p>
        <p>Pais: ${address.country}</p>

    </div>
    <form action="shop" method="post">
        <input type="hidden" name="route" value="confirm">
        <input type="hidden" name="user" value="${user.email}">
        <div class="magneticraft">
            <input class="register-button green" type="submit" value="Confirmar compra">
        </div>
    </form>
</div>

</body>
</html>