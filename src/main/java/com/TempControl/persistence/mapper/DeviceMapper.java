package com.TempControl.persistence.mapper;

import com.TempControl.domain.dto.DeviceDTO;
import com.TempControl.domain.dto.SensorDTO;
import com.TempControl.persistence.entity.Device;
import com.TempControl.persistence.entity.Sensor;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

import java.util.List;

@Mapper(componentModel = "spring")
public interface DeviceMapper {


        @Mappings({
                @Mapping(source = "id", target = "device_id"),
                @Mapping(source = "nameDevice", target = "device_name"),
                @Mapping(source = "location", target = "location"),

        })
        DeviceDTO toSensorDTO(Device Device);
        List< DeviceDTO> toDeviceDTOList(List< Device>  Devices);

        @InheritInverseConfiguration
        @Mapping(target = "alerts", ignore = true)
        @Mapping(target = "temperatureReadings", ignore = true)
        Sensor toSensor(SensorDTO sensorDTO);
    }

