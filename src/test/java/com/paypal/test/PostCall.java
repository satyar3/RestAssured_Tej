package com.paypal.test;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import com.paypal.pojomodel.Amount;
import com.paypal.pojomodel.Details;
import com.paypal.pojomodel.ItemList;
import com.paypal.pojomodel.Items;
import com.paypal.pojomodel.Payer;
import com.paypal.pojomodel.PaymentOptions;
import com.paypal.pojomodel.PostPojo;
import com.paypal.pojomodel.RedirectURLs;
import com.paypal.pojomodel.ShippingAddress;
import com.paypal.pojomodel.Transactions;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;

public class PostCall extends BaseClass
{
	@Test
	public void test001()
	{
		RedirectURLs red_urls = new RedirectURLs();
		red_urls.setCancel_urls("http://www.hawaii.com");
		red_urls.setReturn_urls("http://www.amazon.com");

		Details details = new Details();
		details.setHandling_fee("1.00");
		details.setInsurance("0.01");
		details.setShipping("0.03");
		details.setShipping_discount("-1.00");
		details.setSubtotal("30.00");
		details.setTax("0.07");

		Amount amount = new Amount();
		amount.setCurrency("USD");
		amount.setDetails(details);
		amount.setTotal("30.11");

		// Set the shipping address
		ShippingAddress shipping_address = new ShippingAddress();
		shipping_address.setCity("San Jose");
		shipping_address.setCountry_code("US");
		shipping_address.setLine1("4thFloor");
		shipping_address.setLine2("unit34");
		shipping_address.setPhone("011862212345678");
		shipping_address.setPostal_code("95131");
		shipping_address.setRecipient_name("PAB");
		shipping_address.setState("CA");

		// Set Items
		Items item = new Items();
		item.setCurrency("USD");
		item.setDescription("Brown color hat");
		item.setName("hat");
		item.setPrice("3");
		item.setQuantity("5");
		item.setSku("1");
		item.setTax("0.01");

		Items item2 = new Items();
		item2.setCurrency("USD");
		item2.setDescription("Black color hand bag");
		item2.setName("handbag");
		item2.setPrice("15");
		item2.setQuantity("1");
		item2.setSku("product34");
		item2.setTax("0.02");

		List<Items> items = new ArrayList<Items>();
		items.add(item);
		items.add(item2);

		// Item List
		ItemList item_list = new ItemList();
		item_list.setShippingAddress(shipping_address);
		item_list.setItems(items);

		// Set payment options
		PaymentOptions payment_options = new PaymentOptions();
		payment_options.setAllowed_payment_method("INSTANT_FUNDING_SOURCE");

		// Set Transactions
		Transactions transaction = new Transactions();
		transaction.setAmount(amount);
		transaction.setCustom("EBAY_EMS_90048630024435");
		transaction.setDescription("This is the payment transaction description.");
		transaction.setInvoice_number("48787589674");
		transaction.setItem_list(item_list);
		transaction.setPayment_Options(payment_options);
		transaction.setSoft_descriptor("ECHI5786786");

		List<Transactions> transactions = new ArrayList<Transactions>();
		transactions.add(transaction);

		// Set payer
		Payer payer = new Payer();
		payer.setPayment_method("paypal");

		PostPojo postObj = new PostPojo();
		postObj.setIntent("sale");
		postObj.setNote_to_payer("Contact us");
		postObj.setRedirect_urls(red_urls);
		postObj.setPayer(payer);
		postObj.setTransactions(transactions);

		int payment_id = RestAssured.given().
		contentType(ContentType.JSON).
		auth().
		oauth2(accessToken).
		when().
		body(postObj).
		post("/payments/payment").
		then().
		extract().
		path("id");
	}
}
