package com.TempControl.persistence.crud;

import com.TempControl.persistence.entity.Alert;
import org.springframework.data.repository.CrudRepository;

public interface AlertCrudRepository extends CrudRepository<Alert, Integer> {
}