/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package IEEE.dao;

import IEEE.bean.ContactForm;
import static IEEE.dao.ContactformDao.getConnection;
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
public class ContactformDao {
 
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

    public static int save(ContactForm u) {
        int status = 0;
        try {
            Connection con = getConnection();
            PreparedStatement ps = con.prepareStatement(
                    "insert into contactus(contactus_id, contactus_name, contactus_email, contactus_subject, contactus_message) values(?,?,?,?,?)");
            ps.setInt(1, u.getId());
            ps.setString(2, u.getName());
            ps.setString(3, u.getEmail());
            ps.setString(4, u.getSubject());
            ps.setString(5, u.getMessage());
            status = ps.executeUpdate();
        } catch (Exception e) {
            System.out.println(e);
        }
        return status;
    }
    public static List<ContactForm> getAllRecords() {
        List<ContactForm> list = new ArrayList<ContactForm>();

        try {
            Connection con = getConnection();
            PreparedStatement ps = con.prepareStatement("select * from contactus");
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                ContactForm u = new ContactForm();
                u.setId(rs.getInt("contactus_id"));
                u.setName(rs.getString("contactus_name"));
                u.setEmail(rs.getString("contactus_email"));
                u.setSubject(rs.getString("contactus_subject"));
                u.setMessage(rs.getString("contactus_message"));
                list.add(u);
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        return list;
    }
}
