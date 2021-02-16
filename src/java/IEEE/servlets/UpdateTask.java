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
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
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
@WebServlet(name = "UpdateTask", urlPatterns = {"/UpdateTask"})
public class UpdateTask extends HttpServlet {
    private String MessageFaild="";
    private String MessageSuccess="";
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String ID = request.getParameter("id");
        String name = request.getParameter("name");
        String description = request.getParameter("description");
        String dead_line = request.getParameter("deadline");
        String resp_id = request.getParameter("responsable_id");
        boolean sameresponsible = false ;
        String status = request.getParameter("status");
        String role = request.getSession().getAttribute("role").toString();
        if (ID.isEmpty() || (role.equals("member") && status==null)){
            MessageFaild = "Please fill the required (*) field";
            request.setAttribute("MessageFaild", MessageFaild);
            this.getServletContext().getRequestDispatcher("/ShowTasks").forward(request, response);
            //doGet(request, response);
        }else{
            try {  
                int id = Integer.parseInt(ID);
                Task t = TaskDao.getTaskById(id);
                if (!name.isEmpty()) t.setName(name);
                if (!description.isEmpty()) t.setDescription(description);
                if (!dead_line.isEmpty()) {
                    SimpleDateFormat format1 = new SimpleDateFormat("yyyy-MM-dd");
                    Date deadline = format1.parse(dead_line);
                    t.setDeadline(deadline);
                }
                if (status!=null && !status.isEmpty()) t.setStatus(status);
                if (!resp_id.isEmpty()){
                    int responsable_id = Integer.parseInt(resp_id);
                    if((int) t.getResponsable_id() == responsable_id) sameresponsible=true;
                    t.setResponsable_id(responsable_id);
                }
                
                HttpSession session = request.getSession();
                List<Task> mycreatedtasks = TaskDao.getMyCreatedTasks((int) session.getAttribute("ConnectedMemberID"));
                List<Task> mytasks = TaskDao.getMyTasks((int) session.getAttribute("ConnectedMemberID"));
                boolean youcanupdate = false ;
                for (int i=0; i< mycreatedtasks.size();i++){
                    if (mycreatedtasks.get(i).getId()==id){    
                        youcanupdate = true;
                        break;
                    }
                }
                for (int j=0; j<mytasks.size();j++){
                    if (mytasks.get(j).getId()==id){ 
                        if(! mycreatedtasks.contains(mytasks.get(j))){ 
                                if( !resp_id.isEmpty() && !sameresponsible ) {
                                    MessageFaild = "You can't update the responsible of this task!";
                                    request.setAttribute("MessageFaild", MessageFaild);
                                    this.getServletContext().getRequestDispatcher("/ShowTasks").forward(request, response);
                                }
                                 youcanupdate = true;
                            }
                    }
                }
                
                if (!youcanupdate){
                    MessageFaild = "You can't update this task!";
                    request.setAttribute("MessageFaild", MessageFaild);
                    this.getServletContext().getRequestDispatcher("/ShowTasks").forward(request, response);
                }else {
                    if (TaskDao.update(t)==1){
                        MessageSuccess="Successfully updated";
                        request.setAttribute("MessageSuccess", MessageSuccess);
                        this.getServletContext().getRequestDispatcher("/ShowTasks").forward(request, response);
                    }else{
                        MessageFaild = "An error occurred, Please Try again!";
                        request.setAttribute("MessageFaild", MessageFaild);
                        this.getServletContext().getRequestDispatcher("/ShowTasks").forward(request, response);
                    }
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
