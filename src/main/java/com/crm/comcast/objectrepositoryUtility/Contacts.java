package com.crm.comcast.objectrepositoryUtility;

	import org.openqa.selenium.WebDriver;
	import org.openqa.selenium.WebElement;
	import org.openqa.selenium.support.FindBy;
	import org.openqa.selenium.support.PageFactory;
	/**
	 * 
	 * @author Prasanna
	 *
	 */
	public class Contacts {
		
		public Contacts(WebDriver driver) {
			PageFactory.initElements(driver, this);
		}
		
		@FindBy(xpath = "//img[@alt = 'Create Contact...']")
		private WebElement createNewConatctIMG;

		public WebElement getCreateNewConatctIMG() {
			return createNewConatctIMG;
		}
		
		

	}


