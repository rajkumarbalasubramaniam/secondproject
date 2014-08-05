package testcases;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Hashtable;
import java.util.Properties;
import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.SkipException;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import utility.Utility;
import utility.Xls_Reader;
import utility.keywords;

public class Create_Mtroutes {

	Xls_Reader xls = new Xls_Reader("C:\\AutomationWorkspace\\Infocenter\\TestData.xlsx");

	@Test(dataProvider="getData")
	//public void mtroute(String Browser,String Username,String Password,String Shortcode)
	public void mtroute(Hashtable<String,String> data) throws InterruptedException
	{
		
		if(data.get("Runmode").equals("N"))
		throw new SkipException("Skipping as runmode is N");
		
		keywords app = new keywords();
		app.executeKeywords("Create_Mtroute", xls, data);
	/*keywords app = new keywords();
	app.openBrowser(Browser);
	app.navigate();
	app.input("Info_user",Username);
	app.input("Info_pass",Password);
	app.click("Login_bt");
	app.mousehover("Routes");
	app.click("mtroutes");
	app.click("createmtroutes");
	app.input("mt_shortcode", Shortcode);
	app.click("AT&Tblue");
	app.click("AT&T");
	app.click("Sprint");
	app.click("Sprint1");
	app.click("verizon");
	app.click("addmtroutes");*/
}
	
	@DataProvider
	public Object[][] getData(){
		return Utility.getData("Create_Mtroute", xls);



}


}
