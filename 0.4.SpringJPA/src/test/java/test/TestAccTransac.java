package test;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import com.zycus.entity.Account;
import com.zycus.entity.FacilityTransaction;
import com.zycus.service.AccountService;


public class TestAccTransac {

	@Test
	public void testAddAccount() {
	
	//Loading IoC Container
	ApplicationContext context = new ClassPathXmlApplicationContext("app-config.xml");
	
	//Accessing HellWorld
	AccountService service = (AccountService) context.getBean("accountService");
	
	Account account = new Account();
	account.setName("Sonali");
	account.setBalance(20000);
	account.setType("Current");
	service.registerAccount(account);
	
	}
	
	@Test
	public void testDeposit() {
		//Loading IoC Container
		ApplicationContext context = new ClassPathXmlApplicationContext("app-config.xml");
		
		//Accessing HellWorld
		AccountService accountService = (AccountService) context.getBean("accountService");
		accountService.deposit(1, 100000);
	}
	
	@Test
	public void testWithDraw() {
		//Loading IoC Container
		ApplicationContext context = new ClassPathXmlApplicationContext("app-config.xml");
				
		//Accessing HellWorld
		AccountService accountService = (AccountService) context.getBean("accountService");
		accountService.withDraw(1, 20);
	}
	
	@Test
	public void testTransfer() {
		//Loading IoC Container
		ApplicationContext context = new ClassPathXmlApplicationContext("app-config.xml");
				
		//Accessing HellWorld
		AccountService accountService = (AccountService) context.getBean("accountService");
		accountService.transfer(1, 2, 775);
	}
	
	@Test
	public void testFetchBalance() {
		//Loading IoC Container
		ApplicationContext context = new ClassPathXmlApplicationContext("app-config.xml");
				
		//Accessing HellWorld
		AccountService accountService = (AccountService) context.getBean("accountService");
		System.out.println(accountService.fetchBalance(1));
	}
	
	@Test
	public void testlistMiniStatement() {
		//Loading IoC Container
		ApplicationContext context = new ClassPathXmlApplicationContext("app-config.xml");
						
		//Accessing HellWorld
		AccountService accountService = (AccountService) context.getBean("accountService");
		List<FacilityTransaction> list = accountService.miniStatement(1);
		
		for(FacilityTransaction fac: list) {
			System.out.println(fac.getTransNo());
		}
		
	}
	@Test
	public void testfetchAccByTransAmt() {
		//Loading IoC Container
		ApplicationContext context = new ClassPathXmlApplicationContext("app-config.xml");
								
		//Accessing HellWorld
		AccountService accountService = (AccountService) context.getBean("accountService");
		List<Account> list = accountService.fetchAccByTransAmt(100);
		
		for(Account acc: list) {
			System.out.println(acc.getAccNo());
		}
		
	}
	
	@Test
	public void testfetchAccByHighestTransAmt() {
		//Loading IoC Container
		ApplicationContext context = new ClassPathXmlApplicationContext("app-config.xml");
								
		//Accessing HellWorld
		AccountService accountService = (AccountService) context.getBean("accountService");
		List<Account> list = accountService.fetchAccountsByHighestTransactionAmount();
		
		for(Account acc: list) {
			System.out.println(acc.getAccNo());
		}
		
	}

}
