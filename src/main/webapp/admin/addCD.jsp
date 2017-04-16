<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
    <%@include file="/utils/head.jsp" %>
</head>
<body>
<%@include file="/utils/navbar.jsp" %>
<%--@elvariable id="user" type="dawa.model.VOs.Registered"--%>

<div class="item-wrapper">
    <h2 class="item-name-thingy">Añadir un nuevo item</h2>
    <!-- TODO le cout-->
    <form action="shop" method="get">
        <input type="hidden" name="action" value="todo">

        <div class="general-info">
            <h2>Información general</h2>
            <p>Nombre del producto</p>
            <input type="text" required="" name="name" id="name" placeholder="Nombre del producto" required>
            <p>Precio</p>
            <input type="number" min="0.1" value="1" name="price" id="price" required> &euro;
            <p>Unidades disponibles</p>
            <input type="number" min="1" name="stock" id="stock" value="1" required>
            <h2>Propiedades</h2>
            <fieldset>
                <legend>Descripción</legend>
                <textarea class="item-creator-description" name="description" rows="8" cols="80"></textarea required>
            </fieldset>
            <fieldset>
                <legend>Datos particulares del CD</legend>
                <input type="text" name="cd-title" placeholder="Nombre del CD" required>
                <input type="text" name="cd-author" placeholder="Artista" required>
                <input type="text" name="cd-country" placeholder="País" required>
            </fieldset>

            <div class="create-item-submit-wrapper">
                <input class="register-button" type="submit" value="Crear producto">
            </div>

        </div>


    </form>
</div>

</body>
</html>