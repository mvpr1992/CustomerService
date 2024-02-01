package com.ucm.customerService.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Optional;
import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ucm.customerService.model.entity.Admin;
import com.ucm.customerService.model.entity.BillPayment;
import com.ucm.customerService.model.entity.CreditCard;
import com.ucm.customerService.model.entity.CreditCardTransaction;
import com.ucm.customerService.model.entity.Customer;
import com.ucm.customerService.model.entity.Manager;
import com.ucm.customerService.model.entity.Payee;
import com.ucm.customerService.model.entity.RoutingNumbers;
import com.ucm.customerService.model.entity.Transaction;
import com.ucm.customerService.model.entity.UserSignup;
import com.ucm.customerService.proxy.TransactionProxy;
import com.ucm.customerService.repository.AdminRepo;
import com.ucm.customerService.repository.BillPaymentRepo;
import com.ucm.customerService.repository.CreditCardRepo;
import com.ucm.customerService.repository.CreditCardTransactionRepo;
import com.ucm.customerService.repository.ManagerRepo;
import com.ucm.customerService.repository.PayeeRepo;
import com.ucm.customerService.repository.RoutingNumberRepo;
import com.ucm.customerService.repository.TransactionRepo;
import com.ucm.customerService.repository.UserRepo;
import com.ucm.customerService.repository.UserSignUpRepo;


@Service("customerService")
public class CustomerServiceImpl implements CustomerService {

	protected static final Logger logger = Logger.getLogger(CustomerServiceImpl.class.getName());
    private UserRepo userrepo;
    private CreditCardRepo creditrepo;
    private ManagerRepo managerrepo;
    private AdminRepo adminrepo;
    private RoutingNumberRepo routingrepo;
    private BillPaymentRepo billpaymentrepo;
    private TransactionProxy transactionproxy;
    private TransactionRepo transactionrepo;
    private UserSignUpRepo usersignuprepo;
    private PayeeRepo payeerepo;
    private EmailSenderService emailservice;
    private CreditCardTransactionRepo cctranrepo;

    @Autowired
    public CustomerServiceImpl(UserRepo userrepo, CreditCardRepo creditrepo, ManagerRepo managerrepo, 
    		AdminRepo adminrepo, RoutingNumberRepo routingrepo, BillPaymentRepo billpaymentrepo, TransactionProxy transactionproxy,
    		TransactionRepo transactionrepo,UserSignUpRepo usersignuprepo,PayeeRepo payeerepo, CreditCardTransactionRepo cctranrepo,
    		EmailSenderService emailservice) {   
        this.userrepo = userrepo;
        this.creditrepo = creditrepo;
        this.managerrepo = managerrepo;
        this.adminrepo = adminrepo;
        this.routingrepo = routingrepo;
        this.billpaymentrepo = billpaymentrepo;
        this.transactionproxy = transactionproxy;
        this.transactionrepo = transactionrepo;
        this.usersignuprepo = usersignuprepo;
        this.payeerepo = payeerepo;
        this.cctranrepo = cctranrepo;
        this.emailservice = emailservice;
    }
    
    @Override
    public UserSignup usersignup(UserSignup user) throws Exception {
    	user.setStatus("P");
    	return usersignuprepo.save(user);
    }

    @Override
    public Customer addCustomer(Customer customer) throws Exception {
    	
    	UserSignup user = new UserSignup();
    	user.setCity(customer.getCity());
    	user.setCountry(customer.getCountry());
    	user.setCustomerId(customer.getCustomerId());
    	user.setEmail(customer.getEmail());
    	user.setFirstName(customer.getFirstName());
    	user.setLastName(customer.getLastName());
    	user.setMailingAddress(customer.getMailingAddress());
    	user.setMobile(customer.getMobile());
    	user.setPassword(customer.getPassword());
    	user.setStatus("V");
    	user.setUserId(customer.getUserId());
    	user.setZipCode(customer.getZipCode());
    	usersignuprepo.save(user);
    	return userrepo.save(customer);	
    }
    
    @Override
    public Customer updateUserInfo(Customer customer) throws Exception {
    	return userrepo.save(customer);
    }
    
    @Override
    public Optional<Customer> findbyCustomerId(int customerId) throws Exception {
    	 logger.info("In customer service : findbyCustomerId mehtod: customerId : " + customerId);
    	 return userrepo.findById(customerId);
    }
    
