<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="IEEE.bean.Datacenter"%>
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
        <div class="container col-md-8  pt-5 ">
            <br><br>
                <div class="row mt-5">
                    <div class="col-md-3"><a href="" data-toggle="modal" data-target="#addFile" class="btn btn-success">Add File</a></div>
                    <div class="col-md-3"><a href="" data-toggle="modal" data-target="#deleteFile" class="btn btn-danger">Delete File</a></div>
                </div>
            
        <%
           List<Datacenter> files = (List) request.getAttribute("files");
        %>
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

            <!-- List of files --> 
            <div class="card card-cascade wider reverse mt-5">
                <!-- Card content -->
                <div class="card-body card-body-cascade">
                    <!-- Title -->
                    <div class="section-title text-center wow zoomInfont-weight-bold">
                        <h1>List of Files</h1>
                    </div>
                    <table class="table table-hover">
                        <thead>
                            <tr>
                                <th scope="col">Id</th>
                                <th scope="col">Name</th>
                                <th scope="col">File</th>
                                <th scope="col">Date</th>
                                <th scope="col">Time</th>
                                <th scope="col">Uploaded by</th>

                            </tr>
                        </thead>
                        <tbody>
                            <c:forEach items="${files}" var="file">
                                <tr>
                                    <th scope="row"><c:out value="${file.id}"/></th>
                                    <th scope="row"><c:out value="${file.name}"/></th>
                                    <th scope="row"><a href="${pageContext.request.contextPath}/DownloadServlet?fileName=${file.path}" ><c:out value="${file.path}"/></a></th>
                                    <th scope="row"><c:out value="${file.date}"/></th>
                                    <th scope="row"><c:out value="${file.time}"/></th>
                                    <th scope="row"><c:out value="${file.ownername}"/></th>
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


<!-- Add -->
<div class="modal fade" id="addFile" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
    <div class="modal-dialog" role="document">
        <div class="modal-content">
            <div class="modal-header text-center">
                <h4 class="modal-title w-100 font-weight-bold">Add File</h4>
                <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                    <span aria-hidden="true">&times;</span>
                </button>
            </div>
            <form method="post" action="${pageContext.request.contextPath}/AddFile" enctype="multipart/form-data">
                <div class="modal-body mx-3">
                    <div class="row ">
                        <div class="form-group required col-sm-12">
                            <label for="name" class='control-label'>Name</label>
                            <input type="text" name="name" class="form-control" id="id" placeholder="Name">
                        </div>
                    </div>
                    <div class="row ">
                        <div class="form-group required col-sm-12"> 
                            <div class="form-group required col-sm-12 custom-file ">
                                <input type="file" class="custom-file-input" id="file" name="filepath"
                                       aria-describedby="file" required>
                                <label class="custom-file-label " for="filepath">File</label>
                            </div>
                        </div>
                    </div>
                </div>
                <div class="modal-footer d-flex justify-content-center">
                    <input type="submit" class="btn btn-success" value="Add"/>
                </div>
            </form>
        </div>
    </div>
</div>


<!-- Delete -->
<div class="modal fade" id="deleteFile" tabindex="-1" role="dialog" aria-labelledby="myModalLabel"
     aria-hidden="true">
    <div class="modal-dialog" role="document">
        <div class="modal-content">
            <div class="modal-header text-center">
                <h4 class="modal-title w-100 font-weight-bold">Delete File</h4>
                <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                    <span aria-hidden="true">&times;</span>
                </button>
            </div>
            <form method="get" action="${pageContext.request.contextPath}/DeleteFile">
                <div class="modal-body mx-3">
                    <div class="row ">
                        <div class="form-group required col-sm-12">
                            <label for="fileid" class='control-label'>Id</label>
                            <input type="text" name="fileid" class="form-control" id="id" placeholder="File Identifiant">
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
