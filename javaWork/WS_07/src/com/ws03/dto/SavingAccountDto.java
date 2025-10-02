package com.ws03.dto;

public class SavingAccountDto extends AccountDto {
	private int transferFee;

	public SavingAccountDto() {
		// TODO Auto-generated constructor stub
	}

	public SavingAccountDto(int accountSeq, String accountNumber, int balance, int userSeq, int transferFee) {
		super(accountSeq, accountNumber, balance, userSeq);
		this.transferFee = transferFee;
		// TODO Auto-generated constructor stub
	}

	public int getTransferFee() {
		return transferFee;
	}

	public void setTransferFee(int transferFee) {
		this.transferFee = transferFee;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append(super.toString()).append(" | ").append(transferFee);
		return builder.toString();
	}
	
	
	
}
