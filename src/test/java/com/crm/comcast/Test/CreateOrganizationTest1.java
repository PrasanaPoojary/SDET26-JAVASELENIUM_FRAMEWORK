package com.crm.comcast.Test;

import org.testng.annotations.Test;
import java.awt.Desktop.Action;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Properties;
import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;
import org.testng.internal.annotations.BaseAnnotation;


import com.crm.comcast.objectrepositoryUtility.CreateOrganizationPage;
import com.crm.comcast.objectrepositoryUtility.HomePage;
import com.crm.comcast.objectrepositoryUtility.Login;
import com.crm.comcast.objectrepositoryUtility.OrganizationInfoPage;
import com.crm.comcast.objectrepositoryUtility.OrganizationPage;

import comcast.crm.SDET_26.GenericUtility.BaseAnnotationClass;



/**
 * 
 * @author Prasanna
 *
 */
public class CreateOrganizationTest1 extends BaseAnnotationClass{
	@Test(groups = {"smokeTest"})
	public void createOrganizationTest() throws Throwable {

		/* get ramDomData */
		int randomNum = jLib.getRanDomNumber();
		 /* read test data from Excel File*/
		    String orgName = eLib.getDataFromExcel("Sheet1", 2, 3) + randomNum;
         /* step 2 :  navigate to Org Page*/ 
              HomePage hp = new HomePage(driver);
              hp.getOrganizationLink().click();             
         /* step 3 : navigate to create Org page */  
              OrganizationPage op = new OrganizationPage(driver);
              op.getCreateOrganizationIMG().click();
         /* step 3 : create a new Org */   
              CreateOrganizationPage cop = new CreateOrganizationPage(driver);
              cop.createOrganization(orgName);
         /* step 4 : verify */ 
              OrganizationInfoPage oip = new OrganizationInfoPage(driver);
              String orgNameInfoMsg =  oip.getOrganizationInfo().getText();
              if(orgNameInfoMsg.contains(orgName)) {
            	  System.out.println(orgName + "==>is created==>PASS");
              }else {
            	  System.out.println(orgName + "==>is not created==>fAIL");
              }
	}
	@Test(groups = {"regressionTest"})
	public void  createOrganization_With_Industries_And_Type_Test() throws Throwable {
		/* get ramDomData */
		int randomNum = jLib.getRanDomNumber();
		 /* read test data from Excel File*/
		    String orgName = eLib.getDataFromExcel("Sheet1", 2, 3) + randomNum;
		    String industries = eLib.getDataFromExcel("Sheet1", 2, 2);
		    String type = eLib.getDataFromExcel("Sheet1", 2, 4);
    /* step 2 :  navigate to Org Page*/ 
         HomePage hp = new HomePage(driver);
         hp.getOrganizationLink().click();             
    /* step 3 : navigate to create Org page */  
         OrganizationPage op = new OrganizationPage(driver);
         op.getCreateOrganizationIMG().click();
    /* step 3 : create a new Org  with indutries & type*/   
         CreateOrganizationPage cop = new CreateOrganizationPage(driver);
         cop.createOrganization(orgName, industries, type);
         
    /* step 4 : verify */ 
         OrganizationInfoPage oip = new OrganizationInfoPage(driver);
         String orgNameInfoMsg =  oip.getOrganizationInfo().getText();
         if(orgNameInfoMsg.contains(orgName)) {
       	  System.out.println(orgName + "==>is created==>PASS");
         }else {
       	  System.out.println(orgName + "==>is not created==>fAIL");
         }
         
        String actIndustriesinfo =  oip.getIndustriesInfo().getText();
        if(actIndustriesinfo.equals(industries)) {
         	  System.out.println(industries + "==>is verified==>PASS");
           }else {
         	  System.out.println(industries + "==>is not verified==>fAIL");
           }
        String actTypeinfo =  oip.getTypeInfo().getText();
        if(actTypeinfo.equals(type)) {
       	  System.out.println(type + "==>is verified==>PASS");
         }else {
       	  System.out.println(type + "==>is not verified==>fAIL");
         }
	}

}