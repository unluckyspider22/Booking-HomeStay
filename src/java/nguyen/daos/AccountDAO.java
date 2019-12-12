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
import nguyen.dtos.AccountDTO;

/**
 *
 * @author Unlucky Spider
 */
public class AccountDAO implements Serializable {

    private Connection cnn;
    private PreparedStatement ps;
    private ResultSet rs;

    public AccountDAO() {
    }

    private void closeConnection() throws SQLException {
        if (ps != null) {
            ps.close();
        }
        if (rs != null) {
            rs.close();
        }
        if (cnn != null) {
            cnn.close();
        }
    }

    public String checkLogin(String username, String password) throws Exception {
        String role = "failed";
        String sql = "SELECT Role FROM Account WHERE Username = ? and Password = ?";
        try {
            cnn = MyConnection.getConnection();
            ps = cnn.prepareStatement(sql);
            ps.setString(1, username);
            ps.setString(2, password);
            rs = ps.executeQuery();
            if (rs.next()) {
                role = rs.getString("Role");
            }
        } finally {
            closeConnection();
        }
        return role;
    }

    public List<AccountDTO> findByLikeName(String searchValue) throws Exception {
        List<AccountDTO> result = null;
        AccountDTO dto = null;
        try {
            String sql = "SELECT Username,Fullname,Email,Phone,Gender,IDNumber,Nationality,DOB,Role FROM Account WHERE Fullname LIKE ?";
            cnn = MyConnection.getConnection();
            ps = cnn.prepareStatement(sql);
            ps.setString(1, "%" + searchValue + "%");
            rs = ps.executeQuery();
            result = new ArrayList<>();
            while (rs.next()) {
                String username, fullname, email, phone, idNumber, nationality, role;
                String DOB;
                int gender;
                username = rs.getString("Username");
                fullname = rs.getString("Fullname");
                email = rs.getString("Email");
                phone = rs.getString("Phone");
                gender = rs.getInt("Gender");
                idNumber = rs.getString("IDNumber");
                nationality = rs.getString("Nationality");
                DOB = rs.getString("DOB");
                role = rs.getString("Role");
                dto = new AccountDTO(username, fullname, email, phone, gender, idNumber, nationality, DOB, role);
                result.add(dto);
            }
        } finally {
            closeConnection();
        }
        return result;
    }

    public boolean delete(String id) throws Exception {
        boolean check = false;
        String sql = "DELETE FROM Account WHERE Username = ?";
        try {
            cnn = MyConnection.getConnection();
            ps = cnn.prepareStatement(sql);
            ps.setString(1, id);
            check = ps.executeUpdate() > 0;
        } finally {
            closeConnection();
        }
        return check;
    }

    public boolean insert(AccountDTO dto) throws Exception {
        boolean check = false;
        try {
            String sql = "INSERT INTO Account(Username,Password,Fullname,Email,Phone,Gender,IDNumber,Nationality,DOB,Role)"
                    + " VALUES(?,?,?,?,?,?,?,?,?,?)";
            cnn = MyConnection.getConnection();
            ps = cnn.prepareStatement(sql);
            ps.setString(1, dto.getUsername());
            ps.setString(2, dto.getPassword());
            ps.setString(3, dto.getFullname());
            ps.setString(4, dto.getEmail());
            ps.setString(5, dto.getPhone());
            ps.setInt(6, dto.getGender());
            ps.setString(7, dto.getIdnumber());
            ps.setString(8, dto.getNationality());
            ps.setString(9, dto.getDob());
            ps.setString(10, dto.getRole());
            check = ps.executeUpdate() > 0;
        } finally {
            closeConnection();
        }
        return check;
    }
    public AccountDTO findByPrimaryKey(String id) throws Exception{
        AccountDTO dto = null;
        try{
            String sql = "SELECT Fullname,Password,Email,Phone,Gender,IDNumber,Nationality,DOB,Role FROM Account WHERE Username = ?";
            cnn = MyConnection.getConnection();
            ps = cnn.prepareStatement(sql);
            ps.setString(1, id);
            rs = ps.executeQuery();
            if(rs.next()){
                String password, fullname, email, phone, idNumber, nationality, role;
                String DOB;
                int gender;
                password = rs.getString("Password");
                fullname = rs.getString("Fullname");
                email = rs.getString("Email");
                phone = rs.getString("Phone");
                gender = rs.getInt("Gender");
                idNumber = rs.getString("IDNumber");
                nationality = rs.getString("Nationality");
                DOB = rs.getString("DOB");
                role = rs.getString("Role");
                dto = new AccountDTO(id, fullname, email, phone, gender, idNumber, nationality, DOB, role);
                dto.setPassword(password);
            }
        }finally{
            closeConnection();
        }
        return dto;
    }
    public boolean update(AccountDTO dto) throws Exception{
        boolean check = false;
        try {
            String sql = "UPDATE Account SET Password = ?, Fullname = ?,Email = ?,Phone = ?,Gender = ?,IDNumber = ?,Nationality = ?,DOB = ?, Role = ? WHERE Username = ?";
            cnn = MyConnection.getConnection();
            ps = cnn.prepareStatement(sql);
            ps.setString(1, dto.getPassword());
            ps.setString(2, dto.getFullname());
            ps.setString(3, dto.getEmail());
            ps.setString(4, dto.getPhone());
            ps.setInt(5, dto.getGender());
            ps.setString(6, dto.getIdnumber());
            ps.setString(7, dto.getNationality());
            ps.setString(8, dto.getDob());
            ps.setString(9, dto.getRole());
            ps.setString(10, dto.getUsername());
            check = ps.executeUpdate() > 0;
        }finally {
            closeConnection();
        }
        return check;
    }
}
