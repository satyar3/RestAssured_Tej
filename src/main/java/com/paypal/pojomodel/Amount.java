package com.paypal.pojomodel;

public class Amount
{
	private String total;
	private String currency;
	Details details;
	public String getTotal()
	{
		return total;
	}
	public void setTotal(String total)
	{
		this.total = total;
	}
	public String getCurrency()
	{
		return currency;
	}
	public void setCurrency(String currency)
	{
		this.currency = currency;
	}
	public Details getDetails()
	{
		return details;
	}
	public void setDetails(Details details)
	{
		this.details = details;
	}
	
	
}
