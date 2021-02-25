/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package IEEE.servlets;

import IEEE.dao.EventDao;
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
@WebServlet(name = "ShowStats", urlPatterns = {"/ShowStats"})
public class ShowStats extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
   
        int totalMembers = MemberDao.getCountActifMembers();
        int totalRequests = MemberDao.getCountInactifMembers() ;
        int totalEvents = EventDao.getCountEvents();
        int totalVisitors = EventDao.getCountEvents();
        request.setAttribute("totalMembers", totalMembers);
        request.setAttribute("totalRequests", totalRequests);
        request.setAttribute("totalEvents", totalEvents);
        request.setAttribute("totalVisitors", totalVisitors);
        
        int requestsMedia = MemberDao.getCountInactifMedia();
        int requestsEvent = MemberDao.getCountInactifEvent();
        int requestsTutorial = MemberDao.getCountInactifTutorial();
        int requestsDesign = MemberDao.getCountInactifDesign();
        int requestsSponsoring = MemberDao.getCountInactifSponsoring();
        request.setAttribute("requestsMedia", requestsMedia);
        request.setAttribute("requestsTutorial", requestsTutorial);
        request.setAttribute("requestsEvent", requestsEvent);
        request.setAttribute("requestsDesign", requestsDesign);
        request.setAttribute("requestsSponsoring", requestsSponsoring);
        this.getServletContext().getRequestDispatcher("/jsp/statistics.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    
    }

    
}
