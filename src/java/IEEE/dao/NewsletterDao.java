/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package IEEE.dao;

import IEEE.bean.Newsletter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author AdminCH
 */
public class NewsletterDao {
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
    public static int save(Newsletter u) {
        int status = 0;
        try {
            Connection con = getConnection();
            PreparedStatement ps = con.prepareStatement(
                    "insert into newsletter(newsletter_id, newsletter_name, newsletter_email) values(?,?,?)");
            ps.setInt(1, u.getId());
            ps.setString(2, u.getName());
            ps.setString(3, u.getEmail());
            status = ps.executeUpdate();
        } catch (Exception e) {
            System.out.println(e);
        }
        return status;
    }
     public static List<Newsletter> getAllRecords() {
        List<Newsletter> list = new ArrayList<Newsletter>();

        try {
            Connection con = getConnection();
            PreparedStatement ps = con.prepareStatement("select * from newsletter");
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Newsletter u = new Newsletter();
                u.setId(rs.getInt("newsletter_id"));
                u.setName(rs.getString("newsletter_name"));
                u.setEmail(rs.getString("newsletter_email"));
                list.add(u);
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        return list;
    }
    
    
}
