package pagecomponent;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.aventstack.extentreports.Status;

import utility.WebUtil;

public class FlightBookingPage extends WebUtil {
	
	@FindBy(xpath = "(//div[@class='css-1dbjc4n r-zso239'])[2]")
	WebElement RoundTrip;
	
	@FindBy (xpath = "(//div[@class='css-76zvg2 r-homxoj r-ubezar r-16dba41'])[36]")
	WebElement Return;

	@FindBy (xpath = "(//div[@class='css-76zvg2 css-bfa6kz r-homxoj r-ubezar'])[1]")
	WebElement date;

	@FindBy (xpath = "(//div[@class='css-1dbjc4n r-1awozwy r-1pi2tsx r-1777fci r-13qz1uu'])[29]")
	WebElement DeptDate;

	@FindBy (xpath = "(//input[@type='text'])[1]")
	WebElement From;

	@FindBy (xpath = "(//input[@type='text'])[2]")
	WebElement To;

	@FindBy (xpath = "//div[@data-testid='home-page-flight-cta']")
	WebElement SearchFlight;
	
	@FindBy (xpath = "//div[@data-testid='continue-search-page-cta']")
	WebElement Continue;

	@FindBy(xpath="(//div[@class='css-76zvg2 r-homxoj r-poiln3 r-ubezar'])[2]")
	WebElement title;
	
	@FindBy (xpath = "(//input[@type='text'])[1]")
	WebElement FirstName;

	@FindBy (xpath = "//input[@maxlength='32' and @data-testid='last-inputbox-contact-details']")
	WebElement lastname;

	@FindBy (xpath = "//input[@maxlength='266' and @data-testid='emailAddress-inputbox-contact-details']")
	WebElement emailtext ;

	@FindBy (xpath = "//input[@maxlength='10' and @data-testid='contact-number-input-box']")
	WebElement mobile;

	@FindBy (xpath = "(//div[@class='css-76zvg2 r-qsz3a2 r-poiln3 r-1b43r93 r-16dba41'])[4]")
	WebElement checkbox;
	
	@FindBy(xpath="//div[@data-testid='traveller-info-continue-cta']")
	WebElement Cont;
	
	@FindBy(xpath="(//div[@data-testid=\"add-ons-continue-footer-button\"])[3]")
	WebElement Cont1;
	
	@FindBy(xpath="//div[@class='at_addon_close']")
	WebElement close;
	
	@FindBy(xpath="//div[@class='css-1dbjc4n r-1awozwy r-19m6qjp r-z2wwpe r-1loqt21 r-18u37iz r-1777fci r-6ity3w r-d9fdf6 r-9qu9m4 r-ah5dr5 r-1otgn73']")
	WebElement Cont2;
	
	@FindBy(xpath="//input[@placeholder='Enter Card Number Here']")
	WebElement CardNum;
	
	@FindBy(xpath="//input[@placeholder='Cardholder Name']")
	WebElement CardHolName;
	
	@FindBy(xpath="//input[@placeholder='MM']")
	WebElement MM;
	
	@FindBy(xpath="//input[@placeholder='YY']")
	WebElement YY;
	
	@FindBy(xpath="//input[@placeholder='123']")
	WebElement CVV;
	
	
//	@FindBy (xpath = "//input[@maxlength='15'and @class='css-1cwyjr8 r-homxoj r-poiln3 r-ubezar r-1eimq0t r-1e081e0 r-xfkzu9 r-lnhwgy']")
//	WebElement passportno;
//
//	@FindBy (xpath = "(//input[@placeholder='DD/MM/YYYY'])[2]")
//	WebElement passportvalidity;
//
//	@FindBy (xpath = "(//div[@class='css-76zvg2 r-homxoj r-poiln3 r-edyy15 r-q4m81j'])[93]")
//	WebElement passportyear;
//
//	@FindBy (xpath = "(//div[@class='css-76zvg2 r-homxoj r-poiln3 r-edyy15 r-q4m81j'])[95]")
//	WebElement passportmonth;
//
//	@FindBy (xpath = "(//input[@placeholder='DD/MM/YYYY'])[2]")
//	WebElement passportday;


	public FlightBookingPage(){
		PageFactory.initElements(WebUtil.driver, this);}

	public void flightbooking() {
		try {
			eleClick(RoundTrip);
			sendkeysMethod(From, "HYD");
			expWait(To, 2);
			clearMethod(To);
			sendkeysMethod(To, "DEL");
			impwait();
			eleClick(DeptDate);
			Thread.sleep(500);
			expWait(Return, 2);
			eleClick(Return);
			Thread.sleep(500);
			expWait(SearchFlight, 2);
			eleClick(SearchFlight);
			Thread.sleep(500);
			eleClick(Continue);
			sendkeysMethod(FirstName, "Sachein");
			sendkeysMethod(lastname, "Dinesh");
			sendkeysMethod(emailtext, "sachu@gmail.com");
			sendkeysMethod(mobile, "9876543210");
			eleClick(checkbox);
			eleClick(Cont);
			expWait(Cont1, 2);
			eleClick(Cont1);
			expWait(close, 2);
			eleClick(close);
			eleClick(Cont2);
			Thread.sleep(500);
			eleClick(CardNum);
			sendkeysMethod(CardNum,"5234 7890 9808 9012");
			Thread.sleep(500);
			sendkeysMethod(CardHolName,"Anitha");
			sendkeysMethod(MM,"12");
			sendkeysMethod(YY,"25");
			sendkeysMethod(CVV,"000");
			test.log(Status.INFO, "flightbooking is done");
		} catch (Exception e) {
			test.log(Status.FAIL, "Issue in flightbooking");
			e.printStackTrace();
		}

	}

}
