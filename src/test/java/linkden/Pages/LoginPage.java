package linkden.Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;



public class LoginPage {

	//Page setup
		WebDriver oDriver;
		ExtentReports oExtentReport;
		ExtentTest oExtentTest;
		
		
		
		public LoginPage(WebDriver oDriver, ExtentReports oExtentReport, ExtentTest oExtentTest ) {
		 this.oDriver = oDriver;
		 this.oExtentReport = oExtentReport;
		 this.oExtentTest = oExtentTest;
		 
		
		}

		//Objects
		By Username = By.xpath("//input[@id='username']");
	 
		By Password = By.xpath("//input[@id='password']");
		
		By ButtonSubmit = By.xpath("//form/div[3]/button[@type='submit']");
		
		//UI Methods
		
		public boolean fLogintoLinkdden()  {
			try {
			
				WebElement username = oDriver.findElement(Username);
				WebElement password = oDriver.findElement(Password);
				WebElement buttonSubmit = oDriver.findElement(ButtonSubmit);
				
				username.sendKeys("jaria910@gmail.com");
				password.sendKeys("uytrg");
				buttonSubmit.click();
				
				Thread.sleep(500); 
				String tittle=oDriver.getTitle();
				if(tittle.contains("LinkedIn")) {
					oExtentTest.log(LogStatus.PASS,"Login to Linkdden");
					return true;
				}
				else {
					oExtentTest.log(LogStatus.FAIL,"Login to Linkdden");
					return false;
				}
			
			} 
			catch (Exception e) {
				// TODO: handle exception
				e.printStackTrace();
				System.out.println(e);
				oExtentTest.log(LogStatus.FAIL,"Login to Linkdden");
				return false;
			}
				
		}
		
	
}