    @Override
    public Customer findbyUserId(String userId) throws Exception {
    	 logger.info("In customer service : findbyUserId method: userId : " + userId);
    	 return userrepo.findByUserId(userId);
    }
    
    @Override
    public Customer login(String userId,String password) throws Exception {
    	 logger.info("In customer service : login method: UserId : ");
    	 return userrepo.findByUserIdAndPassword(userId,password);
    }
    
    @Override
    public Manager managerlogin(String userId,String password) throws Exception {
    	 logger.info("In customer service : login method: UserId : ");
    	 return managerrepo.findByUserIdAndPassword(userId, password);
    }
    
    @Override
    public Admin adminlogin(String userId,String password) throws Exception {
    	 logger.info("In customer service : login method: UserId : ");
    	 return adminrepo.findByUserIdAndPassword(userId, password);
    }
    
    @Override
    public CreditCard applyforcreditcard(CreditCard creditcard) throws Exception {
    	 logger.info("In customer service : applyforcreditcard ");
    	 creditcard.setStatus("P");
    	 Date d = new Date();
    	 creditcard.setDate(d);
    	 return creditrepo.save(creditcard);
    }
    
    @Override
    public CreditCard getcreditcardstatus(int customerId) throws Exception {
    	 logger.info("In customer service : getcreditcardstatus mehtod: customerId : " + customerId);
    	 return creditrepo.getcreditcardstatus(customerId);
    }
    
    @Override
    public List<Customer> usersearch(String firstName, int managerId) throws Exception {
    	 logger.info("In customer service : usersearch method: firstName : " + firstName);
    	 return userrepo.findUserByFirstNameAndManagerId(firstName,managerId);
    }
    
    @Override
    public List<Customer> usersearchformanagerupdate(String firstName) throws Exception {
    	 logger.info("In customer service : usersearch method: firstName : " + firstName);
    	 return userrepo.findUserByFirstName(firstName);
    }
    
    @Override
    public void addroutingnumber(RoutingNumbers routingnumber) throws Exception {
    	 logger.info("In customer service : applyforcreditcard ");
    	 routingrepo.save(routingnumber);
    }
    
    @Override
    public void schedulebillpayment(int customerId,String routingnumber,String amount, Date scheduledate) throws Exception {
    	 logger.info("In customer service : applyforcreditcard ");
    	 
    	 BillPayment b = new BillPayment();
    	 
    	 b.setCustomerId(customerId);
    	 b.setAmount(Double.parseDouble(amount));
    	 b.setStatus("P");
    	 b.setRoutingNumber(routingnumber);
    	 Date d = new Date();
    	 b.setDateOfTransaction(d);
    	 b.setScheduledDate(scheduledate);
    	 
    	 billpaymentrepo.save(b);
    }
    
