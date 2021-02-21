<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="IEEE.bean.Event"%>
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
            List<Event> eventslist = (List) request.getAttribute("eventslist");
        %>
        <div class="container col-md-8  pt-5 ">
            <br><br>
            <c:if test="${sessionScope.role != 'member' && sessionScope.role != 'webmaster'}">
                <div class="row mt-5">
                    <div class="col-md-3 offset-2">
                        <a href="${pageContext.request.contextPath}/jsp/EventDetails.jsp" >
                            <button class="btn btn-success" type="submit">Create Event</button>
                        </a>
                    </div>
                    <div class="col-md-3"><a href="" data-toggle="modal" data-target="#updateModal" class="btn btn-warning">Update Event</a></div>
                    <div class="col-md-3"><a href="" data-toggle="modal" data-target="#deleteModal" class="btn btn-danger">Delete Event</a></div>
                </div>
            </c:if>

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
                        <h1>List of Events</h1>
                    </div>
                    <table class="table table-hover">
                        <thead>
                            <tr>
                                <th scope="col">Id</th>
                                <th scope="col">Name</th>
                                <th scope="col">Description</th>
                                <th scope="col">Guests</th>
                                <th scope="col">Date</th>
                                <th scope="col">Time</th>
                                <th scope="col">Flyer</th>
                                <th scope="col">Status</th>

                            </tr>
                        </thead>
                        <tbody>
                            <c:forEach items="${eventslist}" var="event">
                                <tr>
                                    <th scope="row"><c:out value="${event.id}"/></th>
                                    <th scope="row"><c:out value="${event.name}"/></th>
                                    <th scope="row"><c:out value="${event.description}"/></th>
                                    <th scope="row"><c:out value="${event.guests}"/></th>
                                    <th scope="row"><c:out value="${event.date}"/></th>
                                    <th scope="row"><c:out value="${event.time}"/></th>
                                    <th scope="row" style="text-decoration: underline;"><a href="${pageContext.request.contextPath}/DownloadServlet?fileName=${event.imagePath}" ><c:out value="${event.imagePath}" /></a></th>
                                    <th scope="row"><c:out value="${event.status}"/></th>
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




<!-- Update -->
<div class="modal fade" id="updateModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel"
     aria-hidden="true">
    <div class="modal-dialog" role="document">
        <div class="modal-content">
            <div class="modal-header text-center">
                <h4 class="modal-title w-100 font-weight-bold">Update Event</h4>
                <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                    <span aria-hidden="true">&times;</span>
                </button>
            </div>
            <form method="get" action="${pageContext.request.contextPath}/AddEvent">
                <div class="modal-body mx-3">
                    <div class="row ">
                        <div class="form-group required col-sm-12">
                            <label for="eventid" class='control-label'>Id</label>
                            <input type="text" name="eventid" class="form-control" id="id" placeholder="Event Identifiant">
                        </div>
                    </div>
                </div>
                <div class="modal-footer d-flex justify-content-center">
                    <input type="submit" class="btn btn-warning" value="Update"/>
                </div>
            </form>
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
            <form method="get" action="${pageContext.request.contextPath}/DeleteEvent">
                <div class="modal-body mx-3">
                    <div class="row ">
                        <div class="form-group required col-sm-12">
                            <label for="eventid" class='control-label'>Id</label>
                            <input type="text" name="eventid" class="form-control" id="id" placeholder="Event Identifiant">
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
