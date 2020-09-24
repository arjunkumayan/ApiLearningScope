package com.booking.api.tests;

// POJO Class

public class Booking {
	
	// Static int age; - never use static in object because this is not part of object and not participated in serialization
	// can we pass static in serialization in NO
	// Object can not hold static 
	
	String firstname;
	String lastname;
	int totalprice;
	boolean depositpaid;
	String additionalneeds;
	Bookingdates bookingdates;
	
	public Booking() {
		
		
	}

	public Booking(String firstname, String lastname, int totalprice, boolean depositpaid, String additionalneeds,Bookingdates bookingdates) {
		
		this.firstname = firstname;
		this.lastname = lastname;
		this.totalprice = totalprice;
		this.depositpaid = depositpaid;
		this.additionalneeds = additionalneeds;
		this.bookingdates = bookingdates;
	}
	
	

	public Booking(String firstname, String lastname, int totalprice) {
	
		this.firstname = firstname;
		this.lastname = lastname;
		this.totalprice = totalprice;
	}

	public String getFirstname() {
		return firstname;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	public int getTotalprice() {
		return totalprice;
	}

	public void setTotalprice(int totalprice) {
		this.totalprice = totalprice;
	}

	public boolean isDepositpaid() {
		return depositpaid;
	}

	public void setDepositpaid(boolean depositpaid) {
		this.depositpaid = depositpaid;
	}

	public String getAdditionalneeds() {
		return additionalneeds;
	}

	public void setAdditionalneeds(String additionalneeds) {
		this.additionalneeds = additionalneeds;
	}

	public Bookingdates getBookingdates() {
		return bookingdates;
	}

	public void setBookingdates(Bookingdates bookingdates) {
		this.bookingdates = bookingdates;
	}
	
	
	
	

}
