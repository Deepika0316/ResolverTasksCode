package practice;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DragnDrop {

	public static void main(String[] args) throws Exception 
	{
	WebDriverManager.chromedriver().setup();
	ChromeDriver driver =new ChromeDriver();
	driver.get("file:///C:/Users/Deepi/OneDrive/Desktop/index.html");
	driver.manage().window().maximize();
	driver.manage().timeouts().implicitlyWait(1000, TimeUnit.MILLISECONDS);
	WebElement dest=driver.findElement(By.xpath("//div[@id='div1']"));
	WebElement src=driver.findElement(By.xpath("//button[text()='Drag Me']"));
	driver.executeScript("arguments[0].scrollIntoView()", src);
	int w=src.getSize().getWidth();
	int h=src.getSize().getHeight();
	Actions a=new Actions(driver);
	//a.dragAndDrop(src, dest).build().perform();
	//a.moveToElement(src, w/2, h/2).dragAndDrop(src, dest).build().perform();
	//a.moveToElement(src).clickAndHold(src).release().build().perform();
	a.moveByOffset(603, 547).clickAndHold(src).dragAndDrop(src, dest).perform();
	

	}

}
