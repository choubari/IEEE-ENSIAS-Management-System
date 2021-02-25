/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package IEEE.servlets;

import IEEE.bean.ContactForm;
import IEEE.dao.ContactformDao;
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
@WebServlet(name = "ContactForm", urlPatterns = {"/ContactForm"})
public class ContactServlet extends HttpServlet {
    private String MessageFaild="";
    private String MessageSuccess="";
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
            List<ContactForm> formfillers = ContactformDao.getAllRecords();
            //System.out.println(formfillers);
            request.setAttribute("formfillers", formfillers);
            this.getServletContext().getRequestDispatcher("/jsp/ContactForm.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        ContactForm u = new ContactForm();
        String name = request.getParameter("name");
        String email = request.getParameter("email");
        String subject = request.getParameter("subject");
        String message = request.getParameter("message");
        //System.out.println("  "+name+" "+ email+ " " + subject+" " + message);
        if (name.isEmpty() || email.isEmpty() || subject.isEmpty() || message.isEmpty()){
            //System.out.println("Hello1");
            MessageFaild = "Please complete all fields";
            request.setAttribute("MessageFaild", MessageFaild);
            //System.out.println("Hello1");
            this.getServletContext().getRequestDispatcher("/jsp/contactUs.jsp").forward(request, response);
            //doGet(request, response);
        }else{
            u.setName(name);
            u.setEmail(email);
            u.setSubject(subject);
            u.setMessage(message);
            if (ContactformDao.save(u)==1){
                MessageSuccess="Your message is successully Inserted";
                request.setAttribute("MessageSuccess", MessageSuccess);
                this.getServletContext().getRequestDispatcher("/jsp/contactUs.jsp").forward(request, response);
            }else{
                MessageFaild = "An error occurred, Please Try again!";
                request.setAttribute("MessageFaild", MessageFaild);
                this.getServletContext().getRequestDispatcher("/jsp/contactUs.jsp").forward(request, response);
            }
        }
        
    }

}
