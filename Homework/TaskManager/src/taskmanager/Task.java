/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package taskmanager;

import java.io.Serializable;

/**
 *
 * @author alexa
 */
public class Task implements Serializable{

    private String description;
    private String status;

    public Task(String description, String status) {
        this.description = description;
        this.status = status;
    }

    public String getDescription() {
        return description;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

}
