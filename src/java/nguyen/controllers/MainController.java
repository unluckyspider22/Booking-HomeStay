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

/**
 *
 * @author Unlucky Spider
 */
public class MainController extends HttpServlet {

    private static final String ERROR = "error.jsp";
    private static final String LOGIN = "LoginController";
    private static final String SEARCH = "SearchAccountController";
    private static final String DELETE = "DeleteAccountController";
    private static final String EDIT = "EditAccountController";
    private static final String UPDATE = "UpdateAccountController";
    private static final String INSERT = "InsertAccountController";
    private static final String SEARCHFOOD = "SearchFoodController";
    private static final String DELETEFOOD = "DeleteFoodController";
    private static final String EDITFOOD = "EditFoodController";
    private static final String UPDATEFOOD = "UpdateFoodController";
    private static final String INSERTFOOD = "InsertFoodController";
    private static final String SEARCHDRINK = "SearchDrinkController";
    private static final String DELETEDRINK = "DeleteDrinkController";
    private static final String EDITDRINK = "EditDrinkController";
    private static final String UPDATEDRINK = "UpdateDrinkController";
    private static final String INSERTDRINK = "InsertDrinkController";
    private static final String SEARCHSERVICE = "SearchServiceController";
    private static final String DELETESERVICE = "DeleteServiceController";
    private static final String EDITSERVICE = "EditServiceController";
    private static final String UPDATESERVICE = "UpdateServiceController";
    private static final String INSERTSERVICE = "InsertServiceController";
    private static final String SEARCHROOM = "SearchRoomController";
    private static final String DELETEROOM = "DeleteRoomController";
    private static final String EDITROOM = "EditRoomController";
    private static final String UPDATEROOM = "UpdateRoomController";
    private static final String INSERTROOM = "InsertRoomController";
    private static final String SEARCHROOMTYPE = "SearchRoomTypeController";
    private static final String DELETEROOMTYPE = "DeleteRoomTypeController";
    private static final String EDITROOMTYPE = "EditRoomTypeController";
    private static final String UPDATEROOMTYPE = "UpdateRoomTypeController";
    private static final String INSERTROOMTYPE = "InsertRoomTypeController";

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
            String action = request.getParameter("action");
            if (action.equals("Login")) {
                url = LOGIN;
            } else if (action.equals("Search")) {
                url = SEARCH;
            } else if (action.equals("Delete")) {
                url = DELETE;
            } else if (action.equals("Edit")) {
                url = EDIT;
            } else if (action.equals("Update")) {
                url = UPDATE;
            } else if (action.equals("Insert")) {
                url = INSERT;
            } else if (action.equals("SearchFood")) {
                url = SEARCHFOOD;
            } else if (action.equals("DeleteFood")) {
                url = DELETEFOOD;
            } else if (action.equals("EditFood")) {
                url = EDITFOOD;
            } else if (action.equals("UpdateFood")) {
                url = UPDATEFOOD;
            } else if (action.equals("InsertFood")) {
                url = INSERTFOOD;
            } else if (action.equals("SearchDrink")) {
                url = SEARCHDRINK;
            } else if (action.equals("DeleteDrink")) {
                url = DELETEDRINK;
            } else if (action.equals("EditDrink")) {
                url = EDITDRINK;
            } else if (action.equals("UpdateDrink")) {
                url = UPDATEDRINK;
            } else if (action.equals("InsertDrink")) {
                url = INSERTDRINK;
            } else if (action.equals("SearchService")) {
                url = SEARCHSERVICE;
            } else if (action.equals("DeleteService")) {
                url = DELETESERVICE;
            } else if (action.equals("EditService")) {
                url = EDITSERVICE;
            } else if (action.equals("UpdateService")) {
                url = UPDATESERVICE;
            } else if (action.equals("InsertService")) {
                url = INSERTSERVICE;
            } else if (action.equals("SearchRoom")) {
                url = SEARCHROOM;
            } else if (action.equals("DeleteRoom")) {
                url = DELETEROOM;
            } else if (action.equals("EditRoom")) {
                url = EDITROOM;
            } else if (action.equals("UpdateRoom")) {
                url = UPDATEROOM;
            } else if (action.equals("InsertRoom")) {
                url = INSERTROOM;
            } else if (action.equals("SearchRoomType")) {
                url = SEARCHROOMTYPE;
            } else if (action.equals("DeleteRoomType")) {
                url = DELETEROOMTYPE;
            } else if (action.equals("EditRoomType")) {
                url = EDITROOMTYPE;
            } else if (action.equals("UpdateRoomType")) {
                url = UPDATEROOMTYPE;
            } else if (action.equals("InsertRoomType")) {
                url = INSERTROOMTYPE;
            } else {
                request.setAttribute("ERROR", "Action is not supported");
            }

        } catch (Exception e) {
            log("Error at MainController: " + e.getMessage());
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