    @Override
    public void processscheduledpayments(int managerId) throws Exception {
    	 logger.info("In customer service : processscheduledpayments() ");
    	 
    	 List<BillPayment> billpayments = new ArrayList<BillPayment>();
    	 List<Integer> customerlistformanagerId = new ArrayList<Integer>();
    	 
    	 billpayments = billpaymentrepo.getPendingBillPayments();
    	 customerlistformanagerId = userrepo.getcustomerlistformanagerId(managerId);
    	 
    	 System.out.print("billpayments size: " + billpayments.size());
    	 
    	 List<Integer> customerList = new ArrayList<>();
    	 List<BillPayment> billpaymentsformanagerId = new ArrayList<BillPayment>();
    	 
    	 for(int i=0;i<billpayments.size();i++) {
    		 if(customerlistformanagerId.contains(billpayments.get(i).getCustomerId())) {
    			 billpaymentsformanagerId.add(billpayments.get(i));
    			 customerList.add(billpayments.get(i).getCustomerId());
    		 }	 
    	 }
    	 
    	 List<Transaction> transactionlist =  transactionproxy.getTransactionList(customerList);
    	 
    	 List<Customer> customerlist =  findmanagedcustomerlist(customerList);
    	 HashMap<Integer, Transaction> map = new HashMap<>();
    	 List<Transaction> newtransactionlist = new ArrayList<>();
    	 
    	 HashMap<Integer, Customer> customermap = new HashMap<>();
    	 
    	 for (Transaction t:transactionlist) {
    		 map.put(t.getCustomerId(), t);
    	 }
    	 
    	 for (Customer t:customerlist) {
    		 customermap.put(t.getCustomerId(), t);
    	 }
    	 
    	 
    	 for(int i=0;i<billpaymentsformanagerId.size();i++) {
    			if(billpaymentsformanagerId.get(i).getAmount() <= map.get(billpaymentsformanagerId.get(i).getCustomerId()).getAccountBalance()) {
    				billpaymentsformanagerId.get(i).setStatus("V");
    				Transaction tran = new Transaction();
    				tran.setCustomerId(billpaymentsformanagerId.get(i).getCustomerId());
    				tran.setAccountBalance(map.get(billpaymentsformanagerId.get(i).getCustomerId()).getAccountBalance()-billpaymentsformanagerId.get(i).getAmount());
    				tran.setTransactiontype("BILLPAY");
    				tran.setAmount(billpaymentsformanagerId.get(i).getAmount());
    				Date d = new Date();
    				tran.setDateofTransaction(d);
    				
    				Transaction tr = map.get(billpaymentsformanagerId.get(i).getCustomerId());
    				tr.setAccountBalance(tran.getAccountBalance());
    				map.put(billpaymentsformanagerId.get(i).getCustomerId(), tr);
    				
    				emailservice.sendEmail(customermap.get(billpaymentsformanagerId.get(i).getCustomerId()).getEmail(), 
    						" Your Payment of $" + billpaymentsformanagerId.get(i).getAmount() + " for utility payment with routing number: " + billpaymentsformanagerId.get(i).getRoutingNumber()
	    					+ "is Success.",
	    					"Your Payment of $" + billpaymentsformanagerId.get(i).getAmount() + "is success.");
    				newtransactionlist.add(tran);	
    			} else {
    				billpaymentsformanagerId.get(i).setStatus("R");
    				emailservice.sendEmail(customermap.get(billpaymentsformanagerId.get(i).getCustomerId()).getEmail(), 
    						" Your Payment of $" + billpaymentsformanagerId.get(i).getAmount() + " for utility payment with routing number: " + billpaymentsformanagerId.get(i).getRoutingNumber()
	    					+ "is failure because of Insufficient funds.",
	    					"Your Payment of $" + billpaymentsformanagerId.get(i).getAmount() + "is failure.");
    			}
    	 }
    	 
    	 billpaymentrepo.saveAll(billpaymentsformanagerId);
    	 transactionrepo.saveAll(newtransactionlist); 
    }   
    
    @Override
    public List<CreditCard> getPendingcreditcardapplications(int managerId) throws Exception {
    	 logger.info("In customer service : getPendingcreditcardapplications ");
    	 return creditrepo.findByManagerIdAndStatus(managerId,"P");
    }
    
    @Override
    public List<UserSignup> getpendingusersignups() throws Exception {
    	 logger.info("In customer service : getpendingusersignups ");
    	 return usersignuprepo.findByStatus("P");
    }
    
    @Override
    public List<Manager> getmanagerlist() throws Exception {
    	 logger.info("In customer service : getmanagerlist ");
    	 return managerrepo.findAll();
    }
    
    @Override
    public void approvecreditcard(CreditCard cred, CreditCardTransaction credtran) throws Exception {
    	 logger.info("In customer service : approvecreditcard ");
    	 creditrepo.save(cred);
    	 cctranrepo.save(credtran);
    	 Optional<Customer> customer = userrepo.findById(cred.getCustomerId());
    	 emailservice.sendEmail(customer.get().getEmail(), " Your Credit Card is approved with a limit of $" +  cred.getMax_limit(),
					" Your Credit Card is approved with a limit of $" +  cred.getMax_limit());
    }
    
    @Override
    public List<Integer> findaddedcustomeridlist(int customerId) throws Exception {
    	 logger.info("In customer service : findaddedcustomeridlist ");
    	 return payeerepo.findaddedcustomeridlist(customerId);
    }
    
    @Override
    public List<Customer> findmanagedcustomerlist(List<Integer> customerlist) throws Exception {
    	 logger.info("In customer service : findmanagedcustomerlist ");
    	 return userrepo.findAllById(customerlist);
    }
  
    @Override
    public List<Customer> findnonmanagedcustomerlist(List<Integer> customerlist) throws Exception {
    	 logger.info("In customer service : findnonmanagedcustomerlist ");
    	 return userrepo.findnonmanagedcustomerlist(customerlist);
    }
    
