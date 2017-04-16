<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
    <%@include file="/utils/head.jsp" %>
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
                <td>${lineItem.price} &euro;</td>
                <td>${lineItem.amount}</td>
                <td>${lineItem.taxes}</td>
                <td>${lineItem.price * lineItem.taxes * lineItem.amount} &euro;</td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
    <div class="item-properties">
        <p>Subtotal: ${cart.price} &euro;</p>
        <c:if test="${user.type == 'VIP'}">
            <p>Descuento: ${discount} %</p>
        </c:if>
        <p><strong>Total (IVA Incluido):</strong> ${total} &euro;</p>
    </div>

    <div class="item-properties">
        <h2>Dirección de envío</h2>
        <p>${address.firstLine}</p>
        <p>${address.secondLine}</p>
        <p>${address.postCode}</p>
        <p>${address.country}</p>

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