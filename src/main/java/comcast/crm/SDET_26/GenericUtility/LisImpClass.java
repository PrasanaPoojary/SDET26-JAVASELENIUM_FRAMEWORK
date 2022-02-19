package comcast.crm.SDET_26.GenericUtility;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.testng.ITestListener;
import org.testng.ITestResult;

import net.bytebuddy.implementation.bind.annotation.TargetMethodAnnotationDrivenBinder;

public class LisImpClass implements ITestListener {
	
 public void onTestFailure(ITestResult result) {
	String testname = result.getMethod().getMethodName();
	System.out.println(testname + "Execute and i am listening");
	
	EventFiringWebDriver eDriver = new EventFiringWebDriver(BaseAnnotationClass.eDriver);
	File srcFile = eDriver.getScreenshotAs(OutputType.FILE);
	File dest = new File("./screenshot/"+testname+".png");
	  try {
		FileUtils.copyFile(srcFile, dest);
	  } catch(IOException e) {
		  e.printStackTrace();
	  }
	   
	   
 }
}