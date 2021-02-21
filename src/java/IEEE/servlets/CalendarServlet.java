/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package IEEE.servlets;

import IEEE.bean.Event;
import IEEE.bean.Task;
import IEEE.dao.EventDao;
import IEEE.dao.TaskDao;
import IEEE.dto.CalendarDTO;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.google.gson.Gson;

/**
 *
 * @author AdminCH
 */
@WebServlet(name = "CalendarServlet", urlPatterns = {"/CalendarServlet"})
public class CalendarServlet extends HttpServlet {

   
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        //System.out.println("Im in the servlet !!! ");
        List l = new ArrayList();
        List<Task> mytasks = TaskDao.getMyTasks((int) request.getSession().getAttribute("ConnectedMemberID"));
        List<Event> eventslist = EventDao.getAllEvents();
        for (int i =0; i<mytasks.size();i++){
            CalendarDTO c = new CalendarDTO();
            c.setId(i+1);
            c.setStart(mytasks.get(i).getDeadline().toString());
            c.setEnd(mytasks.get(i).getDeadline().toString());
            c.setTitle(mytasks.get(i).getName().toString());
            l.add(c);
        }
        
        for (int j =0; j<eventslist.size();j++){
            CalendarDTO d = new CalendarDTO();
            d.setId(j+1);
            d.setStart(eventslist.get(j).getDate().toString());
            d.setEnd(eventslist.get(j).getDate().toString());
            d.setTitle(eventslist.get(j).getName().toString());
            l.add(d);
        }
        

       String json = new Gson().toJson(l);
       response.setContentType("application/json");
       response.setCharacterEncoding("UTF-8");
       response.getWriter().write(json);
    }

    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
    }

}
