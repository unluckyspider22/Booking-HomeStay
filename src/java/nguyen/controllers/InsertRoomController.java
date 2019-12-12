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
import nguyen.daos.RoomDAO;
import nguyen.daos.RoomTypeDAO;
import nguyen.dtos.ErrorObjRoom;
import nguyen.dtos.RoomDTO;

/**
 *
 * @author Unlucky Spider
 */
public class InsertRoomController extends HttpServlet {
private static final String SUCCESS = "SearchRoomController";
    private static final String ERROR = "error.jsp";
    private static final String INVALID = "admin_insert_room.jsp";

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
        String roomIdPattern = "[R][\\d][\\d][\\d]";
        try {
            String roomId = request.getParameter("txtRoomId");
            String roomType = request.getParameter("selectRoomType");
            String status = request.getParameter("rdStatus");
            ErrorObjRoom errorObj = new ErrorObjRoom();
            boolean valid = true;
            if (!Pattern.matches(roomIdPattern, roomId)) {
                valid = false;
                errorObj.setRoomIdError("RoomID must be format : Rxxx (x is digit) !!!");
            }
            RoomDTO dto = new RoomDTO(roomId,roomType,Integer.parseInt(status));
            if (valid) {
                RoomDAO dao = new RoomDAO();
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
            log("ERROR at InsertRoomController: " + e.getMessage());
            if (e.getMessage().contains("duplicate")) {
                ErrorObjRoom errorObj = new ErrorObjRoom();
                errorObj.setRoomIdError("RoomId is existed !!!");
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
