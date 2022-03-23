package com.grv.expanceTracker.services;

import java.util.List;

import com.grv.expanceTracker.model.Expense;

public interface ExpenseService {
	List<Expense> findAll();
	void save(Expense expense);
	Expense findById(Long id);
	void delete(Long id);
}
