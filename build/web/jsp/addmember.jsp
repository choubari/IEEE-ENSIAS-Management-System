<%-- 
    Document   : addmember
    Created on : 29 janv. 2021, 01:23:41
    Author     : AdminCH
--%>
<%@page import="IEEE.dao.MemberDao"%>  
<jsp:useBean id="u" class="IEEE.bean.Member"></jsp:useBean>  
<jsp:setProperty property="*" name="u"/>  

<%
    int i = MemberDao.save(u);
    if (i > 0) {
        response.sendRedirect("../index.jsp");
    } else {
        response.sendRedirect("login.jsp");
    }
%>  


