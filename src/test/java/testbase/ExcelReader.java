package testbase;

import java.io.FileInputStream;

import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;

public class ExcelReader {
static HSSFWorkbook w;
static HSSFSheet s;
	public Object[][] getTestData(String sheetName)
	{
		FileInputStream fin = null;

		try {
			 fin = new FileInputStream("src/test/resources/testdata.xls");
		}catch(Exception e)
		{
			e.printStackTrace();
		}
		try {
			w=new HSSFWorkbook(fin);
			
		}catch(Exception e)
		{
			e.printStackTrace();
		}
		s=w.getSheet(sheetName);
		Object[][] data=new Object [s.getLastRowNum()+1][s.getRow(0).getLastCellNum()];
		for(int i=0;i<=s.getLastRowNum();i++)
		{
			for(int j=0;j<s.getRow(0).getLastCellNum();j++)
			{
				data[i][j]=s.getRow(i).getCell(j).toString();
			}
		}
		return data;
	}

	
}