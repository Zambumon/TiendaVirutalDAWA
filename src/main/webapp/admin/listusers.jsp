<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
    <%@include file="/utils/head.jsp" %>
</head>
<body>
<%@include file="/utils/navbar.jsp" %>
<%--@elvariable id="listOfUsers" type="java.util.List"--%>

<h1>Usuarios del sistema</h1>
<table>
    <tbody>

    <c:forEach var="otherUser" items="${listOfUsers}">
        <tr>
            <td>${otherUser.email}</td>
            <td>
                <form action="shop" method="post">
                    <input type="hidden" name="route" value="showuser">
                    <input type="hidden" name="userId" value="${otherUser.email}">
                    <input type="submit" value="Editar">

                </form>
            </td>
            <td>
                <form action="shop" method="post">
                    <input type="hidden" name="route" value="deleteuser">
                    <input type="hidden" name="userId" value="${otherUser.email}">
                    <input type="submit" value="Eliminar">
                </form>
            </td>
        </tr>
    </c:forEach>

    </tbody>
</table>

</body>
</html>
