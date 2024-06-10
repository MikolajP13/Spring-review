package com.mp.aopdemo;

import com.mp.aopdemo.dao.AccountDAO;
import com.mp.aopdemo.dao.MembershipDAO;
import com.mp.aopdemo.service.TrafficFortuneService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.List;

@SpringBootApplication
public class AopdemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(AopdemoApplication.class, args);
	}

	@Bean
	public CommandLineRunner commandLineRunner(AccountDAO accountDAO,
											   MembershipDAO membershipDAO,
											   TrafficFortuneService trafficFortuneService) {
		return runner -> {
//			demoTheBeforeAdvice(accountDAO, membershipDAO);
//			demoTheAfterReturnAdvice(accountDAO);
//			demoTheAfterThrowingAdvice(accountDAO);
//			demoTheAfterAdvice(accountDAO);
//			demoTheAroundAdvice(trafficFortuneService);
//			demoTheAroundAdviceHandleException(trafficFortuneService);
			demoTheAroundAdviceRethrowException(trafficFortuneService);

		};
	}

	private void demoTheAroundAdviceRethrowException(TrafficFortuneService trafficFortuneService) {
		System.out.println("demoTheAroundAdviceRethrowException");
		boolean tripWire = true;
		String data = trafficFortuneService.getFortune(tripWire);
		System.out.println("Fortune: " + data);
	}

	private void demoTheAroundAdviceHandleException(TrafficFortuneService trafficFortuneService) {
		System.out.println("demoTheAroundAdviceHandleException");
		boolean tripWire = true;
		String data = trafficFortuneService.getFortune(tripWire);
		System.out.println("Fortune: " + data);
	}

	private void demoTheAroundAdvice(TrafficFortuneService trafficFortuneService) {
		String data = trafficFortuneService.getFortune();
		System.out.println("Fortune: " + data);
	}

	private void demoTheAfterAdvice(AccountDAO accountDAO) {
		List<Account> accounts = null;

		try {
			// add a boolean flag to simulate exceptions
			boolean tripWire = false;
			accounts = accountDAO.findAccounts(tripWire);
		} catch (Exception e) {
			System.out.println("caught exception: " + e);
		}

		System.out.println("demoTheAfterThrowingAdvice");
		System.out.println("Main program: " + accounts);
	}

	private void demoTheAfterThrowingAdvice(AccountDAO accountDAO) {
		List<Account> accounts = null;

		try {
			// add a boolean flag to simulate exceptions
			boolean tripWire = true;
			accounts = accountDAO.findAccounts(tripWire);
		} catch (Exception e) {
			System.out.println("caught exception: " + e);
		}

		System.out.println("demoTheAfterThrowingAdvice");
		System.out.println("Main program: " + accounts);
	}

	private void demoTheAfterReturnAdvice(AccountDAO accountDAO) {
		List<Account> accounts = accountDAO.findAccounts();
		System.out.println("Main program: " + accounts);
	}

	private void demoTheBeforeAdvice(AccountDAO accountDAO, MembershipDAO membershipDAO) {
		Account account = new Account();
		account.setName("Test");
		account.setLevel("Level 1");

		accountDAO.addAccount(account, true);
		accountDAO.doWork();

		accountDAO.setName("foobar");
		accountDAO.setServiceCode("silver");
		accountDAO.getName();
		accountDAO.getServiceCode();

		membershipDAO.addAccount();
		membershipDAO.addSillyMember();
		membershipDAO.goToSleep();
	}
}
