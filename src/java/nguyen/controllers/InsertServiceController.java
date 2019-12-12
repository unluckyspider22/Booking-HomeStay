/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nguyen.controllers;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.regex.Pattern;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import nguyen.daos.ServiceDAO;
import nguyen.dtos.ErrorObjService;
import nguyen.dtos.ServiceDTO;

/**
 *
 * @author Unlucky Spider
 */
public class InsertServiceController extends HttpServlet {

    private static final String SUCCESS = "SearchServiceController";
    private static final String ERROR = "error.jsp";
    private static final String INVALID = "admin_insert_service.jsp";

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
        String serviceIdPattern = "[S][\\d][\\d][\\d]";
        String namePattern = "^[a-zA-Z]{2,}(?: [a-zA-Z]+){0,3}$";
        String pricePattertn = "^\\d+((,\\d+)+)?(.\\d+)?(.\\d+)?(,\\d+)?";
        try {
            String serviceId = request.getParameter("txtServiceId");
            String serviceName = request.getParameter("txtName");
            String price = request.getParameter("txtPrice");
            String des = request.getParameter("txtDescription");
            String status = request.getParameter("rdStatus");
            ErrorObjService errorObj = new ErrorObjService();
            boolean valid = true;
            if (!Pattern.matches(serviceIdPattern, serviceId)) {
                valid = false;
                errorObj.setserviceIdError("ServiceID must be format : Sxxx (x is digit) !!!");
            }
            if (!Pattern.matches(namePattern, serviceName)) {
                valid = false;
                errorObj.setserviceNameError("Service Name can't be black and can't contain specific character !!!");
            }
            if (!Pattern.matches(pricePattertn, price) || price.length() == 0 || Float.parseFloat(price) <= 0) {
                valid = false;
                errorObj.setPriceError("Price is a positive number !!!");
            }
            ServiceDTO dto = new ServiceDTO(serviceId, serviceName, des, price, Integer.parseInt(status));
            if (valid) {
                ServiceDAO dao = new ServiceDAO();
                if (dao.insert(dto)) {
                    url = SUCCESS;
                } else {
                    request.setAttribute("ERROR", "INSERT FAIL !!!");
                }
            } else {
                url = INVALID;
                request.setAttribute("INVALID", errorObj);
            }
        } catch (Exception e) {
            log("ERROR at InsertServiceController: " + e.getMessage());
            if (e.getMessage().contains("duplicate")) {
                ErrorObjService errorObj = new ErrorObjService();
                errorObj.setserviceIdError("ServiceId is existed !!!");
                request.setAttribute("INVALID", errorObj);
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
