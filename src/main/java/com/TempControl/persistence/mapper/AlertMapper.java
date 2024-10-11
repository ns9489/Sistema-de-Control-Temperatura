package com.TempControl.persistence.mapper;

import com.TempControl.persistence.entity.Alert;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

import java.util.List;

@Mapper(componentModel = "spring")

public interface AlertMapper {

        @Mappings({
                @Mapping(source = "id", target = "alert_id"),
                @Mapping(source = "message", target = "message"),
                @Mapping(source = "creation_time", target = "creation_time"),
                @Mapping(source = "sensor", target = "sensor")
        })
        AlertDTO toAlertDTO(Alert alert);
    List<AlertDTO> toAlertDTOList(List<Alert> sensors);

    @InheritInverseConfiguration
    Alert toAlert(AlertDTO alertDTO);
    List<Alert> toAlert(List<AlertDTO> Alerts);
    }

