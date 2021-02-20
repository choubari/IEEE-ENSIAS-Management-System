/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package IEEE.dao;

import IEEE.bean.Datacenter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class DatacenterDao {
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
    public static int savenew(Datacenter t) {
        int status = 0;
        try {
            Connection con = getConnection();
            PreparedStatement ps = con.prepareStatement(
                    "insert into datacenter(file_id, file_name, file_path, file_date, file_time, file_ownerid) values(?,?,?,?,?,?)");
            ps.setInt(1, t.getId());
            ps.setString(2, t.getName());
            ps.setString(3, t.getPath());
            ps.setDate(4,new java.sql.Date(t.getDate().getTime()));
            ps.setTime(5, t.getTime());
            ps.setInt(6, t.getOwnerid());
            status = ps.executeUpdate();
        } catch (Exception e) {
            System.out.println(e);
        }
        return status;
    }
    public static int delete(Datacenter t) {
        int status = 0;
        try {
            Connection con = getConnection();
            PreparedStatement ps = con.prepareStatement("delete from datacenter where file_id=?");
            ps.setInt(1, t.getId());
            status = ps.executeUpdate();
        } catch (Exception e) {
            System.out.println(e);
        }

        return status;
    }
    public static List<Datacenter> getAllFiles() {
        List<Datacenter> list = new ArrayList<Datacenter>();
        try {
            Connection con = getConnection();
            PreparedStatement ps = con.prepareStatement("select file_id, file_name, file_path, file_date, file_time, file_ownerid,member_first_name, member_last_name from datacenter inner join member on datacenter.file_ownerid=member.member_id");
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Datacenter t = new Datacenter();
                t.setId(rs.getInt("file_id"));
                t.setName(rs.getString("file_name"));
                t.setPath(rs.getString("file_path"));
                t.setDate(rs.getDate("file_date"));
                t.setTime(rs.getTime("file_time"));
                t.setOwnerid(rs.getInt("file_ownerid"));
                t.setOwnername(rs.getString("member_first_name")+" "+rs.getString("member_last_name"));
                list.add(t);
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        return list;
    }
    
    
}
