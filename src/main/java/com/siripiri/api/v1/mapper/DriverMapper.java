package com.siripiri.api.v1.mapper;

import com.siripiri.api.domain.Driver;
import com.siripiri.api.v1.model.DriverPersonalDTO;

public interface DriverMapper {
    DriverPersonalDTO driverToDriverPersonalDTO(Driver driver);
}
