/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller_Viet;

import DAO.ConvertStringToDateDAO;
import Entity.Survey;
import ManagementDAO.SurveyManagement;
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
@WebServlet(name = "createSurvey", urlPatterns = {"/createSurvey"})
public class createSurvey extends HttpServlet {

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
            out.println("<title>Servlet createSurvey</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet createSurvey at " + request.getContextPath() + "</h1>");
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
        String error = "";
        int id;
        try {
            //HttpSession session = request.getSession();
            //User user = (User) session.getAttribute("user");
            RequestDispatcher view = request.getRequestDispatcher("View/User/createSurvey.jsp");
            view.forward(request, response);
        } catch (IOException | ServletException ex) {
            error = "Do Not Load DOGET Succesful!";
            request.setAttribute("error", error);
            RequestDispatcher view = request.getRequestDispatcher("View/Exceptions/errorPage.jsp");
            view.forward(request, response);
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
        try {
            String name = request.getParameter("name");
            String description = request.getParameter("description");
            String user = request.getParameter("user");
            String date = request.getParameter("date");
            String link = request.getParameter("link");
            if (name == null || name.equals("") || description == null || description.equals("") || user == null || user.equals("") || date == null || date.equals("")) {
                error = "Do not getParamater Succesful! Some paramater is NUll!";
                request.setAttribute("error", error);
                doGet(request, response);
                return;
            } else {
                boolean insertServeyStatus = SurveyManagement.insertSurvey(new Survey(name, description, user, ConvertStringToDateDAO.StringToSqlDate(date), link));
                if (insertServeyStatus == false) {
                    error = "Do not insert Servey Succesful!";
                    request.setAttribute("error", error);
                    doGet(request, response);
                } else {
                    System.out.println("Send redirect to surveys");
                    response.sendRedirect("surveys");// survey nay la servlet survey cua dung
                }
            }
        } catch (Exception ex) {
            error = "POST is not available, Do not getParamater Succesful!";
            request.setAttribute("error", error);
            doGet(request, response);
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
