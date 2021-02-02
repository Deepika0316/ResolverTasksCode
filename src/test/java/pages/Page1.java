package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Page1
{
private RemoteWebDriver driver;
private WebDriverWait wait;

@FindBy(how=How.XPATH,using="//button[text()='Open Modal']")
private WebElement openmodalbut;

@FindBy(how=How.XPATH,using="//h4[text()='Modal Header']")
private WebElement header;

@FindBy(how=How.XPATH,using="//input[@id='name']")
private WebElement name;

@FindBy(how=How.XPATH,using="//input[@id='city']")
private WebElement city;

@FindBy(how=How.XPATH,using="//button[@id='enter']")
private WebElement enterdata;

@FindBy(how=How.XPATH,using="//button[text()='Close']")
private WebElement close;

@FindBy(how=How.XPATH,using="//span[@id='nameVal']")
private WebElement nameval;

@FindBy(how=How.XPATH,using="//span[@id='cityVal']")
private WebElement cityval;


public Page1(RemoteWebDriver driver,WebDriverWait wait)
{
	this.driver=driver;
	PageFactory.initElements(driver, this);
	this.wait=wait;
}

public void fillForm(String hname,String hcity)
{
	wait.until(ExpectedConditions.visibilityOf(openmodalbut)).click();
	wait.until(ExpectedConditions.visibilityOf(header));
	name.sendKeys(hname);
	city.sendKeys(hcity);
	enterdata.click();
	close.click();
}

public boolean isValuesEntered()
{
	String actual=nameval.getText();
	String expected="Deepika";
	String actualcity=cityval.getText();
	String expectedcity="Hyderabad";
	//System.out.println(actual);
	wait.until(ExpectedConditions.visibilityOf(nameval));
	if(actual.equals(expected)&&actualcity.equals(expectedcity))
	{
		
		return(true);
	}
	else
	{
		
		return(false);
	}
}







}
