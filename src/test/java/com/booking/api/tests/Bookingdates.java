package com.booking.api.tests;

public class Bookingdates {
	
	String checkin;
	String checkout;
	public Bookingdates() {
		
		
	}
	public Bookingdates(String checkin, String checkout) {
	
		this.checkin = checkin;
		this.checkout = checkout;
	}
	public String getCheckin() {
		return checkin;
	}
	public void setCheckin(String checkin) {
		this.checkin = checkin;
	}
	public String getCheckout() {
		return checkout;
	}
	public void setCheckout(String checkout) {
		this.checkout = checkout;
	}
	
	

}
