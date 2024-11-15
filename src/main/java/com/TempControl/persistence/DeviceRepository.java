package com.TempControl.persistence;

import com.TempControl.domain.Repository.DeviceDomainRepository;
import com.TempControl.domain.dto.DeviceDTO;
import com.TempControl.persistence.entity.Device;
import com.TempControl.persistence.mapper.DeviceMapper;
import com.TempControl.persistence.crud.DeviceCrudRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class DeviceRepository implements DeviceDomainRepository {

    @Autowired
    private DeviceCrudRepository deviceCrudRepository;

    @Autowired
    private DeviceMapper deviceMapper;

    @Override
    public DeviceDTO save(DeviceDTO deviceDTO) {
        Device device = deviceMapper.toDevice(deviceDTO);
        return deviceMapper.toDeviceDTO(deviceCrudRepository.save(device));
    }

    @Override
    public Optional<DeviceDTO> getDeviceById(int id) {
        return deviceCrudRepository.findById(id).map(deviceMapper::toDeviceDTO);
    }


    @Override
    public boolean existsDeviceById(int id) {
        return deviceCrudRepository.existsById(id);
    }

    @Override
    public List<DeviceDTO> getAll() {
        List<Device> devices = (List<Device>) deviceCrudRepository.findAll();
        return deviceMapper.toDeviceDTOList(devices);
    }

    @Override
    public long countAll() {
        return deviceCrudRepository.count();
    }

    @Override
    public void deleteById(int id) {
        deviceCrudRepository.deleteById(id);
    }
}
