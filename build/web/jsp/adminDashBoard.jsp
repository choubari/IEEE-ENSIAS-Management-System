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
    <%@include file="adminNavBar.jsp"%>
<%
List<Member> members = (List) request.getAttribute("members");
%>
    <div class="container col-md-8  pt-5 ">
    <br><br>


    <div class="card card-cascade wider reverse">

        <!-- Card content -->
        <div class="card-body card-body-cascade">

            <!-- Title -->
            <div class="section-title text-center wow zoomInfont-weight-bold">
                <h1>Members Management</h1>
            </div>
            <%--alert--%>
            <c:if test="${flashMessageSuccess ne null}">
                <div class="alert alert-success" role="alert">
                        ${flashMessageSuccess}
                </div>
            </c:if>

            <c:if test="${flashMessageFaild ne null}">
                <div class="alert alert-danger" role="alert">
                        ${flashMessageFaild}
                </div>
            </c:if>

            <div class="row mt-5">
                <div class="col-md-3 offset-2"><a href="/addMember" class="btn btn-success">Add Member</a></div>
                <div class="col-md-3"><a href="" data-toggle="modal" data-target="#updateModal" class="btn btn-warning">Update Member</a></div>
                <div class="col-md-3"><a href="" data-toggle="modal" data-target="#deleteModel" class="btn btn-danger">Delete Member</a></div>
            </div>
        </div>
    </div>
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
                    <c:forEach items="${members}" var="member">
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
<div class="modal fade" id="updateModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel"
     aria-hidden="true">
    <div class="modal-dialog" role="document">
        <div class="modal-content">
            <div class="modal-header text-center">
                <h4 class="modal-title w-100 font-weight-bold">Update Member</h4>
                <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                    <span aria-hidden="true">&times;</span>
                </button>
            </div>
            <form method="get" action="/updateMember">
                <div class="modal-body mx-3">
                    <div class="row ">
                        <div class="form-group required col-sm-12">
                            <label for="id" class='control-label'>Id Member</label>
                            <input type="text" name="update" class="form-control" id="id" placeholder="Member Identifiant">
                            <!--<small id="emailHelp" class="form-text text-muted">We'll never share your email with anyone else.</small>-->
                        </div>
                    </div>

                </div>
                <div class="modal-footer d-flex justify-content-center">
                    <input type="submit" class="btn btn-warning" value="Update"/>
                </div>
            </form>
        </div>
    </div>
</div>

<div class="modal fade" id="deleteModel" tabindex="-1" role="dialog" aria-labelledby="myModalLabel"
     aria-hidden="true">
    <div class="modal-dialog" role="document">
        <div class="modal-content">
            <div class="modal-header text-center">
                <h4 class="modal-title w-100 font-weight-bold">Delete Member</h4>
                <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                    <span aria-hidden="true">&times;</span>
                </button>
            </div>
            <form method="post" action="/deleteMember">
                <div class="modal-body mx-3">
                    <div>
                        <!-- Nom input -->
                        <label for="email" class="mt-4">Email Member</label>
                        <input type="email" id="email" name="email" class="form-control "/>
                        <label for="expassword" class="control-label mt-4">Your actual password:</label>
                        <input type="password" id="expassword" name="expassword" class="form-control "/>
                    </div>

                </div>
                <div class="modal-footer d-flex justify-content-center">
                    <input type="submit" class="btn btn-danger" value="Delete"/>
                </div>
            </form>
        </div>
    </div>
</div>