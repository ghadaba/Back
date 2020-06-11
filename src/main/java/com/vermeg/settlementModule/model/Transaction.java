package com.vermeg.settlementModule.model;

import javax.persistence.Entity;
import javax.persistence.Id;

import com.vermeg.settlementModule.model.enums.SettelmentNature;
import com.vermeg.settlementModule.model.enums.TransactionType;


@Entity
public class Transaction {
	private Long idtransaction ;
	private  String contracttype;
	private TransactionType transactiontype ;
	private SettelmentNature settelmentnature ;
	public Transaction() {
		
	}
	@Id
	public Long getIdtransaction() {
		return idtransaction;
	}
	public void setIdtransaction(Long idtransaction) {
		this.idtransaction = idtransaction;
	}
	public String getContracttype() {
		return contracttype;
	}
	public void setContracttype(String contracttype) {
		this.contracttype = contracttype;
	}
	public TransactionType getTransactiontype() {
		return transactiontype;
	}
	public void setTransactiontype(TransactionType transactiontype) {
		this.transactiontype = transactiontype;
	}
	public SettelmentNature getSettelmentnature() {
		return settelmentnature;
	}
	public void setSettelmentnature(SettelmentNature settelmentnature) {
		this.settelmentnature = settelmentnature;
	}
	
}
