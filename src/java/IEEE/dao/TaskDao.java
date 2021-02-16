/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package IEEE.dao;

import IEEE.bean.Task;
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
public class TaskDao {
    static String jointure ="select task.task_id, task.task_name, task.task_description, task.task_deadline, task.task_status, task.task_responsible_id, task.task_creator_id , member.member_first_name, member.member_last_name from task inner join member on task.task_responsible_id=member.member_id";
    
    
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
    public static int savenew(Task t) {
        int status = 0;
        try {
            Connection con = getConnection();
            PreparedStatement ps = con.prepareStatement(
                    "insert into task(task_id, task_name, task_description, task_deadline, task_status, task_responsible_id, task_creator_id) values(?,?,?,?,?,?,?)");
            ps.setInt(1, t.getId());
            ps.setString(2, t.getName());
            ps.setString(3, t.getDescription());
            ps.setDate(4,new java.sql.Date(t.getDeadline().getTime()));
            ps.setString(5, "Todo");
            ps.setInt(6, t.getResponsable_id());
            ps.setInt(7, t.getCreator_id());
            status = ps.executeUpdate();
        } catch (Exception e) {
            System.out.println(e);
        }
        return status;
    }
    public static int update(Task t) {
        int status = 0;
        try {
            Connection con = getConnection();
            PreparedStatement ps = con.prepareStatement(
                    "update task set task_name=?, task_description=?, task_deadline=?, task_status=?, task_responsible_id=? where task_id=?");
            ps.setString(1, t.getName());
            ps.setString(2, t.getDescription());
            ps.setDate(3,new java.sql.Date(t.getDeadline().getTime()));
            ps.setString(4, t.getStatus());
            ps.setInt(5, t.getResponsable_id());
            ps.setInt(6, t.getId());
            status = ps.executeUpdate();
        } catch (Exception e) {
            System.out.println(e);
        }
        return status;
    }
    public static int delete(Task t) {
        int status = 0;
        try {
            Connection con = getConnection();
            PreparedStatement ps = con.prepareStatement("delete from task where task_id=?");
            ps.setInt(1, t.getId());
            status = ps.executeUpdate();
        } catch (Exception e) {
            System.out.println(e);
        }

        return status;
    }
    public static Task getTaskById(int id){
        Task t = new Task ();
        try {
            Connection con = getConnection();
            PreparedStatement ps = con.prepareStatement(jointure +" where task.task_id=?");
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                t.setId(rs.getInt("task.task_id"));
                t.setName(rs.getString("task.task_name"));
                t.setDescription(rs.getString("task.task_description"));
                t.setDeadline(rs.getDate("task.task_deadline"));
                t.setStatus(rs.getString("task.task_status"));
                t.setCreator_id(rs.getInt("task.task_creator_id"));
                t.setResponsable_id(rs.getInt("task.task_responsible_id"));
                t.setResponsable(rs.getString("member.member_first_name")+" "+rs.getString("member.member_last_name"));
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        
        return t;
    }
    
    public static List<Task> getAllTasks() {
        List<Task> list = new ArrayList<Task>();
        try {
            Connection con = getConnection();
            PreparedStatement ps = con.prepareStatement(jointure);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Task t = new Task();
                t.setId(rs.getInt("task.task_id"));
                t.setName(rs.getString("task.task_name"));
                t.setDescription(rs.getString("task.task_description"));
                t.setDeadline(rs.getDate("task.task_deadline"));
                t.setStatus(rs.getString("task.task_status"));
                t.setResponsable_id(rs.getInt("task.task_responsible_id"));
                t.setCreator_id(rs.getInt("task.task_creator_id"));
                t.setResponsable(rs.getString("member.member_first_name")+" "+rs.getString("member.member_last_name"));
                list.add(t);
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        return list;
    }
    public static List<Task> getMyDelegatedTasks(int creator_id) {
        List<Task> list = new ArrayList<Task>();

        try {
            Connection con = getConnection();
            PreparedStatement ps = con.prepareStatement(jointure + " where task.task_creator_id=? and task.task_creator_id<>task.task_responsible_id");
            ps.setInt(1, creator_id);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Task t = new Task();
                t.setId(rs.getInt("task.task_id"));
                t.setName(rs.getString("task.task_name"));
                t.setDescription(rs.getString("task.task_description"));
                t.setDeadline(rs.getDate("task.task_deadline"));
                t.setStatus(rs.getString("task.task_status"));
                t.setResponsable_id(rs.getInt("task.task_responsible_id"));
                t.setCreator_id(rs.getInt("task.task_creator_id"));
                t.setResponsable(rs.getString("member.member_first_name")+" "+rs.getString("member.member_last_name"));
                list.add(t);
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        return list;
    }
    public static List<Task> getMyCreatedTasks(int creator_id) {
        List<Task> list = new ArrayList<Task>();

        try {
            Connection con = getConnection();
            PreparedStatement ps = con.prepareStatement("select * from task where task_creator_id=?");
            ps.setInt(1, creator_id);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Task t = new Task();
                t.setId(rs.getInt("task_id"));
                t.setName(rs.getString("task_name"));
                t.setDescription(rs.getString("task_description"));
                t.setDeadline(rs.getDate("task_deadline"));
                t.setStatus(rs.getString("task_status"));
                t.setResponsable_id(rs.getInt("task_responsible_id"));
                t.setCreator_id(rs.getInt("task_creator_id"));
                //t.setResponsable(rs.getString("member.member_first_name")+" "+rs.getString("member.member_last_name"));
                list.add(t);
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        return list;
    }
    public static List<Task> getMyTasks(int responsible_id) {
        List<Task> list = new ArrayList<Task>();

        try {
            Connection con = getConnection();
            PreparedStatement ps = con.prepareStatement(jointure + " where task.task_responsible_id=?");
            ps.setInt(1, responsible_id);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Task t = new Task();
                t.setId(rs.getInt("task.task_id"));
                t.setName(rs.getString("task.task_name"));
                t.setDescription(rs.getString("task.task_description"));
                t.setDeadline(rs.getDate("task.task_deadline"));
                t.setStatus(rs.getString("task.task_status"));
                t.setResponsable_id(rs.getInt("task.task_responsible_id"));
                t.setCreator_id(rs.getInt("task.task_creator_id"));
                t.setResponsable(rs.getString("member.member_first_name")+" "+rs.getString("member.member_last_name"));
                list.add(t);
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        return list;
    }
    
    
    
    
}
