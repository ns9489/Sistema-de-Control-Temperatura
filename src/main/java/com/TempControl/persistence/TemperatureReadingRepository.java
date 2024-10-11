package com.TempControl.persistence;

import com.TempControl.persistence.crud.TemperatureReadingCrudRepository;
import com.TempControl.persistence.entity.TemperatureReading;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class TemperatureReadingRepository {
    private final TemperatureReadingCrudRepository temperatureReadingCrudRepository;

    public TemperatureReadingRepository(TemperatureReadingCrudRepository temperatureReadingCrudRepository) {
        this.temperatureReadingCrudRepository = temperatureReadingCrudRepository;
    }

    public List<TemperatureReading> getAll() {
        return (List<TemperatureReading>) temperatureReadingCrudRepository.findAll();
    }

    public Optional<TemperatureReading> getTemperatureReadingByID(int id) {
        return temperatureReadingCrudRepository.findById(id);
    }

    public TemperatureReading save(TemperatureReading temperatureReading) {
        return temperatureReadingCrudRepository.save(temperatureReading);
    }

    public void delete(int id) {
        temperatureReadingCrudRepository.deleteById(id);
    }

    public boolean existsTemperatureReading(int id) {
        return temperatureReadingCrudRepository.existsById(id);
    }

    public long countAll() {
        return temperatureReadingCrudRepository.count();
    }
}
