/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package IEEE.servlets;

import IEEE.bean.Member;
import IEEE.dao.MemberDao;
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
@WebServlet(name = "ShowMembers", urlPatterns = {"/ShowMembers"})
public class ShowMembers extends HttpServlet {
    Member member;
  
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String role = request.getSession().getAttribute("role").toString();
        if (role.equals("admin")){
            List<Member> inactive_members = MemberDao.getInactiveRecords();
            List<Member> active_members = MemberDao.getActiveRecords();
            request.setAttribute("active_members", active_members);
            request.setAttribute("inactive_members", inactive_members);
            this.getServletContext().getRequestDispatcher("/jsp/adminMembersList.jsp").forward(request, response);
        }else{
            if (role.equals("chef")){
                int chefID = (int) request.getSession().getAttribute("ConnectedMemberID");
                List<Member> cell_members= MemberDao.getMembersofCell(MemberDao.getCellofChef(chefID));
                //System.out.println(" list  "+cell_members);
                request.setAttribute("cell_members", cell_members);
                this.getServletContext().getRequestDispatcher("/jsp/chefMembersList.jsp").forward(request, response);   
            }
        }
        
    }

   
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
    }

    
}
