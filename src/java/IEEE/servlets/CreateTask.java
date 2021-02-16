/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package IEEE.servlets;

import IEEE.bean.Task;
import IEEE.dao.TaskDao;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author AdminCH
 */
@WebServlet(name = "CreateTask", urlPatterns = {"/CreateTask"})
public class CreateTask extends HttpServlet {
    private String MessageFaild="";
    private String MessageSuccess="";
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        Task t = new Task();
        String name = request.getParameter("name");
        String description = request.getParameter("description");
        String dead_line = request.getParameter("deadline");
        String resp_id = request.getParameter("responsable_id");
        if (name.isEmpty() || description.isEmpty() || dead_line.isEmpty() || resp_id.isEmpty()){
            MessageFaild = "Please complete all fields";
            request.setAttribute("MessageFaild", MessageFaild);
            this.getServletContext().getRequestDispatcher("/ShowTasks").forward(request, response);
            //doGet(request, response);
        }else{
            try {      
                int responsable_id = Integer.parseInt(resp_id);
                SimpleDateFormat format1 = new SimpleDateFormat("yyyy-MM-dd");
                Date deadline = format1.parse(dead_line);
                t.setName(name);
                t.setDescription(description);
                t.setDeadline(deadline);
                t.setResponsable_id(responsable_id);
                t.setCreator_id((int) request.getSession().getAttribute("ConnectedMemberID"));

                if (TaskDao.savenew(t)==1){
                    MessageSuccess="Success";
                    request.setAttribute("MessageSuccess", MessageSuccess);
                    this.getServletContext().getRequestDispatcher("/ShowTasks").forward(request, response);
                }else{
                    MessageFaild = "An error occurred, Please Try again!";
                    request.setAttribute("MessageFaild", MessageFaild);
                    this.getServletContext().getRequestDispatcher("/ShowTasks").forward(request, response);
                }
            } catch (ParseException ex) {
                Logger.getLogger(CreateTask.class.getName()).log(Level.SEVERE, null, ex);
                MessageFaild = "An error occurred, Please Try again!";
                request.setAttribute("MessageFaild", MessageFaild);
                this.getServletContext().getRequestDispatcher("/ShowTasks").forward(request, response);
            }
        }
        
    }
    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        
        
    }

}
