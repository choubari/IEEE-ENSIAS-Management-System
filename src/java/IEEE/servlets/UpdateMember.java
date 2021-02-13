/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package IEEE.servlets;

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
@WebServlet("/updateMember")
public class UpdateMember extends HttpServlet {
    private String MessageFaild="";
    private String MessageSuccess="";

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String role = request.getParameter("role");
        String cell = request.getParameter("cell");
        String memberid = request.getParameter("memberid");
        if (memberid.isEmpty() || role.isEmpty() || cell.isEmpty()){
            MessageFaild = "Please complete all fields";
            request.setAttribute("MessageFaild", MessageFaild);
            this.getServletContext().getRequestDispatcher("/ShowMembers").forward(request, response);
      
            //doGet(request, response);
        }else{
            int id = Integer.parseInt(memberid);
            //System.out.println(id+" "+role+" "+cell);
            MemberDao.adminUpdate(id,role,cell);
            MessageSuccess="Success";
            request.setAttribute("MessageSuccess", MessageSuccess);
            this.getServletContext().getRequestDispatcher("/ShowMembers").forward(request, response);
      
        }
    }
    
    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
           
    }

   
}
