package practice;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class WebTable {

	public static void main(String[] args) 
	{
	WebDriverManager.chromedriver().setup();
	ChromeDriver driver=new ChromeDriver();
	driver.get("file:///C:/Users/Deepi/OneDrive/Desktop/index.html");
	driver.manage().timeouts().implicitlyWait(10000, TimeUnit.MILLISECONDS);
	driver.findElement(By.xpath("//input[@id='searchMe']")).sendKeys("usa");
	List<WebElement> l=driver.findElements(By.xpath("//table/tbody/tr"));
	System.out.println("size is "+l.size());
	int count=0;
	for(WebElement row:l)
	{
		//wait.until(ExpectedConditions.visibilityOf(row));
		if(row.getAttribute("style").contains("none"))
		{
			System.out.println("if block");
		}
		else
		{
			System.out.println("else block");
			count++;
		}
	}
	System.out.println(count);
	
	
	

	}

}
