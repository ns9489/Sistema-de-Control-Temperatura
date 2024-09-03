package com.TempControl.persistence.crud;


import com.TempControl.persistence.entity.TemperatureReading;
import org.springframework.data.repository.CrudRepository;

public interface TemperatureReadingCrudRepository extends CrudRepository<TemperatureReading, Integer> {
}