package com.TempControl.persistence.controller;

import com.TempControl.persistence.entity.TemperatureReading;
import com.TempControl.persistence.TemperatureReadingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/temperature-readings")
public class TemperatureReadingController {

    @Autowired
    private TemperatureReadingRepository temperatureReadingRepository;

    @GetMapping
    public ResponseEntity<List<TemperatureReading>> getAllTemperatureReadings() {
        List<TemperatureReading> temperatureReadings = temperatureReadingRepository.getAll();
        return ResponseEntity.ok(temperatureReadings);
    }

    @GetMapping("/{id}")
    public ResponseEntity<TemperatureReading> getTemperatureReadingById(@PathVariable Integer id) {
        return temperatureReadingRepository.getTemperatureReadingByID(id)
                .map(temperatureReading -> ResponseEntity.ok(temperatureReading))
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<TemperatureReading> createTemperatureReading(@RequestBody TemperatureReading temperatureReading) {
        TemperatureReading createdTemperatureReading = temperatureReadingRepository.save(temperatureReading);
        return ResponseEntity.status(201).body(createdTemperatureReading);
    }

    @PutMapping("/{id}")
    public ResponseEntity<TemperatureReading> updateTemperatureReading(@PathVariable Integer id, @RequestBody TemperatureReading temperatureReading) {
        if (!temperatureReadingRepository.existsTemperatureReading(id)) {
            return ResponseEntity.notFound().build();
        }
        temperatureReading.setId(id); // Ensure the ID is set correctly
        TemperatureReading updatedTemperatureReading = temperatureReadingRepository.save(temperatureReading);
        return ResponseEntity.ok(updatedTemperatureReading);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteTemperatureReading(@PathVariable Integer id) {
        if (!temperatureReadingRepository.existsTemperatureReading(id)) {
            return ResponseEntity.notFound().build();
        }
        temperatureReadingRepository.delete(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/count")
    public ResponseEntity<Long> countAllTemperatureReadings() {
        long count = temperatureReadingRepository.countAll();
        return ResponseEntity.ok(count);
    }
}
