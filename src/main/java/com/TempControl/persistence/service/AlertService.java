package com.TempControl.persistence.service;

import com.TempControl.domain.dto.AlertDTO;
import com.TempControl.persistence.entity.Alert;
import com.TempControl.persistence.AlertRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class AlertService {

    private final AlertRepository alertRepository;
    private final AlertMapper alertMapper = AlertMapper.instance;

    public AlertService(AlertRepository alertRepository) {
        this.alertRepository = alertRepository;
    }

    public List<AlertDTO> getAllAlerts() {
        List<Alert> alerts = alertRepository.getAll();
        return alerts.stream()
                .map(alertMapper::alertToAlertDTO)
                .collect(Collectors.toList());
    }

    public AlertDTO getAlertById(Integer id) {
        Optional<Alert> alert = alertRepository.getAlertByID(id);
        return alert.map(alertMapper::alertToAlertDTO).orElse(null);
    }

    public AlertDTO createAlert(AlertDTO alertDTO) {
        Alert alert = alertMapper.alertDTOToAlert(alertDTO);
        Alert createdAlert = alertRepository.save(alert);
        return alertMapper.alertToAlertDTO(createdAlert);
    }

    public AlertDTO updateAlert(Integer id, AlertDTO alertDTO) {
        if (alertRepository.existsAlert(id)) {
            Alert alert = alertMapper.alertDTOToAlert(alertDTO);
            alert.setId(id);  // Ensure the ID is set for the update
            Alert updatedAlert = alertRepository.save(alert);
            return alertMapper.alertToAlertDTO(updatedAlert);
        }
        return null;
    }

    public boolean deleteAlert(Integer id) {
        if (alertRepository.existsAlert(id)) {
            alertRepository.delete(id);
            return true;
        }
        return false;
    }

    public long countAllAlerts() {
        return alertRepository.countAll();
    }
}
