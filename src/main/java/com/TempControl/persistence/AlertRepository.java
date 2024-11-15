package com.TempControl.persistence;

import com.TempControl.domain.Repository.AlertDomainRepository;
import com.TempControl.domain.dto.AlertDTO;
import com.TempControl.persistence.crud.AlertCrudRepository;
import com.TempControl.persistence.entity.Alert;
import com.TempControl.persistence.mapper.AlertMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class AlertRepository implements AlertDomainRepository {
    @Autowired
    private AlertCrudRepository alertCrudRepository;

    @Autowired
    private AlertMapper alertMapper;

    @Override
    public AlertDTO save(AlertDTO alertDTO) {
        Alert alert = alertMapper.toAlert(alertDTO);
        return alertMapper.toAlertDTO(alertCrudRepository.save(alert));
    }

    @Override
    public Optional<AlertDTO> getAlertById(int id) {
        return alertCrudRepository.findById(id).map(alertMapper::toAlertDTO);
    }

    @Override
    public boolean existsAlertById(int id) {
        return alertCrudRepository.existsById(id);
    }

    @Override
    public List<AlertDTO> getAll() {
        List<Alert> alerts = (List<Alert>) alertCrudRepository.findAll();
        return alertMapper.toAlertDTOList(alerts);
    }

    @Override
    public long countAll() {
        return alertCrudRepository.count();
    }

    public void deleteById(int id) {
        alertCrudRepository.deleteById(id);
    }
}