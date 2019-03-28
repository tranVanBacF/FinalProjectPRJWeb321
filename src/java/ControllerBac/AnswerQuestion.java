/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ControllerBac;

import Entity.Question;
import Entity.Survey;
import Exception.MyException;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author bactv
 */
@WebServlet(name = "AnswerQuestion", urlPatterns = {"/doForm"})
public class AnswerQuestion extends HttpServlet {

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

        try {
            // get session
            HttpSession session = request.getSession();
            // get id survey
            String idSurvey = request.getParameter("id");
            int idSurveyNumber = Integer.parseInt(idSurvey);
            //
            List<Question> listAllQuestion = ManagementDAO.QuestionManagement.getQuestionsBySurvey(idSurveyNumber);
            //
            int currentPage = 1;

            int rowNumber = (int) Math.ceil(listAllQuestion.size() * 1.0 / 3);
            System.out.println("rowNumber" + rowNumber);
            System.out.println("rowNumber" + Math.ceil(listAllQuestion.size() / 3));

            int start = (currentPage - 1) * rowNumber;

            Survey survey = ManagementDAO.SurveyManagement.getSurveyById(idSurveyNumber);

            List<Question> listQuestion = ManagementDAO.QuestionManagement.getQuestionForPagin(idSurveyNumber, start, rowNumber);

            for (int i = 0; i < listQuestion.size(); i++) {
                listQuestion.get(i).setOrderDisplay(i + 1);
            }
            //
            session.setAttribute("currentPage", currentPage);
            session.setAttribute("listQuestion", listQuestion);
            session.setAttribute("survey", survey);
            //
            // RequestDispatcher rd = request.getRequestDispatcher("View/Answer/AnswerQuestion.jsp");
            //rd.forward(request, response);
            response.sendRedirect("/View/Answer/AnswerQuestion.jsp");

        } catch (MyException ex) {
            response.getWriter().println(ex);
        }
//         try {
//            // get session
//            HttpSession session = request.getSession();
//
//
//            // get id survey
//            String idSurvey = request.getParameter("id");
//            int idSurveyNumber = Integer.parseInt(idSurvey);
//            Survey survey = ManagementDAO.SurveyManagement.getSurveyById(idSurveyNumber);
//
//            List<Question> listQuestion = ManagementDAO.QuestionManagement.getQuestionsBySurvey(idSurveyNumber);
//
//            for (int i = 0; i < listQuestion.size(); i++) {
//                listQuestion.get(i).setOrderDisplay(i + 1);
//            }
//            //
//            
//            session.setAttribute("listQuestion", listQuestion);
//            session.setAttribute("survey", survey);
//            //
//            // RequestDispatcher rd = request.getRequestDispatcher("View/Answer/AnswerQuestion.jsp");
//            //rd.forward(request, response);
//            response.sendRedirect("/14_ProjectFinalPRJ321/View/Answer/AnswerQuestion.jsp");
//
//        } catch (MyException ex) {
//            response.getWriter().println(ex);
//        }
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
