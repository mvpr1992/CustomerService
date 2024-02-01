package com.ucm.customerService.proxy;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.ucm.customerService.model.entity.Transaction;

@FeignClient(name="transfer-service")
public interface TransactionProxy {
	
	@PostMapping("/add/{customerId}/{email}/{transactiontype}/{amount}")
	public Transaction addTransaction(@PathVariable("customerId") int customerId, @PathVariable("email") String email,
    		@PathVariable("transactiontype") String transactiontype, @PathVariable("amount") double amount);
	
	@GetMapping("/gettransaction/{customerId}")
	public Transaction getTransaction(@PathVariable("customerId") int customerId);
	
	@GetMapping("/gettransactionlist/{customerList}")
	public List<Transaction> getTransactionList(@PathVariable("customerList") List<Integer> customerList);
	
	@PostMapping("/savetransactionlist/{newtransactionlist}")
	public void savetransactionlist(@PathVariable("newtransactionlist") List<Transaction> newtransactionlist);
	
	@PostMapping("/transfer/{customerId}/{payeeId}/{amount}/{customeremail}/{payeeemail}")
	public Transaction transfertopayee(@PathVariable("customerId") int customerId,
    		@PathVariable("payeeId") int payeeId, @PathVariable("amount") double amount,
    		@PathVariable("customeremail") String customeremail, @PathVariable("payeeemail") String payeeemail);
	
}