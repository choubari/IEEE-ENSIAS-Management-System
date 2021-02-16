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
import java.util.Objects;
import java.util.stream.Collectors;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author AdminCH
 */
@WebServlet(name = "DeleteTask", urlPatterns = {"/DeleteTask"})
public class DeleteTask extends HttpServlet {
    private String MessageFaild="";
    private String MessageSuccess="";
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        Task t = new Task();
        String getid = request.getParameter("id");
        if (getid.isEmpty()){
            MessageFaild = "Please fill the Task Id field";
            request.setAttribute("MessageFaild", MessageFaild);
            this.getServletContext().getRequestDispatcher("/ShowTasks").forward(request, response);
        }else{
            int taskid=Integer.parseInt(getid);
            t.setId(taskid);
            String role = request.getSession().getAttribute("role").toString();
            
                HttpSession session = request.getSession();
                List<Task> mycreatedtasks = TaskDao.getMyCreatedTasks((int) session.getAttribute("ConnectedMemberID"));
                boolean youcandelete = false ;
                for (int i=0; i< mycreatedtasks.size();i++){
                    if (mycreatedtasks.get(i).getId()==taskid){
                        youcandelete = true;
                        break;
                    }
                }
                
                if (!youcandelete){
                    MessageFaild = "You can't delete this task!";
                    request.setAttribute("MessageFaild", MessageFaild);
                    this.getServletContext().getRequestDispatcher("/ShowTasks").forward(request, response);
                }else {
                    if (TaskDao.delete(t)==1){
                        MessageSuccess="Successfully deleted";
                        request.setAttribute("MessageSuccess", MessageSuccess);
                        this.getServletContext().getRequestDispatcher("/ShowTasks").forward(request, response);
                    }else{
                            MessageFaild = "An error occurred, Please Try again!";
                            request.setAttribute("MessageFaild", MessageFaild);
                            this.getServletContext().getRequestDispatcher("/ShowTasks").forward(request, response);
                    }
                }
            
            
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
    }

  
}
