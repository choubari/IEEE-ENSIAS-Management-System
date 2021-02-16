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
                    "update member set member_first_name=?, member_last_name=?, member_email=?, member_password=?, member_tele=?, member_promo=?, member_branch=?, member_cellule=?, member_role=?  where member_id=?");
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
    public static int adminUpdate(int id,String role, String cell) {
        int status = 0;
        try {
            Connection con = getConnection();
            PreparedStatement ps = con.prepareStatement(
                    "update member set member_cellule=?, member_role=?  where member_id=?");
            ps.setString(1, cell);
            ps.setString(2, role);
            ps.setInt(3, id);
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
            PreparedStatement ps = con.prepareStatement("delete from member where member_id=?");
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
                u.setId(rs.getInt("member_id"));
                u.setFirstname(rs.getString("member_first_name"));
                u.setLastname(rs.getString("member_last_name"));
                u.setEmail(rs.getString("member_email"));
                u.setPassword(rs.getString("member_password"));
                u.setPhone(rs.getString("member_tele"));
                u.setPromo(rs.getInt("member_promo"));
                u.setBranch(rs.getString("member_branch"));
                u.setCell(rs.getString("member_cellule"));
                u.setRole(rs.getString("member_role"));
                list.add(u);
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        return list;
    }
    public static List<Member> getActiveRecords() {
        List<Member> list = new ArrayList<Member>();

        try {
            Connection con = getConnection();
            PreparedStatement ps = con.prepareStatement("select * from member where member_role<>'inactif'");
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Member u = new Member();
                u.setId(rs.getInt("member_id"));
                u.setFirstname(rs.getString("member_first_name"));
                u.setLastname(rs.getString("member_last_name"));
                u.setEmail(rs.getString("member_email"));
                u.setPassword(rs.getString("member_password"));
                u.setPhone(rs.getString("member_tele"));
                u.setPromo(rs.getInt("member_promo"));
                u.setBranch(rs.getString("member_branch"));
                u.setCell(rs.getString("member_cellule"));
                u.setRole(rs.getString("member_role"));
                list.add(u);
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        return list;
    }
    public static List<Member> getInactiveRecords() {
        List<Member> list = new ArrayList<Member>();

        try {
            Connection con = getConnection();
            PreparedStatement ps = con.prepareStatement("select * from member where member_role='inactif' ");
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Member u = new Member();
                u.setId(rs.getInt("member_id"));
                u.setFirstname(rs.getString("member_first_name"));
                u.setLastname(rs.getString("member_last_name"));
                u.setEmail(rs.getString("member_email"));
                u.setPassword(rs.getString("member_password"));
                u.setPhone(rs.getString("member_tele"));
                u.setPromo(rs.getInt("member_promo"));
                u.setBranch(rs.getString("member_branch"));
                u.setCell(rs.getString("member_cellule"));
                u.setRole(rs.getString("member_role"));
                list.add(u);
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        return list;
    }
    public static String getCellofChef(int id){
         String cell = "";
        try {
            Connection con = getConnection();
            PreparedStatement ps = con.prepareStatement("select member_cellule from member where member_id=?");
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                cell= rs.getString("member_cellule");
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        return cell;
    }
     public static List<Member> getMembersofCell(String cell) {
        List<Member> list = new ArrayList<Member>();
        try {
            Connection con = getConnection();
            PreparedStatement ps = con.prepareStatement("select * from member where member_role='member' and member_cellule=? ");
            ps.setString(1, cell);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Member u = new Member();
                u.setId(rs.getInt("member_id"));
                u.setFirstname(rs.getString("member_first_name"));
                u.setLastname(rs.getString("member_last_name"));
                u.setEmail(rs.getString("member_email"));
                u.setPassword(rs.getString("member_password"));
                u.setPhone(rs.getString("member_tele"));
                u.setPromo(rs.getInt("member_promo"));
                u.setBranch(rs.getString("member_branch"));
                u.setCell(rs.getString("member_cellule"));
                u.setRole(rs.getString("member_role"));
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
            PreparedStatement ps = con.prepareStatement("select * from member where member_id=?");
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                u = new Member();
                u.setId(rs.getInt("member_id"));
                u.setFirstname(rs.getString("member_first_name"));
                u.setLastname(rs.getString("member_last_name"));
                u.setEmail(rs.getString("member_email"));
                u.setPassword(rs.getString("member_password"));
                u.setPhone(rs.getString("member_tele"));
                u.setPromo(rs.getInt("member_promo"));
                u.setBranch(rs.getString("member_branch"));
                u.setCell(rs.getString("member_cellule"));
                u.setRole(rs.getString("member_role"));
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        return u;
    }
    public static Member getRecordByLogin(String email, String password) {
        Member u = null;
        try {
            Connection con = getConnection();
            PreparedStatement ps = con.prepareStatement("select * from member where member_email=? and member_password = ?");
            ps.setString(1, email);
            ps.setString(2, password);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                u = new Member();
                u.setId(rs.getInt("member_id"));
                u.setFirstname(rs.getString("member_first_name"));
                u.setLastname(rs.getString("member_last_name"));
                u.setEmail(rs.getString("member_email"));
                u.setPassword(rs.getString("member_password"));
                u.setPhone(rs.getString("member_tele"));
                u.setPromo(rs.getInt("member_promo"));
                u.setBranch(rs.getString("member_branch"));
                u.setCell(rs.getString("member_cellule"));
                u.setRole(rs.getString("member_role"));
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        return u;
    }
}
