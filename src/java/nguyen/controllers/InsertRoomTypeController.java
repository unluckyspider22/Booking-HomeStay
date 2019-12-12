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
import nguyen.daos.RoomTypeDAO;
import nguyen.dtos.ErrorObjRoomType;
import nguyen.dtos.RoomTypeDTO;

/**
 *
 * @author Unlucky Spider
 */
public class InsertRoomTypeController extends HttpServlet {

    private static final String SUCCESS = "SearchRoomTypeController";
    private static final String ERROR = "error.jsp";
    private static final String INVALID = "admin_insert_room_type.jsp";

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
        String roomTypePattern = "^[a-zA-Z]{1,}(?: [a-zA-Z]+){0,2}$";
        String pricePattertn = "^\\d+((,\\d+)+)?(.\\d+)?(.\\d+)?(,\\d+)?";
        String capacityPattern = "^[0-9]*$";
        try {
            String roomType = request.getParameter("txtRoomType");
            String description = request.getParameter("txtDescription");
            String capacity = request.getParameter("txtCapacity");
            String price = request.getParameter("txtPrice");
            ErrorObjRoomType errorObj = new ErrorObjRoomType();
            boolean valid = true;
            if (!Pattern.matches(roomTypePattern, roomType)) {
                valid = false;
                errorObj.setRoomTypeError("RoomType can't be blank and can't contain specific character !!!");
            }
            if (!Pattern.matches(capacityPattern, capacity) || capacity.length() == 0 || Integer.parseInt(capacity) <= 0) {
                valid = false;
                errorObj.setCapacityError("Capacity is a positive number !!!");
            }
            if (!Pattern.matches(pricePattertn, price) || price.length() == 0 || Float.parseFloat(price) <= 0) {
                valid = false;
                errorObj.setPriceError("Price is a positive number !!!");
            }
            RoomTypeDTO dto = new RoomTypeDTO(roomType, description, "0",capacity,price, 0);
            if (valid) {
                RoomTypeDAO dao = new RoomTypeDAO();
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
            log("ERROR at InsertRoomTypeController: " + e.getMessage());
            if (e.getMessage().contains("duplicate")) {
                ErrorObjRoomType errorObj = new ErrorObjRoomType();
                errorObj.setRoomTypeError("RoomTypeId is existed !!!");
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
