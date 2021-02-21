<%@ page contentType="text/html;charset=UTF-8" language="java" %>
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
<style>
    body {
    margin: 40px 10px;
    padding: 0;
    font-family: "Lucida Grande",Helvetica,Arial,Verdana,sans-serif;
    font-size: 14px;
    }
    #calendar {
    max-width: 900px;
    margin: 0 auto;
    }
</style>
<html>
    <head>
        <<%@include file="Header.jsp"%>
        
        <link href='${pageContext.request.contextPath}/css/fullcalendar.css' rel='stylesheet' />
        <link href='${pageContext.request.contextPath}/css/fullcalendar.print.css' rel='stylesheet' media='print' />
        <script src='${pageContext.request.contextPath}/js/moment.min.js'></script>
        <script src='${pageContext.request.contextPath}/js/jquery.min.js'></script>
        
        <script src='${pageContext.request.contextPath}/js/fullcalendar.min.js'></script>
        <script src='${pageContext.request.contextPath}/js/fullcalendar.js'></script>
        
        <script>
            $(document).ready(function() {
            $('#calendar').fullCalendar({

            <!--Header Section Including Previous,Next and Today-->
            header: {
            left: 'prev,next today',
            center: 'title',
            right: 'month,basicWeek,basicDay'
            },

            <!--Default Date :
            defaultDate: '2015-02-12',-->
            editable: true,
            eventLimit: true, // allow "more" link when too many events 
            });
            });
        </script>
  
    
    </head>
    <body>
        <%@include file="loginNavbar.jsp"%>
        <div class="container col-md-8  pt-5 ">
            <br><br>
            <div id="calendar">          
            </div>
        </div>
        
        <script>
            $(document).ready(function() {
            $('#calendar').fullCalendar({

            <!--Header Section Including Previous,Next and Today-->
            header: {
            left: 'prev,next today',
            center: 'title',
            right: 'month,basicWeek,basicDay'
            },

            <!--Event Section-->
            eventLimit: true, // allow "more" link when too many events
            events: "${pageContext.request.contextPath}/CalendarServlet",
            });
            });
        </script>
        
        
        
        
        
        
        
            
            
        <%@include file="Footer.jsp"%>
    </body>
</html>