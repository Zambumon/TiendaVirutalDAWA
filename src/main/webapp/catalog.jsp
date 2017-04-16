
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
    <%@include file="/utils/head.jsp" %>
</head>
<body>
<%@include file="/utils/navbar.jsp" %>
<%--@elvariable id="searchResult" type="java.util.List"--%>

<h1>Música para DAWA</h1>
<div class="search-bar">
    <form action="shop" method="get">
        <input type="hidden" name="route" value="searchitems">
        <input class="search-box" type="text" name="item" placeholder="Introduzca parámetros de búsqueda" required>
        <input class="search-button" type="submit" value="Buscar">
        <div class="searchParameters">
            <input type="checkbox" name="searchParameter" value="title" checked required> Título
            <input type="checkbox" name="searchParameter" value="author"> Autor
            <input type="checkbox" name="searchParameter" value="country"> País
            <select name="order">
                <option value="ascendant">Ascendente</option>
                <option value="descendant">Descendente</option>
            </select>
        </div>
    </form>
</div>

<div class="catalog">
    <c:forEach var="item" items="${searchResult}">
        <div class="catalog-item">
            <h3><c:out value="${item.name}"/></h3>
            <p><c:out value="${item.price}"/> &euro;</p>
            <p><c:out value="${item.stock}"/> unidades en stock</p>
            <form action="shop" method="get">
                <input type="hidden" name="route" value="showitem">
                <c:choose>
                    <c:when test="${item.available}">
                        <input type="hidden" name="itemId" value="${item.id}">
                        <input class="catalog-item-submit" type="submit" value="Ver producto">
                    </c:when>
                    <c:otherwise>
                        <input class="catalog-item-submit" type="submit" value="Producto no disponible" disabled="disabled">
                    </c:otherwise>
                </c:choose>
            </form>
        </div>
    </c:forEach>
</div>
</body>
</html>
