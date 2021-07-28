package com.example.map.lamda;

import java.util.ArrayList;
import java.util.List;

public class AccountDetails {

	private List<AccountDetail> accountDetails = new ArrayList<>();

	public List<AccountDetail> getAccountDetails() {
		return accountDetails;
	}

	public void setAccountDetails(List<AccountDetail> accountDetails) {
		this.accountDetails = accountDetails;
	}

	public AccountDetails(List<AccountDetail> accountDetails) {
		super();
		this.accountDetails = accountDetails;
	}

	public AccountDetails() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((accountDetails == null) ? 0 : accountDetails.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		AccountDetails other = (AccountDetails) obj;
		if (accountDetails == null) {
			if (other.accountDetails != null)
				return false;
		} else if (!accountDetails.equals(other.accountDetails))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "AccountDetails [accountDetails=" + accountDetails + "]";
	}

}
