package Init;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import static DataParsing.ParsingBookData.dataType;


public class checkOutF_get
{
	private static ArrayList<String> ListID = new ArrayList<String>();
	private static ArrayList<String> ListBookName = new ArrayList<String>();
	private static ArrayList<Boolean> return_checkOut = new  ArrayList<Boolean>();
	
	public static ArrayList<String> reId() { return ListID; }
	public static ArrayList<String> reBookName() { return ListBookName; }
	public static ArrayList<Boolean> reSW () { return return_checkOut; }

	public void reset_result() { ListID.clear(); ListBookName.clear(); }
	public checkOutF_get () { reset_result(); }


	private static void addEachValues(int columnIndex, String value)
	{
		switch(columnIndex)
		{
			case 0:
				reId().add(value);
				break;
			case 3:
				reBookName().add(value);
				break;
			case 4:
				if(value.equals("Returned book")) { return_checkOut.add(true); }
				else { return_checkOut.add(false); }
				break;
			default:
				break;
		}
	}

	public void GetBooksData()
	{
		final int BOOK_SHEET= 0;
		try(FileInputStream file = new FileInputStream(COMMON.USER_PATH);
			XSSFWorkbook workbook = new XSSFWorkbook(file))
		{
			String value = null; int iMax; boolean sw = false;

			@SuppressWarnings("resource")
			XSSFSheet sheet = workbook.getSheetAt(BOOK_SHEET);
			iMax= sheet.getPhysicalNumberOfRows();
			for(int i=1; i<=iMax; i++)
			{
				XSSFRow row = sheet.getRow(i);
				if(row != null)
				{
					for(int columnIndex=0; columnIndex<=5; columnIndex++)
					{
						XSSFCell cell = row.getCell(columnIndex);
						if(cell != null)
						{
//							Please adjust getCellType obj type in dataType function.
							value= dataType(cell.getCellType(), cell);
							addEachValues(columnIndex, value);
						}
						else if (cell == null) { continue; }
					}
				}
				else if(row == null) { System.out.println("Row value is null"); }
			}
		}
		catch (FileNotFoundException e){ e.printStackTrace(); }
		catch (IOException e) { e.printStackTrace(); }
	}

	// Remove a choice value selected.
	public void delData()
	{
		
	}
}