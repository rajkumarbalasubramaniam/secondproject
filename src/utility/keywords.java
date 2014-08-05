package utility;

import java.io.FileInputStream;

import java.util.Hashtable;
import java.util.Properties;
import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;



public class keywords {
	
	String shortCode;
	WebDriver driver = null;
	Properties prop = null;
	
	public keywords(){
		try{
			prop  = new Properties();
			FileInputStream fs = new FileInputStream(System.getProperty("user.dir")+"\\src\\config\\or.properties");
			prop.load(fs);
		}catch (Exception e){
			e.printStackTrace();
		}
		
	}

	public  void openBrowser(String btype){
		{
			
		if(btype.equals("firefox"))
			driver = new FirefoxDriver();
	    /*else if(btype.equals("chrome"))
			System.setProperty("webdriver.chrome.driver", "C:\\Browser_Drivers\\Chrome_Driver");
		    driver = new ChromeDriver();*/
		    }
			driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
			driver.manage().window().maximize();
}
	
	public void executeKeywords(String testName,Xls_Reader xls,Hashtable<String,String> data) throws InterruptedException{
		int rows = xls.getRowCount("Testcases");
		for(int rNum=2;rNum<=rows;rNum++){
			String tName = xls.getCellData("Testcases", "TCID", rNum);
			
			if(tName.equals(testName)){
				String keyword=xls.getCellData("Testcases", "keyword", rNum);
				String objectKey=xls.getCellData("Testcases", "Object", rNum);
				String dataKey=xls.getCellData("Testcases", "Data", rNum);
			
			
				if(keyword.equals("openBrowser"))
					 openBrowser(data.get(dataKey));
				else if(keyword.equals("navigate"))
				     navigate();
				else if(keyword.equals("input"))
					 input(objectKey, data.get(dataKey));
				else if(keyword.equals("click"))
					 click(objectKey);
				else if(keyword.equals("mousehover"))
					mousehover(objectKey);
				else if(keyword.equals("isElementPresent"))
					isElementPresent(objectKey);
				else if(keyword.equals("waitcall"))
					waitcall();
				else if(keyword.equals("verifyTitle"))
					verifyTitle(objectKey);
			}}
	}

	
	public void navigate(){
		driver.get(prop.getProperty(prop.getProperty("testEnv")));
	}
	
	public void click(String xpathkey){
		driver.findElement(By.xpath(prop.getProperty(xpathkey))).click();
	}
	
	public void input(String xpathkey,String data){
	driver.findElement(By.xpath(prop.getProperty(xpathkey))).sendKeys(data);
	}
	
	public boolean isElementPresent(String xpathkey){
		int count = driver.findElements(By.xpath(prop.getProperty(xpathkey))).size();
		
	if(count== 0)
		return false;
	else
		return true;
	
	}
	
	/*public void random(String xpathkey,String data)
	{
		//randgen();
		//System.out.println("Random in Function: "+randgen());
		System.out.println(strI);
		driver.findElement(By.xpath(prop.getProperty(xpathkey))).sendKeys(data);
	}*/
	
	public void mousehover(String xpathkey){
		Actions action = new Actions(driver);
		WebElement we = driver.findElement(By.xpath(prop.getProperty(xpathkey)));
		action.moveToElement(we).build().perform();
		//action.moveToElement(we).moveToElement(driver.findElement(By.xpath(xpathkey))).click().build().perform();
	}
	
	public static String randgen(){
		Random rand = new Random();
		int shtcode = rand.nextInt(100000);
		String strI = Integer.toString(shtcode);
		System.out.println("Random: "+strI);
		//shortCodeInterface.shortCode=strI;
		return strI;
	
	}
	
	/*public void getrand(String xpathkey){
		driver.findElement(By.xpath(prop.getProperty(xpathkey))).sendKeys(strI);
	}*/
	
	public void waitcall() throws InterruptedException{
		Thread.sleep(9000);
	}
	
	public boolean verifyTitle(String expectedTitle){
		return true;
	}

	public String getShortCode() {
		return shortCode;
	}

	public void setShortCode(String shortCode) {
		this.shortCode = shortCode;
	}
	

  /* public void runmode(){
    	Xls_Reader xls = new Xls_Reader("C:\\AutomationWorkspace\\Infocenter\\TestData.xlsx");
    	if(xls.getCellData("Runmode", colNum, rowNum))
    }*/
}
	
	

