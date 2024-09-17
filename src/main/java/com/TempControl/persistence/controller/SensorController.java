package com.TempControl.persistence.controller;

import com.TempControl.persistence.entity.Sensor;
import com.TempControl.persistence.Repository.SensorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/sensors")
public class SensorController {

    @Autowired
    private SensorRepository sensorRepository;

    @GetMapping
    public ResponseEntity<List<Sensor>> getAllSensors() {
        List<Sensor> sensors = sensorRepository.getAll();
        return ResponseEntity.ok(sensors);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Sensor> getSensorById(@PathVariable Integer id) {
        return sensorRepository.getSensorByID(id)
                .map(sensor -> ResponseEntity.ok(sensor))
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<Sensor> createSensor(@RequestBody Sensor sensor) {
        Sensor createdSensor = sensorRepository.save(sensor);
        return ResponseEntity.status(201).body(createdSensor);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Sensor> updateSensor(@PathVariable Integer id, @RequestBody Sensor sensor) {
        if (!sensorRepository.existsSensor(id)) {
            return ResponseEntity.notFound().build();
        }
        sensor.setId(id); // Ensure the ID is set correctly
        Sensor updatedSensor = sensorRepository.save(sensor);
        return ResponseEntity.ok(updatedSensor);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteSensor(@PathVariable Integer id) {
        if (!sensorRepository.existsSensor(id)) {
            return ResponseEntity.notFound().build();
        }
        sensorRepository.delete(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/count")
    public ResponseEntity<Long> countAllSensors() {
        long count = sensorRepository.countAll();
        return ResponseEntity.ok(count);
    }
}
