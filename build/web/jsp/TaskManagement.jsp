<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="IEEE.bean.Task"%>
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
            List<Task> mytasks = (List) request.getAttribute("mytasks");
            List<Task> delegatedtasks = (List) request.getAttribute("delegatedtasks");
        %>
        <div class="container col-md-8  pt-5 ">
            <br><br>
            
            <c:choose>
                <c:when test = "${sessionScope.role != 'member' && sessionScope.role != 'webmaster'}">
                    <div class="row mt-5">
                        <div class="col-md-3 offset-2"><a href="" data-toggle="modal" data-target="#addTask" class="btn btn-success">Create Task</a></div>
                        <div class="col-md-3"><a href="" data-toggle="modal" data-target="#updateTask" class="btn btn-warning">Update Task</a></div>
                        <div class="col-md-3"><a href="" data-toggle="modal" data-target="#deleteTask" class="btn btn-danger">Delete Task</a></div>
                    </div>
                </c:when>
                <c:otherwise>
                    <div class="col-md-3"><a href="" data-toggle="modal" data-target="#updateStatus" class="btn btn-warning">Update Task</a></div>
                </c:otherwise>
            </c:choose>


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


            <div class="card card-cascade wider reverse mt-5">
                <!-- Card content -->
                <div class="card-body card-body-cascade">
                    <!-- Title -->
                    <div class="section-title text-center wow zoomInfont-weight-bold">
                        <h1>My Tasks</h1>
                    </div>
                    <table class="table table-hover">
                        <thead>
                            <tr>
                                <th scope="col">Id</th>
                                <th scope="col">Name</th>
                                <th scope="col">Description</th>
                                <th scope="col">Deadline</th>
                                <th scope="col">Resp.ID</th>
                                <th scope="col">Responsable</th>
                                <th scope="col">Status</th>
                            </tr>
                        </thead>
                        <tbody>
                            <c:forEach items="${mytasks}" var="task">
                                <tr>
                                    <th scope="row"><c:out value="${task.id}"/></th>
                                    <th scope="row"><c:out value="${task.name}"/></th>
                                    <th scope="row"><c:out value="${task.description}"/></th>
                                    <th scope="row"><c:out value="${task.deadline}"/></th>
                                    <th scope="row"><c:out value="${task.responsable_id}"/></th>
                                    <th scope="row"><c:out value="${task.responsable}"/></th>
                                    <th scope="row"><c:out value="${task.status}"/></th>
                                    <th scope="row">
                                </tr>
                            </c:forEach>
                        </tbody>
                    </table>

                    <c:if test="${sessionScope.role != 'member'}">             
                        <div class="section-title text-center wow zoomInfont-weight-bold">
                            <h1>Delegated Tasks</h1>
                        </div>
                        <table class="table table-hover">
                            <thead>
                                <tr>
                                    <th scope="col">Id</th>
                                    <th scope="col">Name</th>
                                    <th scope="col">Description</th>
                                    <th scope="col">Deadline</th>
                                    <th scope="col">Resp.ID</th>
                                    <th scope="col">Responsable</th>
                                    <th scope="col">Status</th>
                                </tr>
                            </thead>
                            <tbody>
                                <c:forEach items="${delegatedtasks}" var="task">
                                    <tr>
                                        <th scope="row"><c:out value="${task.id}"/></th>
                                        <th scope="row"><c:out value="${task.name}"/></th>
                                        <th scope="row"><c:out value="${task.description}"/></th>
                                        <th scope="row"><c:out value="${task.deadline}"/></th>
                                        <th scope="row"><c:out value="${task.responsable_id}"/></th>
                                        <th scope="row"><c:out value="${task.responsable}"/></th>
                                        <th scope="row"><c:out value="${task.status}"/></th>
                                        <th scope="row">
                                    </tr>
                                </c:forEach>
                            </tbody>
                        </table>
                    </c:if>
                </div>
            </div>
        </div>

        <%@include file="Footer.jsp"%>
    </body>
</html>

<!-- Add -->
<div class="modal fade" id="addTask" tabindex="-1" role="dialog" aria-labelledby="myModalLabel"
     aria-hidden="true">
    <div class="modal-dialog" role="document">
        <div class="modal-content">
            <div class="modal-header text-center">
                <h4 class="modal-title w-100 font-weight-bold">Add Task</h4>
                <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                    <span aria-hidden="true">&times;</span>
                </button>
            </div>
            <form method="get" action="${pageContext.request.contextPath}/CreateTask">
                <div class="modal-body mx-3">
                    <div class="row ">
                        <div class="form-group required col-sm-12">
                            <label for="id" class='control-label'>Name</label>
                            <input type="text" name="name" class="form-control" id="id" placeholder="Task Name">
                            <!--<small id="emailHelp" class="form-text text-muted">We'll never share your email with anyone else.</small>-->
                        </div>
                    </div>
                    <div class="row ">
                        <div class="form-group required col-sm-12">
                            <label for="id" class='control-label'>Description</label>
                            <input type="text" name="description" class="form-control" id="id" placeholder="Task Description">
                            <!--<small id="emailHelp" class="form-text text-muted">We'll never share your email with anyone else.</small>-->
                        </div>
                    </div>
                    <div class="row ">
                        <div class="form-group required col-sm-12">
                            <label for="id" class='control-label'>Deadline</label>
                            <input type="date" name="deadline" class="form-control" id="date" value="" >

                            <!--<small id="emailHelp" class="form-text text-muted">We'll never share your email with anyone else.</small>-->
                        </div>
                    </div>
                    <div class="row ">
                        <div class="form-group required col-sm-12">
                            <label for="id" class='control-label'>Responsable ID</label>
                            <input type="text" name="responsable_id" class="form-control" id="id" placeholder="Member Identifiant">
                            <!--<small id="emailHelp" class="form-text text-muted">We'll never share your email with anyone else.</small>-->
                        </div>
                    </div>
                </div>
                <div class="modal-footer d-flex justify-content-center">
                    <input type="submit" class="btn btn-success" value="Create"/>
                </div>
            </form>
        </div>
    </div>
