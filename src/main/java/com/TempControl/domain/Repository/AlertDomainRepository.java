package com.TempControl.domain.Repository;

import com.TempControl.domain.dto.AlertDTO;

import java.util.List;
import java.util.Optional;

public interface AlertDomainRepository {
    AlertDTO save(AlertDTO alertDTO);
    Optional <AlertDTO> getAlertById(int id);
    boolean existsAlertById(int id);
    List<AlertDTO>getAll();
    long countAll();
    void deleteById(int id);
}
