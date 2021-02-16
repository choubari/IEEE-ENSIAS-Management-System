<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="IEEE.bean.Member"%>
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
    <%@include file="loginNavbar.jsp"%>
<%
List<Member> cell_members = (List) request.getAttribute("cell_members");
%>
    <div class="container col-md-8  pt-5 ">
    <br><br>
  <!-- List of members --> 
        <div class="card card-cascade wider reverse mt-5">
            <!-- Card content -->
            <div class="card-body card-body-cascade">
                <!-- Title -->
                <div class="section-title text-center wow zoomInfont-weight-bold">
                    <h1>List of Members</h1>
                </div>
                <table class="table table-hover">
                    <thead>
                    <tr>
                        <th scope="col">Id</th>
                        <th scope="col">FirstName</th>
                        <th scope="col">LastName</th>
                        <th scope="col">Email</th>
                        <th scope="col">Phone Number</th>
                        <th scope="col">Branch</th>
                        <th scope="col">Cell</th>
                        <th scope="col">Role</th>
                    </tr>
                    </thead>
                    <tbody>
                    <c:forEach items="${cell_members}" var="member">
                        <tr>
                            <th scope="row"><c:out value="${member.id}"/></th>
                            <th scope="row"><c:out value="${member.firstname}"/></th>
                            <th scope="row"><c:out value="${member.lastname}"/></th>
                            <th scope="row"><c:out value="${member.email}"/></th>
                            <th scope="row"><c:out value="${member.phone}"/></th>
                            <th scope="row"><c:out value="${member.branch}"/></th>
                            <th scope="row"><c:out value="${member.cell}"/></th>
                            <th scope="row"><c:out value="${member.role}"/></th>
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
