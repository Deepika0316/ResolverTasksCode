package pages;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Page3 
{
private RemoteWebDriver driver;
private WebDriverWait wait;

@FindBy(how=How.XPATH,using="//input[@id='searchMe']")
private WebElement search;

@FindBy(how=How.XPATH,using="//table/tbody/tr")
private List<WebElement> rows;

public Page3(RemoteWebDriver driver,WebDriverWait wait)
{
	this.driver=driver;
	PageFactory.initElements(driver, this);
	this.wait=wait;
}

public int searchTable(String country)
{
	wait.until(ExpectedConditions.visibilityOf(search));
	search.sendKeys(country);
	int count=0;
	
	for(WebElement row:rows)
	{
		if(row.getAttribute("style").contains("none"))
		{
			
		}
		else
		{
			count++;
		}
	}
	return count;
}

public int countOfRows()
{
	wait.until(ExpectedConditions.visibilityOf(search)).clear();
	return rows.size();
}

public boolean isRowCountMatched(int actual)
{
	int expected=4;
	if(actual==expected)
	{
		return true;
	}
	else
	{
		return false;
	}
}
}
