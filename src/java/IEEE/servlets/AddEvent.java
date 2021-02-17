/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package IEEE.servlets;

import IEEE.bean.Event;
import IEEE.dao.EventDao;
import java.io.*;
import java.sql.Time;
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

import java.text.ParseException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.http.*;

/**
 *
 * @author AdminCH
 */
@WebServlet(name = "AddEvent", urlPatterns = {"/AddEvent"})
@MultipartConfig(fileSizeThreshold = 1024 * 1024 * 2, maxFileSize = 1024 * 1024 * 10, maxRequestSize = 1024 * 1024 * 50)
public class AddEvent extends HttpServlet {
    private String MessageFaild="";
    private String MessageSuccess="";
    public static final int TAILLE_TAMPON=1024*1024*10;
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String eventid = request.getParameter("eventid");
        if (eventid.isEmpty()){
            MessageFaild = "Please complete the ID field";
            request.setAttribute("MessageFaild", MessageFaild);
            this.getServletContext().getRequestDispatcher("/ShowEvents").forward(request, response);
      
        }else{
            int id = Integer.parseInt(eventid);
            HttpSession session = request.getSession();
            session.setAttribute("event_id",id);
            Event e = EventDao.getEventById(id);
            if (e!=null) request.setAttribute("oldevent", e);
            this.getServletContext().getRequestDispatcher("/jsp/EventDetails.jsp").forward(request, response);
            
        }
    }

    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        Event e = new Event();
        String name = request.getParameter("name");
        String description = request.getParameter("description");
        String guests = request.getParameter("guests");
        String eventdate = request.getParameter("date");
        String eventtime = request.getParameter("time");
        Part part = request.getPart("imgInput");
        String fileName = extractFileName(part);
        //System.out.println(eventdate +" "+eventtime+" "+part.toString());
        String status = request.getParameter("status");
        //System.out.println(eventdate +" "+eventtime+" "+name+description+guests+" "+status);
        if (name.isEmpty() || description.isEmpty() || guests.isEmpty() || eventdate.isEmpty() || eventtime.isEmpty() || fileName.isEmpty() || status.isEmpty()){
            //System.out.println("Hello1");
            MessageFaild = "Please complete all fields";
            request.setAttribute("MessageFaild", MessageFaild);
            System.out.println("Hello1");
            this.getServletContext().getRequestDispatcher("/ShowEvents").forward(request, response);
            //doGet(request, response);
        }else{
            System.out.println("Hello2");
            System.out.println(fileName);
            String error="";
            error=validationChamp(fileName,"[^\\s]+(\\.(?i)(jpg|png|gif|bmp))$","Please choose file with (.png, .jpg, .gif, .bmp) extension.");
            if(error!=""){
                request.setAttribute("MessageFaild",error);
                this.getServletContext().getRequestDispatcher("/ShowEvents").forward(request, response);
            }else{
                System.out.println("Hello3");
                if(!fileName.isEmpty() && fileName!=null){
                        writeFile(part,fileName,"C:\\Users\\Admin CH\\Documents\\GitHub\\IEEE-ENSIAS\\web\\img\\uploads");
                }
                try {
                    SimpleDateFormat format1 = new SimpleDateFormat("yyyy-MM-dd");
                    SimpleDateFormat format2 = new SimpleDateFormat("HH:mm");
                    Date date  = format1.parse(eventdate);
                    long ms = format2.parse(eventtime).getTime();
                    Time time = new Time(ms);
                    e.setName(name);
                    e.setDescription(description);
                    e.setGuests(guests);
                    e.setDate(date);
                    e.setTime(time);
                    e.setStatus(status);
                    e.setImagePath(fileName);
                    String eventid = request.getSession().getAttribute("event_id").toString();
                    if (!eventid.isEmpty()){
                        int id = Integer.parseInt(eventid);
                        System.out.println("id is : "+id);
                        e.setId(id);
                        if (EventDao.update(e)==1){
                            MessageSuccess="Event Successully Updated";
                            request.setAttribute("MessageSuccess", MessageSuccess);
                            System.out.println("Hello4");
                            this.getServletContext().getRequestDispatcher("/ShowEvents").forward(request, response);
                        }else{
                            MessageFaild = "An error occurred, Please Try again!";
                            request.setAttribute("MessageFaild", MessageFaild);
                            this.getServletContext().getRequestDispatcher("/ShowEvents").forward(request, response);
                        }
                    }else{
                        if (EventDao.savenew(e)==1){
                            MessageSuccess="Event Successully Inserted";
                            request.setAttribute("MessageSuccess", MessageSuccess);
                            System.out.println("Hello5");
                            this.getServletContext().getRequestDispatcher("/ShowEvents").forward(request, response);
                        }else{
                            MessageFaild = "An error occurred, Please Try again!";
                            request.setAttribute("MessageFaild", MessageFaild);
                            this.getServletContext().getRequestDispatcher("/ShowEvents").forward(request, response);
                        }
                    }
                } catch (ParseException ex) {
                    Logger.getLogger(AddEvent.class.getName()).log(Level.SEVERE, null, ex);
                    MessageFaild = "An error occurred, Please Try again!";
                    request.setAttribute("MessageFaild", MessageFaild);
                    this.getServletContext().getRequestDispatcher("/ShowEvents").forward(request, response);
                }
            
            }   
        }   
    }

    
    
    private String extractFileName(Part part) {

        String contentDisp = part.getHeader("content-disposition");
        String[] items = contentDisp.split(";");

        for (String s : items) {
            if (s.trim().startsWith("filename")) {
                return s.substring(s.indexOf("=") + 2, s.length() - 1);
            }
        }
        return "";
    }
    private String validationChamp(String field, String pattern,String erreur){
        if(!field.matches(pattern)){
            return erreur;
        }
        return "";
    }

    private void writeFile( Part part, String nomFichier, String chemin ) throws IOException {
        /* PrĂ©pare les flux. */
        BufferedInputStream entree = null;
        BufferedOutputStream sortie = null;
        try {
            /* Ouvre les flux. */
            entree = new BufferedInputStream( part.getInputStream(), TAILLE_TAMPON );
            sortie = new BufferedOutputStream( new FileOutputStream( new File( chemin +"\\"+ nomFichier ) ),
                    TAILLE_TAMPON );
            byte[] tampon = new byte[TAILLE_TAMPON];
            int longueur;
            while ( ( longueur = entree.read( tampon ) ) > 0 ) {
                sortie.write( tampon, 0, longueur );
            }
        } finally {
            try {
                sortie.close();
            } catch ( IOException ignore ) {
            }
            try {
                entree.close();
            } catch ( IOException ignore ) {
            }
        }
    }
   
    
}
