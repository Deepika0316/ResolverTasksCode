package practice;

import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import pages.Page1;
import pages.Page2;
import pages.Page3;
import pages.Page4;
import utilities.TestUtility;

public class Test {

	public static void main(String[] args) throws Exception 
	{
		
		TestUtility tu=new TestUtility();
		RemoteWebDriver driver=tu.openbrowser();
		WebDriverWait wait=tu.defineWait(driver);
	    Page1 p=new Page1(driver,wait);
	    tu.launchSite();
	    p.fillForm("Deepika","Hyderabad");
	    if(p.isValuesEntered())
	    {
	    	System.out.println("Name and City values entered as expected");
	    	
	    }
	    else
	    {
	    	System.out.println("values not enetred in textboxes"+tu.captureScreenshot());
	    	
	    }
	     //Test2 for page2
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
			System.out.println("mismatched"+tu.captureScreenshot());
		}
		//Test4 for page4
		Page4 p4=new Page4(driver,wait);
		if(p4.dragndrop())
		{
			System.out.println("source dragged to destination successfully");
		}
		else
		{
			System.out.println("dragging element got failed"+tu.captureScreenshot());
		}
		tu.closeSite();


	}

}
