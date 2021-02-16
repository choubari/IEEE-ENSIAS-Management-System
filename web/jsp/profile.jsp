<%@ page import="java.sql.*"%>
<%@ page import="IEEE.bean.Member"%>
<html>
    <head>
        <%@include file="/jsp/Header.jsp" %>
        <style>
            .form-group.required .control-label:after {
                content: " *";
                color: red;
            }

            .form-control:focus {
                border-color: #006db6;
                box-shadow: inset 0 1px 1px rgba(0, 0, 0, 0.075), 0 0 8px rgba(255, 0, 0, 0.6);
            }

            select option:hover {
                background-color: #006db6;
                color: white;
            }
        </style>
    </head>
    <body>
       
        <!--- Navbar -->
        <%@ include file="/jsp/loginNavbar.jsp" %>
        
        
        
        <%
            Member member = (Member) request.getAttribute("member");
        %>
        <!--- Contenue -->
        <div class="container col-md-8" style="margin-top: 100px;">

            <div class="section-title text-center wow zoomIn mt-5 font-weight-bold">
                <h1 class="h1-responsive">Profile</h1>
            </div>
            <!-- Alerts -->
            <c:if test="${MessageSuccess ne null}">
                <div class="alert alert-success" role="alert">
                    ${MessageSuccess}
                </div>
            </c:if>

            <c:if test="${MessageFailed ne null}">
                <div class="alert alert-danger" role="alert">
                    ${MessageFailed}
                </div>
            </c:if>

            <div class="row">
                <div class="col col-md-12">
                    <form action="${pageContext.request.contextPath}/ProfileServlet" method="post" >
                        <div class="form-group required">
                            <label for="prenom" class='control-label'>First Name</label>
                            <input type="text" name="firstname" class="form-control" id="firstname" placeholder=""
                                   value="${member.firstname}">
                        </div>
                        <div class="form-group required">
                            <label for="nom" class='control-label'>Last Name</label>
                            <input type="text" name="lastname" class="form-control" id="lastname" placeholder=""
                                   value="${member.lastname}">
                        </div>
                        <div class="form-group required">
                            <label for="branch" class='control-label'>Branch</label>
                            <input type="text" name="branch" class="form-control" id="branch" placeholder=""
                                   value="${member.branch}">
                        </div>
                        <div class="form-group required">
                            <label for="phone" class='control-label'>Phone Number</label>
                            <input type="text" name="phone" class="form-control" id="phone" placeholder=""
                                   value="${member.phone}">
                        </div>
                        <div class="form-group required">
                            <label for="email" class='control-label'>Email</label>
                            <input type="text" name="email" class="form-control" id="email" placeholder=""
                                   value="${member.email}">
                        </div>

                        <div class="form-group required">
                            <label for="password" class='control-label'>Old Password</label>
                            <input type="password" name="oldpassword" class="form-control" id="oldpassword" placeholder="">
                        </div>
                        <div class="form-group required">
                            <label for="password" class='control-label'>New Password</label>
                            <input type="password" name="password" class="form-control" id="password" placeholder="">
                        </div>
                        <!-- Update button -->
                        <div class="row">
                            <div class="form-group col-md-3">
                                <button class="btn btn-outline-red btn-rounded btn-block z-depth-0 my-4 waves-effect"
                                        type="submit">
                                    Update
                                </button>
                            </div>
                        </div>
                    </form>
                </div>

            </div>

        </div>

        <!--- FOOTER -->
        <%@ include file="Footer.jsp" %>
        <%@include file="Toastr.jsp"%>
    </body>
</html>
