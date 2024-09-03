package com.TempControl.persistence.Repository;

import com.TempControl.persistence.crud.AlertCrudRepository;
import com.TempControl.persistence.entity.Alert;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class AlertRepository {
    private final AlertCrudRepository alertCrudRepository;

    public AlertRepository(AlertCrudRepository alertCrudRepository) {
        this.alertCrudRepository = alertCrudRepository;
    }

    public List<Alert> getAll() {
        return (List<Alert>) alertCrudRepository.findAll();
    }

    public Optional<Alert> getAlertByID(int id) {
        return alertCrudRepository.findById(id);
    }

    public Alert save(Alert alert) {
        return alertCrudRepository.save(alert);
    }


    public void delete(int id) {
        alertCrudRepository.deleteById(id);
    }

    public boolean existsAlert(int id) {
        return alertCrudRepository.existsById(id);
    }


    public long countAll() {
        return alertCrudRepository.count();
    }
}
