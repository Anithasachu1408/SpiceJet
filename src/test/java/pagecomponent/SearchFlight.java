package pagecomponent;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import com.aventstack.extentreports.Status;

import utility.WebUtil;

public class SearchFlight extends WebUtil {

	@FindBy(xpath = "(//div[@class='css-1dbjc4n r-zso239'])[2]")
	WebElement RoundTrip;
	
	@FindBy(xpath = "(//div[@class='css-1dbjc4n r-zso239'])[1]")
	WebElement Oneway;
	
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

	@FindBy(xpath="//*[@id=\\\"main-container\\\"]/div/div[1]/div[3]/div[2]/div[3]/div/div[1]/div\"")
	WebElement Delhi;
	
	public SearchFlight() {
		PageFactory.initElements(WebUtil.driver, this);
	}

	public void RoundTrip() throws InterruptedException {
		
		try {
			eleClick(RoundTrip);
			eleClick(From);
			sendkeysMethod(From, "HYD");
			expWait(To, 2);
			eleClick(To);
			clearMethod(To);
			sendkeysMethod(To,"DEL");	
			Thread.sleep(500);
			eleClick(DeptDate);
			Thread.sleep(500);
			expWait(Return, 2);
			eleClick(Return);
			Thread.sleep(500);
			expWait(SearchFlight, 2);
			eleClick(SearchFlight);
			test.log(Status.INFO, "RoundTrip is done");
		} catch (InterruptedException e) {
			test.log(Status.FAIL, "Issue in RoundTrip");
			e.printStackTrace();
		}
		
	}
	
	public void Oneway() throws InterruptedException {
		try {
			eleClick(Oneway);
			sendkeysMethod(From,"HYD");
			expWait(To, 2);
			eleClick(To);
			clearMethod(To);
			sendkeysMethod(To,"DEL");
			Thread.sleep(500);
			eleClick(DeptDate);
			Thread.sleep(500);
			expWait(SearchFlight, 2);
			eleClick(SearchFlight);
			test.log(Status.INFO, "Oneway is done");
		} catch (InterruptedException e) {
			test.log(Status.FAIL, "Issue in Oneway");
			e.printStackTrace();
		}
		
	}
	
}
