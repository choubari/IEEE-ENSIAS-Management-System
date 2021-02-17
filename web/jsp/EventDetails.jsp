<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="IEEE.bean.Event"%>
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
           Event oldevent = (Event) request.getAttribute("oldevent");
        %>
      <div class="container col-md-8" style="margin-top: 100px;">


    <div class="row">
        <div class="col col-md-12">

            <div class="wrapper wrapper--w790">
                <div class="card">
                    <h5 class="card-header white-text text-center py-4" style="background-color: #006db6;">
                        <strong>Event Details</strong>
                    </h5>
                    <div class="card-body">
                        <form method="post" action="${pageContext.request.contextPath}/AddEvent" enctype="multipart/form-data">
                            <div class="row row-space">
                                <div class="form-group required col-sm-12">
                                    <label for="title" class='control-label'>Event Name</label>
                                    <input type="text" name="name" class="form-control" id="title" placeholder="Event title" <c:if test="${oldevent.name ne null}"> value="${oldevent.name}" </c:if> >
                                    <!--<small id="emailHelp" class="form-text text-muted">We'll never share your email with anyone else.</small>-->
                                </div>

                            </div>
                            <div class="row">
                                <div class="form-group required col-sm-12">
                                    <label for="description" class='control-label'>Event Description</label>
                                    <textarea class="form-control" id="description" name="description" rows="7" placeholder="Event Description"><c:if test="${oldevent.description ne null}">${oldevent.description}</c:if></textarea>
                                    <!--<small id="emailHelp" class="form-text text-muted">We'll never share your email with anyone else.</small>-->
                                </div>
                            </div>
                            <div class="row row-space">
                                <div class="form-group required col-sm-12">
                                    <label for="title" class='control-label'>Event Guests</label>
                                    <input type="text" name="guests" class="form-control" id="guests" placeholder="Event Guests" <c:if test="${oldevent.guests ne null}"> value="${oldevent.guests}" </c:if> >
                                    <!--<small id="emailHelp" class="form-text text-muted">We'll never share your email with anyone else.</small>-->
                                </div>
                            </div>
                            <div class="row ">
                                <div class="form-group required col-sm-12">
                                    <label for="date" class='control-label'>Event Date</label>
                                    <input type="date" name="date" class="form-control" id="date" <c:if test="${oldevent.date ne null}"> value="${oldevent.date}" </c:if>>
                                    <!--<small id="emailHelp" class="form-text text-muted">We'll never share your email with anyone else.</small>-->
                                </div>
                            </div>
                            <div class="row ">
                                <div class="form-group required col-sm-12">
                                    <label for="time" class='control-label'>Event time</label>
                                    <input type="time" name="time" class="form-control" id="time" <c:if test="${oldevent.time ne null}"> value="${oldevent.time}" </c:if>>
                                    <!--<small id="emailHelp" class="form-text text-muted">We'll never share your email with anyone else.</small>-->
                                </div>
                            </div>
                                
                            <div class="row ">
                                <div class="form-group required col-sm-12"> 
                                    <div class="form-group required col-sm-12 custom-file ">
                                        <input type="file" class="custom-file-input" id="imgInput" name="imgInput"
                                               aria-describedby="imgInput" required>
                                        <label class="custom-file-label " for="imgInput">Event image cover </label>
                                    </div>
                                  </div>
                            </div>
                            
                            <div class="row ">
                                <div class="form-group required col-sm-12">
                                    <label class="control-label">Status</label>
                                        <select class="browser-default custom-select form-control" name="status">
                                            <option value="" disabled selected>Select the visibility</option>
                                            <option value="private">Private</option>
                                            <option value="public">Public</option>                             
                                        </select>
                                  </div>
                            </div>
                            <!-- Submit -->
                            <div class="row">
                                <div class="form-group col-sm-4">
                                    <button class="btn btn-outline-info btn-rounded btn-block z-depth-0 my-4 waves-effect"
                                            type="submit" style="border-color: #D92228 !important; color: #D92228 !important;">
                                        Save
                                    </button>
                                </div>

                            </div>


                        </form>

                    </div>
                </div>
            </div>


        </div>

    </div>

</div>
 <%@include file="Footer.jsp"%>  
        
    </body>
</html>
