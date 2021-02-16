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
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author AdminCH
 */
@WebServlet(name = "DeleteMember", urlPatterns = {"/DeleteMember"})
public class DeleteMember extends HttpServlet {
    private String MessageFaild="";
    private String MessageSuccess="";
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        Member u = new Member ();
        String id = request.getParameter("id");
        if (id.isEmpty()){
            MessageFaild = "Please fill the Id field";
            request.setAttribute("MessageFaild", MessageFaild);
            this.getServletContext().getRequestDispatcher("/ShowMembers").forward(request, response);
        }else{
            u.setId(Integer.parseInt(id));
            if (MemberDao.delete(u)==1){
                    MessageSuccess="Successfully deleted";
                    request.setAttribute("MessageSuccess", MessageSuccess);
                    this.getServletContext().getRequestDispatcher("/ShowMembers").forward(request, response);
            }else{
                    MessageFaild = "An error occurred, Please Try again!";
                    request.setAttribute("MessageFaild", MessageFaild);
                    this.getServletContext().getRequestDispatcher("/ShowMembers").forward(request, response);
            }
        }
    
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
    }

    
}
