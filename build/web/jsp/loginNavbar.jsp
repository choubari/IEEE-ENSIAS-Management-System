    <nav class="navbar fixed-top navbar-expand-lg navbar-dark scrolling-navbar" style="background-color: #006db6">
        <div class="container">
            <a class="navbar-brand">
                <img src="${pageContext.request.contextPath}/img/logo.png" style="height: 38px; margin-top: -2px;" class="mr-4">
            </a>
            <button class="navbar-toggler" type="button" data-toggle="collapse" data-target=""
                    aria-controls="navbarSupportedContent"
                    aria-expanded="false" aria-label="Toggle navigation">
                <span class="navbar-toggler-icon"></span>
            </button>
        <div class="collapse navbar-collapse" id="navbarSupportedContent">
            <ul class="navbar-nav mr-auto"> 
                <li class="nav-item">
                    <a class="nav-link" href="">Inbox</a>
                </li>
                <c:if test="${sessionScope.role != 'member' && sessionScope.role != 'webmaster'}">
                    <li class="nav-item">
                        <a class="nav-link" href="${pageContext.request.contextPath}/ShowMembers">Members</a>
                    </li>
                </c:if>
                <li class="nav-item">
                    <a class="nav-link" href="${pageContext.request.contextPath}/ShowEvents">Events</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="${pageContext.request.contextPath}/ShowTasks">Tasks</a>
                </li>
                 <li class="nav-item">
                    <a class="nav-link" href="">Calendar</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="${pageContext.request.contextPath}/jsp/Datacenter.jsp">Datacenter</a>
                </li>
               
            </ul>
            <ul class="navbar-nav nav-flex-icons">
                <li class="nav-item dropdown">
                    <a class="nav-link dropdown-toggle" id="navbarDropdownMenuLink-4" data-toggle="dropdown" aria-haspopup="true"
                       aria-expanded="false">
                        <i class="fas fa-user"></i> ${sessionScope.admin.nomAdmin} </a>
                    <div class="dropdown-menu dropdown-menu-right dropdown-info" aria-labelledby="navbarDropdownMenuLink-4">
                        <a class="dropdown-item" href="${pageContext.request.contextPath}/ProfileServlet">Profile</a>
                        <a class="dropdown-item" href="">Log out</a>
                    </div>
                </li>
            </ul>
        </div>
        </div>
    </nav>

