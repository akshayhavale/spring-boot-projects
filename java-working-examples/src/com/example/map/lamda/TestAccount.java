package com.example.map.lamda;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.stream.Collectors;

public class TestAccount {

	private static AccountDetail accountDetail1 = new AccountDetail("123", "savings");
	private static AccountDetail accountDetail2 = new AccountDetail("123", "current");
	private static AccountDetail accountDetail3 = new AccountDetail("1234", "current");

	public static void main(String args[]) {
//
//		AccountDetails accountDetails = getDetails().get("123");
//		System.out.println(accountDetails);
//
//		System.out.println("************");
//		getDetails1().entrySet().forEach(entry -> System.out
//				.println("AccountNumber : " + entry.getKey() + "  AccountDetails : " + entry.getValue()));

//		List<AccountDetail> accountDetails = (List<AccountDetail>) getDetails1().get("123");
//		
//		accountDetails.forEach(System.out::println);

		getDetails2().entrySet().forEach(a -> {
			System.out.println("key : " + a.getKey() + "  value  : " + a.getValue());
		});
		

	}

	private static List<AccountDetail> getAccountDetail() {
		return Arrays.asList(accountDetail1, accountDetail2, accountDetail3);
	}

	private static Map<String, AccountDetails> getDetails() {
		Set<String> unique = new HashSet<>();
		/*
		 * ConcurrentHashMap or HashMap whatever you use it wont affect
		 */
		Map<String, AccountDetails> map = new ConcurrentHashMap<>();
		getAccountDetail().stream().forEach(account -> {

			if (unique.add(account.getAccountNumber())) {
				AccountDetails accountDetails = new AccountDetails();
				accountDetails.getAccountDetails().add(account);
				map.put(account.getAccountNumber(), accountDetails);
			} else {
				AccountDetails accountDetails = map.get(account.getAccountNumber());
				accountDetails.getAccountDetails().add(account);
				map.put(account.getAccountNumber(), accountDetails);

			}
		});

		return map;
	}

	
	
	private static Map<String, List<AccountDetail>> getDetails1() {

		return getAccountDetail().stream().collect(Collectors.toMap(AccountDetail::getAccountNumber,
				acct -> addAccountDetail1(acct), (acct, acct1) -> addAccountDetail2(acct, acct1)));

	}


	private static List<AccountDetail> addAccountDetail2(Object accts, Object acct1) {
		List list = (List)accts;
		list.add(acct1);
		return list;
	}

	private static List<AccountDetail> addAccountDetail1(AccountDetail accountDetail) {
		List<AccountDetail> accountDetails = new ArrayList<>();
		accountDetails.add(accountDetail);
		return accountDetails;
	}
	
	private static Map<String, List<AccountDetail>> getDetails2(){

		Map<String, List<AccountDetail>> map = getAccountDetail().stream()
				  .collect(Collectors.groupingBy(AccountDetail::getAccountNumber));
		
		return map;

	}
	
}
