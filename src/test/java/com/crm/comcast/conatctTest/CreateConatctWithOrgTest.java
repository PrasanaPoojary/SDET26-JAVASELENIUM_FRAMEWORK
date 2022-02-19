package com.crm.comcast.conatctTest;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

import comcast.crm.SDET_26.GenericUtility.ExcelUtility;
import comcast.crm.SDET_26.GenericUtility.FileUtility;
import comcast.crm.SDET_26.GenericUtility.JavaUtility;
import comcast.crm.SDET_26.GenericUtility.WebDriverUtility;

public class CreateConatctWithOrgTest {
	public static void main(String[] args) throws Throwable {
		JavaUtility jLib = new JavaUtility();
		WebDriverUtility wLib = new WebDriverUtility();
        FileUtility fLib = new FileUtility();
		ExcelUtility eLib = new ExcelUtility();
		
		String BROWSER =fLib.getPropertyKeyValue("BROWSER");
		String URL =fLib.getPropertyKeyValue("URL");
		String USERNAME =fLib.getPropertyKeyValue("USERNAME");
		String PASSWORD=fLib.getPropertyKeyValue("PASSWORD");
		
		System.out.println(URL);
		
		/* get ramDomData */ 
		int randomNum = jLib.getRanDomNumber();
		System.out.println(randomNum);
		
		/* read test data from excel file */
		String orgName = eLib.getDataFromExcel("Sheet1", 2, 3) + randomNum; 
		String conactName = eLib.getDataFromExcel("Sheet1", 2, 4) + randomNum;
		
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
	driver.findElement(By.name("user_name")).sendKeys(USERNAME);
	driver.findElement(By.name("user_password")).sendKeys(PASSWORD);
	driver.findElement(By.id("submitButton")).click();
	/* step 1 : navigate to Org Page */
	driver.findElement(By.linkText("Organizations")).click();
	
	/* step 2 : navigate to CREATE Org Page*/
	driver.findElement(By.xpath("//img[@title='Create Organization...']")).click();
	

	driver.findElement(By.name("accountname")).sendKeys(orgName);
	driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
	
	
	WebElement headerWb = driver.findElement(By.className("dvHeaderText"));
		

	wLib.waitForElemnetToBeClickAble(driver, headerWb);
	
	/* step 4 : navigate to Contact Page */
	driver.findElement(By.linkText("Contacts")).click();
	
	/* step 5 : navigate to CREATE Coantct Page*/
	driver.findElement(By.xpath("//img[@title='Create Contact...']")).click();
	
	/* step 6 : create a new contact With org Name */
	
	driver.findElement(By.name("lastname")).sendKeys(conactName);
	driver.findElement(By.xpath("//input[@name='account_id']/following-sibling::img")).click();
	wLib.swithToWindow(driver, "Accounts");
	
	driver.findElement(By.name("search_text")).sendKeys(orgName);
	driver.findElement(By.name("search")).click();
	driver.findElement(By.xpath("//a[text()='"+orgName+"']")).click(); wLib.swithToWindow(driver, "Contacts");
	driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
	wLib.mouseOverOnElemnet(driver,driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']")));
	driver.findElement(By.linkText("Sign Out")).click();
	driver.close();
	}
}