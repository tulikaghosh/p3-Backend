package com.project3.revtech.controller;

import java.util.List;
import java.util.ArrayList;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.project3.revtech.pojo.TransactionPojo;
import com.project3.revtech.service.TransactionService;


@RestController
@RequestMapping("api")
public class TransactionController {

	@Autowired
	TransactionService TSI;
	
	@GetMapping("transaction")
	public List<TransactionPojo> getAllTransactions() {
		return TSI.getAllTransactions();
	}
	
	@GetMapping("transaction/{tid}")
	public TransactionPojo getTransactionById(@PathVariable int transactionId) {
		return TSI.getTransactionById(transactionId);
	}
	
	@GetMapping("transaction/cart/{cid}")
	public List<TransactionPojo> getCartTransactions(@PathVariable int cartId) {
		return TSI.findAllTransactionsInCart(cartId);
	}
	
	@PostMapping("transaction")
	public TransactionPojo createTransaction(@Valid @RequestBody TransactionPojo tp) {
		return TSI.createTransaction(tp);
	}
	
	@PutMapping("transaction")
	public TransactionPojo UpdateTransaction(@Valid @RequestBody TransactionPojo tp) {
		return TSI.updateTransaction(tp);
	}
	
	@DeleteMapping("transaction")
	public TransactionPojo deleteTransaction(@Valid @RequestBody TransactionPojo tp) {
		return TSI.deleteTransaction(tp);
	}
	
}
