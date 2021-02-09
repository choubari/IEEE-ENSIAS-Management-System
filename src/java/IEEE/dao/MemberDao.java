/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package IEEE.dao;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import IEEE.bean.Member;

/**
 *
 * @author AdminCH
 */
public class MemberDao {

    public static Connection getConnection() {
        Connection con = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/ieee_ensias?allowPublicKeyRetrieval=true&useSSL=false", "root", "choub");
        } catch (Exception e) {
            System.out.println(e);
        }
        return con;
    }

    public static int save(Member u) {
        int status = 0;
        try {
            Connection con = getConnection();
            PreparedStatement ps = con.prepareStatement(
                    "insert into member(member_id, member_first_name, member_last_name, member_email, member_password, member_tele, member_promo, member_branch, member_cellule, member_role) values(?,?,?,?,?,?,?,?,?,?)");
            ps.setInt(1, u.getId());
            ps.setString(2, u.getFirstname());
            ps.setString(3, u.getLastname());
            ps.setString(4, u.getEmail());
            ps.setString(5, u.getPassword());
            ps.setString(6, u.getPhone());
            ps.setInt(7, u.getPromo());
            ps.setString(8, u.getBranch());
            ps.setString(9, u.getCell());
            ps.setString(10, "inactif");
            status = ps.executeUpdate();
        } catch (Exception e) {
            System.out.println(e);
        }
        return status;
    }

    public static int update(Member u) {
        int status = 0;
        try {
            Connection con = getConnection();
            PreparedStatement ps = con.prepareStatement(
                    "update member set member_first_name=?, member_last_name=?, member_email=?, member_password=?, member_tele=?, member_promo=?, member_branch=?, member_cellule=?, member_role=?  where id=?");
            ps.setString(1, u.getFirstname());
            ps.setString(2, u.getLastname());
            ps.setString(3, u.getEmail());
            ps.setString(4, u.getPassword());
            ps.setString(5, u.getPhone());
            ps.setInt(6, u.getPromo());
            ps.setString(7, u.getBranch());
            ps.setString(8, u.getCell());
            ps.setString(9, u.getRole());
            ps.setInt(10, u.getId());
            status = ps.executeUpdate();
        } catch (Exception e) {
            System.out.println(e);
        }
        return status;
    }

    public static int delete(Member u) {
        int status = 0;
        try {
            Connection con = getConnection();
            PreparedStatement ps = con.prepareStatement("delete from member where id=?");
            ps.setInt(1, u.getId());
            status = ps.executeUpdate();
        } catch (Exception e) {
            System.out.println(e);
        }

        return status;
    }

    public static List<Member> getAllRecords() {
        List<Member> list = new ArrayList<Member>();

        try {
            Connection con = getConnection();
            PreparedStatement ps = con.prepareStatement("select * from member");
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Member u = new Member();
                u.setId(rs.getInt("id"));
                u.setFirstname(rs.getString("firstname"));
                u.setLastname(rs.getString("lastname"));
                u.setEmail(rs.getString("email"));
                u.setPassword(rs.getString("password"));
                u.setPhone(rs.getString("phone"));
                u.setPromo(rs.getInt("promo"));
                u.setBranch(rs.getString("branch"));
                u.setCell(rs.getString("cell"));
                u.setRole(rs.getString("role"));
                list.add(u);
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        return list;
    }

    public static Member getRecordById(int id) {
        Member u = null;
        try {
            Connection con = getConnection();
            PreparedStatement ps = con.prepareStatement("select * from member where id=?");
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                u = new Member();
                u.setId(rs.getInt("id"));
                u.setFirstname(rs.getString("firstname"));
                u.setLastname(rs.getString("lastname"));
                u.setEmail(rs.getString("email"));
                u.setPassword(rs.getString("password"));
                u.setPhone(rs.getString("phone"));
                u.setPromo(rs.getInt("promo"));
                u.setBranch(rs.getString("branch"));
                u.setCell(rs.getString("cell"));
                u.setRole(rs.getString("role"));
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        return u;
    }
}
