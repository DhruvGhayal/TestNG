package interview.testng.excelReader;

import java.io.FileNotFoundException;
import java.io.IOException;

import org.testng.annotations.DataProvider;

public class xls {
	
	//public static void main(String[]args) throws IOException,FileNotFoundException{
	@DataProvider(name="empdataprovider")
	String[][] getEmpData() throws IOException,FileNotFoundException{
		String path = "D:\\QA\\SeleniumWorkSpace\\interview.testng.practice\\src\\main\\resource\\Book1.xlsx";
		String sheet = "List"; 
		int rownum=Xls_ReaderFile.getTotalNumberOfRows(path, sheet);
		//System.out.println(rownum);
		int colcount = Xls_ReaderFile.getTotalNumberOfCells(path, sheet, 0);
		//System.out.println(colcount);
		String empdata[][]=new String [rownum][colcount];
		for(int i=1; i<=rownum; i++) {
			for(int j=0; j<colcount; j++) {
			empdata[i-1][j]=Xls_ReaderFile.getCellValue(path, sheet, i, j);
				//System.out.print(Xls_ReaderFile.getCellValue(path, sheet, i, j));
				//System.out.print("\t");
			}
			//System.out.println();
			}return empdata;
	}
	}

