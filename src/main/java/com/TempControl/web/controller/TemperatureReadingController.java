package com.TempControl.web.controller;

import com.TempControl.domain.dto.TemperatureReadingDTO;
import com.TempControl.domain.service.TemperatureReadingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/temperature-readings")
public class TemperatureReadingController {
    @Autowired
    private TemperatureReadingService temperatureReadingService;

    @PostMapping("/save")
    public TemperatureReadingDTO save(@RequestBody TemperatureReadingDTO temperatureReadingDTO) {
        return temperatureReadingService.save(temperatureReadingDTO);
    }

    @GetMapping("/getTemperatureReadingById/{id}")
    public Optional<TemperatureReadingDTO> getTemperatureReadingById(@PathVariable("id") int id) {
        return temperatureReadingService.getTemperatureReadingById(id);
    }

    @GetMapping("/existsTemperatureReadingById/{id}")
    public boolean existsTemperatureReadingById(@PathVariable("id") int id){
        return temperatureReadingService.existsTemperatureReadingById(id);
    }

    @GetMapping("/getAllTemperatureReadings")
    public List<TemperatureReadingDTO> getAll() {
        return temperatureReadingService.getAll();
    }

    @GetMapping("/countAllTemperatureReadings")
    public long countAll() {
        return temperatureReadingService.countAll();
    }

    @DeleteMapping("/deleteTemperatureReadingById/{id}")
    public boolean deleteTemperatureReadingById(@PathVariable("id") int id) {
        return temperatureReadingService.deleteTemperatureReadingById(id);
    }
}
