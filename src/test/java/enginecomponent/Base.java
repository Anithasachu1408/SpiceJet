package enginecomponent;

import java.io.IOException;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import utility.WebUtil;

public class Base extends WebUtil{
	@BeforeSuite
	public void beforesuite() {
		startReport();
	}
	
	@BeforeMethod
	
	public void beforeTest() throws IOException {
		
		test = reports.createTest("Testcase");
		browser(readProperty("browser"));
		BrowserMax();
		impwait();
		PageOpen(readProperty("url"));
		
	}
	@AfterMethod
	public void afterTest() {
		BrowserClose();	
	}
  
	@AfterSuite
	public void afterSuite() {
		stopReport();
	}
}