    @Override
    public void addpayee(Payee payee) throws Exception {
    	logger.info("In customer service : addpayee ");
   	 	payeerepo.save(payee);
   }
    
    @Override
    public CreditCardTransaction creditcardtransaction(CreditCardTransaction cctran) throws Exception {
    	logger.info("In customer service : creditcardtransaction ");
    	CreditCardTransaction t = null;
        try {

	       double availablelimit = 0;
	        
	       t = cctranrepo.findmaxTransactionUserbyCustomerId(cctran.getCustomerId());
	       Optional<Customer> customer = userrepo.findById(cctran.getCustomerId());
	    	 
	        if(t != null) {
	        	availablelimit = t.getAvailablelimit();
	        } 
	        
	        if(availablelimit > cctran.getAmount()) {
	    			
	    		cctran.setAvailablelimit(availablelimit-cctran.getAmount());
	    		Date d = new Date();
	    		cctran.setDate(d);
	    			
	    		t = cctranrepo.save(cctran);
	    			
	    		emailservice.sendEmail(customer.get().getEmail(), " You made a purchase of $" + cctran.getAmount() + " on your Credit Card",
	    				" You made a purchase of $" + cctran.getAmount() + " on your Credit Card and available limit is $" + t.getAvailablelimit());
	    			
	        }  else { 
	        	t.setMessage("Insufficinet Funds");
	        	emailservice.sendEmail(customer.get().getEmail(), " Your purchase of $" + cctran.getAmount() + " has been declined on insufficient available limit",
	        			" Your purchase of $" + cctran.getAmount() + " has been declined on insufficient available limit which is $" + t.getAvailablelimit());
	        }
	        } catch (Exception e) {
	        	e.printStackTrace();
        }  	
        return t;
    }
 
    @Override
    public List<RoutingNumbers> findutilitylist(int customerId) throws Exception {
        logger.info("In customer service : findmanagedcustomerlist ");
        return routingrepo.findByCustomerId(customerId);
    }
    
    @Override
    public CreditCardTransaction findCreditCardTransaction(int customerId) throws Exception {
        logger.info("In customer service : findmanagedcustomerlist ");
        return cctranrepo.findmaxTransactionUserbyCustomerId(customerId);
    }
    
    @Override
    public void creditcardbillpayment(int customerId, double amount, String email) throws Exception {
    	logger.info("In customer service : creditcardbillpayment method: customerId : ");
        Transaction transaction = new Transaction();
        CreditCardTransaction cctransaction = new CreditCardTransaction();
        CreditCardTransaction cctran = null;
        
        try {
			transaction = transactionproxy.getTransaction(customerId);
	        cctran = cctranrepo.findmaxTransactionUserbyCustomerId(customerId);   
        } catch (Exception e) {
        	e.printStackTrace();
        }
	        
	    if(transaction.getAccountBalance() > amount) {
	        	
	        	transaction.setCustomerId(customerId);
    			transaction.setTransactiontype("CCBILLPAY");
    			transaction.setAmount(amount);
    			transaction.setAccountBalance(transaction.getAccountBalance()-amount);
    			Date d = new Date();
    			transaction.setDateofTransaction(d);
    			transactionrepo.save(transaction);
    			
    			cctransaction.setCustomerId(customerId);
    			cctransaction.setDescription("CC BILL Payment");
    			cctransaction.setAmount(amount);
    			cctransaction.setAvailablelimit(cctran.getAvailablelimit()+amount);
    			cctransaction.setDate(d);
    			cctranrepo.save(cctransaction);		
    			
    			double updatedavailablelimit = cctran.getAvailablelimit()+amount;

	    		emailservice.sendEmail(email, "Your Credit Card bill payment is success",
	    				"Your Credit Card Bill Payment of $" + amount + " has been processed and your "
	    				+ "updated available limit is $" + updatedavailablelimit);
	     }  else {
	        	emailservice.sendEmail(email, "Your Credit Card bill payment is declined due to insufficient funds",
	        			"Your Credit Card bill payment is declined due to insufficient funds");
	    }        
    }
    
    public List<CreditCard> iscreditcardApproved(int customerId) throws Exception {
    	
    	return creditrepo.isccApproved(customerId);
    }

}