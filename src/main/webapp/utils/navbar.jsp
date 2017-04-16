<%--@elvariable id="user" type="dawa.model.VOs.Registered"--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<div class="navbar">
    <ul>
        <li><a class="navbar-link" href="index.jsp">Catálogo</a></li>

        <c:choose>
            <c:when test="${!user.registered}">
                <li>
                    <form action="shop">
                        <input type="hidden" name="route" value="showcart">
                        <input class="navbar-link" type="submit" value="Carrito">
                    </form>
                </li>
                <li><a class="navbar-link" href="access/login.jsp">Iniciar sesión</a></li>
            </c:when>
            <c:otherwise>
                <c:choose>
                    <c:when test="${user.type == 'ADMIN'}">
                        <li>
                            <form action="shop">
                                <input type="hidden" name="route" value="additem">
                                <input class="navbar-link" type="submit" value="Añadir un nuevo CD">
                            </form>
                        </li>
                        <li>
                            <form action="shop">
                                <input type="hidden" name="route" value="searchusers">
                                <input class="navbar-link" type="submit" value="Administrar usuarios">
                            </form>
                        </li>
                    </c:when>
                    <c:otherwise>
                        <li>
                            <form action="shop">
                                <input type="hidden" name="route" value="showcart">
                                <input class="navbar-link" type="submit" value="Carrito">
                            </form>
                        </li>
                    </c:otherwise>
                </c:choose>
                <li>
                    <form action="shop">
                        <input type="hidden" name="route" value="showaccount">
                        <input class="navbar-link" type="submit" value="Mi cuenta">
                    </form>
                </li>
                <li>
                    <form action="shop">
                        <input type="hidden" name="route" value="logout">
                        <input class="navbar-link" type="submit" value="Cerrar sesión">
                    </form>
                </li>
            </c:otherwise>
        </c:choose>
    </ul>
</div>