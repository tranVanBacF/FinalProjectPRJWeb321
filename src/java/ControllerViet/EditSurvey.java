/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ControllerViet;

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
@WebServlet(name = "editSurvey", urlPatterns = {"/editSurvey"})
public class EditSurvey extends HttpServlet {

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
            out.println("<title>Servlet editSurvey</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet editSurvey at " + request.getContextPath() + "</h1>");
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
        int id;
        String error = "";
        try {
            String idSurvey = request.getParameter("id");//request.getParameter("idSurvey");// cho nay khi khung bam edit cuar trang survey thi gui idSurvey xang
            if (idSurvey == null || idSurvey.equals("")) {
                System.out.println("Come here 1");
                error = "IdSurvey Not Available!";
                request.setAttribute("error", error);
                RequestDispatcher View = request.getRequestDispatcher("View/exceptions/errorPage.jsp");
                View.forward(request, response);
                return;
            } else {
                System.out.println("Come here 2");
                try {
                    id = Integer.parseInt(idSurvey);
                } catch (NumberFormatException ee) {
                    error = "NumberFormatException, IdSurvey Not ParseInt!";
                    request.setAttribute("error", error);
                    RequestDispatcher View = request.getRequestDispatcher("View/exceptions/errorPage.jsp");
                    View.forward(request, response);
                    return;
                }
            }

            try {
                System.out.println("Come here 3");
                QuestionManagement manageQuestionDAO = new QuestionManagement();
                List<Question> questions = manageQuestionDAO.getQuestion(id);
                request.setAttribute("questions", questions);
                request.getSession().setAttribute("surveyId", idSurvey);
                RequestDispatcher View = request.getRequestDispatcher("View/User/editSurvey.jsp");
                View.forward(request, response);
            } catch (MyException ex) {
                error = "ManageQuestionDAO Error!";
                request.setAttribute("error", error);
                RequestDispatcher View = request.getRequestDispatcher("View/exceptions/errorPage.jsp");
                View.forward(request, response);
                return;
            }

        } catch (Exception e) {
            error = "Do Not Load DOGET Succesful!";
            request.setAttribute("error", error);
            RequestDispatcher View = request.getRequestDispatcher("View/exceptions/errorPage.jsp");
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
