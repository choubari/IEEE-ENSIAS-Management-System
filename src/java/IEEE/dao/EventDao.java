/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package IEEE.dao;

import IEEE.bean.Event;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class EventDao {
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
    public static int savenew(Event t) {
        int status = 0;
        try {
            Connection con = getConnection();
            PreparedStatement ps = con.prepareStatement(
                    "insert into event(event_id, event_name, event_description, event_date, event_time, event_guests, event_flyer, event_status) values(?,?,?,?,?,?,?,?)");
            ps.setInt(1, t.getId());
            ps.setString(2, t.getName());
            ps.setString(3, t.getDescription());
            ps.setDate(4,new java.sql.Date(t.getDate().getTime()));
            ps.setTime(5, t.getTime());
            ps.setString(6, t.getGuests());
            ps.setString(7, t.getImagePath());
            ps.setString(8, t.getStatus());
            status = ps.executeUpdate();
        } catch (Exception e) {
            System.out.println(e);
        }
        return status;
    }
    public static int update(Event t) {
        int status = 0;
        try {
            Connection con = getConnection();
            PreparedStatement ps = con.prepareStatement(
                    "update event set event_name=?, event_description=?, event_date=?, event_time=?, event_guests=?, event_flyer=?, event_status=? where event_id=?");
            ps.setString(1, t.getName());
            ps.setString(2, t.getDescription());
            ps.setDate(3,new java.sql.Date(t.getDate().getTime()));
            ps.setTime(4, t.getTime());
            ps.setString(5, t.getGuests());
            ps.setString(6, t.getImagePath());
            ps.setString(7, t.getStatus());
            ps.setInt(8, t.getId());
            status = ps.executeUpdate();
        } catch (Exception e) {
            System.out.println(e);
        }
        return status;
    }
    public static int delete(Event t) {
        int status = 0;
        try {
            Connection con = getConnection();
            PreparedStatement ps = con.prepareStatement("delete from event where event_id=?");
            ps.setInt(1, t.getId());
            status = ps.executeUpdate();
        } catch (Exception e) {
            System.out.println(e);
        }

        return status;
    }
    
    public static Event getEventById(int id){
        Event t = null;
        try {
            Connection con = getConnection();
            PreparedStatement ps = con.prepareStatement("select * from event where event_id=?");
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                t = new Event ();
                t.setId(rs.getInt("event_id"));
                t.setName(rs.getString("event_name"));
                t.setDescription(rs.getString("event_description"));
                t.setGuests(rs.getString("event_guests"));
                t.setDate(rs.getDate("event_date"));
                t.setTime(rs.getTime("event_time"));
                t.setStatus(rs.getString("event_status"));
                t.setImagePath(rs.getString("event_flyer"));
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        
        return t;
    }
    
    public static List<Event> getAllEvents() {
        List<Event> list = new ArrayList<Event>();
        try {
            Connection con = getConnection();
            PreparedStatement ps = con.prepareStatement("select * from event");
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Event t = new Event();
                t.setId(rs.getInt("event_id"));
                t.setName(rs.getString("event_name"));
                t.setDescription(rs.getString("event_description"));
                t.setGuests(rs.getString("event_guests"));
                t.setDate(rs.getDate("event_date"));
                t.setTime(rs.getTime("event_time"));
                t.setStatus(rs.getString("event_status"));
                t.setImagePath(rs.getString("event_flyer"));
                list.add(t);
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        return list;
    }
    
}
