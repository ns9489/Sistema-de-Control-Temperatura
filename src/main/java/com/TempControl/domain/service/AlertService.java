package com.TempControl.domain.service;

import com.TempControl.domain.Repository.AlertDomainRepository;
import com.TempControl.domain.dto.AlertDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AlertService {

    @Autowired
    private AlertDomainRepository alertDomainRepository;

    public AlertDTO save(AlertDTO alertDTO){
        return alertDomainRepository.save(alertDTO);
    }

    public Optional<AlertDTO> getAlertById(int id) {
        return alertDomainRepository.getAlertById(id);
    }

    public boolean existsAlertById(int id){
        return alertDomainRepository.existsAlertById(id);
    }

    public List<AlertDTO> getAll() {
        return alertDomainRepository.getAll();
    }

    public long countAll() {
        return alertDomainRepository.countAll();
    }

    public boolean deleteAlertById(int id) {
        return getAlertById(id).map(alertDTO -> {
            alertDomainRepository.deleteById(id);
            return true;
        }).orElse(false);
    }
}