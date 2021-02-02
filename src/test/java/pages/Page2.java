package pages;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Page2 
{
private RemoteWebDriver driver;
private WebDriverWait wait;

@FindBy(how=How.XPATH,using="//button[contains(text(),'Click Me')]")
private WebElement clickme;

@FindBy(how=How.XPATH,using="//ul[@class='dropdown-menu show']/li")
private List<WebElement> items;

@FindBy(how=How.XPATH,using="//ul[@class='dropdown-menu show']/li")
private List<WebElement> opendd; 

@FindBy(how=How.XPATH,using="//ul/input[@id='myInput']")
private WebElement search;

public Page2(RemoteWebDriver driver,WebDriverWait wait)
{
	this.driver=driver;
	PageFactory.initElements(driver, this);
	this.wait=wait;
}

public void clickme()
{
	//for verification i have created a array and added all the items and then comparing with collecting all items from webpage(clikme dropdown)
	wait.until(ExpectedConditions.visibilityOf(clickme));
	ArrayList<String> x=new ArrayList<String>();
	x.add("Java");
	x.add("C#");
	x.add("Python");
	x.add("Angular 2");
	x.add("Angular");
	clickme.click();
	for(int i=0;i<items.size();i++)
	{
		if(x.get(i).equals(items.get(i).getText()))
		{
			System.out.println("verification passed");
			clickme.sendKeys(Keys.ESCAPE);
		}
		else
		{
			System.out.println("failed");
			clickme.sendKeys(Keys.ESCAPE);
		}
	}
	
	
	clickme.click();
	for(WebElement item:items)
	{
		wait.until(ExpectedConditions.visibilityOf(item));
		System.out.println(item.getText());
	}
	clickme.sendKeys(Keys.ESCAPE);
}

public void searchFor(String value,String value2)
{
	wait.until(ExpectedConditions.visibilityOf(clickme));
	clickme.click();
	wait.until(ExpectedConditions.visibilityOf(search));
	search.sendKeys(value);
	int count=0;
	for(WebElement each:opendd)
	{
		if(each.getAttribute("style").contains("none"))
		{
		}
		
		else
		{
			System.out.println("options containing angular : ");
			System.out.println(each.getText());
			count++;

		}
	}
	System.out.println("count for searched(Angular) value : "+count);
	search.clear();
	search.sendKeys(value2);
	//when searching for ReactJS in the dropdown no result 
	int count1=0;
	for(WebElement each:opendd)
	{
		if(each.getAttribute("style").contains("none"))
		{
		}
		else
		{
			
			System.out.println(each.getText());
			count1++;
		
		}
	}
	System.out.println("options count when reactjs is entered : "+count1);
	clickme.click();
	
	
	
}



}
