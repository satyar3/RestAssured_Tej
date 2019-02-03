package com.paypal.pojomodel;

import java.util.List;

public class ItemList
{
	List<Items> items;
	ShippingAddress shippingAddress;
	
	public List<Items> getItems()
	{
		return items;
	}
	public void setItems(List<Items> items)
	{
		this.items = items;
	}
	public ShippingAddress getShippingAddress()
	{
		return shippingAddress;
	}
	public void setShippingAddress(ShippingAddress shippingAddress)
	{
		this.shippingAddress = shippingAddress;
	}	
}
