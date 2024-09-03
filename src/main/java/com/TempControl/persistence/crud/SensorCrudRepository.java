package com.TempControl.persistence.crud;

import com.TempControl.persistence.entity.Sensor;
import org.springframework.data.repository.CrudRepository;

public interface SensorCrudRepository extends CrudRepository<Sensor, Integer> {
}