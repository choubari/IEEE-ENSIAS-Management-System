/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package IEEE.servlets;

import IEEE.bean.Newsletter;
import IEEE.dao.NewsletterDao;
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
@WebServlet(name = "NewsletterServlet", urlPatterns = {"/NewsletterServlet"})
public class NewsletterServlet extends HttpServlet {

    private String MessageFaild="";
    private String MessageSuccess="";
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        List<Newsletter> newsletterdata = NewsletterDao.getAllRecords();
        request.setAttribute("newsletterdata", newsletterdata);
        this.getServletContext().getRequestDispatcher("/jsp/NewsletterManagement.jsp").forward(request, response);
    }
    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        if (request.getSession().getAttribute("role").equals("webmaster")){
                doGet(request, response);
        }else{
            Newsletter u = new Newsletter();
            String name = request.getParameter("name");
            String email = request.getParameter("email");

            if (name.isEmpty() || email.isEmpty()){
                //System.out.println("Hello1");
                MessageFaild = "Please complete all fields";
                request.setAttribute("MessageFaild", MessageFaild);
                //System.out.println("Hello1");
                this.getServletContext().getRequestDispatcher("/index.jsp").forward(request, response);
                //doGet(request, response);
            }else{

                u.setName(name);
                u.setEmail(email);
                if (NewsletterDao.save(u)==1){
                    MessageSuccess="Thank you for your subscription!";
                    request.setAttribute("MessageSuccess", MessageSuccess);
                    this.getServletContext().getRequestDispatcher("/index.jsp").forward(request, response);
                }else{
                    MessageFaild = "An error occurred, Please Try again!";
                    request.setAttribute("MessageFaild", MessageFaild);
                    this.getServletContext().getRequestDispatcher("/index.jsp").forward(request, response);
                }
            }
        }
    }

}
