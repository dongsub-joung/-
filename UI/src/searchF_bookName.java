import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class searchF_bookName{

	//���� ���� ����
	String value;
	//searchF_bookName���� ���������� ���ϴ� ����
	public static ArrayList<String> bookName_list = new ArrayList<String>();

	public static String bookName; //�˻� ����
	public static int resultIndex;
	//public int bookIndex;	//������ �ٸ� ������ ��ġ
	
	public String return_bookName(int resultIndex)
	{
		//�ش� index�� ����Ǿ� �ִ� �������� �޾ƿ�
		String result = bookName_list.get(resultIndex);
		//result���� input�� ������� �����Ǿ� ��Ÿ�� , ù��° ������ �����Ǿ� ����
		//System.out.println(result);
		bookName = result;
		return bookName;
	}
	
	//input�� 
	public int return_ResultIndex (String bookName)
	{
		//list������ ���� �������� index�� �����ؼ� ����
		resultIndex = bookName_list.indexOf(bookName);
		//resultIndex�� ���ڴ���̰�, -1�� ��� ��µǴ� ����� �����ؾ���.
		//System.out.println(resultIndex);
		return resultIndex;
	}
			
	//������ ���� ���� �о list�� ������.
	public searchF_bookName(){
		try
		{
			String a= "C:/Users/ehdtj/OneDrive/���� ȭ��/Web/bookControl/UI/bookList.xlsx";
			FileInputStream file = new FileInputStream(a);
			@SuppressWarnings("resource")
			
			XSSFWorkbook workbook = new XSSFWorkbook(file);
			XSSFSheet sheet = workbook.getSheetAt(0);
			
			value="";
			int rows = sheet.getPhysicalNumberOfRows();
			//�� �����͸� ���� 1���� ~ ������
			for(int rowIndex=3; rowIndex< rows+30; rowIndex++)
			{
				XSSFRow row = sheet.getRow(rowIndex);
				if(row != null)
				{
					//������ �����Ͱ��� ���ϰ� �ప�� ����
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
			//�������� ���������� list�� �����.
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