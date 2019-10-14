package CrossBrowserData_ParameterPac;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class OpenBrowser_CrossBrowserDataParameter {
	WebDriver driver;
	@Parameters("browser")
	@BeforeTest
	public void openBrowser(String browsername) throws Exception {
		if (browsername.equalsIgnoreCase("Firefox")) {
			System.setProperty("webdriver.gecko.driver", "C:\\\\ITTraining\\\\AllDriver\\\\geckodriver.exe");
			driver=new FirefoxDriver();	
		}
		else if(browsername.equalsIgnoreCase("IE")) {
			System.setProperty("webdriver.ie.driver", "C:\\\\ITTraining\\\\AllDriver\\\\IEDriverServer.exe");
			driver=new InternetExplorerDriver();
		}
		
		else if(browsername.equalsIgnoreCase("Chrome")) {
			System.setProperty("webdriver.chrome.driver", "C:\\\\ITTraining\\\\AllDriver\\\\chromedriver.exe");
			driver=new ChromeDriver();
		}
		
		else {
			throw new Exception("Wrong object type");
		}
		
	}

	@Test
	public void facebookSignUp( ){

		driver.get("https://www.facebook.com/");

		driver.findElement(By.name("firstname")).sendKeys("Parveen");
		driver.findElement(By.name("lastname")).sendKeys("Sultana");
		driver.findElement(By.name("reg_email__")).sendKeys("sultana@yahoo.com");
		driver.findElement(By.name("reg_email_confirmation__")).sendKeys("sultana@yahoo.com");
		driver.findElement(By.name("reg_passwd__")).sendKeys("sul2123");
		driver.findElement(By.id("month")).sendKeys("May");
		driver.findElement(By.id("day")).sendKeys("20");
		driver.findElement(By.id("year")).sendKeys("1990");

		WebDriverWait wait=new WebDriverWait(driver, 20);
		wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.id("u_0_9"))));
		driver.findElement(By.id("u_0_9")).click();
	}
	//@AfterTest
		public void closeBrowser(){
			driver.close();
			driver.quit();
		}
}


