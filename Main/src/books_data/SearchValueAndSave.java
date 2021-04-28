package books_data;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.HashMap;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import Init.COMMON;
import static DataParsing.ParsingBookData.dataType;

/*
	1. Get String entered by user.
	2. DataArray.bookNames().indexOf(String str)
	3. Adjust SearchValueAndSave's parameter.
	4. Set HashMap obj_searched_book
 */

public class SearchValueAndSave
{
	private static HashMap obj_searched_book= new HashMap();

//	Search Row using bookIndex, than save values in obj_searched_book.
	public SearchValueAndSave(int bookIndex)
	{
		final int SELECTED_ROW= bookIndex+3;
		String value= "";

		try(FileInputStream file = new FileInputStream(COMMON.FILE_PATH);
			@SuppressWarnings("resource")
			XSSFWorkbook workbook = new XSSFWorkbook(file);
			XSSFSheet sheet = workbook.getSheetAt(COMMON.ABOUT_BOOK_SHEET);
			XSSFRow row = sheet.getRow(SELECTED_ROW))
		{
			if(row != null)
			{
				// [max : max +3]
				int cells = row.getPhysicalNumberOfCells();
				for(int columnIndex=1; columnIndex <= cells+3; columnIndex++)
				{
					XSSFCell cell = row.getCell(columnIndex);
					if(cell != null)
					{
						value= dataType(cell.getCellType(), cell);
						switch(columnIndex)
						{
							case 1:
								obj_searched_book.put("BookName", value);
								break;
							case 2:
								obj_searched_book.put("PublishingCompanys", value);
								break;
							case 3:
								obj_searched_book.put("Authors", value);
								break;
							case 4:
								obj_searched_book.put("Translators", value);
								break;
							case 7:
								obj_searched_book.put("Amounts", value);
								break;
							case 8:
								obj_searched_book.put("Locations", value);
								break;
							default:
								System.out.println("Out Of Range"); break;
						}
					}
					else if (cell == null) { continue; }
				}
			}
		}
		catch (FileNotFoundException e){ System.out.println("file path err"); e.printStackTrace(); }
		catch (IOException e) { System.out.println("I/O err"); e.printStackTrace(); }
		catch (Exception e) { System.out.println(e + "unexpected err"); }
	}

	public static HashMap getObj_searched_book() {
		return obj_searched_book;
	}

	public static String getSearchedObj()
	{
		String bookName = obj_searched_book.get("BookName") + System.lineSeparator();
		String author = obj_searched_book.get("Authors") + System.lineSeparator();
		String translator= other.retunr_translator() + System.lineSeparator();
		String publishingCompany = other.retunr_publishing() + System.lineSeparator();
		String amount = other.retunr_amount();
		return bookName + "Author: "+author + "translator: " + translator + "PublishingCompany: "+ publishingCompany;
	}
}