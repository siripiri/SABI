package com.siripiri.api.repositories;

import com.siripiri.api.domain.Driver;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface DriverRepository extends JpaRepository<Driver, Long> {
    public Optional<Driver> findByName(String name);
}
