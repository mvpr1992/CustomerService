package com.ucm.customerService.service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import com.ucm.customerService.model.entity.Admin;
import com.ucm.customerService.model.entity.CreditCard;
import com.ucm.customerService.model.entity.CreditCardTransaction;
import com.ucm.customerService.model.entity.Customer;
import com.ucm.customerService.model.entity.Manager;
import com.ucm.customerService.model.entity.Payee;
import com.ucm.customerService.model.entity.RoutingNumbers;
import com.ucm.customerService.model.entity.UserSignup;

public interface CustomerService {
	
	public UserSignup usersignup(UserSignup user) throws Exception;
	
    public Customer addCustomer(Customer customer) throws Exception;
    
    public Optional<Customer> findbyCustomerId(int customerId) throws Exception;   
    
    public Customer findbyUserId(String userId) throws Exception;
    
    public Customer login(String userId,String password) throws Exception;
    
    public Manager managerlogin(String userId,String password) throws Exception;
    
    public Admin adminlogin(String userId,String password) throws Exception;
    
    public Customer updateUserInfo(Customer customer) throws Exception;
    
    public CreditCard applyforcreditcard(CreditCard creditcard) throws Exception;
    
    public CreditCard getcreditcardstatus(int customerId) throws Exception;
    
    public List<Customer> usersearch(String firstName, int managerId) throws Exception;
    
    public List<Customer> usersearchformanagerupdate(String firstName) throws Exception;
    
    public void addroutingnumber(RoutingNumbers routingnumber) throws Exception;
    
    public void schedulebillpayment(int customerId,String routingnumber,String amount, Date scheduledate) throws Exception;
    
    public void processscheduledpayments(int managerId) throws Exception;
    
    public List<CreditCard> getPendingcreditcardapplications(int managerId) throws Exception;
    
    public List<UserSignup> getpendingusersignups() throws Exception;
    
    public List<Manager> getmanagerlist() throws Exception;
    
    public void approvecreditcard(CreditCard cred, CreditCardTransaction credtran) throws Exception;
    
    public List<Integer> findaddedcustomeridlist(int customerId) throws Exception;
    
    public List<Customer> findmanagedcustomerlist(List<Integer> customerlist) throws Exception;
    
    public List<Customer> findnonmanagedcustomerlist(List<Integer> customerlist) throws Exception;
    
    public void addpayee(Payee payee) throws Exception;
    
    public CreditCardTransaction creditcardtransaction(CreditCardTransaction cctran) throws Exception;
    
    public List<RoutingNumbers> findutilitylist(int customerId) throws Exception;
  
    public CreditCardTransaction findCreditCardTransaction(int customerId) throws Exception;
    
    public void creditcardbillpayment(int customerId, double amount, String email) throws Exception;
    
    public List<CreditCard> iscreditcardApproved(int customerId) throws Exception;
}