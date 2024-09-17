package com.TempControl.persistence.service;

import com.TempControl.domain.dto.DeviceDTO;
import com.TempControl.persistence.entity.Device;
import com.TempControl.persistence.mapper.DeviceMapper;
import com.TempControl.persistence.Repository.DeviceRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class DeviceService {

    private final DeviceRepository deviceRepository;
    private final DeviceMapper deviceMapper;

    public DeviceService(DeviceRepository deviceRepository, DeviceMapper deviceMapper) {
        this.deviceRepository = deviceRepository;
        this.deviceMapper = deviceMapper;
    }

    public List<DeviceDTO> getAllDevices() {
        List<Device> devices = deviceRepository.getAll();
        return devices.stream()
                .map(deviceMapper::deviceToDeviceDTO)
                .collect(Collectors.toList());
    }

    public DeviceDTO getDeviceById(Integer id) {
        Optional<Device> device = deviceRepository.getDeviceByID(id);
        return device.map(deviceMapper::deviceToDeviceDTO).orElse(null);
    }

    public DeviceDTO createDevice(DeviceDTO deviceDTO) {
        Device device = deviceMapper.deviceDTOToDevice(deviceDTO);
        Device createdDevice = deviceRepository.save(device);
        return deviceMapper.deviceToDeviceDTO(createdDevice);
    }

    public DeviceDTO updateDevice(Integer id, DeviceDTO deviceDTO) {
        if (deviceRepository.existsDevice(id)) {
            Device device = deviceMapper.deviceDTOToDevice(deviceDTO);
            device.setId(id); // Ensure the ID is set for the update
            Device updatedDevice = deviceRepository.save(device);
            return deviceMapper.deviceToDeviceDTO(updatedDevice);
        }
        return null;
    }

    public boolean deleteDevice(Integer id) {
        if (deviceRepository.existsDevice(id)) {
            deviceRepository.delete(id);
            return true;
        }
        return false;
    }

    public long countAllDevices() {
        return deviceRepository.countAll();
    }
}
