package com.ucm.customerService.proxy;

import java.util.Date;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name="reports-service")
public interface ReportsProxy {
	
	@GetMapping("/generateuserdatareport/{userId}")
	public void generateuserdatareport(@PathVariable String userId);
	
	@GetMapping("/alluserdatareportformanager/{managerId}")
	public void alluserdatareportformanager(@PathVariable int managerId);
	
	@GetMapping("/alluserdatareport")
	public void alluserdatareport();
	
	@GetMapping("/transactionstatementreport/{customerId}/{fromdate}/{todate}")
	public void transactionstatementreport(@PathVariable int customerId,@PathVariable Date fromdate,@PathVariable Date todate);
	
	@GetMapping("/creditcardstatementreport/{customerId}/{fromdate}/{todate}")
	public void creditcardstatementreport(@PathVariable int customerId,@PathVariable Date fromdate,@PathVariable Date todate);
	
}