import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;

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
		
	public ArrayList<String> reBookName() 
	{
		return ListBookName;
	}
	
	public ArrayList<Boolean> reSW ()
	{
		return return_checkOut;
	}
	
	public void reset_result()
	{
		ListID.clear();
		ListBookName.clear();
	}
	
	public checkOutF_get ()
	{	
		try {
			reset_result();
			
			String a = "C:/Users/ehdtj/OneDrive/바탕 화면/Web/bookControl/UI/info.xlsx";
			FileInputStream file = new FileInputStream(a);
			@SuppressWarnings("resource")
			XSSFWorkbook workbook = new XSSFWorkbook(file);
			XSSFSheet sheet = workbook.getSheetAt(0); 
			String value = null;
			boolean sw = false;
			
			//행 추출
			int iMax= sheet.getPhysicalNumberOfRows();
			for(int i=1; i<=iMax; i++)
			{
				//행 반복
				XSSFRow row = sheet.getRow(i);
				
				if(row != null)
				{
					//int cells = row.getPhysicalNumberOfCells();
					for(int columnIndex=0; columnIndex<=5; columnIndex++)
					{
						XSSFCell cell = row.getCell(columnIndex);
						
						if(cell == null)
						{
							continue;
						}
						else 
						{
							switch(cell.getCellType())
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
							
							//값을 저장
							
							
							switch(columnIndex)
							{
							case 0:
								ListID.add(value);
								break;
							case 3:
								ListBookName.add(value);
								break;
							case 4: 
								if(value=="반납")
								{
									sw = true;
									return_checkOut.add(sw);
								}
								else
								{
									return_checkOut.add(sw);
								}
								break;
							default:
								break;
							}	
							
						}
						
					}
				}
			}
			
		}
		catch (FileNotFoundException e){
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
	//choice의 선택 값을 받아서 삭제
	public void delData()
	{
		
	}
}