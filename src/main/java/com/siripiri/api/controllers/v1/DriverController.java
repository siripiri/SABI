package com.siripiri.api.controllers.v1;

import com.siripiri.api.services.DriverService;
import com.siripiri.api.v1.model.DriverPersonalDTO;
import io.swagger.v3.oas.annotations.Operation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/drivers")
@Slf4j
public class DriverController {
    private final DriverService driverService;

    public DriverController(@Qualifier("driverService") DriverService driverService) {
        this.driverService = driverService;
    }

    @GetMapping(value = "/{name}", produces = "application/json")
    @ResponseStatus(HttpStatus.OK)
    @Operation(summary = "Get personal details of a driver by name")
    public DriverPersonalDTO getDriverPersonal(@PathVariable String name){
        log.debug(name);
        return driverService.getDriverPersonalByName(name);
    }

}
