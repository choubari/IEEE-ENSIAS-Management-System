<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="IEEE.bean.Newsletter"%>
<%@ page import ="java.util.ArrayList"%>
<%@ page import ="java.util.List"%>

<style>
    .form-group.required .control-label:after {
        content:" *";
        color:red;
    }
    .form-control:focus {
        border-color: #006db6;
        box-shadow: inset 0 1px 1px rgba(0, 0, 0, 0.075), 0 0 8px rgba(255, 0, 0, 0.6);
    }
    select option:hover {
        background: #006db6;
        color: white;
    }
</style>
<html>
    <head>
        <%@include file="Header.jsp"%>
    </head>
    <body>

        <!--- Navbar -->
        <%@ include file="/jsp/loginNavbar.jsp" %>
        <%
            List<Newsletter> newsletterdata = (List) request.getAttribute("newsletterdata");
        %>
        <div class="container col-md-8  pt-5 ">
            <br><br>

            <form action="${pageContext.request.contextPath}/EmailSendingServlet" method="post">
                 <div class="row">

                        

                        <!--Grid column-->
                        <div class="col-md-6">
                            <div class="md-form mb-0">
                                <input type="text" id="email" name="recipient" class="form-control"  placeholder="Recipient">
                            </div>
                        </div>
                        <!--Grid column-->

                    </div>
                    <!--Grid row-->

                    <!--Grid row-->
                    <div class="row">
                        <div class="col-md-12">
                            <div class="md-form mb-0">
                                <input type="text" id="subject" name="subject" class="form-control"  placeholder="Subject">
                            </div>
                        </div>
                    </div>
                    <!--Grid row-->

                    <!--Grid row-->
                    <div class="row">

                        <!--Grid column-->
                        <div class="col-md-12">

                            <div class="md-form">
                                <textarea type="text" id="message" name="content" rows="2"
                                          class="form-control md-textarea"  placeholder="Content"></textarea>
                            </div>

                        </div>
                    </div>
                    <!--Grid row-->

                    <div class="text-center text-md-left">
                        <button class="btn btn-red btn-block col-md-2 my-4" name="submit" type="submit">Send</button>
                    </div>

            </form>
                ${Message}
        </div>

        <%@include file="Footer.jsp"%>
    </body>
</html>

