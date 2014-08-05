package utility;

import java.util.Hashtable;
import java.util.Random;
public class Utility {
	
	

	public static Object[][] getData(String sheetName,Xls_Reader xls){
		 int rows = xls.getRowCount(sheetName);
		  int cols = xls.getColumnCount(sheetName);
		//  Object[][] data = new Object[rows-1][cols];
		  Object[][] data = new Object[rows-1][1];
		  
		  Hashtable<String,String> table = null;
		  
		  for(int rNum=2;rNum<=rows;rNum++){
			  table = new Hashtable<String,String>();
			  for(int cNum=0;cNum<cols;cNum++){
				 // data[rNum-2][cNum] =  xls.getCellData(sheetName, cNum, rNum);
				  table.put(xls.getCellData(sheetName,cNum,1), xls.getCellData(sheetName, cNum, rNum));
				  
			  }
			  data[rNum-2][0] =table;
		  }
		  
		  return data;
	}


/*public boolean getRunmode(String testName, Xls_Reader xls){
	if(Runmode="Y")
	{
		
	}
	return true; //Y
	//return false; //N
}*/
	


}