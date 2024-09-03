package com.TempControl.persistence.Repository;

import com.TempControl.persistence.crud.DeviceCrudRepository;
import com.TempControl.persistence.entity.Device;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class DeviceRepository {
    private final DeviceCrudRepository deviceCrudRepository;

    public DeviceRepository(DeviceCrudRepository deviceCrudRepository) {
        this.deviceCrudRepository = deviceCrudRepository;
    }

    public List<Device> getAll() {
        return (List<Device>) deviceCrudRepository.findAll();
    }

    public Optional<Device> getDeviceByID(int id) {
        return deviceCrudRepository.findById(id);
    }

    public Device save(Device device) {
        return deviceCrudRepository.save(device);
    }

    public void delete(int id) {
        deviceCrudRepository.deleteById(id);
    }

    public boolean existsDevice(int id) {
        return deviceCrudRepository.existsById(id);
    }

    public long countAll() {
        return deviceCrudRepository.count();
    }
}