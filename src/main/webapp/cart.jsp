<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
    <%@include file="/utils/head.jsp" %>
</head>
<body>
<%@include file="/utils/navbar.jsp" %>
<div class="cart">

    <h1>Carrito de la compra</h1>
    <c:choose>
        <c:when test="${cart.isEmpty() == true}">
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
                <c:forEach var="cartItem" items="${cart}">
                    <tr>
                        <td>
                            <form action="viewItem" method="get">
                                <input type="hidden" name="itemId" value="${item.id}">
                                <input class="view-from-cart" type="submit" value="${cartItem.name}">
                            </form>


                        </td>
                        <td>${cartItem.price}</td>
                        <td>${cartItem.amount}</td>
                        <td>${cartItem.taxes}</td>
                        <td>${cartItem.taxes*cartItem.price*cartItem.amount}</td>
                        <td>
                            <form action="removeFromCart" method="post">
                                <input type="submit" value="Eliminar producto">
                                <input type="hidden" name="itemId" value="${cartItem.name}">
                            </form>
                        </td>
                    </tr>
                </c:forEach>

                </tbody>
            </table>
            <div class="cart-summary">
                <p>Subtotal: ${cart.total} &euro;</p>
                <p><strong>Total (IVA Incluido): ${cart.total} &euro;</strong></p>
                <a href="catalog.jsp">Seguir comprando</a>
                <c:choose>
                    <c:when test="${user.type == 'REGISTERED'}">
                        <a class="payday" href="registered/checkout.jsp">Pagar</a>
                    </c:when>
                    <c:otherwise>
                        <p>Debe <a href="access/login.jsp">iniciar sesión</a> para poder comprar</p>
                    </c:otherwise>
                </c:choose>
            </div>
        </c:otherwise>
    </c:choose>
</div>

</body>
</html>
