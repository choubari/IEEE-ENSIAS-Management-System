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
@WebServlet(name = "ShowTasks", urlPatterns = {"/ShowTasks"})
public class ShowTasks extends HttpServlet {

   
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
       List<Task> mytasks = TaskDao.getMyTasks((int) request.getSession().getAttribute("ConnectedMemberID"));
       List<Task> delegatedtasks = TaskDao.getMyDelegatedTasks((int) request.getSession().getAttribute("ConnectedMemberID"));
       request.setAttribute("mytasks", mytasks);
       request.setAttribute("delegatedtasks", delegatedtasks);
       this.getServletContext().getRequestDispatcher("/jsp/TaskManagement.jsp").forward(request, response);
        
    }

    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
    }

    
}
