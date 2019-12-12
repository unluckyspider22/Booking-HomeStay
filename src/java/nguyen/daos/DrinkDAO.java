/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nguyen.daos;

import java.io.Serializable;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import nguyen.dbs.MyConnection;
import nguyen.dtos.DrinkDTO;

/**
 *
 * @author Unlucky Spider
 */
public class DrinkDAO implements Serializable{
    private Connection cnn;
    private PreparedStatement ps;
    private ResultSet rs;

    public DrinkDAO() {
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
    public List<DrinkDTO> findByLikeName(String searchValue) throws Exception{
        List<DrinkDTO> result = null;
        DrinkDTO dto = null;
        try{
            String sql = "SELECT DrinkID,Name,Description,Price,Status FROM Drink WHERE Name LIKE ?";
            cnn = MyConnection.getConnection();
            ps = cnn.prepareStatement(sql);
            ps.setString(1, "%" + searchValue +"%");
            rs = ps.executeQuery();
            result = new ArrayList<>();
            while(rs.next()){
                String foodId,name,des;
                String price;
                int status;
                foodId = rs.getString("DrinkID");
                name = rs.getString("Name");
                des = rs.getString("Description");
                price = rs.getString("Price");
                status = rs.getInt("Status");
                dto = new DrinkDTO(foodId, name, des, price, status);
                result.add(dto);
            }
        }finally{
            closeConnection();
        }
        return result;
    }
    public boolean delete(String id) throws Exception{
        boolean check = false;
        String sql = "DELETE FROM Drink WHERE DrinkID = ?";
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
    public boolean insert(DrinkDTO dto) throws Exception {
        boolean check = false;
        try {
            String sql = "INSERT INTO Drink(DrinkID,Name,Description,Price,Status)"
                    + " VALUES(?,?,?,?,?)";
            cnn = MyConnection.getConnection();
            ps = cnn.prepareStatement(sql);
            ps.setString(1, dto.getDrinkId());
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
    public DrinkDTO findByPrimaryKey(String id) throws Exception{
        DrinkDTO dto = null;
        try{
            String sql = "SELECT Name,Description,Price,Status FROM Drink WHERE DrinkID = ?";
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
                dto = new DrinkDTO(id, name, des, price, status);
            }
        }finally{
            closeConnection();
        }
        return dto;
    }
    public boolean update(DrinkDTO dto) throws Exception{
        boolean check = false;
        try {
            String sql = "UPDATE Drink SET Name = ?,Description = ?,Price = ?,Status = ? WHERE DrinkID = ?";
            cnn = MyConnection.getConnection();
            ps = cnn.prepareStatement(sql);
            ps.setString(1, dto.getName());
            ps.setString(2, dto.getDescription());
            ps.setString(3, dto.getPrice());
            ps.setInt(4, dto.getStatus());
            ps.setString(5, dto.getDrinkId());
            check = ps.executeUpdate() > 0;
        }finally {
            closeConnection();
        }
        return check;
    }
}
