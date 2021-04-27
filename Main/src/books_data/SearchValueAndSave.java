package books_data;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import Init.COMMON;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import static DataParsing.ParsingBookData.dataType;


public class SearchValueAndSave
{

	SearchValueAndSave(){}
	public SearchValueAndSave(int bookIndex)
	{
		String value= "";

		try(FileInputStream file = new FileInputStream(COMMON.FILE_PATH);
			@SuppressWarnings("resource")
			XSSFWorkbook workbook = new XSSFWorkbook(file);
			XSSFSheet sheet = workbook.getSheetAt(0);
			XSSFRow row = sheet.getRow(bookIndex+3))
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
								DataArray.getBookNames().add(value);
								break;
							case 2:
								DataArray.getPublishingCompanys().add(value);
								break;
							case 3:
								DataArray.getAuthors().add(value);
								break;
							case 4:
								DataArray.getTranslators().add(value);
								break;
							case 7:
								DataArray.getAmounts().add(value);
								break;
							case 8:
								DataArray.getLocations().add(value);
								break;
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
}