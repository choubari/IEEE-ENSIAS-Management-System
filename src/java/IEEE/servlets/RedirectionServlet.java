
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
import javax.servlet.http.HttpSession;

/**
 *
 * @author AdminCH
 */
@WebServlet(name = "RedirectionServlet", urlPatterns = {"/RedirectionServlet"})
public class RedirectionServlet extends HttpServlet {
    Member member;
  
            
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        member = (Member) MemberDao.getRecordByLogin(request.getSession().getAttribute("email").toString(),request.getSession().getAttribute("password").toString());
        request.setAttribute("member", member);
        HttpSession session = request.getSession();
        session.setAttribute("role",member.getRole());
        if(member.getRole().equals("admin")){
            this.getServletContext().getRequestDispatcher("/jsp/WelcomeAdmin.jsp").forward(request, response);
        }else{
            if(member.getRole().equals("chef")){
                this.getServletContext().getRequestDispatcher("/jsp/WelcomeChef.jsp").forward(request, response);
            }else{
                if(member.getRole().equals("webmaster")){
                    this.getServletContext().getRequestDispatcher("/jsp/WelcomeWebmaster.jsp").forward(request, response);
                }else{
                    this.getServletContext().getRequestDispatcher("/jsp/WelcomeMember.jsp").forward(request, response);
                }
            }
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
