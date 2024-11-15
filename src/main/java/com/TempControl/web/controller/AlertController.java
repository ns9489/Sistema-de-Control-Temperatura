package com.TempControl.web.controller;

import com.TempControl.domain.dto.AlertDTO;
import com.TempControl.domain.service.AlertService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

    @RestController
    @RequestMapping("/alerts")
    public class AlertController {
        @Autowired
        private AlertService alertService;

        @PostMapping("/save")
        public AlertDTO save(@RequestBody AlertDTO alertDTO) {
            return alertService.save(alertDTO);
        }

        @GetMapping("/getAlertById/{id}")
        public Optional<AlertDTO> getAlertById(@PathVariable("id") int id) {
            return alertService.getAlertById(id);
        }

        @GetMapping("/existsAlertById/{id}")
        public boolean existsAlertById(@PathVariable("id") int id){
            return alertService.existsAlertById(id);
        }

        @GetMapping("/getAllAlerts")
        public List<AlertDTO> getAll() {
            return alertService.getAll();
        }

        @GetMapping("/countAllAlerts")
        public long countAll() {
            return alertService.countAll();
        }

        @DeleteMapping("/deleteAlertById/{id}")
        public boolean deleteAlertById(@PathVariable("id") int id) {
            return alertService.deleteAlertById(id);
        }
    }

