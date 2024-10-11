package com.TempControl.persistence.mapper;

import com.TempControl.domain.dto.SensorDTO;
import com.TempControl.persistence.entity.Sensor;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

import java.util.List;

    @Mapper(componentModel = "spring")
    public interface SensorMapper {
        @Mappings({
                @Mapping(source = "id", target = "sensorID"),
                @Mapping(source = "model", target = "model"),
                @Mapping(source = "type", target = "type"),
                @Mapping(source = "device", target = "device")
        })
        SensorDTO toSensorDTO(Sensor sensor);
        List<SensorDTO> toSensorDTOList(List<Sensor> sensors);

        @InheritInverseConfiguration
        @Mapping(target = "alerts", ignore = true)
        @Mapping(target = "temperatureReadings", ignore = true)
        Sensor toSensor(SensorDTO sensorDTO);
    }

