<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
    <%@include file="/utils/head.jsp" %>
</head>
<body>
<%@include file="/utils/navbar.jsp" %>
<h1>Se ha producido un error</h1>
<p>
    Error <c:out value="${errorCode}"/>:
    <c:out value="${errorMsg}"/>
</p>
<p><a href="index.jsp">Volver</a> a la página principal</p>


</body>
</html>