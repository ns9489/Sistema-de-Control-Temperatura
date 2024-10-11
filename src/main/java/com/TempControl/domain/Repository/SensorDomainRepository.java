package com.TempControl.domain.Repository;

import com.TempControl.domain.dto.SensorDTO;


import java.util.List;
import java.util.Optional;

public interface SensorDomainRepository {
    SensorDTO save(SensorDTO sensorDTO);
    Optional<SensorDTO> getSensorById(int id);
    boolean existsSensorByI(int id);
    List<SensorDTO> getAll();
    long countAll();
    void deleteById(int id);
}
