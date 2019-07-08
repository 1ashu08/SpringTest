package exceltest;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.ArrayList;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class WriteTest {

	public void doTest(String  colHeader[])
	{
		try
		{
			
			 FileInputStream myxls = new FileInputStream("Test.xlsx");
	         
			 XSSFWorkbook writeBook = new XSSFWorkbook();
	         XSSFSheet writeSheet = writeBook.createSheet("New Sheet");
			 
			 XSSFWorkbook workbook = new XSSFWorkbook(myxls);
	         int sheetCount=workbook.getNumberOfSheets();
	         int flag=0;
	         boolean colHeaderFlag[]=null; 
			 for(int i=0;i<sheetCount;i++)
			 {
				 XSSFSheet sheet = workbook.getSheetAt(i);
				 int lastRow=sheet.getLastRowNum();
				 for(int j=0;j<lastRow;j++)
				 {
					 Row row=sheet.getRow(j);
					 Row writeRow=writeSheet.createRow(j);
					 if(flag==0)
						 colHeaderFlag=new boolean[row.getLastCellNum()];
					 int cel=0;
					 for(int k=0;k<row.getLastCellNum();k++)
					 {
						 if(flag==0)
						 {
							 String col=row.getCell(k).getStringCellValue();
							 if(colHeader[k].equalsIgnoreCase(col))
							 {
								 colHeaderFlag[k]=true;
								 Cell cellData=writeRow.createCell(cel++);
								 cellData.setCellValue(colHeader[k]);
							 }
							 else
								 colHeaderFlag[k]=false;
								 
						 }
						 else
						 {
							 if(colHeaderFlag[k]==true)
							 {
								 Cell cellData=writeRow.createCell(cel++);
								 cellData.setCellValue(row.getCell(k).getStringCellValue());
							 }
						 }
					 }
					 flag=1;
				 }
			 }
	        
	        
	         try
	         {
	        	 FileOutputStream outputStream = new FileOutputStream("NewFile.xlsx"); 
	        	 writeBook.write(outputStream);
	             
	             writeBook.close();
	             outputStream.close();
	         }catch (Exception e)
	         {
				System.out.println(e);
				System.out.println(e.getMessage());
			 }			
			 
		}catch(Exception e)
		{
			System.out.println(e);
			System.out.println(e.getMessage());
		}
	}
	
	public static void main(String args[])
	{
		WriteTest obj =new WriteTest();
		String colHeaader[]= {"CLO1","COL2","","COL2","CLO1",""};
		obj.doTest(colHeaader);
	}
}
