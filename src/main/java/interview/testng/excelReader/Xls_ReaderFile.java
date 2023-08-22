package interview.testng.excelReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Calendar;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.DateUtil;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
public class Xls_ReaderFile {
	
	public static FileInputStream fi=null;
	public static FileOutputStream fo=null;
	public static XSSFWorkbook wb=null;
 	public static XSSFSheet ws=null;
 	public static XSSFRow row=null;
 	public static XSSFCell cell=null;
 	
 	
	
	public static int getTotalNumberOfRows(String xlfile, String xlsheet) throws FileNotFoundException,IOException {
		fi=new FileInputStream(xlfile);
		wb=new XSSFWorkbook(fi);
		ws=wb.getSheet(xlsheet);
		int totalRowsCount = ws.getLastRowNum();
		wb.close();
		fi.close();
		return totalRowsCount;
	}
	
	public static int getTotalNumberOfCells(String xlfile, String xlsheet, int nrow) throws FileNotFoundException,IOException {
		fi=new FileInputStream(xlfile);
		wb=new XSSFWorkbook(fi);
		ws=wb.getSheet(xlsheet);
		row=ws.getRow(nrow);
		int totalCellCount = ws.getRow(nrow).getLastCellNum();
		wb.close();
		fi.close();
		return totalCellCount;
	}
	
	public static String getCellValue(String xlfile, String xlsheet, int nrow, int ncell) throws FileNotFoundException,IOException {
		fi=new FileInputStream(xlfile);
		wb=new XSSFWorkbook(fi);
		ws=wb.getSheet(xlsheet);
		row=ws.getRow(nrow);
		cell=row.getCell(ncell);
		String data;
		try {
			DataFormatter formatter = new DataFormatter();
			String cellData = formatter.formatCellValue(cell);
			return cellData;
		}catch(Exception e){		
				data="";
		}
		wb.close();
		fi.close();
		return data;	
		}
	
	public static void setCellValue(String xlfile, String xlsheet, int nrow, int ncell, String data) throws FileNotFoundException,IOException {
		fi=new FileInputStream(xlfile);
		wb=new XSSFWorkbook(fi);
		ws=wb.getSheet(xlsheet);
		row=ws.getRow(nrow);
		cell=row.createCell(ncell);
		cell.setCellValue(data);
		fo=new FileOutputStream(xlfile);
		wb.write(fo);
		wb.close();
		fi.close();
	}
	
	public static String getCellData(String xlfile, String sheetName,String colName,int rowNum) throws IOException,FileNotFoundException{
		fi=new FileInputStream(xlfile);
		wb=new XSSFWorkbook(fi);
		try{
			if(rowNum <=0)
				return "";
			int index = wb.getSheetIndex(sheetName);
			int col_Num=-1;
			if(index==-1)
				return "";
			ws = wb.getSheetAt(index);
			row=ws.getRow(0);
			for(int i=0;i<row.getLastCellNum();i++){
				if(row.getCell(i).getStringCellValue().trim().equals(colName.trim()))
					col_Num=i;
			}
			if(col_Num==-1)
				return "";
			ws = wb.getSheetAt(index);
			row = ws.getRow(rowNum-1);
			if(row==null)
				return "";
			cell = row.getCell(col_Num);
			if(cell==null)
				return "";
			if(cell.getCellType()==CellType.STRING)
				  return cell.getStringCellValue();
			else if(cell.getCellType()==CellType.NUMERIC || cell.getCellType()==CellType.FORMULA ){
				  String cellText  = String.valueOf(cell.getNumericCellValue());
				  if (DateUtil.isCellDateFormatted(cell)) {
					  double d = cell.getNumericCellValue();
					  Calendar cal =Calendar.getInstance();
					  cal.setTime(DateUtil.getJavaDate(d));
			            cellText =
			             (String.valueOf(cal.get(Calendar.YEAR))).substring(2);
			           cellText = cal.get(Calendar.DAY_OF_MONTH) + "/" +
			                      cal.get(Calendar.MONTH)+1 + "/" + 
			                      cellText;
			           			         }
				 return cellText;
			  }else if(cell.getCellType()==CellType.BLANK)
			      return "";
			  else 
		return String.valueOf(cell.getBooleanCellValue());
			}
			catch(Exception e){
				e.printStackTrace();
				return "row "+rowNum+" or column "+colName +" does not exist in xls";
			}
		}
}