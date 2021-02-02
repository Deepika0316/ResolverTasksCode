package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Page4 
{
	private RemoteWebDriver driver;
	private WebDriverWait wait;
	
	@FindBy(how=How.ID,using="drag1")
	private WebElement src;
	
	@FindBy(how=How.XPATH,using="//div[@ondrop='drop(event)']")
	private WebElement dest;
	
	@FindBy(how=How.XPATH,using="//div[@ondrop='drop(event)']/button")
	private WebElement afterdrag;
	
	public Page4(RemoteWebDriver driver,WebDriverWait wait)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
		this.wait=wait;
	}
	
	public boolean dragndrop()
	{
		driver.executeScript("arguments[0].scrollIntoView()", src);
		wait.until(ExpectedConditions.visibilityOf(src));
		Actions a=new Actions(driver);
		a.dragAndDrop(src,dest).perform();
		try
		{
			wait.until(ExpectedConditions.visibilityOf(afterdrag));
			dest.findElement(By.xpath("child::button"));
			return true;
		}
		catch(Exception ex)
		{
			System.out.println("exception is : "+ex.getMessage());
			return false;
		}
	}
	
	
}
