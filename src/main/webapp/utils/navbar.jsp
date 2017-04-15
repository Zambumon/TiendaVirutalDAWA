<ul>
    <li><a href="index.jsp">Catálogo</a></li>
    <li><a href="cart.jsp">Carrito</a></li>
    <c:choose>
        <c:when test="${sessionScope.user == null}">
            <li><a href="access/login.jsp">Iniciar sesión</a></li>
        </c:when>
        <c:otherwise>
            <c:if test="${user.registered}">
                <c:if test="${user.type == 'ADMIN'}">
                    <li><a href="">Añadir un nuevo CD</a></li>
                    <li><a href="">Administrar usuarios</a></li>
                </c:if>
            </c:if>
            <li><a href="registered/account.jsp">Mi cuenta</a></li>
            <li><a href="access/logout.jsp">Cerrar sesión</a></li>
        </c:otherwise>
    </c:choose>
</ul>