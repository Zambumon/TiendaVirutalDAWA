<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<!DOCTYPE html>
<html>
<head>
    <%@include file="head.jsp" %>
</head>
<body>
<%@include file="navbar.jsp" %>
<%--@elvariable id="cart" type="dawa.model.VOs.cart"--%>
<%--@elvariable id="user" type="dawa.model.VOs.User"--%>

<div class="cart">

    <h1>Carrito de la compra</h1>
    <c:choose>
        <c:when test="${empty cart.lines}">
            <h2>Tu carrito de la compra está vacio</h2>
        </c:when>
        <c:otherwise>
            <table>
                <thead>
                <tr>
                    <th>Nombre</th>
                    <th>Precio</th>
                    <th>Cantidad</th>
                    <th>IVA</th>
                    <th>Subtotal</th>
                    <th></th>
                </tr>
                </thead>
                <tbody>
                <c:forEach var="lineItem" items="${cart.lines}">
                    <tr>
                        <td>
                            <form action="shop" method="get">
                                <input type="hidden" name="route" value="showitem">
                                <input type="hidden" name="itemId" value="${lineItem.item.id}">
                                <input class="view-from-cart" type="submit" value="${lineItem.item.name}">
                            </form>


                        </td>
                        <td>${lineItem.price}</td>
                        <td>${lineItem.amount}</td>
                        <td><fmt:formatNumber value="${lineItem.taxes}" type="currency"/></td>
                        <td><fmt:formatNumber value="${lineItem.taxes * lineItem.price * lineItem.amount}" type="currency"/></td>
                        <td>
                            <form action="shop" method="post">
                                <input type="hidden" name="route" value="removefromcart">
                                <input type="hidden" name="itemId" value="${lineItem.item.id}">
                                <input type="submit" value="Eliminar producto">
                            </form>
                        </td>
                    </tr>
                </c:forEach>

                </tbody>
            </table>
            <div class="cart-summary">
                <p><strong>Total (IVA Incluido): <fmt:formatNumber value="${cart.price}" type="currency"/></strong></p>
                <a href="index.jsp">Seguir comprando</a>
                <c:choose>
                    <c:when test="${user.registered}">
                        <form action="shop">
                            <input type="hidden" name="route" value="checkout">
                            <input type="submit" class="payday" value="Pagar">
                        </form>
                    </c:when>
                    <c:otherwise>
                        <p>Debe <a href="login.jsp">iniciar sesión</a> para poder comprar</p>
                    </c:otherwise>
                </c:choose>
            </div>
        </c:otherwise>
    </c:choose>
</div>

</body>
</html>
