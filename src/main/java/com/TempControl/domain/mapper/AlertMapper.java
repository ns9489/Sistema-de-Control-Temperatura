package com.TempControl.persistence.mapper;

import com.TempControl.domain.dto.AlertDTO;
import com.TempControl.persistence.entity.Alert;

public class AlertMapper {

    public AlertDTO alertToAlertDTO(Alert alert) {
        if (alert == null) {
            return null;
        }
        AlertDTO dto = new AlertDTO();
        dto.setId(alert.getId());
        dto.setMessage(alert.getMessage());
        dto.setCreationTime(alert.getCreationTime());
        dto.setLocation(alert.getLocation());
        dto.setDeviceId(alert.getDevice() != null ? alert.getDevice().getId() : null);
        dto.setSensorId(alert.getSensor() != null ? alert.getSensor().getId() : null);
        return dto;
    }

    public Alert alertDTOToAlert(AlertDTO alertDTO) {
        if (alertDTO == null) {
            return null;
        }
        Alert alert = new Alert();
        alert.setId(alertDTO.getId());
        alert.setMessage(alertDTO.getMessage());
        alert.setCreationTime(alertDTO.getCreationTime());
        alert.setLocation(alertDTO.getLocation());
        // Aquí debes asegurarte de establecer `device` y `sensor` basándote en IDs, si es necesario
        return alert;
    }
}
