<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="IEEE.bean.ContactForm"%>
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
            List<ContactForm> formfillers = (List) request.getAttribute("formfillers");
        %>
        <div class="container col-md-8  pt-5 ">
            <br><br>
                       
            <div class="card card-cascade wider reverse mt-5">
                <!-- Card content -->
                <div class="card-body card-body-cascade">
                    <!-- Title -->
                    <div class="section-title text-center wow zoomInfont-weight-bold">
                        <h1>Contacts</h1>
                    </div>
                    <table class="table table-hover">
                        <thead>
                            <tr>
                                <th scope="col">Id</th>
                                <th scope="col">Name</th>
                                <th scope="col">Email</th>
                                <th scope="col">Subject</th>
                                <th scope="col">Message</th>
                            </tr>
                        </thead>
                        <tbody>
                            <c:forEach items="${formfillers}" var="line">
                                <tr>
                                    <th scope="row"><c:out value="${line.id}"/></th>
                                    <th scope="row"><c:out value="${line.name}"/></th>
                                    <th scope="row" style="text-decoration: underline;"><a href="mailto:${line.email}"><c:out value="${line.email}"/></a></th>
                                    <th scope="row"><c:out value="${line.subject}"/></th>
                                    <th scope="row"><c:out value="${line.message}"/></th>
                                    <th scope="row">
                                </tr>
                            </c:forEach>
                        </tbody>
                    </table>
                </div>
            </div>
        </div>

        <%@include file="Footer.jsp"%>
    </body>
</html>

