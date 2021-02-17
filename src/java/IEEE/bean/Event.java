/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package IEEE.bean;

import java.sql.Time;
import java.util.Date;

public class Event {
    private int id;
    private String name, description, guests, status, imagePath;
    private Date date;
    private Time time;

    public Event() {
    }

    
    public Event(int id, String name, String description, String guests, String status, String imagePath, Date date, Time time) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.guests = guests;
        this.status = status;
        this.imagePath = imagePath;
        this.date = date;
        this.time = time;
    }

  
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getGuests() {
        return guests;
    }

    public void setGuests(String guests) {
        this.guests = guests;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getImagePath() {
        return imagePath;
    }

    public void setImagePath(String imagePath) {
        this.imagePath = imagePath;
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
