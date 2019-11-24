package linkden.Pages;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Keyboard;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;


public class FeedPage {
	//Page setup
			WebDriver oDriver;
			ExtentReports oExtentReport;
			ExtentTest oExtentTest;
			
			
			
			public FeedPage(WebDriver oDriver, ExtentReports oExtentReport, ExtentTest oExtentTest ) {
			 this.oDriver = oDriver;
			 this.oExtentReport = oExtentReport;
			 this.oExtentTest = oExtentTest;
			 
			
			}

			//Objects
			By SearchBox = By.xpath("//div[@id='ember30']/input");
			By Content =By.xpath("//button/span[text()='Content']");
			By Contenttile = By.xpath("//ul/li[@class='search-content__result search-entity ember-view']/div");


			
			//Actions
			
			public boolean fSearchByContent() throws InterruptedException {
				
				Thread.sleep(500);
				try {
					
					WebElement searchBox = oDriver.findElement(SearchBox);
				//	WebElement content = oDriver.findElement(Content);
				//	WebElement contenttile = oDriver.findElement(Contenttile);
					
					searchBox.sendKeys("SDET");
					searchBox.sendKeys(Keys.ENTER);
					Thread.sleep(500); 
					oDriver.switchTo().defaultContent();
					WebDriverWait wait=new WebDriverWait(oDriver,100);
					WebElement content = wait.until(ExpectedConditions.visibilityOfElementLocated(Content));
					content.click();
					
					Thread.sleep(500);
					
				   oExtentTest.log(LogStatus.PASS,"search by content");
						return true;
									
				} 
				catch (Exception e) {
					// TODO: handle exception
					e.printStackTrace();
					System.out.println(e);
					oExtentTest.log(LogStatus.FAIL,"search by content");
					return false;
				}
			}
			
public boolean fGetCOntent() throws InterruptedException {
	try {
		
	long i=System.currentTimeMillis();
	long j=0;
	while(j<9000) {
		JavascriptExecutor js = (JavascriptExecutor) oDriver;
         //This will scroll the web page till end.		
        js.executeScript("window.scrollTo(0, document.body.scrollHeight)");
	    j=System.currentTimeMillis()-i;	
	}
	
	List<WebElement> contenttile = oDriver.findElements(Contenttile);
	
	List<String> all_elements_text=new ArrayList<>();
	System.out.println(contenttile.size());

    for (WebElement webElement : contenttile) {
        String name = webElement.getText();
        all_elements_text.add(webElement.getText());
        System.out.println(name);
    }
   
        oExtentTest.log(LogStatus.PASS,"Get Content from Result");
		return true;
					
} 
catch (Exception e) {
	// TODO: handle exception
	e.printStackTrace();
	System.out.println(e);
	oExtentTest.log(LogStatus.FAIL,"Get Content from Result");
	return false;
}
	
	}
	
				
				


	
	
	
}

