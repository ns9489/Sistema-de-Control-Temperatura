package com.TempControl.domain.Repository;

import com.TempControl.domain.dto.DeviceDTO;
import com.TempControl.domain.dto.TemperatureReadingDTO;

import java.util.List;
import java.util.Optional;

public interface TemperatureDomainReadingRepository {
    TemperatureReadingDTO save (TemperatureReadingDTO temperatureReadingDTO);
    Optional<TemperatureReadingDTO> getTemperatureReadingById(int id);
    boolean existsTemperatureReadingByI(int id);
    List<TemperatureReadingDTO> getAll();
    long countAll();
    void deleteById(int id);
}
