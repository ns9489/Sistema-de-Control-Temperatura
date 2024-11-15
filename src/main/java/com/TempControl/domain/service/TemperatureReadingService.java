package com.TempControl.domain.service;


import com.TempControl.domain.Repository.TemperatureReadingDomainRepository;
import com.TempControl.domain.dto.TemperatureReadingDTO;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Optional;

public class TemperatureReadingService {
    @Autowired
    private TemperatureReadingDomainRepository temperatureReadingDomainRepository;

    public TemperatureReadingDTO save(TemperatureReadingDTO temperatureReadingDTO){
        return temperatureReadingDomainRepository.save(temperatureReadingDTO);
    }

    public Optional<TemperatureReadingDTO> getTemperatureReadingById(int id){
        return temperatureReadingDomainRepository.getTemperatureReadingById(id);
    }

    public boolean existsTemperatureReadingById(int id){
        return temperatureReadingDomainRepository.existsTemperatureReadingById(id);
    }

    public List<TemperatureReadingDTO> getAll() {
        return temperatureReadingDomainRepository.getAll();
    }

    public long countAll() {
        return temperatureReadingDomainRepository.countAll();
    }

    public boolean deleteTemperatureReadingById(int id) {
        return getTemperatureReadingById(id).map(temperatureReadingDTO -> {
            temperatureReadingDomainRepository.deleteById(id);
            return true;
        }).orElse(false);
    }
}