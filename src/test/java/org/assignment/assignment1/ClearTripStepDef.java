package org.assignment.assignment1;

import org.openqa.selenium.WebDriver;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;

public class ClearTripStepDef {
	 WebDriver driver;
	private ClearTripPage ClTrip;
	private AmazonPage Amazon;
	public ClearTripStepDef(WebDriver driver) {
		driver=this.driver;
		this.ClTrip=new ClearTripPage();
		this.Amazon=new AmazonPage();
	}
	
	public ClearTripStepDef() {
		
	}
	
	@Given("^Karan books flight in ClearTrip website$")
	public void Karan_books_flight_in_ClearTrip_website() throws Throwable {
		this.ClTrip=new ClearTripPage();
		ClTrip.flightBooking(driver);
	  
	}
	
	@Given("^Karan purhcases Book in Amazon$")
	public void karan_purhcases_Book_in_Amazon() throws Throwable {
		this.Amazon=new AmazonPage();
		Amazon.AmazonShopping(driver);
	   
	}

	@Then("^My Process is completed$")
	public void my_Process_is_completed() throws Throwable {
	  System.out.println("My Process is completed");
	}
	
	@Given("^Karan keeps a track of the expense in excel sheet$")
	public void karan_keeps_a_track_of_the_expense_in_excel_sheet() throws Throwable {
		this.Amazon=new AmazonPage();
		Amazon.BudgetEstimation();
	   
	}

}
