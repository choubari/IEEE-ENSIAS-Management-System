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
List<Member> active_members = (List) request.getAttribute("active_members");
List<Member> inactive_members = (List) request.getAttribute("inactive_members");
%>
    <div class="container col-md-8  pt-5 ">
    <br><br>

    <div class="row mt-5">
        <div class="col-md-3"><a href="" data-toggle="modal" data-target="#updateModal" class="btn btn-warning">Update Member</a></div>
        <div class="col-md-3"><a href="" data-toggle="modal" data-target="#deleteModal" class="btn btn-danger">Delete Member</a></div>
    </div>
  
    <!-- Alerts -->
            <c:if test="${MessageSuccess ne null}">
                <div class="alert alert-success" role="alert">
                    ${MessageSuccess}
                </div>
            </c:if>

            <c:if test="${MessageFaild ne null}">
                <div class="alert alert-danger" role="alert">
                    ${MessageFaild}
                </div>
            </c:if>

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
                    <c:forEach items="${active_members}" var="member">
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
<!-- List of requests --> 
 <div class="card card-cascade wider reverse mt-5">
            <!-- Card content -->
            <div class="card-body card-body-cascade">

                <!-- Title -->
                <div class="section-title text-center wow zoomInfont-weight-bold">
                    <h1>List of Requests</h1>
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
                    <c:forEach items="${inactive_members}" var="member">
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
            <form method="get" action="${pageContext.request.contextPath}/updateMember">
                <div class="modal-body mx-3">
                    <div class="row ">
                        <div class="form-group required col-sm-12">
                            <label for="id" class='control-label'>Id Member</label>
                            <input type="text" name="memberid" class="form-control" id="id" placeholder="Member Identifiant">
                            <!--<small id="emailHelp" class="form-text text-muted">We'll never share your email with anyone else.</small>-->
                        </div>
                    </div>
                    <div class="row ">
                        <div class="form-group required col-sm-12">
                            <label  class='control-label'>Role</label>
                            <select class="browser-default custom-select form-control" name="role">
                                <option value="" disabled selected>Select the role</option>
                                <option value="admin">admin</option>
                                <option value="chef">chef of cell</option>
                                <option value="webmaster">webmaster</option>
                                <option value="member">member</option>
                                <option value="inactif">inactif</option>                                 
                            </select>
                         </div>
                    </div>
                    <div class="row ">
                        <div class="form-group required col-sm-12">
                            <label  class='control-label'>Cell</label>
                            <select class="browser-default custom-select form-control" name="cell">
                                <option value="" disabled selected>Select the desired cell</option>
                                <option value="admin">Admin</option>
                                <option value="Sponsoring">Sponsoring</option>
                                <option value="Event">Event</option>
                                <option value="Media">Media</option>
                                <option value="Tutorial">Tutorial</option>
                                <option value="Design">Design</option>                                        
                            </select>
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

<!-- Delete -->
<div class="modal fade" id="deleteModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel"
     aria-hidden="true">
    <div class="modal-dialog" role="document">
        <div class="modal-content">
            <div class="modal-header text-center">
                <h4 class="modal-title w-100 font-weight-bold">Delete Member</h4>
                <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                    <span aria-hidden="true">&times;</span>
                </button>
            </div>
            <form method="get" action="${pageContext.request.contextPath}/DeleteMember">
                <div class="modal-body mx-3">
                    <div class="row ">
                        <div class="form-group required col-sm-12">
                            <label for="id" class='control-label'>Id</label>
                            <input type="text" name="id" class="form-control" id="id" placeholder="Member Identifiant">
                        </div>
                    </div>
                </div>
                <div class="modal-footer d-flex justify-content-center">
                    <input type="submit" class="btn btn-danger" value="Delete"/>
                </div>
            </form>
        </div>
    </div>
</div>
           