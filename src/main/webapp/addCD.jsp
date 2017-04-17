<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
    <%@include file="head.jsp" %>
</head>
<body>
<%@include file="navbar.jsp" %>

<div class="item-wrapper">
    <h2 class="item-name-thingy">Añadir un nuevo item</h2>
    <form action="shop" method="post">
        <input type="hidden" name="route" value="additem">

        <div class="general-info">
            <h2>Información general</h2>
            <p>Nombre del producto</p>
            <input type="text" name="name" id="name" placeholder="Nombre del producto" required>
            <p>Precio</p>
            <input type="number" min="0" value="99" name="price" id="price" required> &euro;
            <p>Unidades disponibles</p>
            <input type="number" min="1" name="stock" id="stock" value="1" required>
            <h2>Propiedades</h2>
            <fieldset>
                <legend>Descripción</legend>
                <textarea class="item-creator-description" name="description" rows="8" cols="80" required></textarea>
            </fieldset>
            <fieldset>
                <legend>Datos particulares del CD</legend>
                <input type="text" name="cd-author" placeholder="Artista" required>
                <input type="text" name="cd-country" placeholder="País" required>
                <input type="number" name="cd-year" min="1900" placeholder="Año" required>
            </fieldset>

            <div class="create-item-submit-wrapper">
                <input class="register-button" type="submit" value="Crear producto">
            </div>

        </div>

    </form>
</div>

</body>
</html>