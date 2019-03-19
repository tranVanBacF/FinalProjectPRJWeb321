/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Filter;

import java.io.File;
import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author bactv
 */
@WebFilter(urlPatterns = {""})
public class AuthenticationFilter implements Filter {

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        HttpServletRequest httpRequest = (HttpServletRequest) request;
        HttpServletResponse httpResponse = (HttpServletResponse) response;
        HttpSession session = httpRequest.getSession();
        // get request path contain name project + servletPath
        String requestPath = httpRequest.getRequestURI();
        //  System.out.println("requestPath " + requestPath);
        // get servlet path
        String servletPath = httpRequest.getServletPath();
        // System.out.println("servletPath " + servletPath);

        // getroot to file
        String realRootPath = httpRequest.getServletContext().getRealPath("");
        //System.out.println("realRootPath " + realRootPath);

        String FileRealPath = realRootPath + servletPath;
        //System.out.println("imageRealPath " + FileRealPath);
        File checkFile = new File(FileRealPath);
//        if (!checkFile.exists()) {
//            session.setAttribute("errorPage", servletPath + " doesn't exist");
//            httpResponse.sendRedirect("/14_ProjectFinalPRJ321/View/ErrorPage.jsp");
//            return;
//        }
        if (requestPath.contains("/View/User") || requestPath.contains("/surveys")
                ||requestPath.contains("/change_status") ||requestPath.contains("/answers")
                ||requestPath.contains("/submitters")) {

            if (session.getAttribute("user") == null) {
                session.setAttribute("loginError", " you must have to login");
                httpResponse.sendRedirect("/14_ProjectFinalPRJ321/View/Login/Login.jsp");
                return;
            }
        } else if (requestPath.endsWith("Login.jsp") || requestPath.endsWith("Register.jsp")) {
            if (session.getAttribute("user") != null) {
                httpResponse.sendRedirect("/14_ProjectFinalPRJ321/View/Home.jsp");
            }

        } else {

        }
        chain.doFilter(request, response);

    }

    @Override
    public void destroy() {

    }

}
