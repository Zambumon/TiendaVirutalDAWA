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

<div class="item-wrapper">
    <h2 class="item-name-thingy">${item.name}</h2>
    <div class="general-info">
        <h2>Información general</h2>
        <c:if test="${user.registered && user.type == 'ADMIN'}">
            <p>ID: <strong>${item.id}</strong></p>
        </c:if>
        <p>Precio: <strong>${item.price} &euro;</strong></p>
        <p>Stock: <strong>${item.stock} unidades disponibles</strong></p>
        <c:if test="${user.registered && user.type == 'ADMIN'}">
            <h3>Editar stock del producto</h3>
            <form action="shop" method="post">
                <input type="hidden" name="route" value="editstock">
                <input type="hidden" name="itemId" id="itemId" value="${item.id}">
                <input type="number" min="0" name="stock" id="stock">
                <input type="submit" value="Confirmar">
            </form>
        </c:if>
    </div>
    <div class="item-properties">
        <c:choose>
            <c:when test="${item.available && (!user.registered || user.type != 'ADMIN')}">
                <div class="addToCart">
                    <h3>Añadir al carrito</h3>
                    <form action="shop" method="post">
                        <input type="hidden" name="route" value="addtocart">
                        <input type="hidden" name="itemId" value="${item.id}">
                        <input type="number" name="amount" value="1" min="1">
                        <input type="submit" value="Añadir">
                    </form>
                </div>
            </c:when>
            <c:otherwise>
                <p>Producto no disponible</p>
            </c:otherwise>
        </c:choose>
    </div>
    <div class="item-properties">
        <h2>Propiedades</h2>
        <p>${item.description}</p>
        <ul class="properties-list">
            <c:forEach items="${item.properties}" var="entry">
                <li>    <strong>${entry.key}:</strong> ${entry.value}</li>
            </c:forEach>
        </ul>
    </div>





    <div class="comment-section">
        <h2>Comentarios</h2>
        <c:forEach var="review" items="${requestScope.itemReviews}">
            <div class="comment">
                <p class="comment-author">${review.author} dice:</p>
                <p class="comment-text"> ${review.text}</p>
                <p class="comment-points">Valoración: ${review.points}/10</p>
            </div>
        </c:forEach>
        <c:choose>
            <c:when test="${!user.registered}">
                <p>Debe <a href="access/login.jsp">iniciar sesión</a> para poder comentar</p>
            </c:when>
            <c:otherwise>
                <form class="comment-submission" action="addComment" method="post">
                    <fieldset class="comment-submission-fieldset">
                        <legend>Comentar</legend>
                        <textarea name="comment" required></textarea>
                        <div class="petrusboniatus">
                            <label for="new-points">Tu puntuación:</label>
                            <select name="points" id="points">
                                <c:forEach begin="1" end="10" var="val">
                                    <option value="${val}"><c:out value="${val}"/></option>
                                </c:forEach>
                            </select>
                            <input class="send-button" type="submit" value="Enviar">
                        </div>
                    </fieldset>

                </form>
            </c:otherwise>
        </c:choose>
    </div>
</div>
</body>
</html>