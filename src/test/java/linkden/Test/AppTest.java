package linkden.Test;

import org.testng.Assert;
import org.testng.annotations.Test;

import linkden.Pages.FeedPage;
import linkden.Pages.LoginPage;



public class AppTest extends MyTestNGBaseClass{
	
static DataDriver obj = new DataDriver();
	
	@Test
	public void validation() throws Throwable{
	
		oExtentTest= oExtentReport.startTest("Search Content on linkden");
		
	System.out.println("sdfdsf sdfdf");
	
	LoginPage obj = new LoginPage(oDriver, oExtentReport, oExtentTest);
	Assert.assertTrue(obj.fLogintoLinkdden());
	
	FeedPage obj2 = new FeedPage(oDriver, oExtentReport, oExtentTest);
	Assert.assertTrue(obj2.fSearchByContent());
	Assert.assertTrue(obj2.fGetCOntent());
}
}
