package pagecomponent;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.aventstack.extentreports.Status;

import utility.WebUtil;

public class PassengersPage extends WebUtil {

	@FindBy(xpath = "(//div[@class='css-1dbjc4n r-zso239'])[2]")
	WebElement RoundTrip;

	@FindBy(xpath = "(//div[@class='css-76zvg2 r-homxoj r-ubezar r-16dba41'])[36]")
	WebElement Return;

	@FindBy(xpath = "(//div[@class='css-76zvg2 css-bfa6kz r-homxoj r-ubezar'])[1]")
	WebElement date;

	@FindBy(xpath = "(//div[@class='css-1dbjc4n r-1awozwy r-1pi2tsx r-1777fci r-13qz1uu'])[29]")
	WebElement DeptDate;

	@FindBy(xpath = "(//input[@type='text'])[1]")
	WebElement From;

	@FindBy(xpath = "(//input[@type='text'])[2]")
	WebElement To;

	@FindBy(xpath = "//div[@data-testid='home-page-flight-cta']")
	WebElement SearchFlight;

	@FindBy(xpath = "//div[@data-testid='continue-search-page-cta']")
	WebElement Continue;

	@FindBy(xpath = "(//div[@class='css-76zvg2 r-homxoj r-poiln3 r-ubezar'])[2]")
	WebElement title;

	@FindBy(xpath = "(//input[@type='text'])[1]")
	WebElement FirstName;

	@FindBy(xpath = "//input[@maxlength='32' and @data-testid='last-inputbox-contact-details']")
	WebElement lastname;

	@FindBy(xpath = "//input[@maxlength='266' and @data-testid='emailAddress-inputbox-contact-details']")
	WebElement emailtext;

	@FindBy(xpath = "//input[@maxlength='10' and @data-testid='contact-number-input-box']")
	WebElement mobile;

	@FindBy(xpath = "(//div[@class='css-76zvg2 r-qsz3a2 r-poiln3 r-1b43r93 r-16dba41'])[4]")
	WebElement checkbox;

	@FindBy(xpath = "//div[@data-testid='traveller-info-continue-cta']")
	WebElement Cont;

	public PassengersPage() {
		PageFactory.initElements(WebUtil.driver, this);
	}

	public void passengers() throws InterruptedException {

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
			test.log(Status.INFO, "passengers information is done");
		} catch (InterruptedException e) {
			test.log(Status.FAIL, "Issue in passengers information");
			e.printStackTrace();
		}

	}
}
