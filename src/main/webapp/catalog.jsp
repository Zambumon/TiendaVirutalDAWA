
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
<%--@elvariable id="searchResult" type="java.util.List"--%>

<h1>Música para DAWA</h1>
<div class="search-bar">
    <form action="shop" method="get">
        <input type="hidden" name="route" value="searchitems">
        <input class="search-box" type="text" name="searchParameter-title" placeholder="Introduzca título del producto">
        <input class="search-button" type="submit" value="Buscar">
        <div class="searchParameters">
            <input type="text" name="searchParameter-author" placeholder="Autor">
            <input type="text" name="searchParameter-country" placeholder="País">
            <input type="number" name="searchParameter-year" min="1970" placeholder="Año">
            <br>Precio máximo <input type="number" name="searchParameter-max-price" min="1" placeholder="Precio máximo"> &euro;
        </div>
    </form>
</div>

<div class="catalog">
    <c:forEach var="item" items="${searchResult}">
        <div class="catalog-item">
            <h3><c:out value="${item.name}"/></h3>
            <p><fmt:formatNumber value="${item.price}" type="currency"/></p>
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
