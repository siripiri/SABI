package com.siripiri.api.repositories;

import com.siripiri.api.domain.Expenses;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ExpensesRepository extends JpaRepository<Expenses, Long> {
}
