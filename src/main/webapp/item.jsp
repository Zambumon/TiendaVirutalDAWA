<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
    <%@include file="/utils/head.jsp" %>
</head>
<body>
<%@include file="/utils/navbar.jsp" %>
<%--@elvariable id="item" type="dawa.model.VOs.Item"--%>
<%--@elvariable id="user" type="dawa.model.VOs.Registered"--%>

<h2>${item.name}</h2>
<div class="generalInfo">
    <p>Precio: <strong>${item.price} €</strong></p>
    <p>Descripción: ${item.description}</p>
    <p>Stock: ${item.stock} unidades disponibles</p>
    <c:forEach items="${item.properties}" var="entry">
        <p>    <strong>${entry.key}:</strong> ${entry.value}</p>
    </c:forEach>
</div>
<c:choose>
  <c:when test="${user.registered && user.type == 'ADMIN'}">
        <p>Editar stock del producto</p>
      <form action="shop" method="post">
          <input type="hidden" name="route" value="editstock">
          <input type="hidden" name="itemId" id="itemId" value="${item.id}">
          <input type="number" min="0" name="stock" id="stock">
          <input type="submit" value="Confirmar">
      </form>
    </c:when>
    <c:otherwise>
        <c:choose>
            <c:when test="${item.available}">
                <div class="addToCart">
                    <p>Añadir al carrito</p>
                    <form action="shop" method="post">
                        <input type="hidden" name="route" value="addtocart">
                        <input type="hidden" name="itemId" value="${item.id}">
                        <input type="number" name="amount" value="1" min="1">
                        <input type="submit" value="Confirmar">
                    </form>
                </div>
            </c:when>
            <c:otherwise>
                <p>Producto no disponible</p>
            </c:otherwise>
        </c:choose>

    </c:otherwise>
</c:choose>



<div id="commentSection">
    <h2>Comentarios</h2>
    <c:forEach var="review" items="${requestScope.itemReviews}">
        <div class="comment">
            <p>Autor: ${review.getAuthor()}</p>
            <p>Valoración: ${review.getPoints()}</p>
            <p>Contenido: ${review.getText()}</p>

        </div>
    </c:forEach>
    <c:choose>
        <c:when test="${!user.registered}">
        <p>Debe <a href="access/login.jsp">inicar sesión</a> para poder comentar</p>
    </c:when>
    <c:otherwise>
        <form action="addComment" method="post">
            <input type="text" id="commentContent">
            <input type="number" min="1" max="5">
        </form>
    </c:otherwise>
    </c:choose>
</div>
</body>
</html>