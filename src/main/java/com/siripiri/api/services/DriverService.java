package com.siripiri.api.services;

import com.siripiri.api.domain.Driver;
import com.siripiri.api.v1.model.DriverPersonalDTO;

public interface DriverService {
    DriverPersonalDTO getDriverPersonalByName(String name);
}
