package pagecomponent;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;

import utility.WebUtil;

public class SignUpPage extends WebUtil{
	
	@FindBy(xpath="(//div[@class='css-1dbjc4n r-1jkjb'])[2]")
	WebElement Signup;
	
	@FindBy(xpath="//select[@class='form-control form-select ']")
	WebElement title;
	
	@FindBy(xpath="//input[@id='first_name']")
	WebElement FirstName;
	
	@FindBy(xpath="//input[@id='last_name']")
	WebElement LastName;
	
	@FindBy(xpath="//select[@class='form-control form-select']")
	WebElement country;
	
	@FindBy(xpath="//input[@id='dobDate']")
	WebElement DOB;
	
	@FindBy(xpath="//input[@type='tel']")
	WebElement MobNum;
	
	@FindBy(xpath="/html/body/div[2]/div/div/div[2]/div[2]/div/div[1]/div[4]/div[2]/input")
	WebElement email;
	
	@FindBy(xpath="(//input[@type='password'])[1]")
	WebElement password;
	
	@FindBy(xpath="(//input[@type='password'])[2]")
	WebElement ConfirmPassword;
	
	@FindBy(xpath="//input[@type='checkbox']")
	WebElement tick;
	
	@FindBy(xpath="//button[@type='button']")
	WebElement submit;
	
	public SignUpPage() {
		PageFactory.initElements(WebUtil.driver, this);
	}
	
	@Test
	public void SignUp() throws InterruptedException {
		try {
			eleClick(Signup);
			windowHandles();
			expWait(title, 2);
			eleClick(title);
			dropDownMethodwithText(title,"Mrs");
			expWait(FirstName, 2);
			sendkeysMethod(FirstName,"Anitha");
			expWait(LastName, 2);
			sendkeysMethod(LastName,"Kothandapani");
			expWait(country, 2);
			eleClick(country);
			dropDownMethodwithText(country,"IN");
			expWait(DOB, 2);
			sendkeysMethod(DOB,"08/14/1993");
			expWait(MobNum, 2);
			sendkeysMethod(MobNum,"9952855426");
			Thread.sleep(5000);
			expWait(password, 2);
			sendkeysMethod(password,"Anitha@143");
			Thread.sleep(5000);
			expWait(ConfirmPassword, 2);
			sendkeysMethod(ConfirmPassword,"Anitha@143");
			Thread.sleep(5000);
			expWait(email, 2);
			sendkeysMethod(email,"anitamil1408@gmail.com");
			Thread.sleep(5000);
			expWait(tick, 2);
			eleClick(tick);
			Thread.sleep(5000);
			expWait(submit, 2);
			eleClick(submit);
			test.log(Status.INFO, "Signup is done");
		} catch (InterruptedException e) {
			test.log(Status.FAIL, "Issue in Signup");
			e.printStackTrace();
		}
	}

}
