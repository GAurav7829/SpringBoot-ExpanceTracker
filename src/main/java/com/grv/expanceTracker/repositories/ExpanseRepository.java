package com.grv.expanceTracker.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.grv.expanceTracker.model.Expense;

@Repository
public interface ExpanseRepository extends JpaRepository<Expense, Long> {

}
