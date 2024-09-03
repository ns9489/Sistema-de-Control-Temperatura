package com.TempControl.persistence.Repository;

import com.TempControl.persistence.crud.SensorCrudRepository;
import com.TempControl.persistence.entity.Sensor;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class SensorRepository {
    private final SensorCrudRepository sensorCrudRepository;

    public SensorRepository(SensorCrudRepository sensorCrudRepository) {
        this.sensorCrudRepository = sensorCrudRepository;
    }

    public List<Sensor> getAll() {
        return (List<Sensor>) sensorCrudRepository.findAll();
    }

    public Optional<Sensor> getSensorByID(int id) {
        return sensorCrudRepository.findById(id);
    }

    public Sensor save(Sensor sensor) {
        return sensorCrudRepository.save(sensor);
    }

    public void delete(int id) {
        sensorCrudRepository.deleteById(id);
    }

    public boolean existsSensor(int id) {
        return sensorCrudRepository.existsById(id);
    }

    public long countAll() {
        return sensorCrudRepository.count();
    }
}
