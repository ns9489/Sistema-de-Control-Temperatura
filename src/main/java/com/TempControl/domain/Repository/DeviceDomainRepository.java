package com.TempControl.domain.Repository;

import com.TempControl.domain.dto.DeviceDTO;

import java.util.List;
import java.util.Optional;

public interface DeviceDomainRepository {
    DeviceDTO save(DeviceDTO alertDTO);
    Optional<DeviceDTO> getDeviceById(int id);
    boolean existsDeviceByI(int id);
    List<DeviceDTO> getAll();
    long countAll();
    void deleteById(int id);
}
