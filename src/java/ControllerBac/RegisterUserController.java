/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ControllerBac;

import DAO.ConvertStringToDateDAO;
import Entity.User;
import Exception.MyException;
import ManagementDAO.ManageUserDAO;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.Enumeration;
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
@WebServlet(name = "RegisterUserController", urlPatterns = {"/RegisterUserController"})
public class RegisterUserController extends HttpServlet {

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
            out.println("<title>Servlet RegisterUserController</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet RegisterUserController at " + request.getContextPath() + "</h1>");
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
        // get session
        HttpSession session = request.getSession();
        ;
        session.setAttribute("MyException", "");
         session.setAttribute("responseRegister", "");
      

        try {

            String name = request.getParameter("name");
            String email = request.getParameter("email");
            String birthday = request.getParameter("birthday");
            String registrationDate = request.getParameter("registrationDate");
            String username = request.getParameter("username");
            String password = request.getParameter("password");
            // lay toan bo tham so gui len
            Enumeration<String> parameterNames = request.getParameterNames();
            // convert enumration tham so thanh list
            List<String> listParam = Collections.list(parameterNames);
            // create a list value param
            List<String> listValue = new ArrayList<>();
            // add value param to list value param
            for (String string : listParam) {
                String paramValues = request.getParameter(string).trim();
                listValue.add(paramValues);
                // set attribute to save value of param, to
                // when have error, then remain value of params in form
                session.setAttribute(string, paramValues);
            }
            // check if list param have found

            for (int i = 0; i < listValue.size(); i++) {
                if (listValue.get(i).equals("")) {
                    session.setAttribute("responseRegister", listParam.get(i) + " is empty");
                    response.sendRedirect("/14_ProjectFinalPRJ321/View/Register/Register.jsp");
                    return;
                }
            }
            // check user exist or not
            if (ManageUserDAO.getOneUser(username) != null) {
                session.setAttribute("responseRegister", username + " exist");
                response.sendRedirect("/14_ProjectFinalPRJ321/View/Register/Register.jsp");
                return;
            }
            // check password equal repassword or not

            User user = new User(name, email, ConvertStringToDateDAO.StringToSqlDate(birthday), ConvertStringToDateDAO.StringToSqlDate(registrationDate), username, password);
            if (ManageUserDAO.insertUser(user)) {
                session.setAttribute("responseRegister", "RegisterSucessful");
                // set all session param = ""
                for (String string : listParam) {
                    String paramValues = request.getParameter(string).trim();
                    // set attribute to save value of param, to
                    // when have error, then remain value of params in form
                    session.setAttribute(string, "");
                }
            } else {
                session.setAttribute("responseRegister", "Register Fail");
            }
            response.sendRedirect("/14_ProjectFinalPRJ321/View/Register/Register.jsp");

        } catch (MyException ex) {
            session.setAttribute("MyException", ex);
            response.sendRedirect("/14_ProjectFinalPRJ321/View/Register/Register.jsp");
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
