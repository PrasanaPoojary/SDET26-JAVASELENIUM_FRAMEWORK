package com.crm.comcast.organaizationtest;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

import com.crm.comcast.objectrepositoryUtility.CreateOrganizationPage;
import com.crm.comcast.objectrepositoryUtility.HomePage;
import com.crm.comcast.objectrepositoryUtility.Login;
import com.crm.comcast.objectrepositoryUtility.OrganizationInfoPage;
import com.crm.comcast.objectrepositoryUtility.OrganizationPage;

import comcast.crm.SDET_26.GenericUtility.BaseAnnotationClass;
import comcast.crm.SDET_26.GenericUtility.ExcelUtility;
import comcast.crm.SDET_26.GenericUtility.FileUtility;
import comcast.crm.SDET_26.GenericUtility.JavaUtility;
import comcast.crm.SDET_26.GenericUtility.WebDriverUtility;

public class CheckWhileCreatingNewOrganizationTypeDropdownOptionIsWorkingOrNot extends BaseAnnotationClass {
	public static void main(String[] args) throws Throwable {
		JavaUtility jLib = new JavaUtility();
		WebDriverUtility wLib = new WebDriverUtility();
        FileUtility fLib = new FileUtility();
		ExcelUtility eLib = new ExcelUtility();
		
		/* get ramDomData */ 
		int randomNum = jLib.getRanDomNumber();
		 
		/**
		 * read the data from property file
		 */
		String BROWSER =fLib.getPropertyKeyValue("BROWSER");
		String URL =fLib.getPropertyKeyValue("URL");
		String USERNAME =fLib.getPropertyKeyValue("USERNAME");
		String PASSWORD=fLib.getPropertyKeyValue("PASSWORD");
		
		/* read test data from excel file */
		String orgName = eLib.getDataFromExcel("Sheet1", 2, 3) + randomNum; 
		String conactName = eLib.getDataFromExcel("Sheet1", 2, 5) + randomNum;
		String IndustryType= eLib.getDataFromExcel("Sheet1", 2, 2 );
		String Type =eLib.getDataFromExcel("Sheet1",2,4);

		/* launch the Browser */
		WebDriver driver = null;
		if(BROWSER.equals("chrome")) {
		driver = new ChromeDriver();
		}else if(BROWSER.equals("firefox")){
		driver = new FirefoxDriver();
		}else if(BROWSER.equals("ie")){
		driver = new InternetExplorerDriver();
		}else {
		driver = new ChromeDriver();
		}
		wLib.waitForPageToLoad(driver);
		driver.get(URL);
		/* step 1 : login to APP */
		Login lp =new Login(driver);
	    lp.loginToApp(URL, USERNAME, PASSWORD);
	    
	    /*navigate to Org Page*/   
	    HomePage hp =new  HomePage(driver);
	    hp.getOrganizationLink().click();;
	    
	    /* step 3 : navigate to create Org page */ 
	    OrganizationPage op = new OrganizationPage(driver);
	    op.getCreateOrganizationIMG().click();
	    
	    /* create a new Org */
	    CreateOrganizationPage cop = new CreateOrganizationPage(driver);
	    WebElement td = cop.getTypeDropDown();
	    
	    /* Verfication */
	    boolean Result = td.isEnabled();
	   if(Result) {
		   System.out.println(">Type Drop Down Option is working>>>>>>PASS");
	   }
	   else
	   {
		   System.out.println( ">Type Drop Down Option is not working>>>>>>Fail");
	   }
	   /* step 5 : logout */ 
	   hp.signOut();
	   driver.quit();
	}
}


	
