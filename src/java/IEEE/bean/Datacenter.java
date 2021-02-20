/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package IEEE.bean;

import java.sql.Time;
import java.util.Date;

public class Datacenter {
    private int id, ownerid;
    private String name, path, ownername;
    private Date date;
    private Time time;

    public Datacenter(int id, int ownerid, String name, String path, String ownername, Date date, Time time) {
        this.id = id;
        this.ownerid = ownerid;
        this.name = name;
        this.path = path;
        this.ownername = ownername;
        this.date = date;
        this.time = time;
    }

    public Datacenter() {
    }

    
    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getOwnerid() {
        return ownerid;
    }

    public void setOwnerid(int ownerid) {
        this.ownerid = ownerid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public String getOwnername() {
        return ownername;
    }

    public void setOwnername(String ownername) {
        this.ownername = ownername;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Time getTime() {
        return time;
    }

    public void setTime(Time time) {
        this.time = time;
    }
    
    
    
    
}
