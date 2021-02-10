<html>
<head>
    <%@include file="Header.jsp" %>
</head>
<body>

    <%@include file="Navbar.jsp" %>
<br><br><br>
<div class="container col-md-4 align-content-center mt-5 mb-5">
    <div class="card">
        <!-- Default form login -->

        <h5 class="card-header white-text text-center py-4" style="background: #006db6">
            <strong>Sign in</strong>
        </h5>
        <div class="card-body">
            <form class="text-center border border-light p-3" method="post" action="${pageContext.request.contextPath}/LoginServlet">
                <!-- Email -->
                <input type="email" id="defaultLoginFormEmail" class="form-control mb-4" placeholder="Email"
                       name="email">

                <!-- Password -->
                <input type="password" id="defaultLoginFormPassword" class="form-control mb-4" placeholder="Password"
                       name="password">

                <div class="d-flex justify-content-around">
                    <div>
                        <!-- Remember me -->
                        <div class="custom-control custom-checkbox">
                            <input type="checkbox" class="custom-control-input" id="defaultLoginFormRemember">
                            <label class="custom-control-label" for="defaultLoginFormRemember">Remember me</label>
                        </div>
                    </div>
                    <div>
                        <!-- Forgot password -->
                        <a href="">Forgot password?</a>
                    </div>
                </div>

                <!-- Sign in button -->
                <button class="btn btn-block my-4" style="background: #006db6" type="submit">Sign in</button>

                <!-- Register -->
                <p>Not a member?
                    <a href="../jsp/signup.jsp">Register</a>
                </p>

            </form>
            <!-- Default form login -->
        </div>
    </div>
</div>
<%@include file="Footer.jsp"%>
<%@include file="Toastr.jsp"%>
</body>
</html>
