package com.grv.expanceTracker.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.grv.expanceTracker.model.Expense;
import com.grv.expanceTracker.services.ExpenseService;

@Controller
public class MasterController {
	
	@Autowired
	private ExpenseService expenseService;
	
	@RequestMapping("/")
	public String home(Model model) {
		model.addAttribute("message", "List of Expenses");
		model.addAttribute("expenses", expenseService.findAll());
		return "home";
	}
	
	@GetMapping("/expense")
	public String addExpense(Model model) {
		model.addAttribute("expense", new Expense());
		return "expense";
	}
	
	@PostMapping("/expense")
	public String saveExpense(Expense expense, Model model) {
		model.addAttribute("message", "List of Expenses");
		model.addAttribute("expenses", expenseService.findAll());
		expenseService.save(expense);
		return "redirect:/";
	}
	
	@GetMapping("/expense/{id}")
	public String editExpense(@PathVariable Long id, Model model) {
		model.addAttribute("expense", expenseService.findById(id));
		return "expense";
	}
	
	@GetMapping("/expense/{id}/delete")
	public String deleteExpense(@PathVariable Long id, Model model) {
		expenseService.delete(id);
		return "redirect:/";
	}
}
