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
import nguyen.dtos.ServiceDTO;

/**
 *
 * @author Unlucky Spider
 */
public class ServiceDAO implements Serializable{
    private Connection cnn;
    private PreparedStatement ps;
    private ResultSet rs;

    public ServiceDAO() {
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
    public List<ServiceDTO> findByLikeName(String searchValue) throws Exception{
        List<ServiceDTO> result = null;
        ServiceDTO dto = null;
        try{
            String sql = "SELECT ServiceID,Name,Description,Price,Status FROM Service WHERE Name LIKE ?";
            cnn = MyConnection.getConnection();
            ps = cnn.prepareStatement(sql);
            ps.setString(1, "%" + searchValue +"%");
            rs = ps.executeQuery();
            result = new ArrayList<>();
            while(rs.next()){
                String serviceId,name,des;
                String price;
                int status;
                serviceId = rs.getString("ServiceID");
                name = rs.getString("Name");
                des = rs.getString("Description");
                price = rs.getString("Price");
                status = rs.getInt("Status");
                dto = new ServiceDTO(serviceId, name, des, price, status);
                result.add(dto);
            }
        }finally{
            closeConnection();
        }
        return result;
    }
    public boolean delete(String id) throws Exception{
        boolean check = false;
        String sql = "DELETE FROM Service WHERE ServiceID = ?";
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
    public boolean insert(ServiceDTO dto) throws Exception {
        boolean check = false;
        try {
            String sql = "INSERT INTO Service(ServiceID,Name,Description,Price,Status)"
                    + " VALUES(?,?,?,?,?)";
            cnn = MyConnection.getConnection();
            ps = cnn.prepareStatement(sql);
            ps.setString(1, dto.getServiceId());
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
    public ServiceDTO findByPrimaryKey(String id) throws Exception{
        ServiceDTO dto = null;
        try{
            String sql = "SELECT Name,Description,Price,Status FROM Service WHERE ServiceID = ?";
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
                dto = new ServiceDTO(id, name, des, price, status);
            }
        }finally{
            closeConnection();
        }
        return dto;
    }
    public boolean update(ServiceDTO dto) throws Exception{
        boolean check = false;
        try {
            String sql = "UPDATE Service SET Name = ?,Description = ?,Price = ?,Status = ? WHERE ServiceID = ?";
            cnn = MyConnection.getConnection();
            ps = cnn.prepareStatement(sql);
            ps.setString(1, dto.getName());
            ps.setString(2, dto.getDescription());
            ps.setString(3, dto.getPrice());
            ps.setInt(4, dto.getStatus());
            ps.setString(5, dto.getServiceId());
            check = ps.executeUpdate() > 0;
        }finally {
            closeConnection();
        }
        return check;
    }
}
