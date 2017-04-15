
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
    <%@include file="/utils/head.jsp" %>
</head>
<body>
<%@include file="/utils/navbar.jsp" %>
<h1>Música para DAA</h1>
<form action="searchItems" method="post">
    <input type="text" placeholder="Introduzca parámetros de búsqueda">
    <input type="checkbox" name="searchParameter" value="title"> Título
    <input type="checkbox" name="searchParameter" value="author"> Autor
    <input type="checkbox" name="searchParameter" value="country"> País
    <select name="order">
        <option value="ascendant">Ascendente</option>
        <option value="descendant">Descendente</option>
    </select>
    <input type="submit" value="Buscar">
</form>

<div class="catalog">
    <c:forEach var="item" items="${searchResult}">
        <div class="catalogItem">
            <h3><c:out value="${item.name}"/></h3>
            <p><c:out value="${item.price}"/></p>
            <p><c:out value="${item.stock}"/></p>
            <form action="viewItem" method="post">
                <c:choose>
                    <c:when test="${item.available}">
                        <input type="hidden" name="itemId" value="${item.id}">
                        <input type="submit" value="Ver producto">
                    </c:when>
                    <c:otherwise>
                        <input type="submit" value="Producto no disponible" disabled="disabled">
                    </c:otherwise>
                </c:choose>

            </form>
        </div>
    </c:forEach>
</div>



</body>
</html>
