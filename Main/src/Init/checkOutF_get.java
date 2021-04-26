import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;

import jdk.swing.interop.SwingInterOpUtils;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class checkOutF_get
{
	//static String ID;
	//static String bookName;
	static ArrayList<String> ListID = new ArrayList<String>();
	static ArrayList<String> ListBookName = new ArrayList<String>();
	static ArrayList<Boolean> return_checkOut = new  ArrayList<Boolean>();
	
	public ArrayList<String> reId() 
	{
		return ListID;
	}
	public ArrayList<String> reBookName() { return ListBookName; }
	public ArrayList<Boolean> reSW () { return return_checkOut; }

	public void reset_result() { ListID.clear(); ListBookName.clear(); }

	public checkOutF_get ()
	{
		reset_result();
		final int BOOK_SHEET= 0;
		try(FileInputStream file = new FileInputStream(FI);
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
							dataType(cell.getCellType(), cell);
							switch(columnIndex)
							{
								case 0:
									ListID.add(value);
									break;
								case 3:
									ListBookName.add(value);
									break;
								case 4:
									if(value=="Returned book")
									{
										sw = true;
										return_checkOut.add(sw);
									}
									else { return_checkOut.add(sw); }
									break;
								default:
									break;
							}
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

//	Please check object type when you use.
	private void dataType(XSSFCell getType, XSSFCell cell)
	{
		switch(getType)
		{
			case NUMERIC://XSSFCell.CELL_TYPE_NUMERIC:
				value = cell.getStringCellValue()+"";
				break;
			case STRING://XSSFCell.CELL_TYPE_STRING:
				value = cell.getStringCellValue()+"";
				break;
			case BLANK://XSSFCell.CELL_TYPE_BLANK:
				value = "nell";
				break;
			case ERROR://XSSFCell.CELL_TYPE_ERROR:
				value = cell.getErrorCellValue()+"";
				break;
			default:
				break;
		}
	}

	// Remove a choice value selected.
	public void delData()
	{
		
	}
}