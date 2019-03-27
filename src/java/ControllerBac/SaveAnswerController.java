/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ControllerBac;

import DAO.ConvertStringToDateDAO;
import Entity.Answer;
import Entity.Question;
import Entity.Survey;
import Exception.MyException;
import ManagementDAO.AnswerManagement;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
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
@WebServlet(name = "SaveAnswerController", urlPatterns = {"/SaveFormUser"})
public class SaveAnswerController extends HttpServlet {

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
            out.println("<title>Servlet SaveAnswerController</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet SaveAnswerController at " + request.getContextPath() + "</h1>");
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
            HttpSession session = request.getSession();

            String idSurvey = request.getParameter("id");
            String submiter = request.getParameter("submiter");
            String registrationDate = request.getParameter("registrationDate");
// parse
            int idSurveyNumber = Integer.parseInt(idSurvey);
            Survey survey = ManagementDAO.SurveyManagement.getSurveyById(idSurveyNumber);
            // get list question
            List<Question> listQuestion = ManagementDAO.QuestionManagement.getQuestionsBySurvey(idSurveyNumber);
            // lây toan bo tham so gui len
            Enumeration<String> parameterNames = request.getParameterNames();
            // convert enumration tham so thanh list
            List<String> listParam = Collections.list(parameterNames);
            System.out.println("parameterNames " + listParam.size());

            // create hashmap to save <paramaterName,value>
            Map<String, String> nameValueHashMap = new HashMap<>();
            // add value param to list value param
            for (String string : listParam) {
                nameValueHashMap.put(string, request.getParameter(string).trim());
                session.setAttribute(string, request.getParameter(string).trim());
            }
            // check if list param have found
            for (String string : listParam) {
                if (request.getParameter(string).trim().equals("")) {
                    session.setAttribute("emptyMessage", string + " is empty");
                    response.sendRedirect("/14_ProjectFinalPRJ321/View/Answer/AnswerQuestion.jsp");
                    return;
                }
            }
            for (Question question : listQuestion) {
                if (nameValueHashMap.containsKey(question.getId() + "")) {
                    AnswerManagement.insertAnswer(new Answer(question.getId(), nameValueHashMap.get(question.getId() + ""), submiter, ConvertStringToDateDAO.StringToSqlDate(registrationDate)));
                }
            }
            // remove  answer
            for (String string : listParam) {
                //nameValueHashMap.put(string, request.getParameter(string).trim());
                session.setAttribute(string, "");
            }
            // lap hashmap
//            nameValueHashMap.forEach((name, value) -> {
//                System.out.println(name + " => " + value);
//            });

            //
            session.setAttribute("resultMessage", "thanks you for answer our survey ");
            response.sendRedirect("/14_ProjectFinalPRJ321/View/Result/Result.jsp");
            //  response.getWriter().println("<h1 style='color:blue'>" + " thanks you for answer our survey" + "</h1>");
        } catch (MyException ex) {
            response.getWriter().println(ex.getMessage());

            System.out.println(ex);
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
