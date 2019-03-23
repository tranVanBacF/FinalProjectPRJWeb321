/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ControllerViet;

import DAO.ConvertStringToDateDAO;
import Entity.Question;
import Exception.MyException;
import ManagementDAO.QuestionManagement;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author TranViet
 */
@WebServlet(name = "editQuestion", urlPatterns = {"/editQuestion"})
public class EditQuestion extends HttpServlet {

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
            out.println("<title>Servlet editQuestion</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet editQuestion at " + request.getContextPath() + "</h1>");
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
        int ids;
        String error = "";
        try {
            String id = request.getParameter("id");
            if (id == null || id.equals("")) {
                error = "IdSurvey Not Available!";
                request.setAttribute("error", error);
                RequestDispatcher View = request.getRequestDispatcher("View/exceptions/errorPage.jsp");
                View.forward(request, response);
                return;
            } else {
                try {
                    ids = Integer.parseInt(id);
                    request.setAttribute("id", ids);
                    Question questions = QuestionManagement.getQuestionByID(ids);
                    System.out.println(questions.getContent());
                    request.setAttribute("questions", questions);
                    RequestDispatcher View = request.getRequestDispatcher("View/User/editQuestion.jsp");
                    View.forward(request, response);
                } catch (NumberFormatException ee) {
                    error = "NumberFormatException, ID or IdSurvey Not ParseInt!";
                    request.setAttribute("error", error);
                    RequestDispatcher View = request.getRequestDispatcher("View/exceptions/errorPage.jsp");
                    View.forward(request, response);
                    return;
                }
            }
        } catch (Exception e) {
            error = "Do Not Load DOGET Succesful!";
            request.setAttribute("error", error);
            RequestDispatcher View = request.getRequestDispatcher("View/User/errorPage.jsp");
            View.forward(request, response);
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
        String error = "";
        int ids;
        String surveyID = (String) request.getSession().getAttribute("surveyId");
        int idSurveys = Integer.valueOf(surveyID);
        try {
            String id = request.getParameter("id");
            String content = request.getParameter("description");
            String date = request.getParameter("date");
            if (id == null || id.equals("") || content == null || content.equals("") || date == null || date.equals("")) {
                error = "Id or idSurvey or Content or Date Not Available!";
                request.setAttribute("error", error);
                RequestDispatcher View = request.getRequestDispatcher("View/User/editQuestion.jsp");
                View.forward(request, response);
                return;
            } else {
                try {
                    ids = Integer.parseInt(id);
                } catch (Exception e) {
                    error = "Id or idSurveys Not Available!";
                    request.setAttribute("error", error);
                    RequestDispatcher View = request.getRequestDispatcher("View/User/editQuestion.jsp");
                    View.forward(request, response);
                    return;
                }
                boolean insertQuestionStatus = QuestionManagement.updateQuestion(new Question(ids, idSurveys, content, ConvertStringToDateDAO.StringToSqlDate(date)));
                if (insertQuestionStatus == false) {
                    error = "Update Question Error!";
                    request.setAttribute("error", error);
                    RequestDispatcher View = request.getRequestDispatcher("View/Exceptions/errorPage.jsp");
                    View.forward(request, response);
                    return;
                } else {
                    response.sendRedirect("editSurvey?id=" + surveyID);
                }
            }
        } catch (Exception ex) {
            error = "Do Not POST!";
            request.setAttribute("error", error);
            RequestDispatcher View = request.getRequestDispatcher("View/Exceptions/errorPage.jsp");
            View.forward(request, response);
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
