package pagecomponent;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.aventstack.extentreports.Status;

import utility.WebUtil;

public class LoginPage extends WebUtil {

	@FindBy(xpath="(//div[@class='css-1dbjc4n r-1jkjb'])[1]")
	WebElement Login;
	
	@FindBy(xpath="(//div[@class=\"css-1dbjc4n r-zso239\"])[4]")
	WebElement Email;
	
	@FindBy(xpath="//input[@type='email']")
	WebElement typeemailid;
	
	@FindBy(xpath="//input[@type='password']")
	WebElement Password;
	
	@FindBy(xpath="//div[@class='css-1dbjc4n r-1awozwy r-184aecr r-z2wwpe r-1loqt21 r-18u37iz r-tmtnm0 r-1777fci r-1x0uki6 r-1w50u8q r-ah5dr5 r-1otgn73']")
	WebElement Submit;
	
	public LoginPage() {
		PageFactory.initElements(WebUtil.driver, this);
	}
	
	public void Login() {
		try {
			eleClick(Login);
			expWait(Email, 2);
			eleClick(Email);
			sendkeysMethod(typeemailid,"sachu1408@gmail.com");
			sendkeysMethod(Password,"Sachu@123");
			eleClick(Submit);
			test.log(Status.INFO, "Login is done");
		} catch (Exception e) {
			test.log(Status.FAIL, "Issue in Login");
			e.printStackTrace();
		}
	}
	
}
