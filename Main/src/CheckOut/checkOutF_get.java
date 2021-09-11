package CheckOut;

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
		catch (Exception e) { printf(">> Unexpected ERR"); e.printStackTrace(); }
	}

	
	/*
	* Remove a selected value about a book.
	* TODO: GET A VALUE choose GUI options from other class file.
	* Data class is the structure of book's infomations .
	* Data data= new Data();
	*/
	class InfoOfBook {
		String title;
		int reId;	
		InfoOfBook(){
			title= data.title;
			reId= data.ID;
		}
		
		public ArrayList<String> returnArray(){
			private ArrayList<String> pushOther = new ArrayList<String>();
			pushOther.append(title);
			pushOther.append(reId+" ");
			return pushOther;
		}
	}
	
	class InfoOfusers {
		String name;
		int PH;
		int date;
		InfoOfusers(){
			name= data.user_name;
			PH= data.PH;
			date= data.date;
		}
		public ArrayList<String> returnArray(){
			private ArrayList<String> pushOther = new ArrayList<String>();
			pushOther.name(title);
			pushOther.PH(reId+" ");
			pushOther.date(reId+" ");
			return pushOther;
		}
	}

	public void delData(Data data)
	{
		String reset_value= "*";
		Iterator<String> iter= data.iterator();
		
		int i= 0;
		while(iter.hasNext()){
			data.set(i, reset_value); i++;
		}
	}
}
