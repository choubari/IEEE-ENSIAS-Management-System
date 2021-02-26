/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package IEEE.servlets;

import IEEE.bean.Member;
import IEEE.dao.MemberDao;
import IEEE.dto.EmailUtil;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.mail.MessagingException;
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
                String host = "smtp.gmail.com";
                String port = "587";
                String user = "1email4project@gmail.com";
                String pass = "1EMAIL4project";
                String content = "Hello "+firstname+",\n" +
                        "\n" +
                        "We have successfully received your request to join us.\n" +
                        "\n" +
                        "We will reach you by email in the next few days. \n" +
                        "\n" +
                        "Best Regards, \n" +
                        "IEEE ENSIAS";
                try {
                    EmailUtil.sendEmail(host, port, user, pass, email, "We received your request to join us!",content);
                } catch (MessagingException ex) {
                    Logger.getLogger(SignupServlet.class.getName()).log(Level.SEVERE, null, ex);
                }
            } 
            else {
                 isInserted="failure";
            }
        }    
        request.setAttribute("isInserted", isInserted);
        this.getServletContext().getRequestDispatcher("/jsp/signup.jsp").forward(request, response);
    }

}
