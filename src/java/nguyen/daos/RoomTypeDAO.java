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
import java.util.ArrayList;
import java.util.List;
import nguyen.dbs.MyConnection;
import nguyen.dtos.RoomTypeDTO;

/**
 *
 * @author Unlucky Spider
 */
public class RoomTypeDAO implements Serializable{
    private Connection cnn;
    private PreparedStatement ps;
    private ResultSet rs;

    public RoomTypeDAO() {
    }
    private void closeConnection() throws Exception{
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
    public List<RoomTypeDTO> findByLikeName(String searchValue) throws Exception{
        List<RoomTypeDTO> result = null;
        RoomTypeDTO dto = null;
        try{
            String sql = "SELECT RoomType,Description,Quantity,Capacity,Price,Status FROM Room_Type WHERE RoomType LIKE ?";
            cnn = MyConnection.getConnection();
            ps = cnn.prepareStatement(sql);
            ps.setString(1, "%" + searchValue +"%");
            rs = ps.executeQuery();
            result = new ArrayList<>();
            while(rs.next()){
                String roomType,des,quantity,capacity,price;
                int status;
                roomType = rs.getString("RoomType");
                des = rs.getString("Description");
                quantity = rs.getString("Quantity");
                capacity = rs.getString("Capacity");
                price = rs.getString("Price");
                status = rs.getInt("Status");
                dto = new RoomTypeDTO(roomType, des, quantity, capacity, price, status);
                result.add(dto);
            }
        }finally{
            closeConnection();
        }
        return result;
    }
    public boolean delete(String id) throws Exception{
        boolean check = false;
        String sql = "DELETE FROM Room_Type WHERE RoomType = ?";
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
    public boolean insert(RoomTypeDTO dto) throws Exception {
        boolean check = false;
        try {
            String sql = "INSERT INTO Room_Type(RoomType,Description,Quantity,Capacity,Price,Status)"
                    + " VALUES(?,?,?,?,?,?)";
            cnn = MyConnection.getConnection();
            ps = cnn.prepareStatement(sql);
            ps.setString(1, dto.getRoomType());
            ps.setString(2, dto.getDescription());
            ps.setString(3, dto.getQuantity());
            ps.setString(4, dto.getCapacity());
            ps.setString(5, dto.getPrice());
            ps.setInt(6, dto.getStatus());
            check = ps.executeUpdate() > 0;
        } finally {
            closeConnection();
        }
        return check;
    }
    public RoomTypeDTO findByPrimaryKey(String id) throws Exception{
        RoomTypeDTO dto = null;
        try{
            String sql = "SELECT Description,Quantity,Capacity,Price,Status FROM Room_Type WHERE RoomType = ?";
            cnn = MyConnection.getConnection();
            ps = cnn.prepareStatement(sql);
            ps.setString(1, id);
            rs = ps.executeQuery();
            if(rs.next()){
                String des,quantity,capacity,price;
                int status;
                des = rs.getString("Description");
                quantity = rs.getString("Quantity");
                capacity=rs.getString("Capacity");
                price = rs.getString("Price");
                status = rs.getInt("Status");
                dto = new RoomTypeDTO(id, des, quantity, capacity, price, status);
            }
        }finally{
            closeConnection();
        }
        return dto;
    }
    public boolean update(RoomTypeDTO dto) throws Exception{
        boolean check = false;
        try {
            String sql = "UPDATE Room_Type SET Description = ?,Capacity = ?,Price = ? WHERE RoomType = ?";
            cnn = MyConnection.getConnection();
            ps = cnn.prepareStatement(sql);
            ps.setString(1, dto.getDescription());
            ps.setString(2, dto.getCapacity());
            ps.setString(3, dto.getPrice());
            ps.setString(4, dto.getRoomType());
            check = ps.executeUpdate() > 0;
        }finally {
            closeConnection();
        }
        return check;
    }
}
