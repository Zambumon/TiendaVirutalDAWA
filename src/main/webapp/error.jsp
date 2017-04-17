<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
    <%@include file="head.jsp" %>
</head>
<body>
<%@include file="navbar.jsp" %>
<%--@elvariable id="errorCode" type="java.lang.Integer"--%>
<%--@elvariable id="errorMsg" type="java.lang.String"--%>

<div class="confirmation">
    <h1>Se ha producido un error</h1>
    <p>
        Error <c:out value="${errorCode}"/>:
        <c:out value="${errorMsg}"/>
    </p>
    <p><a href="index.jsp">Volver</a> a la página principal</p>

</div>

</body>
</html>