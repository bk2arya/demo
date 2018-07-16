package com.example.demo.common;

public class RatesDto {
	
	private double income;
	private double totalTaxesPaid;
	private double effectiveTaxRate;
	private String status;
	
	public double getIncome() {
		return income;
	}
	public void setIncome(double income) {
		this.income = income;
	}
	public double getTotalTaxesPaid() {
		return totalTaxesPaid;
	}
	public void setTotalTaxesPaid(double totalTaxesPaid) {
		this.totalTaxesPaid = totalTaxesPaid;
	}
	public double getEffectiveTaxRate() {
		return effectiveTaxRate;
	}
	public void setEffectiveTaxRate(double effectiveTaxRate) {
		this.effectiveTaxRate = effectiveTaxRate;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	
	
	

}
