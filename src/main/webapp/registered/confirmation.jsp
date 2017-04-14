
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
    <%@include file="/utils/head.jsp" %>
</head>
<body>
<%@include file="/utils/navbar.jsp" %>
<div class="confirmation">
    <p>Compra realizada con éxito. Se le enviará un correo de confirmación a
        <c:out value="${sessionScope.user.getEmail()}"/></p>
    <p><a href="index.jsp">Volver</a> la página principal</p>
</div>




</body>
</html>