/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package IEEE.servlets;

import IEEE.bean.Datacenter;
import IEEE.dao.DatacenterDao;
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
@WebServlet(name = "DatacenterServlet", urlPatterns = {"/DatacenterServlet"})
public class DatacenterServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
       List<Datacenter> files = DatacenterDao.getAllFiles();
       System.out.println(files);
       request.setAttribute("files", files);
       this.getServletContext().getRequestDispatcher("/jsp/Datacenter.jsp").forward(request, response);
       
    }

    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        List<Datacenter> files = DatacenterDao.getAllFiles();
       System.out.println(files);
       request.setAttribute("files", files);
       this.getServletContext().getRequestDispatcher("/jsp/Datacenter.jsp").forward(request, response);
       
    }

   
}
