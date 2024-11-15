package com.TempControl.domain.service;

import com.TempControl.domain.Repository.DeviceDomainRepository;
import com.TempControl.domain.dto.DeviceDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DeviceService {

    @Autowired
    private DeviceDomainRepository deviceDomainRepository;

    public DeviceDTO save(DeviceDTO deviceDTO){
        return deviceDomainRepository.save(deviceDTO);
    }

    public Optional<DeviceDTO> getDeviceById(int id){
        return deviceDomainRepository.getDeviceById(id);
    }

    public boolean existsDeviceById(int id){
        return deviceDomainRepository.existsDeviceById(id);
    }

    public List<DeviceDTO> getAll() {
        return deviceDomainRepository.getAll();
    }

    public long countAll() {
        return deviceDomainRepository.countAll();
    }

    public boolean deleteDeviceById(int id) {
        return getDeviceById(id).map(deviceDTO -> {
            deviceDomainRepository.deleteById(id);
            return true;
        }).orElse(false);
    }
}