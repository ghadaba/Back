package com.vermeg.settlementModule.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Asset {
	private long Isin ;
	private String instrument ;
	private String settelmentplace ;
	private String nostrosecacc;
	private String nostrocashacc;
	public Asset() {
		
	}
	@Id
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	public long getIsin() {
		return Isin;
	}
	public void setIsin(long isin) {
		Isin = isin;
	}
	public String getInstrument() {
		return instrument;
	}
	public void setInstrument(String instrument) {
		this.instrument = instrument;
	}
	public String getSettelmentplace() {
		return settelmentplace;
	}
	public void setSettelmentplace(String settelmentplace) {
		this.settelmentplace = settelmentplace;
	}
	public String getNostrosecacc() {
		return nostrosecacc;
	}
	public void setNostrosecacc(String nostrosecacc) {
		this.nostrosecacc = nostrosecacc;
	}
	public String getNostrocashacc() {
		return nostrocashacc;
	}
	public void setNostrocashacc(String nostrocashacc) {
		this.nostrocashacc = nostrocashacc;
	}
	
	
	
	}