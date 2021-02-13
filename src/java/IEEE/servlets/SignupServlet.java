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
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author AdminCH
 */
@WebServlet(name = "SignupServlet", urlPatterns = {"/SignupServlet"})
public class SignupServlet extends HttpServlet {
    Member u = new Member();
    String isInserted;
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
       
    }

   
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String firstname=request.getParameter("firstname"); 
        String lastname=request.getParameter("lastname"); 
        String email=request.getParameter("email"); 
        String password=request.getParameter("password"); 
        String phone=request.getParameter("phone"); 
        String branch=request.getParameter("branch"); 
        String promo=request.getParameter("promo"); 
        String cell=request.getParameter("cell"); 
        if(firstname.isEmpty() || lastname.isEmpty() || email.isEmpty() || password.isEmpty() || phone.isEmpty() || branch.isEmpty() || promo.isEmpty() || cell.isEmpty()){
            isInserted="empty";
        }else{
            u.setFirstname(firstname);
            u.setLastname(lastname);
            u.setEmail(email);
            u.setPassword(password);
            u.setPhone(phone);
            u.setPromo(Integer.parseInt(promo));
            u.setBranch(branch);
            u.setCell(cell);
            if (MemberDao.save(u) > 0) {
                isInserted="succes";
            } 
            else {
                 isInserted="failure";
            }
        }    
        request.setAttribute("isInserted", isInserted);
        this.getServletContext().getRequestDispatcher("/jsp/signup.jsp").forward(request, response);
    }

}
