<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <%@include file="Header.jsp" %>
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
</head>
<body>

<%@include file="othersNavbar.jsp"%>
<div class="container col-md-8" style="margin-top: 100px;">
<h1>Welcome Chef!</h1>
<h1>Welcome Chef!</h1>
<h1>Welcome Chef!</h1>
<h1>Welcome Chef!</h1>


</div>



<!--- FOOTER -->
<%@ include file="Footer.jsp" %>
</body>
</html>
