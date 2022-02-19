package com.crm.comcast.Test;

import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.annotations.Test;

import com.crm.comcast.objectrepositoryUtility.Contacts;
import com.crm.comcast.objectrepositoryUtility.ContactsInfoPage;
import com.crm.comcast.objectrepositoryUtility.CreateNewConatctPage;
import com.crm.comcast.objectrepositoryUtility.CreateOrganizationPage;
import com.crm.comcast.objectrepositoryUtility.HomePage;
import com.crm.comcast.objectrepositoryUtility.OrganizationInfoPage;
import com.crm.comcast.objectrepositoryUtility.OrganizationPage;

import comcast.crm.SDET_26.GenericUtility.BaseAnnotationClass;





/**
 * 
 * @author Prasanna
 *
 */
public class ContactPageTest extends  BaseAnnotationClass{

	@Test(groups = {"smokeTest"})
	public void  createContactWithLastNameTest() throws Throwable {
		/* get ramDomData */
		int randomNum = jLib.getRanDomNumber();
		 /* read test data from Excel File*/
		    String lastName = eLib.getDataFromExcel("Sheet1", 2, 5) + randomNum;
         /* step 1 : navigate to Contacts Page */ 
         HomePage hp = new HomePage(driver);
         hp.getContactLink().click(); 
         /* step 2 :  navigate to CREATE  Contact Page*/ 
         Contacts cp = new Contacts(driver);
         cp.getCreateNewConatctIMG().click();
         
         /* step 3 : create a new Contact Page */
         CreateNewConatctPage cncp = new CreateNewConatctPage(driver);
         cncp.createNewConatct(lastName);

         /* step 4 : verify */ 
         ContactsInfoPage cip = new ContactsInfoPage(driver);
         String  actContactinfo = cip.getContactSucMsg().getText();
         Assert.assertTrue(actContactinfo.contains(lastName)); 
        	 System.out.println(actContactinfo + "==> is created==>PASS");
         
	
	}
	@Test(groups = {"regressionTest"})
	public void createContact_Support_DateTest() throws Throwable {
		/* get ramDomData */
		int randomNum = jLib.getRanDomNumber();
		 
		 /* read test data from Excel File*/
		    String lastName = eLib.getDataFromExcel("Sheet1", 2, 6) + randomNum;
		    String mobileNumber = eLib.getDataFromExcel("Sheet1", 2, 7); 
         /* step 1 : navigate to Contacts Page */ 
         HomePage hp = new HomePage(driver);
         hp.getContactLink().click(); 
         /* step 2 :  navigate to CREATE  Contact Page*/ 
         Contacts cp = new Contacts(driver);
         cp.getCreateNewConatctIMG().click();         
         /* step 3 : create a new Contact Page */
         CreateNewConatctPage cncp = new CreateNewConatctPage(driver);
         cncp.createNewConatct(lastName, mobileNumber, jLib.getSystmeDate_YYYY_MM__DD());

         /* step 4 : verify */ 
         ContactsInfoPage cip = new ContactsInfoPage(driver);
         String  actContactinfo = cip.getContactSucMsg().getText();
         if(actContactinfo.contains(lastName)) {
        	 System.out.println(actContactinfo + "==> is created==>PASS");
         }else {
        	 System.out.println(actContactinfo + "==> is not created==>Fail");

         }
	}
	
	@Test(groups = {"regressionTest"})
	public void createConatctWithOrgTest() throws Throwable {	
		/* get ramDomData */
		int randomNum = jLib.getRanDomNumber();
		 /* read test data from Excel File*/
		    String orgName = eLib.getDataFromExcel("Sheet1", 2, 3) + randomNum;
		    String conactName = eLib.getDataFromExcel("Sheet1", 2, 5) + randomNum;
  
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
        wLib.waitForElemnetToBeClickAble(driver, oip.getOrganizationInfo());  
        
         /* step 5 :  navigate to CREATE  Coantct Page*/ 
        hp.getContactLink().click();
  
        /* step 6 :  navigate to CREATE  Contact Page*/ 
        Contacts cp = new Contacts(driver);
        cp.getCreateNewConatctIMG().click();
        
        /* step 7 : create a new Contact Page */
        CreateNewConatctPage cncp = new CreateNewConatctPage(driver);
        cncp.createNewConatct(conactName, orgName);
        
        /* step 8 : verify */ 
        ContactsInfoPage cip = new ContactsInfoPage(driver);
        String  actContactinfo = cip.getContactSucMsg().getText();
        	Assert.assertTrue(actContactinfo.contains(conactName));
       	 System.out.println(conactName + "==> is created==>PASS");
        
	}
}