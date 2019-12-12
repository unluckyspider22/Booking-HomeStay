/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nguyen.daos;

import java.io.Serializable;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import nguyen.dbs.MyConnection;
import nguyen.dtos.FoodDTO;

/**
 *
 * @author Unlucky Spider
 */
public class FoodDAO implements Serializable{
    private Connection cnn;
    private PreparedStatement ps;
    private ResultSet rs;

    public FoodDAO() {
    }
    private void closeConnection() throws SQLException{
        if(ps != null){
            ps.close();
        }
        if(rs != null){
            rs.close();
        }
        if(cnn != null){
            cnn.close();
        }
    }
    public List<FoodDTO> findByLikeName(String searchValue) throws Exception{
        List<FoodDTO> result = null;
        FoodDTO dto = null;
        try{
            String sql = "SELECT FoodID,Name,Description,Price,Status FROM Food WHERE Name LIKE ?";
            cnn = MyConnection.getConnection();
            ps = cnn.prepareStatement(sql);
            ps.setString(1, "%" + searchValue +"%");
            rs = ps.executeQuery();
            result = new ArrayList<>();
            while(rs.next()){
                String foodId,name,des;
                String price;
                int status;
                foodId = rs.getString("FoodID");
                name = rs.getString("Name");
                des = rs.getString("Description");
                price = rs.getString("Price");
                status = rs.getInt("Status");
                dto = new FoodDTO(foodId, name, des, price, status);
                result.add(dto);
            }
        }finally{
            closeConnection();
        }
        return result;
    }
    public boolean delete(String id) throws Exception{
        boolean check = false;
        String sql = "DELETE FROM Food WHERE FoodID = ?";
        try{
            cnn = MyConnection.getConnection();
            ps = cnn.prepareStatement(sql);
            ps.setString(1, id);
            check = ps.executeUpdate() > 0;
        }finally{
            closeConnection();
        }
        return check;
    }
    public boolean insert(FoodDTO dto) throws Exception {
        boolean check = false;
        try {
            String sql = "INSERT INTO Food(FoodID,Name,Description,Price,Status)"
                    + " VALUES(?,?,?,?,?)";
            cnn = MyConnection.getConnection();
            ps = cnn.prepareStatement(sql);
            ps.setString(1, dto.getFoodId());
            ps.setString(2, dto.getName());
            ps.setString(3, dto.getDescription());
            ps.setString(4, dto.getPrice());
            ps.setInt(5, dto.getStatus());
            check = ps.executeUpdate() > 0;
        } finally {
            closeConnection();
        }
        return check;
    }
    public FoodDTO findByPrimaryKey(String id) throws Exception{
        FoodDTO dto = null;
        try{
            String sql = "SELECT Name,Description,Price,Status FROM Food WHERE FoodID = ?";
            cnn = MyConnection.getConnection();
            ps = cnn.prepareStatement(sql);
            ps.setString(1, id);
            rs = ps.executeQuery();
            if(rs.next()){
                String name,des,price;
                int status;
                name = rs.getString("Name");
                des = rs.getString("Description");
                price = rs.getString("Price");
                status = rs.getInt("Status");
                dto = new FoodDTO(id, name, des, price, status);
            }
        }finally{
            closeConnection();
        }
        return dto;
    }
    public boolean update(FoodDTO dto) throws Exception{
        boolean check = false;
        try {
            String sql = "UPDATE Food SET Name = ?,Description = ?,Price = ?,Status = ? WHERE FoodID = ?";
            cnn = MyConnection.getConnection();
            ps = cnn.prepareStatement(sql);
            ps.setString(1, dto.getName());
            ps.setString(2, dto.getDescription());
            ps.setString(3, dto.getPrice());
            ps.setInt(4, dto.getStatus());
            ps.setString(5, dto.getFoodId());
            check = ps.executeUpdate() > 0;
        }finally {
            closeConnection();
        }
        return check;
    }
}
