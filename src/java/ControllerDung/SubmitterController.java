package ControllerDung;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import Entity.Survey;
import Exception.MyException;
import ManagementDAO.AnswerManagement;
import ManagementDAO.SurveyManagement;
import java.util.logging.Level;
import java.util.logging.Logger;


/**
 *
 * @author DxG
 */
@WebServlet(urlPatterns = {"/submitters"})
public class SubmitterController extends HttpServlet {

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
            out.println("<title>Servlet UserAnswerServlet</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet UserAnswerServlet at " + request.getContextPath() + "</h1>");
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
        
        try {
            String surveyId = request.getParameter("id");
            int surveyID = Integer.valueOf(surveyId);
            Survey survey = SurveyManagement.getSurveyById(surveyID);
            if (survey == null){
                RequestDispatcher dispatcher  = request.getRequestDispatcher("View/User/survey_unavailable.jsp");
                dispatcher.forward(request, response);
            }
            request.setAttribute("survey", survey);
            List<String> submitters = AnswerManagement.getAllSubmittersBySurveyId(surveyID);
            request.setAttribute("submitters", submitters);
            System.out.println("Prepared to dispatcher");
            RequestDispatcher dispatcher  = request.getRequestDispatcher("View/User/submitters.jsp");
            dispatcher.forward(request, response);
        } catch (MyException ex) {
            request.setAttribute("exception", ex);
            RequestDispatcher dispatcher  = request.getRequestDispatcher("View/User/submitters.jsp");
            dispatcher.forward(request, response);
        } catch (Exception ex){
            String error = "Survey ID must be a integer";
            request.setAttribute("systemException", error);
            RequestDispatcher requestDispatcher = request.getRequestDispatcher("View/User/answers.jsp");
            requestDispatcher.forward(request, response);
            return;
        }
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
        processRequest(request, response);
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
