package testcomponent;

import org.testng.annotations.Test;

import enginecomponent.Base;
import pagecomponent.FlightBookingPage;
import pagecomponent.LoginPage;
import pagecomponent.PassengersPage;
import pagecomponent.SearchFlight;
import pagecomponent.SignUpPage;
import pagecomponent.ValidateFields;
@Test
public class SmokeTesting extends Base{
	@Test
	public void test01() throws InterruptedException {
		SignUpPage obj = new SignUpPage();
		obj.SignUp();
	}
	@Test
	public void test02() {
		LoginPage obj = new LoginPage();
		obj.Login();
	
	}
	@Test
	public void test03() throws InterruptedException {
		SearchFlight obj = new SearchFlight();
		obj.RoundTrip();
	}
	@Test
	public void test04() throws InterruptedException {
		SearchFlight obj = new SearchFlight();
		obj.Oneway();
}
	@Test
	public void test05()throws InterruptedException {
	PassengersPage obj = new PassengersPage();
	obj.passengers();
}
	@Test
	public void test06() {
		FlightBookingPage obj = new FlightBookingPage();
		obj.flightbooking();
	}
	@Test
	public void test07() {
		ValidateFields obj = new ValidateFields();
		obj.Fields();
	
	}
}
