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



public class Create_Shortcodes {
	
	
	String str1;
	Xls_Reader xls = new Xls_Reader("C:\\AutomationWorkspace\\Infocenter\\TestData.xlsx");
	
	
	
	
	
	@Test(dataProvider="getData")
//	public void createshortcode(String Browser,String Username,String Password,String Shortcode,String Customer)
	public void createshortcode(Hashtable<String,String> data) throws InterruptedException
	
	{	
		
		
		
		if(data.get("Runmode").equals("N"))
		throw new SkipException("Skipping as runmode is N");
		
		
		if(data.get("Shortcode").equals("1")){
			Random rand = new Random();
			int shtcode = rand.nextInt(100000);
			String strI = Integer.toString(shtcode);
			System.out.println("Random: "+strI);
		//	xls.setCellData("Create_Shortcode", "Shortcode", F6, strI);
			xls.setCellData("Create_Shortcode", 2, 5, strI);
		}
		

	
		
		keywords app = new keywords();
		app.executeKeywords("Create_Shortcode", xls, data);

		
		/*WebDriver driver = new FirefoxDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);*/
	/*	driver.get("http://infocenter-02.qa.air2web.com:8080/c/login");
		driver.findElement(By.xpath("//*[@id='username']")).sendKeys("qa");
		driver.findElement(By.xpath("//*[@id='password']")).sendKeys("password1");
		driver.findElement(By.xpath("//*[@id='loginbutton']")).click();
		driver.findElement(By.xpath("//*[@id='content']/div[3]/div[2]/div[1]")).click();
		driver.findElement(By.xpath("//*[@id='content']/p[1]/a")).click();
		Random rand = new Random();
		int shtcode = rand.nextInt(100000);
		String strI = Integer.toString(shtcode);
		driver.findElement(By.xpath("//*[@id='shortcode']")).sendKeys(strI);
		driver.findElement(By.xpath("//*[@id='customer']")).sendKeys("Air2Web");
		driver.findElement(By.xpath("//*[@id='shortCode']/table/tbody/tr[9]/td[2]/input")).click();
		Actions action = new Actions(driver);
		WebElement we = driver.findElement(By.xpath("html/body/div[3]/ul/li[5]/a"));
		action.moveToElement(we).build().perform();
		driver.findElement(By.cssSelector("a[href='/c/mtRoutes']")).click();
		driver.findElement(By.xpath("//*[@id='content']/p[1]/a[1]")).click();
		driver.findElement(By.xpath("//*[@id='shortcode']")).sendKeys(strI);
		driver.findElement(By.xpath("//*[@id='check_true']/input[2]")).click();
		driver.findElement(By.xpath("//*[@id='check_true']/input[3]")).click();
		driver.findElement(By.xpath("//*[@id='check_true']/input[8]")).click();
		driver.findElement(By.xpath("//*[@id='check_true']/input[9]")).click();
		driver.findElement(By.xpath("//*[@id='check_true']/input[12]")).click();
		driver.findElement(By.xpath("//*[@id='content']/form/table/tbody/tr[3]/td[2]/input")).click();
		Actions action1 = new Actions(driver);
		WebElement we1 = driver.findElement(By.xpath("html/body/div[3]/ul/li[5]/a"));
		action1.moveToElement(we1).build().perform();
		//driver.findElement(By.cssSelector("a[href='/c/shortCodes']")).click();
	
		driver.findElement(By.cssSelector("a[href='/c/moRoutes']")).click();
		driver.findElement(By.xpath("//*[@id='content']/p[1]/a")).click();
		driver.findElement(By.xpath("//*[@id='custId']")).sendKeys("Air2Web");
		driver.findElement(By.xpath("//*[@id='shortcode']")).click();
		Thread.sleep(5000);
		driver.findElement(By.xpath("//*[@id='shortcode']")).sendKeys(strI);
		driver.findElement(By.xpath("//*[@id='endpointUrl']")).sendKeys("http://cmpro-04.qa.air2web.com:8080/2notify/2NotifyResponse");
		driver.findElement(By.xpath("//*[@id='content']/form/table/tbody/tr[7]/td[2]/input")).click(); 
		
		/*driver.findElement(By.cssSelector("a[href='/c/shortCodes']")).click();*/
		/*Actions action2 = new Actions(driver);
		WebElement we2 = driver.findElement(By.xpath("html/body/div[3]/ul/li[5]/a"));
		action2.moveToElement(we2).build().perform();
		driver.findElement(By.xpath("html/body/div[3]/ul/li[5]/div/ul/li[11]/a")).click();
		driver.findElement(By.xpath("//*[@id='content']/p[1]/a")).click();
		driver.findElement(By.xpath("//*[@id='name']")).sendKeys("rajk_"+strI);
		driver.findElement(By.xpath("//*[@id='carrier']")).sendKeys("verizon");
		driver.findElement(By.xpath("//*[@id='channel']")).sendKeys("SMS");
		driver.findElement(By.xpath("//*[@id='routerUrl']")).sendKeys("http://verizon-02.qa.air2web.com:8080/a2w_msgRouter");
		driver.findElement(By.xpath("//*[@id='sourceAddress']")).sendKeys(strI);
		driver.findElement(By.xpath("//*[@id='routerDeploy']/table/tbody/tr[7]/td[2]/input")).click();
		//driver.findElement(By.cssSelector("a[href='/c/shortCodes']")).click();
		Actions action3 = new Actions(driver);
		WebElement we3 = driver.findElement(By.xpath("html/body/div[3]/ul/li[5]/a"));
		action3.moveToElement(we3).build().perform();
		driver.findElement(By.xpath("html/body/div[3]/ul/li[5]/div/ul/li[2]/a")).click();
		driver.findElement(By.xpath("//*[@id='content']/p[1]/a[3]")).click();
		driver.findElement(By.xpath("//*[@id='content']/p[1]/a")).click();
		driver.findElement(By.xpath("//*[@id='indCustomers2']/select")).sendKeys("Air2Web");
		driver.findElement(By.xpath("//*[@id='shortcode']")).click();
		Thread.sleep(5000);
		driver.findElement(By.xpath("//*[@id='shortcode']")).sendKeys(strI);
		driver.findElement(By.xpath("//*[@id='carrier']")).sendKeys("Verizon");
		driver.findElement(By.xpath("//*[@id='isStandardProgram']")).click();
		driver.findElement(By.xpath("//*[@id='standardProgramId']")).sendKeys("raj"+strI);
		driver.findElement(By.xpath("//*[@id='content']/form/table/tbody/tr[8]/td[2]/input")).click();*/
		
		/*keywords app = new keywords();
		app.openBrowser(Browser);
		app.navigate();
		app.input("Info_user",Username);
		app.input("Info_pass",Password);
		app.click("Login_bt");
		app.mousehover("Routes");
		//app.click("Shtcode");
		app.click("createsht");
		app.randgen();
		app.getrand("Shtcode");
		app.input("cr_shortcode",Shortcode);
		app.input("customer",Customer);
		app.click("createbt");*/
		
		
		
		
		
		}
		
		
		
	


		@DataProvider
			public Object[][] getData(){
			//Xls_Reader xls = new Xls_Reader("C:\\tests\\project\\TestData.xlsx");
		        return Utility.getData("Create_Shortcode", xls);
		       
		
		
		}


}