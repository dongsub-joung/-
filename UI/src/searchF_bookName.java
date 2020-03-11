import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class searchF_bookName{

	//전역 변수 선언
	String value;
	//searchF_bookName에서 최종적으로 구하는 변수
	public static ArrayList<String> bookName_list = new ArrayList<String>();

	public static String bookName; //검색 도서
	public static int resultIndex;
	//public int bookIndex;	//도서의 다른 데이터 위치
	
	public String return_bookName(int resultIndex)
	{
		//해당 index에 저장되어 있는 도서명을 받아옴
		String result = bookName_list.get(resultIndex);
		//result값이 input에 상관없이 고정되어 나타남 , 첫번째 도서명에 고정되어 있음
		//System.out.println(result);
		bookName = result;
		return bookName;
	}
	
	//input과 
	public int return_ResultIndex (String bookName)
	{
		//list내에서 같은 도서명의 index를 리턴해서 저장
		resultIndex = bookName_list.indexOf(bookName);
		//resultIndex가 제멋대로이고, -1일 경우 출력되는 경고문을 구현해야함.
		//System.out.println(resultIndex);
		return resultIndex;
	}
			
	//생성자 도서 명을 읽어서 list로 저장함.
	public searchF_bookName(){
		try
		{
			String a= "C:/Users/ehdtj/OneDrive/바탕 화면/Web/bookControl/UI/bookList.xlsx";
			FileInputStream file = new FileInputStream(a);
			@SuppressWarnings("resource")
			
			XSSFWorkbook workbook = new XSSFWorkbook(file);
			XSSFSheet sheet = workbook.getSheetAt(0);
			
			value="";
			int rows = sheet.getPhysicalNumberOfRows();
			//행 데이터를 읽음 1부터 ~ 끝까지
			for(int rowIndex=3; rowIndex< rows+30; rowIndex++)
			{
				XSSFRow row = sheet.getRow(rowIndex);
				if(row != null)
				{
					//제목의 데이터값을 비교하고 행값을 리턴
					XSSFCell cell = row.getCell(1);
					
					if(cell == null)
					{
						continue;
					}
					else
					{
						switch(cell.getCellType())
						{
						case STRING: //XSSFCell.CELL_TYPE_STRING:
							value = cell.getStringCellValue();
							break;
						default:
							break;
						}
					}
				}
				bookName_list.add(value);
			}
			//도서명은 정상적으로 list에 저장됨.
			//System.out.println(bookName_list); 
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