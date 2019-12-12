/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nguyen.controllers;

import java.io.IOException;
import java.util.regex.Pattern;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import nguyen.daos.AccountDAO;
import nguyen.dtos.AccountDTO;
import nguyen.dtos.ErrorObj;

/**
 *
 * @author Unlucky Spider
 */
public class InsertAccountController extends HttpServlet {

    private static final String ERROR = "error.jsp";
    private static final String SUCCESS = "SearchAccountController";
    private static final String INVALID = "admin_insert_account.jsp";

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
        String fullnamePattern = "^[a-zA-Z]{1,}(?: [a-zA-Z]+){0,3}$";
        String usernamePattern = "[a-zA-Z_0-9]";
        String emailPattern = "^[a-zA-Z][\\w-]+@([\\w]+\\.[\\w]+|[\\w]+\\.[\\w]{2,}\\.[\\w]{2,})$";
        String phonePattern = "\\d{11}";
        String idNumberPattern = "\\d{9}";
        try {
            String username = request.getParameter("txtUsername");
            String password = request.getParameter("txtPassword");
            String fullname = request.getParameter("txtFullname");
            String email = request.getParameter("txtEmail");
            String phone = request.getParameter("txtPhone");
            String gender = request.getParameter("rdGender");
            String idNumber = request.getParameter("txtIdnumber");
            String nationality = request.getParameter("nationality");
            String dob = request.getParameter("selectDate");
            String role = request.getParameter("role");
            ErrorObj errorObj = new ErrorObj();
            AccountDTO dto = new AccountDTO(username, fullname, email, phone, Integer.parseInt(gender), idNumber, nationality, dob, role);
            dto.setPassword(password);
            boolean valid = true;
            if (username.isEmpty()) {
                errorObj.setUsernameError("Username can't be blank !!!");
                valid = false;
            }
            if (password.isEmpty()) {
                errorObj.setPasswordError("Password can't be blank !!!");
                valid = false;
            }
            if (!Pattern.matches(fullnamePattern, fullname)) {
                errorObj.setFullnameError("Fullname can't be blank and can't contain number of specific character!!!");
                valid = false;
            }
            if (!Pattern.matches(emailPattern, email)) {
                errorObj.setEmailError("Email can't be blank and must be valid in pattern (abc@domain.com) !!!");
                valid = false;
            }
            if (phone.length() > 11 || !Pattern.matches(phonePattern, phone)) {
                errorObj.setPhoneError("Phone is only number format with 11 numbers !!!");
                valid = false;
            }
            if (idNumber.length() > 9 || !Pattern.matches(idNumberPattern, idNumber)) {
                errorObj.setIdNumberError("IDNumber is only number format with 9 numbers !!!");
                valid = false;
            }
            if(dob.isEmpty()){
                errorObj.setDobError("Please select your DOB !!!");
                valid = false;
            }
            if(nationality.equals("None")){
                errorObj.setNationalityError("Please select your nationality !!!");
                valid = false;
            }
            if(role.equals("None")){
                errorObj.setRoleError("Please select Role !!!");
                valid = false;
            }
            if (valid) {
                AccountDAO dao = new AccountDAO();
                if (dao.insert(dto)) {
                    url = SUCCESS;
                } else {
                    request.setAttribute("ERROR", "Insert Failed");
                }
            } else {
                url = INVALID;
                request.setAttribute("INVALID", errorObj);
            }
        } catch (Exception e) {
            log("ERROR at InsertAccountController: " + e.getMessage());
            if(e.getMessage().contains("duplicate")){
                ErrorObj errorObject = new ErrorObj();
                errorObject.setUsernameError("Username is existed !!!");
                request.setAttribute("INVALID", errorObject);
                url = INVALID;
            }
            
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
