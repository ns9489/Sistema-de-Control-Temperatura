package com.TempControl.persistence.mapper;

import com.TempControl.domain.dto.TemperatureReadingDTO;
import com.TempControl.persistence.entity.TemperatureReading;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

import java.util.List;

    @Mapper(componentModel = "spring")
    public interface TemperatureReadingMapper {
        @Mappings({
                @Mapping(source = "id", target = "reading_id"),
                @Mapping(source = "temperature", target = "temperature"),
                @Mapping(source = "readingTime", target = "reading_time"),
                @Mapping(source = "sensor", target = "sensor")
        })
        TemperatureReadingDTO toTemperatureReadingDTO(TemperatureReading temperatureReading);
        List<TemperatureReadingDTO> toTemperatureReadingDTOList(List<TemperatureReading> sensors);

        @InheritInverseConfiguration
        TemperatureReading toTemperatureReading(TemperatureReadingDTO temperatureReadingDTO);
            List<TemperatureReading> toTemperatureReading(List<TemperatureReadingDTO> TemperatureReadings);
    }

