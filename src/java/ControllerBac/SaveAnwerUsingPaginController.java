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
import java.util.Collections;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
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
@WebServlet(name = "SaveAnwerUsingPaginController", urlPatterns = {"/SaveForm"})
public class SaveAnwerUsingPaginController extends HttpServlet {

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
            out.println("<title>Servlet SaveAnwerUsingPaginController</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet SaveAnwerUsingPaginController at " + request.getContextPath() + "</h1>");
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
            //
            HttpSession session = request.getSession();
            //
            String pageSubmit = request.getParameter("pageSubmit");
            String submit = request.getParameter("Submit");
            String currenPage = request.getParameter("currentPage");
            String increase = request.getParameter("increase");
            String decrease = request.getParameter("decrease");

//
//            if(pageSubmit !=  null && pageSubmit.matches("[0-9]+") == false){
//                pageSubmit = currenPage;
//            }
            // get survey
            Survey survey = (Survey) session.getAttribute("survey");
            // GET all question
            List<Question> listAllQuestion = ManagementDAO.QuestionManagement.getQuestionsBySurvey(survey.getId());

            // lây toan bo tham so gui len
            Enumeration<String> parameterNames = request.getParameterNames();
            // convert enumration tham so thanh list
            List<String> listParam = Collections.list(parameterNames);
            //  System.out.println("parameterNames size " + listParam.size());

//            // save all value  to session
            for (String string : listParam) {
                session.setAttribute(string, request.getParameter(string).trim());
                //System.out.println("[" + string + " : " + request.getParameter(string).trim() + "]");
            }
//            //
            int pageNumber = 1;
            if (pageSubmit != null && pageSubmit.matches("[0-9]+")) {
                pageNumber = Integer.parseInt(pageSubmit);// get page target
            } else if(increase != null) {
                pageNumber = Integer.parseInt(currenPage) + 1;// increase page
            }else if(decrease != null){
                  pageNumber = Integer.parseInt(currenPage) -1;// decrease page
            }
            // get page next
            int nextPage = pageNumber;

            int rowNumber = (int) Math.ceil(listAllQuestion.size() * 1.0 / 3);

            int start = (nextPage - 1) * rowNumber;
         //   System.out.println("pageSubmit " + pageSubmit);
           // System.out.println("submit " + submit);
            // get question to display
            List<Question> listQuestion = ManagementDAO.QuestionManagement.getQuestionForPagin(survey.getId(), start, rowNumber);
//
            for (int i = 0; i < listQuestion.size(); i++) {// set order display
                listQuestion.get(i).setOrderDisplay(++start);
            }
            // get all session
            Enumeration allSession = session.getAttributeNames(); //getkeys()
            //
            // convert enumration tham so thanh list
            List<String> listAllSession = Collections.list(allSession);
            // System.out.println("listAllSession " + listAllSession.size());

            // create hashmap to save <session,value>
            Map<String, String> sessionValueHashMap = new HashMap<>();
            // add value param to sessionValueHashMap
            for (String string : listAllSession) {
                sessionValueHashMap.put(string, string);
                //session.setAttribute(string, request.getParameter(string).trim());
                // System.out.println("name : " + string);
            }
            // set value tempaory answer of question
            for (Question question : listQuestion) {
                if (sessionValueHashMap.containsKey(question.getId() + "")) {
                    if (question.getTemporaryAnswer().equals("")) {
                        question.setTemporaryAnswer((String) session.getAttribute(question.getId() + ""));
                        System.out.println(question.getId() + " set: " + session.getAttribute(question.getId() + ""));
                    }

                }
            }

            //  // save question
            if (submit != null) {
                // List<Question> listAllQuestion = ManagementDAO.QuestionManagement.getQuestionsBySurvey(survey.getId());
                for (Question question : listAllQuestion) {
                    if (sessionValueHashMap.containsKey(question.getId() + "")) {
                        AnswerManagement.insertAnswer(new Answer(question.getId(), (String) session.getAttribute(question.getId() + ""), (String) session.getAttribute("submiter"), null));
                        //remove this answer session
                        session.setAttribute(question.getId() + "", "");
                    }
                }
                session.setAttribute("submiter", "");

                session.setAttribute("resultMessage", "thanks you for answer our survey ");
                response.sendRedirect("/14_ProjectFinalPRJ321/View/Result/Result.jsp");
                return;
            }
////
            session.setAttribute("currentPage", nextPage);
            session.setAttribute("listQuestion", listQuestion);
            response.sendRedirect("/14_ProjectFinalPRJ321/View/Answer/AnswerQuestion.jsp");

        } catch (MyException ex) {
            Logger.getLogger(SaveAnwerUsingPaginController.class.getName()).log(Level.SEVERE, null, ex);
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
