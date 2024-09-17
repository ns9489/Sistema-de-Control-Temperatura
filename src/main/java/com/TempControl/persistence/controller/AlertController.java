package com.TempControl.persistence.controller;

import com.TempControl.domain.dto.AlertDTO;
import com.TempControl.persistence.service.AlertService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/alerts")
public class AlertController {

    @Autowired
    private AlertService alertService;

    @GetMapping
    public ResponseEntity<List<AlertDTO>> getAllAlerts() {
        List<AlertDTO> alerts = alertService.getAllAlerts();
        return ResponseEntity.ok(alerts);
    }

    @GetMapping("/{id}")
    public ResponseEntity<AlertDTO> getAlertById(@PathVariable("id") Integer id) {
        AlertDTO alert = alertService.getAlertById(id);
        return alert != null ? ResponseEntity.ok(alert) : ResponseEntity.notFound().build();
    }

    @PostMapping
    public ResponseEntity<AlertDTO> createAlert(@RequestBody AlertDTO alertDTO) {
        AlertDTO createdAlert = alertService.createAlert(alertDTO);
        return ResponseEntity.status(201).body(createdAlert);
    }

    @PutMapping("/{id}")
    public ResponseEntity<AlertDTO> updateAlert(@PathVariable("id") Integer id, @RequestBody AlertDTO alertDTO) {
        AlertDTO updatedAlert = alertService.updateAlert(id, alertDTO);
        return updatedAlert != null ? ResponseEntity.ok(updatedAlert) : ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteAlert(@PathVariable("id") Integer id) {
        boolean deleted = alertService.deleteAlert(id);
        return deleted ? ResponseEntity.noContent().build() : ResponseEntity.notFound().build();
    }

    @GetMapping("/count")
    public ResponseEntity<Long> countAllAlerts() {
        long count = alertService.countAllAlerts();
        return ResponseEntity.ok(count);
    }
}
