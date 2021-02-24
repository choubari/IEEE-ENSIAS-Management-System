<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@ page import="IEEE.bean.Chat"%>
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
    .container{max-width:1170px; margin:auto;}
    img{ max-width:100%;}
    .inbox_people {
        background: #f8f8f8 none repeat scroll 0 0;
        float: left;
        overflow: hidden;
        width: 40%; border-right:1px solid #c4c4c4;
    }
    .inbox_msg {
        border: 1px solid #c4c4c4;
        clear: both;
        overflow: hidden;
    }
    .top_spac{ margin: 20px 0 0;}

    .chat_ib h5{ font-size:15px; color:#464646; margin:0 0 8px 0;}
    .chat_ib h5 span{ font-size:13px; float:right;}
    .chat_ib p{ font-size:14px; color:#989898; margin:auto}
    .chat_img {
        float: left;
        width: 11%;
    }
    .chat_ib {
        float: left;
        padding: 0 0 0 15px;
        width: 88%;
    }

    .chat_people{ overflow:hidden; clear:both;}
    .chat_list {
        border-bottom: 1px solid #c4c4c4;
        margin: 0;
        padding: 18px 16px 10px;
    }
    .inbox_chat { 
        height: 550px; 
        overflow-y: scroll;
    }

    .active_chat{ background:#ebebeb;}

    .incoming_msg_img {
        display: inline-block;
        width: 6%;
    }
    .received_msg {
        display: inline-block;
        padding: 0 0 0 10px;
        vertical-align: top;
        width: 92%;
    }
    .received_withd_msg p {
        background: #ebebeb none repeat scroll 0 0;
        border-radius: 3px;
        color: #646464;
        font-size: 14px;
        margin: 0;
        padding: 5px 10px 5px 12px;
        width: 100%;
    }
    .time_date {
        color: #747474;
        display: block;
        font-size: 12px;
        margin: 8px 0 0;
    }
    .received_withd_msg { width: 57%;}
    .mesgs {
        float: left;
        padding: 30px 15px 0 25px;
        width: 60%;
    }

    .sent_msg p {
        background: #05728f none repeat scroll 0 0;
        border-radius: 3px;
        font-size: 14px;
        margin: 0; color:#fff;
        padding: 5px 10px 5px 12px;
        width:100%;
    }
    .outgoing_msg{ overflow:hidden; margin:26px 0 26px;}
    .sent_msg {
        float: right;
        width: 46%;
    }
    .input_msg_write input {
        background: rgba(0, 0, 0, 0) none repeat scroll 0 0;
        border: medium none;
        color: #4c4c4c;
        font-size: 15px;
        min-height: 48px;
        width: 100%;
    }

    .type_msg {border-top: 1px solid #c4c4c4;position: relative;}
    .msg_send_btn {
        background: #05728f none repeat scroll 0 0;
        border: medium none;
        border-radius: 50%;
        color: #fff;
        cursor: pointer;
        font-size: 17px;
        height: 33px;
        position: absolute;
        right: 0;
        top: 11px;
        width: 33px;
    }
    .messaging { padding: 0 0 50px 0;}
    .msg_history {
        height: 516px;
        overflow-y: auto;
    }
    .circle {
        width: 40px;
        height: 40px;
        line-height: 40px;
        border-radius: 50%;
        font-size: 20px;
        color: #fff;
        text-align: center;
        background: #006db6
    }
</style>
<html>
    <head>
        <%@include file="Header.jsp"%>

    </head>
    <body>
        <%
            List<Chat> list = (List) request.getAttribute("list");
        %>
        <%@include file="loginNavbar.jsp"%>
        <div class="container col-md-8  pt-5 ">
            <br><br> 

            <div class="inbox_chat" id="inbox_chat"> 
                <c:forEach items="${list}" var="val">
                    <c:choose>
                        <c:when test="${sessionScope.ConnectedMemberID == val.from}">
                            <div class="chat_list">
                                <div class="outgoing_msg">
                                    <div class="sent_msg">
                                        <p>${val.content}</p>
                                        <span class="time_date"> ${val.date}    ||     ${val.time}</span> 
                                    </div>
                                </div>
                            </div>
                        </c:when>
                        <c:otherwise>
                            <div class="chat_list">
                                <div class="incoming_msg">
                                    <div class="incoming_msg_img"><div class="circle">${fn:substring(val.sender, -1, 1)}</div> </div>
                                    <div class="received_msg">
                                        <div class="received_withd_msg">
                                            <div class="chat_ib">
                                                <h5>${val.sender}<span class="chat_date">${val.date}    ||     ${val.time}</span></h5>      
                                                <p>${val.content}</p>
                                            </div>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </c:otherwise>
                    </c:choose>
                </c:forEach>
            </div>    

            <div class="type_msg">
                <div class="input_msg_write">
                    <form action="${pageContext.request.contextPath}/ChatServlet" method="POST">
                        <input type="text" name="content" class="write_msg" placeholder="Type a message" />
                        <button class="msg_send_btn" type="submit" value="submit"><i class="fa fa-paper-plane-o" aria-hidden="true"></i></button>
                    </form> 
                </div>
            </div>  


            <script type="text/javascript">
                var element = document.getElementById("inbox_chat");
                element.scrollTop = element.scrollHeight;
            </script>

        </div>
        <%@include file="Footer.jsp"%>
    </body>
</html>
