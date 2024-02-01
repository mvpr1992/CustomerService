package com.ucm.customerService.controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.ucm.customerService.model.entity.Admin;
import com.ucm.customerService.model.entity.CreditCard;
import com.ucm.customerService.model.entity.CreditCardTransaction;
import com.ucm.customerService.model.entity.Customer;
import com.ucm.customerService.model.entity.Manager;
import com.ucm.customerService.model.entity.Payee;
import com.ucm.customerService.model.entity.RoutingNumbers;
import com.ucm.customerService.model.entity.Transaction;
import com.ucm.customerService.model.entity.UserSignup;
import com.ucm.customerService.proxy.ReportsProxy;
import com.ucm.customerService.proxy.TransactionProxy;
import com.ucm.customerService.service.CustomerService;
import com.ucm.customerService.service.EmailSenderService;


@Controller
public class CustomerController {

    
    protected static final Logger logger = Logger.getLogger(CustomerController.class.getName());
    protected CustomerService  customerService;
    protected EmailSenderService emailservice;
    
    @Autowired
    private ReportsProxy reportsproxy;
    
    @Autowired
    private TransactionProxy transactionproxy;

    
    @Autowired
    public CustomerController(CustomerService customerService, EmailSenderService emailservice) {
        this.customerService = customerService;
        this.emailservice = emailservice;
    }
    
    @GetMapping("/")
	public String home() {
		return "index";
	}
    
    @GetMapping("/login") 
	public String login() { 
		 return "login"; 
	 }
	  
	 @GetMapping("/signup")
	 public String signup() { 
		 return "signup"; 
	 }
	 
	 @GetMapping("/managerlogin")
	 public String managerlogin() { 
		 return "managerlogin"; 
	 }
	 
	 @GetMapping("/adminlogin")
	 public String adminlogin() { 
		 return "adminlogin"; 
	 }
	 
