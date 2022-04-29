 package week5.day2.assignment;

import java.io.IOException;


import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ReadExcel
{

	
		public static String[][] readData(String fileName) throws IOException {
			//step1: setup the path of the workbook--to setup we have a class called XSSFClass
			XSSFWorkbook wb = new XSSFWorkbook("./data/"+fileName+".xlsx");
			
			//step2-setup the sheet using XSSFSheet
			XSSFSheet ws = wb.getSheet("Sheet1");
			
			//to get the row count
			int rCount = ws.getLastRowNum();
			
			//to get the cell count
			int cCount=ws.getRow(0).getLastCellNum();
			
			
			//Declare 2D string array
			String [][] data = new String [rCount][cCount];
			
			for(int i =1;i<=rCount;i++) {
				for(int j=0;j<cCount;j++) {
					String cellval = ws.getRow(i).getCell(j).getStringCellValue();
					System.out.println(cellval);
					data[i-1][j]= cellval;
				}
			}
			
			
			
			wb.close();
			return data;
		}

	}
