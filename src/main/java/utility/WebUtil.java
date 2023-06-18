package utility;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;
import java.util.Set;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

import io.github.bonigarcia.wdm.WebDriverManager;

public class WebUtil extends FileUtil {

	public static WebDriver driver;
	
	public static ExtentHtmlReporter htmlreporter;
	public static ExtentReports reports;
	public static ExtentTest test;
	
	
	public static void startReport() {
		htmlreporter = new ExtentHtmlReporter(System.getProperty("user.dir") + "/AutomationTestReport.html");
		reports = new ExtentReports();
		reports.attachReporter(htmlreporter);
	}

	public static void stopReport() {
		reports.flush();
	}
	
	
	public static boolean browser(String name) {
		boolean flag = false;

		try {
			switch (name) {

			case "Chrome":
				WebDriverManager.chromedriver().setup();
				driver = new ChromeDriver();
				flag = true;
				test.log(Status.PASS, "Chrome is launched.");
				break;
			case "Edge":
				WebDriverManager.edgedriver().setup();
				driver = new EdgeDriver();
				flag = true;
				test.log(Status.PASS, "Edge is launched.");
				break;
			case "FireFox":
				WebDriverManager.firefoxdriver().setup();
				driver = new FirefoxDriver();
				flag = true;
				test.log(Status.PASS, "Firefox is launched.");
				break;
			case "Safari":
				WebDriverManager.safaridriver().setup();
				driver = new SafariDriver();
				flag = true;
				test.log(Status.PASS, "Safari is launched.");
				break;
			}
		} catch (Exception e) {
			test.log(Status.FAIL, "Issue in opening a browser." + e.getMessage());
		}
		return flag;

	}

	public void PageOpen(String Weblink) {
		try {
			driver.get(Weblink);
			test.log(Status.PASS, "PageOpen Successful");
		} catch (Exception e) {
			test.log(Status.FAIL, "PageOpen Failed");
			e.printStackTrace();
		}
	}

	public void BrowserMax() {
		try {
			driver.manage().window().maximize();
			test.log(Status.PASS, "BrowserMax Successful");
		} catch (Exception e) {
			test.log(Status.FAIL, "BrowserMax Failed");
			e.printStackTrace();
		}
	}

	public String Gettitle(WebElement ele) {
		String val = null;
		try {
			val = driver.getTitle();
			test.log(Status.PASS, "Gettitle Successful");
		} catch (Exception e) {
			test.log(Status.FAIL, "Gettitle Failed");
			e.printStackTrace();
		}
		return val;
	}

	public void impwait() {
		try {
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
			test.log(Status.PASS, "impwait Successful");
		} catch (Exception e) {
			test.log(Status.FAIL, "impwait Failed");
			e.printStackTrace();
		}
	}

	public void expWait(WebElement ele, int timer) {
		try {
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timer));
			wait.until(ExpectedConditions.visibilityOf(ele));
			test.log(Status.PASS, "expWait Successful");
		} catch (Exception e) {
			test.log(Status.FAIL, "expWait Failed");
			e.printStackTrace();
		}

	}

	public void eleClick(WebElement ele) {
		try {
			ele.click();
			test.log(Status.PASS, "eleClick Successful");
		} catch (Exception e) {
			test.log(Status.FAIL, "eleClick Failed");
			e.printStackTrace();
		}

	}

	public void sendkeysMethod(WebElement ele, String value) {
		try {
			ele.sendKeys(value);
			test.log(Status.PASS, "sendkeysMethod Successful");
		} catch (Exception e) {
			test.log(Status.FAIL, "sendkeysMethod Failed");
			e.printStackTrace();
		}
	}
	
	public boolean isPresentMethod(WebElement ele) {
		boolean flag = false;
		try {
			 ele.isDisplayed();
			 test.log(Status.PASS, "isPresentMethod Successful");
		} catch (Exception e) {
			test.log(Status.FAIL, "isPresentMethod Failed");
			e.printStackTrace();
		}
		return flag;
		
	}
	
	public void navigateback() {
		try {
			driver.navigate().back();
			test.log(Status.PASS, "navigateback Successful");
		} catch (Exception e) {
			test.log(Status.FAIL, "navigateback Failed");
			e.printStackTrace();
		}
	}
	
	public String getTextMethod(WebElement ele) {
		String val = null;
		try {
			val= ele.getText();
			test.log(Status.PASS, "getTextMethod Successful");
		} catch (Exception e) {
			test.log(Status.FAIL, "getTextMethod Failed");
			e.printStackTrace();
		};
		return val;
	}
	
	public String getTitleMethod(WebElement ele) {
		String val = null;
		try {
			val= driver.getTitle();
			test.log(Status.PASS, "getTitleMethod Successful");
		} catch (Exception e) {
			test.log(Status.FAIL, "getTitleMethod Failed");
			e.printStackTrace();
		};
		return val;
	
	}

	public void BrowserClose() {
		try {
			driver.close();
			test.log(Status.PASS, "BrowserClose Successful");
		} catch (Exception e) {
			test.log(Status.FAIL, "BrowserClose Failed");
			e.printStackTrace();
		}
	}
		
		public void dropDownMethodwithText(WebElement ele, String txt) {
			try {
				Select sel = new Select(ele);
				sel.selectByVisibleText(txt);
				test.log(Status.INFO, "dropDownMethodwithText is done");
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}  test.log(Status.FAIL, "Issue in dropDownMethodwithText");
		}
		

		public void dropDownMethodwithIndex(WebElement ele, int index) {
			try {
				Select sel = new Select(ele);
				sel.selectByIndex(index);
				test.log(Status.INFO, "dropDownMethodwithIndex is done");
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}test.log(Status.FAIL, "Issue in dropDownMethodwithIndex");
		}
		
		public static boolean windowHandles() {
			boolean flag = false;
			try {
				Set<String> alldata = driver.getWindowHandles();
				for (String data: alldata) {
				driver.switchTo().window(data).getTitle();	
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
			return flag;
		}
			
			public void clearMethod(WebElement element) {
				element.clear();
			}




	
	
	public static String getScreenShot(String screenshotName) throws IOException {
		String dateName = new SimpleDateFormat("yyyyMMddhhmmss").format(new Date());
		TakesScreenshot ts = (TakesScreenshot) driver;
		File source = ts.getScreenshotAs(OutputType.FILE);
		String destination = System.getProperty("user.dir") + "/Screenshots/" + screenshotName + dateName + ".png";
		File finalDestination = new File(destination);
		FileUtils.copyFile(source, finalDestination);
		return destination;
	}

}