	 @GetMapping("/managepayees/{customerId}")
	 public String managepayees(@PathVariable("customerId") int customerId, Model model) { 
		 
		List<Customer> addpayeelist = null;
		List<Customer> managedpayeelist = null;
		List<Integer> managedcustomeridlist = new ArrayList<Integer>();
		Transaction transaction = null;
		
		try {
			managedcustomeridlist = customerService.findaddedcustomeridlist(customerId);
			managedpayeelist = customerService.findmanagedcustomerlist(managedcustomeridlist);
			managedcustomeridlist.add(customerId);
			addpayeelist = customerService.findnonmanagedcustomerlist(managedcustomeridlist);
			transaction = transactionproxy.getTransaction(customerId);	
			System.out.print("managedpayeelist size:" + managedpayeelist.size());
			System.out.print("addpayeelist size:" + addpayeelist.size());
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		model.addAttribute("managedpayeelist",managedpayeelist);
		model.addAttribute("addpayeelist",addpayeelist);
		model.addAttribute("transaction",transaction);
		
		return "managepayees"; 
	 }
	 
	 @GetMapping("/utilitypayments/{customerId}")
	 public String utilitypayments(@PathVariable("customerId") int customerId, Model model) { 
		 
		 Transaction transaction = null;
		 List<RoutingNumbers> utilitylist = null;
			try {
				transaction = transactionproxy.getTransaction(customerId);
				utilitylist = customerService.findutilitylist(customerId);
			} catch (Exception e) {
				e.printStackTrace();
			}
		 model.addAttribute("utilitylist",utilitylist);
		 model.addAttribute("transaction",transaction);
		 return "utilitypayments";
	 }
	 
	 @GetMapping("/creditcard/{customerId}")
	 public String creditcard(@PathVariable("customerId") int customerId, Model model) { 
		 
		 CreditCardTransaction cctran = null;
		 List<CreditCard> cc = null;
		 String approved = null;
			try {
				cctran = customerService.findCreditCardTransaction(customerId);
				cc = customerService.iscreditcardApproved(customerId);
			} catch (Exception e) {
				e.printStackTrace();
			}
		 model.addAttribute("cctran",cctran);
		 if(cc.size() > 0) {
			 System.out.println("Approevd yes");
			 approved = "true";
			 model.addAttribute("approved",approved);
			 return "creditcarddisabled";
		 } else {
			 System.out.println("Approevd no");
			 return "creditcard";
		 }	 
	 }
	 
	 @GetMapping("/updatemanager")
	 public String updatemanager() { 
		 return "updatemanager";
	 }
	 
	 @GetMapping("/reports")
	 public String reports() { 
		 return "reports"; 
	 }
	 
	 @GetMapping("/adminreports")
	 public String adminreports() { 
		 return "adminreports"; 
	 }
	 
	 @GetMapping("/about")
	 public String about() {
		return "about";
	 }
	 
	 @GetMapping("/forgotpassword")
	 public String forgotpassword() {
		return "resetpassword";
	 }
	 
	 @GetMapping("/welcomehome")
	 public String welcomehome() {
		return "welcomehome";
	 }
	 
	 @GetMapping("/welcomeadmin")
	 public String welcomeadmin(Model model) {
		 
		 logger.info(String.format("customer-service admin login invoked:{0} for {1} ", customerService.getClass().getName()));
	     
	     List<UserSignup> pendingusersignups = null;
	     List<Manager> managerlist = null;
	    	
	     try {
	        pendingusersignups = customerService.getpendingusersignups();
	        managerlist = customerService.getmanagerlist();
		 } catch (Exception ex) {
			logger.log(Level.WARNING, "Exception raised findByUserId REST Call {0}", ex); 
	     }

	     model.addAttribute("pendingusersignups", pendingusersignups);
	     model.addAttribute("managerlist", managerlist);
	     return "welcomeadmin";
	 }
	 
	 @GetMapping("/updatepersonalinfo")
	 public String update() {
		return "update";
	 }
	 
	 @GetMapping("/logout")
	 public String logout() {
	    return "index";
	 }
	 
	 @GetMapping("/welcomemanagerhome")
	 public String welcomemanagerhome() { 
		 return "welcomemanagerhome"; 
	 }
	 
	 @GetMapping("/managerscheduledpayments")
	 public String managerscheduledpayments() { 
		 return "managerscheduledpayments";
	 }
	 
	 @GetMapping("/managercreditcard/{managerId}")
	 public String managercreditcard(@PathVariable("managerId") int managerId, Model model) { 
		
		List<CreditCard> creditapplications = null;
		try {
			creditapplications = customerService.getPendingcreditcardapplications(managerId);
		} catch (Exception e) {
			e.printStackTrace();
		}
		 model.addAttribute("creditapplications",creditapplications);
		 return "managercreditcard"; 
	 }
	 
	 @GetMapping("/managerreports")
	 public String managerreports() { 
		 return "managerreports"; 
	 }
    
    @PostMapping("/loginuser")
	public String loginuser(@RequestParam("userId") String userId, @RequestParam("password") String password, Model model) throws NumberFormatException, Exception {	
	    
    	logger.info(String.format("customer-service login invoked:{0} for {1} ", customerService.getClass().getName(), userId));
        userId = userId.trim();
        password = password.trim();
        Customer customer = null;
        CreditCard creditcard = null;
    	
        try {
			customer = customerService.login(userId,password);
			
			creditcard = customerService.getcreditcardstatus(customer.getCustomerId());

			if (creditcard == null) {
				creditcard = new CreditCard();
				creditcard.setStatus("No Application");
			} else if("P".equals(creditcard.getStatus())) {
				creditcard.setStatus("Pending");
			} else if("V".equals(creditcard.getStatus())) {
				creditcard.setStatus("Approved");
			} 
		} catch (Exception ex) {
			 logger.log(Level.WARNING, "Exception raised findByUserId REST Call {0}", ex); 
        }

		if(customer==null) {
			model.addAttribute("errorMessage", "login not success");
	        return "login";
		}
		else {
	        model.addAttribute("user", customer);
	        model.addAttribute("creditcard", creditcard);
	        return "welcome";
	    }
	}
    
    @PostMapping("/managerlogin")
	public String managerlogin(@RequestParam("userId") String userId, @RequestParam("password") String password, Model model) throws Exception {	
	    
    	logger.info(String.format("customer-service manager login invoked:{0} for {1} ", customerService.getClass().getName(), userId));
        userId = userId.trim();
        password = password.trim();
        Manager manager = null;
    	
        try {
        	manager = customerService.managerlogin(userId,password);		
		} catch (Exception ex) {
			 logger.log(Level.WARNING, "Exception raised findByUserId REST Call {0}", ex); 
        }

		if(manager==null) {
			model.addAttribute("errorMessage", "login not success");
	        return "managerlogin";
		}
		else {
	        model.addAttribute("manager", manager);
	        return "welcomemanager";
	    }
	}

    @PostMapping("/adminlogin")
	public String adminlogin(@RequestParam("userId") String userId, @RequestParam("password") String password, Model model) throws Exception {	
	    
    	logger.info(String.format("customer-service admin login invoked:{0} for {1} ", customerService.getClass().getName(), userId));
        userId = userId.trim();
        password = password.trim();
        Admin admin = null;
        List<UserSignup> pendingusersignups = null;
        List<Manager> managerlist = null;
    	
        try {
        	admin = customerService.adminlogin(userId,password);
        	pendingusersignups = customerService.getpendingusersignups();
        	managerlist = customerService.getmanagerlist();
        	System.out.print("pendingusersignups size:" + pendingusersignups.size());
        	System.out.print("managerlist size:" + managerlist.size());
		} catch (Exception ex) {
			 logger.log(Level.WARNING, "Exception raised findByUserId REST Call {0}", ex); 
        }

		if(admin==null) {
			model.addAttribute("errorMessage", "login not success");
	        return "adminlogin";
		}
		else {
	        model.addAttribute("admin", admin);
	        model.addAttribute("pendingusersignups", pendingusersignups);
	        model.addAttribute("managerlist", managerlist);
	        return "welcomeadmin";
	    }
	}
   
    @GetMapping(path = "/userdatareport")
    public String generateUserDataReport(@RequestParam("userId") String userId, Model model) {
    	logger.info(String.format("customer-service findById() invoked:{0} for {1} ", customerService.getClass().getName(), userId));
    	System.out.print("userId1 +++++++++++++" + userId);
 		try {	
 			reportsproxy.generateuserdatareport(userId);
 		} catch (Exception e) {
 			e.printStackTrace();
 		}    
 		return "reports";
    }
    
    @GetMapping(path = "/alluserdatareportformanager")
    public String allUserDataReportForManager(@RequestParam("managerId") int managerId, Model model) {
    	
    	logger.info(String.format("customer-service allUserDataReportForManager() invoked:{0} ", customerService.getClass().getName()));
 		try {	
 			reportsproxy.alluserdatareportformanager(managerId);
 		} catch (Exception e) {
 			e.printStackTrace();
 		}    
 		return "welcomemanagerhome";
    }
    
    @GetMapping(path = "/alluserdatareport")
    public String allUserDataReport() {
    	
    	logger.info(String.format("customer-service allUserDataReport() invoked:{0} ", customerService.getClass().getName()));
 		try {	
 			reportsproxy.alluserdatareport();
 		} catch (Exception e) {
 			e.printStackTrace();
 		}    
 		return "welcomeadmin";
    }
    
    @GetMapping(path = "/transactionstatementreport")
    public String generateTransactionStatementReport(@RequestParam("customerId") int customerId, 
    		@RequestParam("fromdate") @DateTimeFormat(pattern = "yyyy-MM-dd") Date fromdate, @RequestParam("todate") @DateTimeFormat(pattern = "yyyy-MM-dd") Date todate, Model model) {
        logger.info(String.format("customer-service generateUserDataReport invoked:{0} for {1} ", customerService.getClass().getName(), customerId));
       
        try {
 			reportsproxy.transactionstatementreport(customerId,fromdate,todate);
 		} catch (Exception e) {
 			e.printStackTrace();
 		}   
	     return "reports";
    }
    
    @GetMapping(path = "/creditcardstatementreport")
    public String generateCreditCardStatementReport(@RequestParam("customerId") int customerId, 
    		@RequestParam("fromdate") @DateTimeFormat(pattern = "yyyy-MM-dd") Date fromdate, @RequestParam("todate") @DateTimeFormat(pattern = "yyyy-MM-dd") Date todate, Model model) {
        logger.info(String.format("customer-service generateCreditCardStatementReport invoked:{0} for {1} ", customerService.getClass().getName(), customerId));
       
        try {
 			reportsproxy.creditcardstatementreport(customerId,fromdate,todate);
 		} catch (Exception e) {
 			e.printStackTrace();
 		}   
	     return "reports";
    }
    
    @PostMapping("/usersignup")
	public String usersignup(@ModelAttribute("user") UserSignup user, Model model) {
    	
    	logger.info(String.format("customer-service usersignup invoked:{0} ", customerService.getClass().getName()));
    	
        try {
        	user = customerService.usersignup(user);
        	System.out.println("user.getCustomerId():" + user.getCustomerId());
        } catch (Exception ex) {
            logger.log(Level.WARNING, "Exception raised findByUserId REST Call {0}", ex);   
        }
        
        if(user==null) {
    		model.addAttribute("errorMessage", "Signup not Success");
            return "signup";
    	}
    	else {
    		model.addAttribute("id", Integer.valueOf(user.getCustomerId()));
            model.addAttribute("user", user);
            return "index";
        }
    }
    
    @PostMapping("/approveuser")
	public String adduser(@ModelAttribute("customer") Customer customer,Model model) {
    	
    	logger.info(String.format("customer-service addCustomer invoked:{0} ", customerService.getClass().getName()));
    	Transaction transaction = null;
        List<UserSignup> pendingusersignups = null;
        List<Manager> managerlist = null;
    	
        try {
        	customer = customerService.addCustomer(customer);
        	System.out.println("customer.getCustomerId():" + customer.getCustomerId());
        	transaction = transactionproxy.addTransaction(customer.getCustomerId(), customer.getEmail(), "INIT", 0);
        	
        	emailservice.sendEmail(customer.getEmail(), "Your Account has been approved!", "Congratulations " + customer.getFirstName() + "!"  );
        	pendingusersignups = customerService.getpendingusersignups();
        	managerlist = customerService.getmanagerlist();
        	
        } catch (Exception ex) {
            logger.log(Level.WARNING, "Exception raised findByUserId REST Call {0}", ex);   
        }   
		
	    model.addAttribute("pendingusersignups", pendingusersignups);
	    model.addAttribute("managerlist", managerlist);
	    return "welcomeadmin";  
    }
    
    @PostMapping("/updateuserinfo")
	public String updateuserinfo(@ModelAttribute("customer") Customer customer,Model model) {
    	
    	logger.info(String.format("customer-service updateuser invoked:{0} ", customerService.getClass().getName()));
        try {
        	customer = customerService.updateUserInfo(customer);
        } catch (Exception ex) {
            logger.log(Level.WARNING, "Exception raised findByUserId REST Call {0}", ex);   
        }
        
        model.addAttribute("user", customer);
        return "welcome";
    }   
    
    @PostMapping("/transactuser")
	public String transactuser(@RequestParam("customerId") int customerId, @RequestParam("email") String email,
			@RequestParam("transactiontype") String transactiontype, @RequestParam("amount") String amount, Model model) {
    	
    	logger.info(String.format("transfertopayee invoked:{0} ", customerService.getClass().getName()));
    	
   		List<Customer> addpayeelist = null;
		List<Customer> managedpayeelist = null;
		List<Integer> managedcustomeridlist = new ArrayList<Integer>();
		Transaction t = null;
		Double amt = Double.parseDouble(amount);
		try {
			t = transactionproxy.addTransaction(customerId, email, transactiontype, amt);
			managedcustomeridlist = customerService.findaddedcustomeridlist(customerId);
			managedpayeelist = customerService.findmanagedcustomerlist(managedcustomeridlist);
			managedcustomeridlist.add(customerId);
			addpayeelist = customerService.findnonmanagedcustomerlist(managedcustomeridlist);
		} catch (Exception e) {
			e.printStackTrace();
		}	
    	
    	model.addAttribute("managedpayeelist",managedpayeelist);
    	model.addAttribute("addpayeelist",addpayeelist);
    	model.addAttribute("transaction",t);
    		
    	return "managepayees";
    } 
    
    @PostMapping("/transfertopayee")
	public String transfertopayee(@RequestParam("customerId") int customerId, @RequestParam("payeeId") int payeeId,
			String amount, Model model) {
    	
    	logger.info(String.format("transfertopayee invoked:{0} ", customerService.getClass().getName()));
    	
    	Double amt = Double.parseDouble(amount);
    	
    	List<Integer> customerIdList = new ArrayList<Integer>();
    	customerIdList.add(customerId);
    	customerIdList.add(payeeId);
    	List<Customer> customerList = null;
    	
    	try {
			customerList = customerService.findmanagedcustomerlist(customerIdList);
		} catch (Exception e) {
			e.printStackTrace();
		}
    	
    	HashMap<Integer,Customer> customermap = new HashMap<>();
    	for(int i = 0; i < customerList.size(); i++) {
    		customermap.put(customerList.get(i).getCustomerId(), customerList.get(i));
    	}
  	
    	Transaction transaction = transactionproxy.transfertopayee(customerId,payeeId,amt,customermap.get(customerId).getEmail(),
    			customermap.get(payeeId).getEmail());
    	
   		List<Customer> addpayeelist = null;
		List<Customer> managedpayeelist = null;
		List<Integer> managedcustomeridlist = new ArrayList<Integer>();
		
       	try {
        				
    		managedcustomeridlist = customerService.findaddedcustomeridlist(customerId);
    		managedpayeelist = customerService.findmanagedcustomerlist(managedcustomeridlist);
    		managedcustomeridlist.add(customerId);
    		addpayeelist = customerService.findnonmanagedcustomerlist(managedcustomeridlist);
    			
    	} catch (Exception e) {
    		e.printStackTrace();
    	}
    		
    	model.addAttribute("managedpayeelist",managedpayeelist);
    	model.addAttribute("addpayeelist",addpayeelist);
    	model.addAttribute("transaction",transaction);
    		
    	return "managepayees";
    }
    
    @PostMapping("/applyforcreditcard")
	public String applyforcreditcard(@ModelAttribute("creditcard") CreditCard creditcard,Model model) {
    	
    	logger.info(String.format("applyforcreditcard invoked:{0} ", customerService.getClass().getName()));
    	
    	try {
			creditcard = customerService.applyforcreditcard(creditcard);
		} catch (Exception e) {
			e.printStackTrace();
		}
    	
    	model.addAttribute("creditcard",creditcard);
    	return "creditcard";
    } 
    
    @GetMapping("/usersearch")
	public String usersearch(@RequestParam("firstName") String firstName, @RequestParam("managerId") int managerId, Model model) throws Exception {	
	    
    	logger.info(String.format("customer-service login invoked:{0} for {1} ", customerService.getClass().getName(), firstName));
    	firstName = firstName.trim();
        List<Customer> customers = null;
    	
        try {
			customers = customerService.usersearch(firstName,managerId);
			System.out.print("customers size:" + customers.size());
		} catch (Exception ex) {
			 logger.log(Level.WARNING, "Exception raised findByUserId REST Call {0}", ex); 
        }
	    model.addAttribute("customers", customers);
	    return "welcomemanagerhome";
	}
    
    @GetMapping("/usersearchformanagerupdate")
	public String usersearchformanagerupdate(@RequestParam("firstName") String firstName, Model model) throws Exception {	
	    
    	logger.info(String.format("customer-service login invoked:{0} for {1} ", customerService.getClass().getName(), firstName));
    	firstName = firstName.trim();
        List<Customer> customers = null;
        List<Manager> managerlist = null;
        HashMap<String,String> managermap = new HashMap<String,String>();
    	
        try {
			customers = customerService.usersearchformanagerupdate(firstName);
			managerlist = customerService.getmanagerlist();
			System.out.print("customers size:" + customers.size());
			
			for(Manager m:managerlist) {
				String s = String.valueOf(m.getManagerId());
				managermap.put(s, m.getName());
			}
			
		} catch (Exception ex) {
			 logger.log(Level.WARNING, "Exception raised findByUserId REST Call {0}", ex); 
        }
	    model.addAttribute("customers", customers);
	    model.addAttribute("managerlist", managerlist);
	    model.addAttribute("managermap", managermap);
	    return "updatemanager";
	}
    
    @PostMapping("/addroutingnumbers")
	public String addroutingnumbers(@ModelAttribute("routingnumber") RoutingNumbers routingnumber,Model model) {
    	
    	logger.info(String.format("addroutingnumbers invoked:{0} ", customerService.getClass().getName()));
    	 Transaction transaction = null;
    	 List<RoutingNumbers> utilitylist = null;
	     try {
	    	customerService.addroutingnumber(routingnumber);
	    	transaction = transactionproxy.getTransaction(routingnumber.getCustomerId());
	    	utilitylist = customerService.findutilitylist(routingnumber.getCustomerId());
		} catch (Exception ex) {
			logger.log(Level.WARNING, "Exception raised findByUserId REST Call {0}", ex); 
	    }
	    model.addAttribute("utilitylist",utilitylist);
		model.addAttribute("transaction",transaction);
		
	    return "utilitypayments";
    } 
    
    @PostMapping("/billpayment")
	public String schedulebillpayment(@RequestParam("routingnumber") String routingnumber, @RequestParam("amount") String amount, 
			@RequestParam("customerId") int customerId, 
			@RequestParam("scheduledate") @DateTimeFormat(pattern = "yyyy-MM-dd") Date scheduledate, Model model) {
    	
    	logger.info(String.format("billpayment invoked:{0} ", customerService.getClass().getName()));
    	Transaction transaction = null;
    	List<RoutingNumbers> utilitylist = null;
    	try {
    		customerService.schedulebillpayment(customerId,routingnumber,amount,scheduledate);
    		utilitylist = customerService.findutilitylist(customerId);
    		transaction = transactionproxy.getTransaction(customerId);
		} catch (Exception e) {
			e.printStackTrace();
		}
    	model.addAttribute("utilitylist",utilitylist);
    	model.addAttribute("transaction",transaction);
    	return "utilitypayments";
    } 
    
    @PostMapping("/processscheduledpayments")
	public String processscheduledpayments(@RequestParam("managerId") int managerId,Model model) {
    	
    	logger.info(String.format("processscheduledpayments invoked:{0} ", customerService.getClass().getName()));
    	
    	try {
    		customerService.processscheduledpayments(managerId);
		} catch (Exception e) {
			e.printStackTrace();
		}
    	return "welcomemanagerhome";
    } 
    
    @PostMapping("/approvecreditcard")
   	public String approvecreditcard(@RequestParam("applicationId") int applicationId, @RequestParam("max_limit") String max_limit,
   			@RequestParam("managerId") int managerId,@RequestParam("customerId") int customerId, Model model) {
       	
       	logger.info(String.format("approvecreditcard invoked:{0} ", customerService.getClass().getName()));
       	List<CreditCard> creditapplications = null;
       	CreditCard cred = new CreditCard();
       	CreditCardTransaction credtran = new CreditCardTransaction();
       	try {
       		Double limit = Double.parseDouble(max_limit);
       		cred.setApplicationId(applicationId);
       		cred.setCustomerId(customerId);
       		cred.setManagerId(managerId);
       		cred.setMax_limit(limit);
       		cred.setStatus("V");
       		Date d = new Date();
       		cred.setDate(d);

       		credtran.setAmount(0);
       		credtran.setAvailablelimit(limit);
       		credtran.setCustomerId(customerId);
       		credtran.setDate(d);
       		credtran.setDescription("Initial Approval");
       		
       		customerService.approvecreditcard(cred,credtran);
       		
       		creditapplications = customerService.getPendingcreditcardapplications(managerId);
   		} catch (Exception e) {
   			e.printStackTrace();
   		}
       	
		 model.addAttribute("creditapplications",creditapplications);
		 return "managercreditcard";  	
    } 
    
    @PostMapping("/addpayee")
   	public String addpayee(@RequestParam("customerId") int customerId, @RequestParam("payeeId") int payeeId, Model model) {
       	
       	logger.info(String.format("addpayee invoked:{0} ", customerService.getClass().getName()));
       	Payee payee = new Payee();
   		List<Customer> addpayeelist = null;
		List<Customer> managedpayeelist = null;
		List<Integer> managedcustomeridlist = new ArrayList<Integer>();
		Transaction transaction = null;
		
       	try {
       		payee.setParent_customerId(customerId);
       		payee.setChild_customerId(payeeId);
       		Date d = new Date();
       		payee.setDate(d);
       		customerService.addpayee(payee);
       				
    		managedcustomeridlist = customerService.findaddedcustomeridlist(customerId);
    		managedpayeelist = customerService.findmanagedcustomerlist(managedcustomeridlist);
    		managedcustomeridlist.add(customerId);
    		addpayeelist = customerService.findnonmanagedcustomerlist(managedcustomeridlist);
    		
    		transaction = transactionproxy.getTransaction(customerId);	
    	} catch (Exception e) {
    		e.printStackTrace();
    	}
    		
    	model.addAttribute("managedpayeelist",managedpayeelist);
    	model.addAttribute("addpayeelist",addpayeelist);
    	model.addAttribute("transaction",transaction);
    		
    	return "managepayees";
    } 
    
    @PostMapping("/creditcardtransaction")
   	public String creditcardtransaction(@ModelAttribute("cctran") CreditCardTransaction cctran, Model model) {
       	
       	logger.info(String.format("customer-service creditcardtransaction invoked:{0} ", customerService.getClass().getName()));
       	
        try {
        	cctran = customerService.creditcardtransaction(cctran);
        } catch (Exception ex) {
           logger.log(Level.WARNING, "Exception raised findByUserId REST Call {0}", ex);   
        }  
           model.addAttribute("cctran",cctran);
           return "creditcard";
       }
    
    
    @PostMapping("/creditcardbillpayment")
	public String creditcardbillpayment(@RequestParam("customerId") int customerId, @RequestParam("amount") String amount, 
			@RequestParam("email") String email, Model model) {
    	
    	logger.info(String.format("transfertopayee invoked:{0} ", customerService.getClass().getName()));
    	
		Transaction transaction = null;
		List<RoutingNumbers> utilitylist = null;
		 
		Double amt = Double.parseDouble(amount);

		try {
			customerService.creditcardbillpayment(customerId,amt,email);
			transaction = transactionproxy.getTransaction(customerId);
			utilitylist = customerService.findutilitylist(customerId);
		} catch (Exception e) {
			e.printStackTrace();
		}
		model.addAttribute("utilitylist",utilitylist);
		model.addAttribute("transaction",transaction);
		return "utilitypayments";
    }
    
}