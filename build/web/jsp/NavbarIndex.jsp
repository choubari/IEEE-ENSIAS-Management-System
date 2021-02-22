<nav class="navbar fixed-top navbar-expand-lg navbar-dark scrolling-navbar">
    <div class="container">
        <a class="navbar-brand" href="./index.jsp">
            <img src="img/logo.png" style="height: 38px; margin-top: -2px;" class="mr-4">
        </a>
        <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarSupportedContent"
                aria-controls="navbarSupportedContent"
                aria-expanded="false" aria-label="Toggle navigation">
            <span class="navbar-toggler-icon"></span>
        </button>
        <div class="collapse navbar-collapse" id="navbarSupportedContent">
            <ul class="navbar-nav mr-auto">

                <li class="nav-item">
                    <a class="nav-link" href="">Our Work</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="">Agenda</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="">FAQ</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="">Blog</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="">About us</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="jsp/contactUs.jsp">Contact us</a>
                </li>
            </ul>
            <c:choose>
                <c:when test="${sessionScope.role !=null}">
                    <ul class="navbar-nav nav-flex-icons">
                        <li class="nav-item dropdown">
                            <a class="nav-link dropdown-toggle" id="navbarDropdownMenuLink-4" data-toggle="dropdown" aria-haspopup="true"
                               aria-expanded="false">
                                <i class="fas fa-user"></i> ${sessionScope.role} </a>
                            <div class="dropdown-menu dropdown-menu-right dropdown-info" aria-labelledby="navbarDropdownMenuLink-4">
                                <a class="dropdown-item" href="${pageContext.request.contextPath}/ProfileServlet">Profile</a>
                                <a class="dropdown-item" href="${pageContext.request.contextPath}/LogoutServlet">Log out</a>
                            </div>
                        </li>
                    </ul>
                </c:when>
                <c:otherwise>



                    <ul class="navbar-nav nav-flex-icons">
                        <!-- to set button invisible if the user is connected -->
                        <li class="nav-item mr-1">
                            <a href="${pageContext.request.contextPath}/jsp/login.jsp"
                               class="nav-link border border-light rounded">
                                <i class="fas fa-sign-in-alt mr-2"></i>Sign in
                            </a>
                        </li>
                        <li class="nav-item mr-1">
                            <a class="nav-link border-light">
                                or
                            </a>
                        </li>

                        <li class="nav-item">
                            <a href="${pageContext.request.contextPath}/jsp/signup.jsp" class="nav-link border border-light rounded">
                                <i class="fas fa-user-plus "></i>Sign up
                            </a>
                        </li>
                    </ul>
                </c:otherwise>
            </c:choose>
        </div>
    </div>
</nav>