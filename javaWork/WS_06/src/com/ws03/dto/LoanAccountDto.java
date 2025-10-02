package com.ws03.dto;

public class LoanAccountDto extends AccountDto {
	private String mortgage;

	public LoanAccountDto() {
		// TODO Auto-generated constructor stub
	}

	public LoanAccountDto(int accountSeq, String accountNumber, int balance, int userSeq, String mortgage) {
		super(accountSeq, accountNumber, balance, userSeq);
		this.mortgage = mortgage;
		// TODO Auto-generated constructor stub
	}

	public String getMortgage() {
		return mortgage;
	}

	public void setMortgage(String mortgage) {
		this.mortgage = mortgage;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append(super.toString()).append(" | ").append(mortgage);
		return builder.toString();
	}
	
	
	
	
}
