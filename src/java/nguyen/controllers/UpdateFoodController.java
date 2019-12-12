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
import nguyen.daos.FoodDAO;
import nguyen.dtos.ErrorObjFood;
import nguyen.dtos.FoodDTO;

/**
 *
 * @author Unlucky Spider
 */
public class UpdateFoodController extends HttpServlet {
private static final String ERROR = "error.jsp";
private static final String SUCCESS = "SearchFoodController";
private static final String INVALID = "admin_update_food.jsp";
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
        String foodIdPattern = "[F][\\d][\\d][\\d]";
        String namePattern = "^[a-zA-Z]{2,}(?: [a-zA-Z]+){0,3}$";
        String pricePattertn = "\\d+((,\\d+)+)?(.\\d+)?(.\\d+)?(,\\d+)?";
        try{
            String foodId = request.getParameter("txtFoodId");
            String foodName = request.getParameter("txtName");
            String price = request.getParameter("txtPrice");
            String des = request.getParameter("txtDescription");
            String status = request.getParameter("rdStatus");
            ErrorObjFood errorObj = new ErrorObjFood();
            boolean valid = true;
            if(!Pattern.matches(foodIdPattern, foodId)){
                valid = false;
                errorObj.setFoodIdError("FoodID must be format : Fxxx (x is digit) !!!");
            }
            if(!Pattern.matches(namePattern, foodName)){
                valid = false;
                errorObj.setFoodNameError("Food Name can't be black and can't contain specific character !!!");
            }if(!Pattern.matches(pricePattertn, price) || price.length() == 0){
                valid = false;
                errorObj.setPriceError("Price is a positive number !!!");
            }
            FoodDTO dto = new FoodDTO(foodId, foodName, des, price, Integer.parseInt(status));
            if(valid){
                FoodDAO dao = new FoodDAO();
                if(dao.update(dto)){
                    url = SUCCESS;
                }else request.setAttribute("ERROR", "Update FAIL !!!");
            }else {
                url = INVALID;
                request.setAttribute("INVALID", errorObj);
                request.setAttribute("DTO", dto);
            }
        }catch(Exception e) {
            log("ERROR at UpdateFoodController: " + e.getMessage());
        }finally{
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
