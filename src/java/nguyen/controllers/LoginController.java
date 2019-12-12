/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nguyen.controllers;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import nguyen.daos.AccountDAO;
import nguyen.dtos.ErrorObj;

/**
 *
 * @author Unlucky Spider
 */
public class LoginController extends HttpServlet {
    private static final String INVALID = "login.jsp";
    private static final String ERROR = "error.jsp";
    private static final String ADMIN = "admin_search_account.jsp";
    private static final String CUSTOMER = "index.jsp";
    private static final String STAFF = "staff.jsp";

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
        String url = ERROR;
        try {
            String username = request.getParameter("txtUsername");
            String password = request.getParameter("txtPassword");
            AccountDAO dao = new AccountDAO();
            String role = dao.checkLogin(username, password).trim();
            boolean valid = true;
            ErrorObj errorObj = new ErrorObj();
            if (username.isEmpty()) {
                errorObj.setUsernameError("Username can't be blank !!!");
                valid = false;
            }
            if (password.isEmpty()) {
                errorObj.setPasswordError("Password can't be blank !!!");
                valid = false;
            }
            if (role.equals("failed")) {
                    errorObj.setInvalidUNP("Invalid Username or Password !!!");
                    valid = false;
                }
            if (valid) {
                    HttpSession session = request.getSession(false);
                    session.setAttribute("ROLE", role);
                    if (role.equals("admin")) {
                        url = ADMIN;
                        session.setAttribute("USERNAMEADMIN", username);
                    } else if (role.equals("staff")) {
                        url = STAFF;
                        session.setAttribute("USERNAMESTAFF", username);
                    } else if (role.equals("customer")) {
                        url = CUSTOMER;
                        session.setAttribute("USERNAMECUSTOMER", username);
                    } else {
                        request.setAttribute("ERROR", "YOUR ROLE IS NOT SUPPORTED !!!");
                    }
                }else {
                request.setAttribute("INVALID", errorObj);
                url = INVALID;
            }
        } catch (Exception e) {
            log("ERROR at LoginController: " + e.getMessage());
        } finally {
            request.getRequestDispatcher(url).forward(request, response);
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
