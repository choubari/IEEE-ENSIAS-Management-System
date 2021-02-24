/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package IEEE.servlets;

import IEEE.bean.Chat;
import IEEE.dao.ChatDao;

import java.util.List;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Time;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.http.HttpSession;
/**
 *
 * @author AdminCH
 */
@WebServlet(name = "ChatServlet", urlPatterns = {"/ChatServlet"})
public class ChatServlet extends HttpServlet {

   
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
            List<Chat> list = ChatDao.getAllChats();
            request.setAttribute("list", list);
            this.getServletContext().getRequestDispatcher("/jsp/Inbox.jsp").forward(request, response);
        
    }

    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        Chat t = new Chat();
        final String msg = request.getParameter("content");
        final SimpleDateFormat timeFormat = new SimpleDateFormat("HH:mm:ss");
        final SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        Date date;
        String content = request.getParameter("content");
        try {
            date = dateFormat.parse(java.time.LocalDate.now().toString());
            long ms = timeFormat.parse(""+java.time.LocalTime.now()).getTime();
            Time time = new Time(ms);
            HttpSession session = request.getSession();
            String memberid = session.getAttribute("ConnectedMemberID").toString();
            int id = Integer.parseInt(memberid);
            t.setFrom(id);
            t.setTo(1);
            t.setDate(date);
            t.setTime(time);
            t.setContent(content);
            if(ChatDao.savenew(t)==1){
                System.out.println("Successful !!");
            }else{
                System.out.println("Faiiiiil !!");
            }
            
        } catch (ParseException ex) {
            Logger.getLogger(ChatServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
        List<Chat> list = ChatDao.getAllChats();
        request.setAttribute("list", list);
        this.getServletContext().getRequestDispatcher("/jsp/Inbox.jsp").forward(request, response);
        
    }

   
}
