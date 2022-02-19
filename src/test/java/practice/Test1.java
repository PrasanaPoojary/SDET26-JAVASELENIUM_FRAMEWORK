package practice;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class Test1 {
	 public static void main(String[] args) throws InterruptedException {
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get("https://www.icc-cricket.com/rankings/womens/team-rankings/odi");
		WebElement ele = driver.findElement(By.xpath("//div[contains(text(),'Rankings ')]"));
		Thread.sleep(2000);
		Actions a = new Actions(driver);
		a.moveToElement(ele).perform();
		Thread.sleep(4000);
		
		driver.quit();
	}

}
