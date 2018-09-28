package com.autofusion.test;

import org.testng.ITestContext;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Listeners;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.autofusion.BaseClass;
import com.autofusion.mobile.page.HamburgerMenuPage;
import com.autofusion.pages.HomePage;
import com.autofusion.pages.LoginPage;
import com.autofusion.pages.LogoutPage;
import com.autofusion.report.ReportListener;
import com.relevantcodes.extentreports.ExtentTest;

@Listeners(ReportListener.class)			
 
public class HomePageTest extends BaseClass{
	  
  /***************** Define the page class object here ******************/

  public HomePage objHomePage ;
  public LoginPage objLoginPage ;
  public LogoutPage objLogoutPage;
  /*************************************************/

  public ExtentTest extentParentNode;
	  

	 /* **************    IMPORTANT INITIALIZATIONS **************    
	  * 
	  * Enable this code if user is passing the params from testng.xml and execute the test via testng.xml
	  * 
	  * 
	  * 
	   
  	  @BeforeSuite
	  @Parameters({ "browser", "executionEnviroment", "runOnMachine","projectPath","device","releaseVersion"})
	  public void setUpRequriedParam(String browser, String environment, String runOnMachine, String projectPath, String device, String releaseVersion){
		  	BaseClass.browser = browser;
		  	BaseClass.executionEnviroment = environment;
		  	BaseClass.runOnMachine = runOnMachine;
		  	BaseClass.projectPath = projectPath;
		  	BaseClass.device = device;
		  	BaseClass.releaseVersion = releaseVersion;
	  }/**/
	  
	  @BeforeClass
	  public void getSuitName(ITestContext ctx){
	       runningSuitName = ctx.getSuite().getName();
	  }
	  
	  @BeforeTest()
	   public void setUp() {
		  super.initializeReportObject();
		  super.getWebDriver();
		  
		  /***************** Change the suite name here ******************/

		  extentParentNode = reportObj.startTest("LoginSuite").assignCategory("Regression");
		  
		  /*************************************************/

	  }
	  
	  public void startReport(String testDesc){
 		  reportTestObj = reportObj.startTest(testDesc);
		  /***************** Change the class here ******************/
		  objHomePage = new HomePage(reportTestObj, APP_LOG);
		  objLogoutPage = new LogoutPage(extentParentNode, APP_LOG);
		  BaseClass.loadPage(HomePage.class);
		  /***********************************************************/
	  }
	  
	  
	 @AfterMethod
	  public void endReport(){
		 try{
			extentParentNode.appendChild(reportTestObj);
		  	reportObj.endTest(extentParentNode);
		  	reportTestObj = null;
		 }catch(Exception e){
			 APP_LOG.debug("endReport : "+e);
		 }
	  }
	 @AfterTest
	  public void tearDown() {
	      appiumDriver.quit();
	      reportObj.endTest(reportTestObj);
	      reportObj.flush();
	  }
	 /***********************************************************************************************/
	 
	 
	  /*********************Define the test cases below ****************************/

	 @Test(enabled = true, description="Search User")
	  public void testSearchUser() throws InterruptedException{
		  startReport("Search User");
		  objHomePage.doSearch("nitin.singh");
		  
	  }
	 
	  
	 @Test(enabled = true, description="click on any link")
	  public void clickonlink() throws InterruptedException{
		  startReport("click on any link");
		  objHomePage.Clickonanylink();
	  }
	  
	 @Test(enabled = true, description="Verify scroll element")
	  public void Verifyscrollelement() throws InterruptedException{
		  startReport("Verify the scroll element");
		  objHomePage.Verifyscroll();
	 }
		  
	  
	 @Test(enabled = true, description="close the browser")
	  public void Verifyusername() throws InterruptedException{
		  startReport("close the browser");
		  objHomePage.Closebrowser();
		  
	  }
	 
	 @Test(enabled = true, description="Click on Myprofile")
	  public void CloseThebrowser() throws InterruptedException{
		  startReport("Click on profile");
		  objHomePage.ClickonMyprofile();
		  
	  }
	 @Test(enabled = true, description="Verify edit")
	  public void verifyedit() throws InterruptedException{
		  startReport("Verify edit");
		  objHomePage.ClickonEdit();
	 }
	 @Test(enabled = true, description="Verify PHNno is present")
	  public void PHNnoispresent() throws InterruptedException{
		  startReport("Verify PHNno is present");
		  objHomePage.Verifyphnnopresent("9990616693");	  
	  }
	 @Test(enabled = true, description="Verify PHNno is not present")
	  public void PHNnoisNOTpresent() throws InterruptedException{
		  startReport("Verify PHNno is present");
		  objHomePage.Verifyphnnopresent("9990616693");	  
	  }
	 
	 @Test(enabled = true, description="Logout")
	  public void testLogout() throws InterruptedException{
		  startReport("Logout");
		  objHomePage.doVerification("nitin.singh");
		  objLogoutPage.clickLogoutImage();
		  objLoginPage = objLogoutPage.clickLogout();
		  
		  
		  
	  }
	  
	   
	 
	 
}
