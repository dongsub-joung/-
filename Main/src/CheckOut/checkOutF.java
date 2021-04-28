package Init;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class checkOutF
{
	final int SPACE_RETURN= 4;
	private boolean bol_check_out_book= false;

	public boolean toggleCheckOutValue() { return bol_check_out_book = true; }

	// Insert String "Returned book" on user_data
	public void insertData(int selectedIndex)
	{
			try(FileInputStream USER_File = new FileInputStream(COMMON.USER_PATH);
				XSSFWorkbook workbook = new XSSFWorkbook(USER_File))
			{
				@SuppressWarnings("resource")
				XSSFRow row = workbook.getSheetAt(0).getRow(selectedIndex+1))
				// Adding String at Row5
				row.createCell(SPACE_RETURN).setCellValue("Returned book");
				COMMON.commint(workbook, COMMON.USER_PATH);
			}
			catch (FileNotFoundException e) { System.out.println(e + "file not found"); }
			catch (IOException e) { System.out.println(e + "IO exception"); }
			catch (Exception e) { e.printStackTrace(); }
	}
}