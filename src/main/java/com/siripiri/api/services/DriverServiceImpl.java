package com.siripiri.api.services;

import com.siripiri.api.repositories.DriverRepository;
import com.siripiri.api.v1.mapper.DriverMapper;
import com.siripiri.api.v1.model.DriverPersonalDTO;
import org.springframework.stereotype.Service;

@Service("driverService")
public class DriverServiceImpl implements DriverService{
    private final DriverRepository driverRepository;
    private final DriverMapper driverMapper;

    public DriverServiceImpl(DriverRepository driverRepository, DriverMapper driverMapper) {
        this.driverRepository = driverRepository;
        this.driverMapper = driverMapper;
    }

    @Override
    public DriverPersonalDTO getDriverPersonalByName(String name) {
        return driverRepository.findByName(name)
                .map(driverMapper::driverToDriverPersonalDTO)
                .map(driverPersonalDTO -> {
                    driverPersonalDTO.setUrl("/api/v1/drivers/" + driverPersonalDTO.getId());
                    return driverPersonalDTO;
                }).orElseThrow(ResourceNotFoundException::new);
    }
}
