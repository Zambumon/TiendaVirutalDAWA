
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
    <%@include file="head.jsp" %>
</head>
<body>
<%@include file="navbar.jsp" %>
<%--@elvariable id="user" type="dawa.model.VOs.Registered"--%>

<div class="confirmation">
    <p>Compra realizada con éxito. Se le enviará un correo de confirmación a
        <c:out value="${user.email}"/></p>
    <p><a href="index.jsp">Volver</a> la página principal</p>
</div>


</body>
</html>