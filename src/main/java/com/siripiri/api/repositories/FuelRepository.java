package com.siripiri.api.repositories;

import com.siripiri.api.domain.Fuel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FuelRepository extends JpaRepository<Fuel, Long> {
}
