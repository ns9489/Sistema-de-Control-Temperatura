package com.TempControl.persistence.entity;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "sensor")
public class Sensor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "sensor_id")
    private Integer id;

    @Column(name = "model")
    private String model;

    @Column(name = "type")
    private String type;


    @ManyToOne
    @JoinColumn(name = "device_id", nullable = false)
    private Device device;

    @OneToMany(mappedBy = "sensor")
    private List <Alert> alerts;
    @OneToMany(mappedBy = "sensor")
    private List <TemperatureReading> TemperatureReadings;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Device getDevice() {
        return device;
    }

    public void setDevice(Device device) {
        this.device = device;
    }

    public List<Alert> getAlerts() {
        return alerts;
    }

    public void setAlerts(List<Alert> alerts) {
        this.alerts = alerts;
    }

    public List<TemperatureReading> getTemperatureReadings() {
        return TemperatureReadings;
    }

    public void setTemperatureReadings(List<TemperatureReading> temperatureReadings) {
        TemperatureReadings = temperatureReadings;
    }
}
