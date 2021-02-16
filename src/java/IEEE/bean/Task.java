/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package IEEE.bean;

import java.util.Date;

/**
 *
 * @author AdminCH
 */
public class Task {
    private int id, responsable_id, creator_id; 
    private String name, description, status, responsable; 
    private Date deadline;

    public Task(int id, int responsable_id, int creator_id, String name, String description, String status, String responsable, Date deadline) {
        this.id = id;
        this.responsable_id = responsable_id;
        this.creator_id = creator_id;
        this.name = name;
        this.description = description;
        this.status = status;
        this.responsable = responsable;
        this.deadline = deadline;
    }

   
    public Task(){
    
    }
    
    public String getResponsable() {
        return responsable;
    }

    public void setResponsable(String responsable) {
        this.responsable = responsable;
    }

    public int getCreator_id() {
        return creator_id;
    }

    public void setCreator_id(int creator_id) {
        this.creator_id = creator_id;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
    public int getResponsable_id() {
        return responsable_id;
    }

    public void setResponsable_id(int responsable_id) {
        this.responsable_id = responsable_id;
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

    public Date getDeadline() {
        return deadline;
    }

    public void setDeadline(Date deadline) {
        this.deadline = deadline;
    }

    
}
