package tests;

import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import pages.Page1;
import pages.Page2;
import pages.Page3;
import pages.Page4;
import utilities.ExcelUtility;
import utilities.TestUtility;

public class TestwithExcel {

	public static void main(String[] args) throws Exception 
	{
		TestUtility tu=new TestUtility();
		String excpath=System.getProperty("user.dir")+"\\src\\test\\resources\\TestData.xlsx";
		ExcelUtility eu=new ExcelUtility(excpath);
		RemoteWebDriver driver=tu.openbrowser();
		WebDriverWait wait=tu.defineWait(driver);
	    Page1 p=new Page1(driver,wait);
	    tu.launchSite();
		try 
		{
		eu.openSheet("Sheet1");
		int cc=eu.getCellCount();
		eu.createResultColumn(cc);
		int rc=eu.getRowsCount();
		for(int i=1;i<rc;i++)
		{
		String name=eu.getCellValue(i, 0);
		String city=eu.getCellValue(i, 1);
		  p.fillForm(name,city);
	    if(p.isValuesEntered())
	    {
	    	//used console as well as Excel to add results
	    	System.out.println("Name and City values entered as expected");
	    	eu.setCellValue(i, cc, "Name and City values entered as expected");
	    	
	    }
	    else
	    {
	    	System.out.println("values not enetred in textboxes and path for exception is : "+tu.captureScreenshot());
	    	eu.setCellValue(i, cc, "Name and City values not enetred and path for exception is: "+tu.captureScreenshot());
	    }
	    eu.saveAndCloseExcel();
		}
		}
		catch(Exception ex)
		{
			eu.saveAndCloseExcel();
			System.out.println("exception with Excel: "+ex.getMessage());
		}
	     //Test2 for page2 and from here just generated results via console
	   Page2 p2=new Page2(driver,wait);
		p2.clickme();
		p2.searchFor("Angular" ,"ReactJS");
		//Test3 for page3
	   Page3 p3=new Page3(driver,wait);
		System.out.println("rowcount with text as usa : "+p3.searchTable("usa"));
		int trc=p3.countOfRows();
		System.out.println("total count : "+trc);
		if(p3.isRowCountMatched(trc))
		{
			System.out.println("count matched");
		}
		else
		{
			System.out.println("mismatched  "+tu.captureScreenshot());
		}
		//Test4 for page4
		Page4 p4=new Page4(driver,wait);
		if(p4.dragndrop())
		{
			System.out.println("source dragged to destination successfully");
		}
		else
		{
			System.out.println("dragging element got failed  "+tu.captureScreenshot());
		}
		tu.closeSite();


	}

}
