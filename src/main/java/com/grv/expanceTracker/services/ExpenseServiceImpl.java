package com.grv.expanceTracker.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.grv.expanceTracker.model.Expense;
import com.grv.expanceTracker.repositories.ExpanseRepository;

@Service
public class ExpenseServiceImpl implements ExpenseService {
	
	@Autowired
	private ExpanseRepository repository;
	
	@Override
	public List<Expense> findAll() {
		return repository.findAll();
	}

	@Override
	public void save(Expense expense) {
		expense.setCreatedAt(System.currentTimeMillis());
		repository.save(expense);
	}

	@Override
	public Expense findById(Long id) {
		if(repository.findById(id).isPresent())
			return repository.findById(id).get();
		return null;
	}

	@Override
	public void delete(Long id) {
		repository.deleteById(id);
	}

}
