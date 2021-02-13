/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package IEEE.servlets;
import IEEE.dao.LoginDao;
import IEEE.bean.LoginBean ;
import IEEE.bean.Member;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
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
@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
    private LoginDao loginDao;
    public void init() {
        loginDao = new LoginDao();
    }
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        
        String email = request.getParameter("email");
        String password = request.getParameter("password");
        LoginBean loginBean = new LoginBean();
        loginBean.setEmail(email);
        loginBean.setPassword(password);
        int result;
        try {
            result = loginDao.validate(loginBean);
            if (result==1) {
                HttpSession session = request.getSession();
                session.setAttribute("email",email);
                session.setAttribute("password",password);
                //response.sendRedirect("jsp/profile.jsp");
                response.sendRedirect(request.getContextPath() + "/RedirectionServlet");
            } else {
                if (result==0){
                    String msg = "Your account isn't active.";
                    request.setAttribute("msg", msg);
                    this.getServletContext().getRequestDispatcher("/jsp/login.jsp").forward(request, response);
                }else{
                    String msg = "Invalid informations";
                    request.setAttribute("msg", msg);
                    this.getServletContext().getRequestDispatcher("/jsp/login.jsp").forward(request, response);
                    //HttpSession session = request.getSession();
                    //response.sendRedirect("jsp/login.jsp");
                }
            }
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(LoginServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
}