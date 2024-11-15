package com.TempControl.persistence.mapper;

import com.TempControl.domain.dto.AlertDTO;
import com.TempControl.persistence.entity.Alert;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

import java.util.List;

@Mapper(componentModel = "spring", uses = {SensorMapper.class, DeviceMapper.class})

public interface AlertMapper {

        @Mappings({
                @Mapping(source = "id", target = "id"),
                @Mapping(source = "message", target = "message"),
                @Mapping(source = "creationTime", target = "creation_time"),
                @Mapping(source = "sensor", target = "sensor"),
                @Mapping(source = "device", target = "device")
        })
        AlertDTO toAlertDTO(Alert alert);
    List<AlertDTO> toAlertDTOList(List<Alert> sensors);

    @InheritInverseConfiguration
    Alert toAlert(AlertDTO alertDTO);
    List<Alert> toAlert(List<AlertDTO> Alerts);
    }

