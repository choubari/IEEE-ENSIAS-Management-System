/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package IEEE.servlets;

import IEEE.bean.Event;
import IEEE.dao.EventDao;
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
@WebServlet(name = "ShowEvents", urlPatterns = {"/ShowEvents"})
public class ShowEvents extends HttpServlet {

   
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
       List<Event> eventslist = EventDao.getAllEvents();
       System.out.println("events list :"+eventslist);
       request.setAttribute("eventslist", eventslist);
       this.getServletContext().getRequestDispatcher("/jsp/Events.jsp").forward(request, response);
      
    }

    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
       this.getServletContext().getRequestDispatcher("/jsp/Events.jsp").forward(request, response);
    }

}
