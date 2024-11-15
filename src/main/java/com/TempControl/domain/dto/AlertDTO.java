package com.TempControl.domain.dto;

import com.TempControl.persistence.entity.Device;
import com.TempControl.persistence.entity.Sensor;

public class AlertDTO {

    private Integer id;
    private String message;
    private String creation_time;
    private Sensor sensor;
    private Device device;

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

    public Sensor getSensor() {
        return sensor;
    }

    public void setSensor(Sensor sensor) {
        this.sensor = sensor;
    }

    public Device getDevice() {
        return device;
    }

    public void setDevice(Device device) {
        this.device = device;
    }
}
