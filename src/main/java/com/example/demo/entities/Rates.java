package com.example.demo.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "TAX_SLABS",schema="dbo")
public class Rates {

	private int taxId;
	private double incomeFrom;
	private double incomeTo;
	private double taxPercentage;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "TAX_ID")
	public int getTaxId() {
		return taxId;
	}
	public void setTaxId(int taxId) {
		this.taxId = taxId;
	}
	
	@Column(name = "INCOME_FROM")
	public double getIncomeFrom() {
		return incomeFrom;
	}
	public void setIncomeFrom(double incomeFrom) {
		this.incomeFrom = incomeFrom;
	}
	
	@Column(name = "INCOME_TO")
	public double getIncomeTo() {
		return incomeTo;
	}
	public void setIncomeTo(double incomeTo) {
		this.incomeTo = incomeTo;
	}
	
	@Column(name = "TAX_PERCENTAGE")
	public double getTaxPercentage() {
		return taxPercentage;
	}
	public void setTaxPercentage(double taxPercentage) {
		this.taxPercentage = taxPercentage;
	}
	
	
/*	private int id;
	private double rates;
	
	@Id
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public double getRates() {
		return rates;
	}
	public void setRates(double rates) {
		this.rates = rates;
	}*/
	
	
}
