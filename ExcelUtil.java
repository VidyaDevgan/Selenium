package commonUtils;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ExcelUtil {

	public String getDataFromExcel(String Sheetname,int Rownum,int Cellnum) throws EncryptedDocumentException, IOException {
		// TODO Auto-generated method stub

	
		FileInputStream fils = new FileInputStream("src/test/resources/Data.xlsx");
		
		Workbook wb = WorkbookFactory.create(fils);
		
		//Sheet sh = wb.getSheet("Organizations");
		//Sheet sh = wb.getSheet("Contacts");
		Sheet sh = wb.getSheet("Leads");
		
		
		Row rw = sh.getRow(Rownum);
		
        Cell c1 = rw.getCell(Cellnum);
        
        String val = c1.getStringCellValue();
        
        return val;
        
	}

}
