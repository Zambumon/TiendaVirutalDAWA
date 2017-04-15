<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
    <%@include file="/utils/head.jsp" %>
</head>
<body>
<%@include file="/utils/navbar.jsp" %>
<h1>Usuarios del sistema</h1>
<table>
    <tbody>
    <c:forEach var="otherUser" items="${listOfUsers}">
        <tr>
            <td>${otherUser.getEmail()}</td>
            <td>
                <form action="editUser" method="post">
                    <input type="hidden" name="otherUserId" value="${otherUser.getId()}">
                    <input type="submit" value="Editar">

                </form>
            </td>
            <td>
                <form action="deleteUser" method="post">
                    <input type="submit" value="Eliminar">
                    <input type="hidden" name="otherUserId" value="${otherUser.getId()}">
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
