package testcases;

import java.util.Hashtable;

import org.testng.SkipException;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import utility.Utility;
import utility.Xls_Reader;
import utility.keywords;

public class Create_Routerlog {
	
	Xls_Reader xls = new Xls_Reader("C:\\AutomationWorkspace\\Infocenter\\TestData.xlsx");
	

	@Test(dataProvider="getData")
		public void moroute(Hashtable<String,String> data) throws InterruptedException
		{
		
		if(data.get("Runmode").equals("N"))
			throw new SkipException("Skipping as runmode is N");
			
			keywords app = new keywords();
			app.executeKeywords("Create_Routerlog", xls, data);
	
		
		}
		
		@DataProvider
		public Object[][] getData(){
			return Utility.getData("Create_Routerlog", xls);



	}



}
