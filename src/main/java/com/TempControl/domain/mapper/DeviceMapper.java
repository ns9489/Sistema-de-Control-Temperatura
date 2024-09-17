package com.TempControl.persistence.mapper;

import com.TempControl.domain.dto.DeviceDTO;
import com.TempControl.persistence.entity.Device;
import org.springframework.stereotype.Component;

@Component
public class DeviceMapper {

    // Convierte Device a DeviceDTO
    public DeviceDTO deviceToDeviceDTO(Device device) {
        if (device == null) {
            return null;
        }

        DeviceDTO deviceDTO = new DeviceDTO();
        deviceDTO.setId(device.getId());
        deviceDTO.setNameDevice(device.getNameDevice());
        deviceDTO.setLocation(device.getLocation());
        deviceDTO.setDevice(device.getDevice());

        return deviceDTO;
    }

    // Convierte DeviceDTO a Device
    public Device deviceDTOToDevice(DeviceDTO deviceDTO) {
        if (deviceDTO == null) {
            return null;
        }

        Device device = new Device();
        device.setId(deviceDTO.getId());
        device.setNameDevice(deviceDTO.getNameDevice());
        device.setLocation(deviceDTO.getLocation());
        device.setDevice(deviceDTO.getDevice());

        return device;
    }
}
