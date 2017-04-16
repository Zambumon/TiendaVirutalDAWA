<%--@elvariable id="user" type="dawa.model.VOs.Registered"--%>
<div class="navbar">
    <ul>
        <li><a class="navbar-link" href="index.jsp">Catálogo</a></li>
        <li>
            <form action="shop">
                <input type="hidden" name="route" value="showcart">
                <input class="navbar-link" type="submit" value="Carrito">
            </form>
        </li>
        <c:choose>
            <c:when test="${!user.registered}">
                <li><a class="navbar-link" href="access/login.jsp">Iniciar sesión</a></li>
            </c:when>
            <c:otherwise>
                <c:if test="${user.type == 'ADMIN'}">
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
                </c:if>
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