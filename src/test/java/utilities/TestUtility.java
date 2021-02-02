package utilities;

import java.io.File;
import java.io.FileInputStream;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Properties;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TestUtility
{
private RemoteWebDriver driver;
private WebDriverWait wait;

public TestUtility()
{
	driver=null;
	wait=null;
}

public String getvaluesfromPropsFile(String propname) throws Exception
{
	String fpath=System.getProperty("user.dir")+"\\src\\test\\resources\\Config.properties";
	File f=new File(fpath);
	FileInputStream fi=new FileInputStream(f);
	Properties p=new Properties();
	p.load(fi);
	String value=p.getProperty(propname);
	fi.close();
	return value;
}

public RemoteWebDriver openbrowser()
{
	WebDriverManager.chromedriver().setup();
	//To avoid default banner
	  String[] s=new String[] {"enable-automation"};
		ChromeOptions co=new ChromeOptions();
		co.setExperimentalOption("excludeSwitches", s);
		driver=new ChromeDriver(co);
	 return driver;
}

public WebDriverWait defineWait(RemoteWebDriver driver) throws Exception
{
	String val=getvaluesfromPropsFile("maxtime");
	Integer max=Integer.parseInt(val);
	wait=new WebDriverWait(driver,max);
	return wait;
	
}

public void launchSite() throws Exception
{
	String url=getvaluesfromPropsFile("url");
	driver.get(url);
	driver.manage().window().maximize();
}

public String captureScreenshot() throws Exception
{
	SimpleDateFormat sf=new SimpleDateFormat("dd-MMM-yyyy-hh-mm-ss");
	Date dt=new Date();
	String scsht=System.getProperty("user.dir")+"\\target\\"+sf.format(dt)+".png";
	File src=driver.getScreenshotAs(OutputType.FILE);
	File dest=new File(scsht);
	FileHandler.copy(src, dest);
	return(dest.getAbsolutePath());
}

public void closeSite()
{
	driver.close();
}
	
}
