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
            <ul class="navbar-nav nav-flex-icons">
                <li class="nav-item mr-1 ${(not empty sessionScope.donnateur) || (not empty sessionScope.centre) ? 'd-none': ''}">
                    <a href="jsp/login.jsp"
                       class="nav-link border border-light rounded">
                        <i class="fas fa-sign-in-alt mr-2"></i>Sign in
                    </a>
                </li>
                <li class="nav-item mr-1 ${(not empty sessionScope.donnateur) || (not empty sessionScope.centre) ? 'd-none': ''}">
                    <a class="nav-link border-light">
                        or
                    </a>
                </li>

                <li class="nav-item ${(not empty sessionScope.donnateur) || (not empty sessionScope.centre)  ? 'd-none': ''}">
                    <a href="jsp/signup.jsp" class="nav-link border border-light rounded">
                        <i class="fas fa-user-plus"></i>Sign up
                    </a>
                </li>
                <li class="nav-item dropdown ${(empty sessionScope.donnateur) && (empty sessionScope.centre) ? 'd-none' : ''}">
                    <a class="nav-link dropdown-toggle" id="navbarDropdownMenuLink-4" data-toggle="dropdown" aria-haspopup="true"
                       aria-expanded="false">
                        <i class="fas fa-user"></i> ${not empty sessionScope.donnateur.getNomDonnateur() ?
                            sessionScope.donnateur.getNomDonnateur() : sessionScope.centre.getNameCentre()} </a>
                    <div class="dropdown-menu dropdown-menu-right dropdown-info" aria-labelledby="navbarDropdownMenuLink-4">
                        <c:if test="${not empty sessionScope.centre}">
                            <a class="dropdown-item" href="/updateCentre?update=${sessionScope.centre.idCentre}">Update information</a>
                        </c:if>
                        <a class="dropdown-item ${(empty sessionScope.donnateur) ? 'd-none': ''}" href="profile">My account</a>
                        <a class="dropdown-item" href="logout">Log out</a>
                    </div>
                </li>

            </ul>
        </div>
    </div>
</nav>