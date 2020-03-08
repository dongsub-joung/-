import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class searchF_other
{
	String value;
	
	static String publishingCompany;
	static String author;
	static String translator;
	static String amount;
	static String location;
	
	public String retunr_author() {
		return author;
	}
	public String retunr_publishing() {
		return publishingCompany;
	}
	public String retunr_translator() {
		return translator;
	}
	public String retunr_amount() {
		return amount;
	}
	public String retunr_loacation() {
		return location;
	}
	
	
	public searchF_other (int bookIndex)
	{
		try {
			//파일을 받아옴
			String a = "C:/Users/ehdtj/OneDrive/바탕 화면/Web/bookControl/UI/bookList.xlsx";
			FileInputStream file = new FileInputStream(a);
			@SuppressWarnings("resource")
			XSSFWorkbook workbook = new XSSFWorkbook(file);
			//첫번째 시트를 받아옴
			XSSFSheet sheet = workbook.getSheetAt(0); 
			value="";
			
			//입력받은 index행에서 데이터을 추출
			XSSFRow row = sheet.getRow(bookIndex+3);
			
			if(row != null)
			{
				//max +3 셀까지 가져옴, 출판사~위치
				int cells = row.getPhysicalNumberOfCells();
				for(int columnIndex=2; columnIndex <= cells+3; columnIndex++)
				{
					//셀의 데이터를 받아옴
					XSSFCell cell = row.getCell(columnIndex);
					//데이터 타입 정의
					if(cell == null)
					{
						continue;
					}
					else 
					{
						//데이터를 분류
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
						case 2:
							publishingCompany = value;
							break;
						case 3:
							author = value;
							break;
						case 4:
							translator = value;
							break;
						case 7:
							amount = value;
							break;
						case 8:
							location = value;
							break;
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
}