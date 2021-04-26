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

public class searchF_other
{
	public String publishingCompany= "", author="", translator= "", amount= "", location= "";

	private static ArrayList<String> authors = new ArrayList<>();
	private static ArrayList<String> publishingCompanys = new ArrayList<>();
	private static ArrayList<String> translators = new ArrayList<>();
	private static ArrayList<String> amounts = new ArrayList<>();
	private static ArrayList<String> locations = new ArrayList<>();

	public static ArrayList<String> getAuthors() {
		return authors;
	}

	public static ArrayList<String> getPublishingCompanys() {
		return publishingCompanys;
	}

	public static ArrayList<String> getTranslators() {
		return translators;
	}

	public static ArrayList<String> getAmounts() {
		return amounts;
	}

	public static ArrayList<String> getLocations() {
		return locations;
	}

	public String retunr_author() { return author; }

	public String retunr_publishing() { return publishingCompany; }
	public  String retunr_translator() { return translator; }
	public  String retunr_amount() { return amount; }
	public  String retunr_loacation() { return location; }

	
	
	public searchF_other (int bookIndex)
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
				for(int columnIndex=2; columnIndex <= cells+3; columnIndex++)
				{
					XSSFCell cell = row.getCell(columnIndex);
					if(cell != null)
					{
						value= dataType(cell.getCellType(), cell);

						switch(columnIndex)
						{
							case 2:
								publishingCompany = value;
								publishingCompanys.add(value);
								break;
							case 3:
								author = value;
								authors.add(value);
								break;
							case 4:
								translator = value;
								translators.add(value);
								break;
							case 7:
								amount = value;
								amounts.add(value);
								break;
							case 8:
								location = value;
								locations.add(value);
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