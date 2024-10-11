package com.TempControl.domain.dto;

public class AlertDTO {

    private Integer id;
    private String message;
    private String creation_time;

// Getters and Setters
    // ...

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCreation_time() {
        return creation_time;
    }

    public void setCreation_time(String creation_time) {
        this.creation_time = creation_time;
    }
}
