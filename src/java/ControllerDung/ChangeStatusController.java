package ControllerDung;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


import Exception.MyException;
import ManagementDAO.SurveyManagement;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author DxG
 */
@WebServlet(urlPatterns = {"/change_status"})
public class ChangeStatusController extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet ChangeSurveyStatusServlet</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet ChangeSurveyStatusServlet at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        try {
            String surveyId = request.getParameter("survey");
            System.out.println("Survey id " + surveyId);
            int surveyID = Integer.parseInt(surveyId);
            String statusToChange = request.getParameter("status");
            System.out.println("Status id " + statusToChange);
            int status = Integer.valueOf(statusToChange);
            boolean updateStatusRS = SurveyManagement.setStatusBySurveyId(surveyID, status);
            String link = "http://" + InetAddress.getLocalHost().getHostAddress() + ":8080/doForm?id=" + surveyId;
            SurveyManagement.setLinkBySurveyId(surveyID, link);
            System.out.println("Change status come herer");
            if (updateStatusRS){
                response.sendRedirect("surveys");
            }
            else{
                request.setAttribute("err", "Can't set status of survey");
            }
        } catch (MyException ex) {
            request.setAttribute("exception", ex);
            RequestDispatcher requestDispatcher = request.getRequestDispatcher("View/User/surveyboard.jsp");
            requestDispatcher.forward(request, response);
            return;
        }
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
