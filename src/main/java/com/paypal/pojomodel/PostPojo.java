package com.paypal.pojomodel;

import java.util.List;

public class PostPojo
{
	private String intent;
	private Payer payer;
	private List<Transactions> transactions;
	private String note_to_payer;
	private RedirectURLs redirect_urls;
	public String getIntent()
	{
		return intent;
	}
	public void setIntent(String intent)
	{
		this.intent = intent;
	}
	public Payer getPayer()
	{
		return payer;
	}
	public void setPayer(Payer payer)
	{
		this.payer = payer;
	}
	public List<Transactions> getTransactions()
	{
		return transactions;
	}
	public void setTransactions(List<Transactions> transactions)
	{
		this.transactions = transactions;
	}
	public String getNote_to_payer()
	{
		return note_to_payer;
	}
	public void setNote_to_payer(String note_to_payer)
	{
		this.note_to_payer = note_to_payer;
	}
	public RedirectURLs getRedirect_urls()
	{
		return redirect_urls;
	}
	public void setRedirect_urls(RedirectURLs redirect_urls)
	{
		this.redirect_urls = redirect_urls;
	}
	
	
}
