/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package IEEE.servlets;

import IEEE.bean.Member;
import IEEE.dao.MemberDao;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author AdminCH
 */
@WebServlet(name = "ProfileServlet", urlPatterns = {"/ProfileServlet"})
public class ProfileServlet extends HttpServlet {
    private String firstname, lastname, password, email, phone, branch, cell, role; 
    Member member;
    private String MessageFailed="";
    private String MessageSuccess="";

    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        member = (Member) MemberDao.getRecordByLogin(request.getSession().getAttribute("email").toString(),request.getSession().getAttribute("password").toString());
        request.setAttribute("member", member);
        this.getServletContext().getRequestDispatcher("/jsp/profile.jsp").forward(request, response);
    }

    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String firstname = request.getParameter("firstname");
        String lastname = request.getParameter("lastname");
        String branch = request.getParameter("branch");
        String email = request.getParameter("email");
        String password = request.getParameter("password");
        String phone = request.getParameter("phone");
        //String cell = request.getParameter("cellule");
        //System.out.println(firstname+lastname+branch+email+password+phone);
        if (firstname.isEmpty() || lastname.isEmpty() || branch.isEmpty() || email.isEmpty() ||
                password.isEmpty() || phone.isEmpty()){

            MessageFailed = "Please complete all fields";
            request.setAttribute("MessageFailed", MessageFailed);
            doGet(request, response);

            //this.getServletContext().getRequestDispatcher("/jsp/profile.jsp").forward(request, response);

        }else{
            member = (Member) MemberDao.getRecordByLogin(request.getSession().getAttribute("email").toString(),request.getSession().getAttribute("password").toString());
            member.setFirstname(firstname);
            member.setLastname(lastname);
            member.setBranch(branch);
            member.setEmail(email);
            member.setPassword(password);
            member.setPhone(phone);
           MessageSuccess = "Profile Updated";
           request.setAttribute("MessageSuccess", MessageSuccess);
           //this.getServletContext().getRequestDispatcher("/jsp/profile.jsp").forward(request, response);
           doGet(request, response);
            
        }
    }

    
}