</div>


<!-- Update -->
<div class="modal fade" id="updateTask" tabindex="-1" role="dialog" aria-labelledby="myModalLabel"
     aria-hidden="true">
    <div class="modal-dialog" role="document">
        <div class="modal-content">
            <div class="modal-header text-center">
                <h4 class="modal-title w-100 font-weight-bold">Update Task</h4>
                <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                    <span aria-hidden="true">&times;</span>
                </button>
            </div>
            <form method="get" action="${pageContext.request.contextPath}/UpdateTask">
                <div class="modal-body mx-3">
                    <div class="row ">
                        <div class="form-group required col-sm-12">
                            <label for="id" class='control-label'>Id</label>
                            <input type="text" name="id" class="form-control" id="id" placeholder="Task Identifiant">
                        </div>
                    </div>
                </div>
                <div class="modal-body mx-3">
                    <div class="row ">
                        <div class="form-group required col-sm-12">
                            <label for="id">Name</label>
                            <input type="text" name="name" class="form-control" id="id" placeholder="Task Name">
                        </div>
                    </div>
                    <div class="row ">
                        <div class="form-group required col-sm-12">
                            <label for="id">Description</label>
                            <input type="text" name="description" class="form-control" id="id" placeholder="Task Description">
                        </div>
                    </div>
                    <div class="row ">
                        <div class="form-group required col-sm-12">
                            <label for="id">Deadline</label>
                            <input type="date" name="deadline" class="form-control" id="date" value="" >
                        </div>
                    </div>
                    <div class="row ">
                        <div class="form-group required col-sm-12">
                            <label for="id">Responsable ID</label>
                            <input type="text" name="responsable_id" class="form-control" id="id" placeholder="Member Identifiant">
                        </div>
                    </div>
                    <div class="row ">
                        <div class="form-group required col-sm-12">
                            <label for="id">Status</label>
                            <select class="browser-default custom-select form-control" name="status">
                                <option value="" disabled selected>Select the task status</option>
                                <option value="Todo">Todo</option>
                                <option value="In Progress">In Progress</option>
                                <option value="Done">Done</option>                     
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
<div class="modal fade" id="deleteTask" tabindex="-1" role="dialog" aria-labelledby="myModalLabel"
     aria-hidden="true">
    <div class="modal-dialog" role="document">
        <div class="modal-content">
            <div class="modal-header text-center">
                <h4 class="modal-title w-100 font-weight-bold">Delete Task</h4>
                <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                    <span aria-hidden="true">&times;</span>
                </button>
            </div>
            <form method="get" action="${pageContext.request.contextPath}/DeleteTask">
                <div class="modal-body mx-3">
                    <div class="row ">
                        <div class="form-group required col-sm-12">
                            <label for="id" class='control-label'>Id</label>
                            <input type="text" name="id" class="form-control" id="id" placeholder="Task Identifiant">
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
                
                
                
                
<!-- Update Status -->
<div class="modal fade" id="updateStatus" tabindex="-1" role="dialog" aria-labelledby="myModalLabel"
     aria-hidden="true">
    <div class="modal-dialog" role="document">
        <div class="modal-content">
            <div class="modal-header text-center">
                <h4 class="modal-title w-100 font-weight-bold">Update Task</h4>
                <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                    <span aria-hidden="true">&times;</span>
                </button>
            </div>
            <form method="get" action="${pageContext.request.contextPath}/UpdateTask">
                <div class="modal-body mx-3">
                    <div class="row ">
                        <div class="form-group required col-sm-12">
                            <label for="id" class='control-label'>Id</label>
                            <input type="text" name="id" class="form-control" id="id" placeholder="Task Identifiant">
                        </div>
                    </div>
                </div>
                <div class="row ">
                        <div class="form-group required col-sm-12">
                            <label for="id" class='control-label'>Status</label>
                            <select class="browser-default custom-select form-control" name="status">
                                <option value="" disabled selected>Select the task status</option>
                                <option value="Todo">Todo</option>
                                <option value="In Progress">In Progress</option>
                                <option value="Done">Done</option>                     
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

