package com.TempControl.persistence.mapper;

import com.TempControl.domain.dto.DeviceDTO;
import com.TempControl.persistence.entity.Device;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

import java.util.List;

@Mapper(componentModel = "spring")
public interface DeviceMapper {

        @Mappings({
                @Mapping(source = "id", target = "id"),
                @Mapping(source = "nameDevice", target = "deviceName"),
                @Mapping(source = "location", target = "location"),

        })
        DeviceDTO toDeviceDTO(Device device);
        List<DeviceDTO> toDeviceDTOList(List< Device> devices);

        @InheritInverseConfiguration
        @Mapping(target = "sensors", ignore = true)
        Device toDevice(DeviceDTO deviceDTO);
    }

