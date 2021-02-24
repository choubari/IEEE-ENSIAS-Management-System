/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package IEEE.dao;

import IEEE.bean.Chat;
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
public class ChatDao {
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
    public static int savenew(Chat t) {
        int status = 0;
        try {
            Connection con = getConnection();
            PreparedStatement ps = con.prepareStatement(
                    "insert into chat(chat_id, chat_from, chat_to, chat_content, chat_date, chat_time) values(?,?,?,?,?,?)");
            ps.setInt(1, t.getId());
            ps.setInt(2, t.getFrom());
            ps.setInt(3, 2);
            ps.setString(4, t.getContent());
            ps.setDate(5,new java.sql.Date(t.getDate().getTime()));
            ps.setTime(6, t.getTime());
            status = ps.executeUpdate();
        } catch (Exception e) {
            System.out.println(e);
        }
        return status;
    }
     public static List<Chat> getAllChats() {
        List<Chat> list = new ArrayList<Chat>();
        try {
            Connection con = getConnection();
            PreparedStatement ps = con.prepareStatement("select chat_id, chat_from, chat_to, chat_content, chat_date, chat_time, member_first_name, member_last_name from chat inner join member on chat_from=member_id where chat_to=2 order by chat_date, chat_time asc");
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Chat t = new Chat();
                t.setId(rs.getInt("chat_id"));
                t.setFrom(rs.getInt("chat_from"));
                t.setTo(rs.getInt("chat_to"));
                t.setContent(rs.getString("chat_content"));
                t.setDate(rs.getDate("chat_date"));
                t.setTime(rs.getTime("chat_time"));
                t.setSender(rs.getString("member_first_name")+" "+rs.getString("member_last_name"));
                list.add(t);
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        return list;
    }
}
