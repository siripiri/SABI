package com.siripiri.api.v1.mapper;

import com.siripiri.api.domain.Driver;
import com.siripiri.api.v1.model.DriverPersonalDTO;
import com.siripiri.api.v1.model.PhoneNumberDTO;
import org.springframework.stereotype.Component;

@Component
public class DriverMapperImpl implements DriverMapper{
    @Override
    public DriverPersonalDTO driverToDriverPersonalDTO(Driver driver) {

        if(driver == null){
            return null;
        }

        DriverPersonalDTO driverPersonalDTO = new DriverPersonalDTO();
        driverPersonalDTO.setId(driver.getId());
        driverPersonalDTO.setAge(driver.getAge());
        driverPersonalDTO.setAddress(driver.getAddress());
        driverPersonalDTO.setChildrenDetails(driver.getChildrenDetails());
        driverPersonalDTO.setName(driver.getName());

        if(driver.getPhoneNumber() == null){
            driverPersonalDTO.setPhoneNumber(null);
            return driverPersonalDTO;
        }
        PhoneNumberDTO phoneNumberDTO = new PhoneNumberDTO();
        phoneNumberDTO.setId(driver.getPhoneNumber().getId());
        phoneNumberDTO.setPersonal(driver.getPhoneNumber().getPersonal());
        phoneNumberDTO.setOffice(driver.getPhoneNumber().getOffice());
        phoneNumberDTO.setHouse(driver.getPhoneNumber().getHouse());

        driverPersonalDTO.setPhoneNumber(phoneNumberDTO);

        return driverPersonalDTO;
    }
}
