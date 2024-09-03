package com.TempControl.persistence.crud;

import com.TempControl.persistence.entity.Device;
import org.springframework.data.repository.CrudRepository;

public interface DeviceCrudRepository extends CrudRepository<Device, Integer> {
}
