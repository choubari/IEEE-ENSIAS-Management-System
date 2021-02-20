/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package IEEE.servlets;

import IEEE.bean.Datacenter;
import IEEE.dao.DatacenterDao;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Time;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;

/**
 *
 * @author AdminCH
 */
@WebServlet(name = "AddFile", urlPatterns = {"/AddFile"})
@MultipartConfig(fileSizeThreshold = 1024 * 1024 * 2, maxFileSize = 1024 * 1024 * 10, maxRequestSize = 1024 * 1024 * 50)
public class AddFile extends HttpServlet {
    private String MessageFaild="";
    private String MessageSuccess="";
    public static final int TAILLE_TAMPON=1024*1024*10;
   
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
    }

   
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        Datacenter e = new Datacenter();
        String name = request.getParameter("name");
        Part part = request.getPart("filepath");
        String fileName = extractFileName(part);
        if (name.isEmpty() || fileName.isEmpty()){
            //System.out.println("Hello1");
            MessageFaild = "Please complete all fields";
            request.setAttribute("MessageFaild", MessageFaild);
            //System.out.println("Hello1");
            this.getServletContext().getRequestDispatcher("/Datacenter").forward(request, response);
            //doGet(request, response);
        }else{
            if(!fileName.isEmpty() && fileName!=null){
                        writeFile(part,fileName,"C:\\Users\\Admin CH\\Documents\\GitHub\\IEEE-ENSIAS\\web\\img\\uploads");
            }
            try {
                SimpleDateFormat format1 = new SimpleDateFormat("yyyy-MM-dd");
                SimpleDateFormat format2 = new SimpleDateFormat("HH:mm");
                Date date  = format1.parse(java.time.LocalDate.now().toString());
                long ms = format2.parse(""+java.time.LocalTime.now()).getTime();
                Time time = new Time(ms);
                HttpSession session = request.getSession();
                String memberid = session.getAttribute("ConnectedMemberID").toString();
                System.out.println("owner id : "+memberid);
                int id = Integer.parseInt(memberid);
                e.setName(name);
                e.setDate(date);
                e.setTime(time);
                e.setPath(fileName);
                e.setOwnerid(id);
                if (DatacenterDao.savenew(e)==1){
                    MessageSuccess="File Successully Added";
                    request.setAttribute("MessageSuccess", MessageSuccess);
                    //System.out.println("Hello5");
                    this.getServletContext().getRequestDispatcher("/DatacenterServlet").forward(request, response);
                }else{
                    MessageFaild = "An error occurred, Please Try again!";
                    request.setAttribute("MessageFaild", MessageFaild);
                    this.getServletContext().getRequestDispatcher("/DatacenterServlet").forward(request, response);
                }
                    
            } catch (ParseException ex) {
                Logger.getLogger(AddEvent.class.getName()).log(Level.SEVERE, null, ex);
                MessageFaild = "An error occurred, Please Try again!";
                request.setAttribute("MessageFaild", MessageFaild);
                this.getServletContext().getRequestDispatcher("/DatacenterServlet").forward(request, response);
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
