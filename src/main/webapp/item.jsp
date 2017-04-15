<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
    <%@include file="/utils/head.jsp" %>
</head>
<body>
<%@include file="/utils/navbar.jsp" %>

<h2>${name}</h2>
<div class="generalInfo">
    <p>Precio: <strong>${price} €</strong></p>
    <p>Descripción: ${description}</p>
    <p>Stock: ${stock} unidades disponibles</p>
    <c:forEach items="${properties}" var="entry">
        <p>    <strong>${properties.key}:</strong> ${properties.value}</p>
    </c:forEach>
</div>
<c:choose>
  <c:when test="${user.type == 'ADMIN'}">
        <p>Editar stock del producto</p>
      <form action="EditStock" method="post">
          <input type="hidden" name="itemId" id="itemId" value="${id}">
          <input type="number" min="0" name="stock" id="stock">
          <input type="submit" value="Confirmar">
      </form>
    </c:when>
    <c:otherwise>
        <c:choose>
            <c:when test="${avaliable == true}">
                <div class="addToCart">
                    <p>Añadir al carrito</p>
                    <form action="addtocart" method="post">
                        <input type="hidden" name="itemId" value="${id}">
                        <input type="number" value="" min="1">
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
        <c:when test="${user.type == 'UNREGISTERED'}">
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