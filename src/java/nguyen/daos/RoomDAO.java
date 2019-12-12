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
import nguyen.dtos.RoomDTO;

/**
 *
 * @author Unlucky Spider
 */
public class RoomDAO implements Serializable{
    private Connection cnn;
    private PreparedStatement ps;
    private ResultSet rs;

    public RoomDAO() {
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
    public List<RoomDTO> findByLikeName(String searchValue) throws Exception{
        List<RoomDTO> result = null;
        RoomDTO dto = null;
        try{
            String sql = "SELECT RoomID,RoomType,Status FROM Room WHERE RoomID LIKE ?";
            cnn = MyConnection.getConnection();
            ps = cnn.prepareStatement(sql);
            ps.setString(1, "%" + searchValue +"%");
            rs = ps.executeQuery();
            result = new ArrayList<>();
            while(rs.next()){
                String roomId,roomType;
                int status;
                roomId = rs.getString("RoomID");
                roomType = rs.getString("RoomType");
                status = rs.getInt("Status");
                dto = new RoomDTO(roomId,roomType,status);
                result.add(dto);
            }
        }finally{
            closeConnection();
        }
        return result;
    }
    public boolean insert(RoomDTO dto) throws Exception {
        boolean check = false;
        PreparedStatement ps1 = null;
        PreparedStatement ps2 = null;
        try {
            String sql = "INSERT INTO Room(RoomID,RoomType,Status)"
                    + " VALUES(?,?,?)";
            String sql2 = "UPDATE Room_Type SET Quantity = Quantity + 1 WHERE RoomType = ?";
            cnn = MyConnection.getConnection();
            ps1 = cnn.prepareStatement(sql);
            ps2 = cnn.prepareStatement(sql2);
            ps1.setString(1, dto.getRoomId());
            ps1.setString(2, dto.getRoomType());
            ps1.setInt(3, dto.getStatus());
            ps2.setString(1, dto.getRoomType());
            ps1.executeUpdate();
            check = ps2.executeUpdate() > 0;
        } finally {
            closeConnection();
        }
        return check;
    }
    public boolean update(String id,int status) throws Exception{
        boolean check = false;
        if(status == 0){
            status = 1;
        }else if(status == 1) status = 0;
        try {
            String sql = "UPDATE Room SET Status = ? WHERE RoomID = ?";
            cnn = MyConnection.getConnection();
            ps = cnn.prepareStatement(sql);
            ps.setInt(1, status);
            ps.setString(2, id);
            check = ps.executeUpdate() > 0;
        }finally {
            closeConnection();
        }
        return check;
    }
}
