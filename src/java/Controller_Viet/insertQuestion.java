/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller_Viet;

import DAO.ConvertStringToDateDAO;
import Entity.Question;
import ManagementDAO.QuestionManagement;
import java.io.IOException;
import java.io.PrintWriter;
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
@WebServlet(name = "insertQuestion", urlPatterns = {"/insertQuestion"})
public class insertQuestion extends HttpServlet {

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
            out.println("<title>Servlet insertQuestion</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet insertQuestion at " + request.getContextPath() + "</h1>");
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
            String idSurvey = "13";// request.getParameter("id");
            if (idSurvey == null || idSurvey.equals("")) {
                error = "IdSurvey Not Available!";
                request.setAttribute("error", error);
                RequestDispatcher View = request.getRequestDispatcher("View/Exceptions/errorPage.jsp");
                View.forward(request, response);
                return;
            } else {
                try {
                    id = Integer.parseInt(idSurvey);
                    request.setAttribute("id", id);
                    RequestDispatcher View = request.getRequestDispatcher("View/User/insertQuestion.jsp");
                    View.forward(request, response);
                    return;
                } catch (Exception e) {
                    error = "NumberFormatException, IdSurvey Not ParseInt!";
                    request.setAttribute("error", error);
                    RequestDispatcher View = request.getRequestDispatcher("View/Exceptions/errorPage.jsp");
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
        int id = 0;
        try {
            String idSurvey = request.getParameter("id");
            String content = request.getParameter("content");
            String date = request.getParameter("date");
            if (idSurvey == null || idSurvey.equals("") || content == null || content.equals("") || date == null || date.equals("")) {
                error = "Id or Content or Date Not Available!";
                request.setAttribute("error", error);
                RequestDispatcher View = request.getRequestDispatcher("View/User/insertQuestion.jsp");
                View.forward(request, response);
                return;
            } else {
                try {
                    id = Integer.parseInt(idSurvey);
                } catch (Exception e) {
                    error = "Id Not Available!";
                    request.setAttribute("error", error);
                    RequestDispatcher View = request.getRequestDispatcher("View/User/insertQuestion.jsp");
                    View.forward(request, response);
                    return;
                }
                boolean insertQuestionStatus = QuestionManagement.insertQuestion(new Question(id, content, ConvertStringToDateDAO.StringToSqlDate(date)));
                if (insertQuestionStatus == false) {
                    error = "Insert Question Error!";
                    request.setAttribute("error", error);
                    RequestDispatcher View = request.getRequestDispatcher("View/Exceptions/errorPage.jsp");
                    View.forward(request, response);
                    return;
                } else {
                    response.sendRedirect("editSurvey");
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
