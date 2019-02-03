package com.paypal.pojomodel;

public class Transactions
{
	Amount amount;
	PaymentOptions payment_Options;
	ItemList item_list;
	String noteToThePayer;
	
	private String description;
	private String custom;
	private String invoice_number;
	private String short_description;
	public Amount getAmount()
	{
		return amount;
	}
	public void setAmount(Amount amount)
	{
		this.amount = amount;
	}
	public PaymentOptions getPayment_Options()
	{
		return payment_Options;
	}
	public void setPayment_Options(PaymentOptions payment_Options)
	{
		this.payment_Options = payment_Options;
	}
	public ItemList getItem_list()
	{
		return item_list;
	}
	public void setItem_list(ItemList item_list)
	{
		this.item_list = item_list;
	}
	public String getNoteToThePayer()
	{
		return noteToThePayer;
	}
	public void setNoteToThePayer(String noteToThePayer)
	{
		this.noteToThePayer = noteToThePayer;
	}
	public String getDescription()
	{
		return description;
	}
	public void setDescription(String description)
	{
		this.description = description;
	}
	public String getCustom()
	{
		return custom;
	}
	public void setCustom(String custom)
	{
		this.custom = custom;
	}
	public String getInvoice_number()
	{
		return invoice_number;
	}
	public void setInvoice_number(String invoice_number)
	{
		this.invoice_number = invoice_number;
	}
	public String getShort_description()
	{
		return short_description;
	}
	public void setShort_description(String short_description)
	{
		this.short_description = short_description;
	}
	public void setSoft_descriptor(String string)
	{
		// TODO Auto-generated method stub
		
	}
	
}
