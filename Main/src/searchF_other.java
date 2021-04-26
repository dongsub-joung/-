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
			//������ �޾ƿ�
			String a = "C:/Users/ehdtj/OneDrive/���� ȭ��/Web/bookControl/UI/bookList.xlsx";
			FileInputStream file = new FileInputStream(a);
			@SuppressWarnings("resource")
			XSSFWorkbook workbook = new XSSFWorkbook(file);
			//ù��° ��Ʈ�� �޾ƿ�
			XSSFSheet sheet = workbook.getSheetAt(0); 
			value="";
			
			//�Է¹��� index�࿡�� �������� ����
			XSSFRow row = sheet.getRow(bookIndex+3);
			
			if(row != null)
			{
				//max +3 ������ ������, ���ǻ�~��ġ
				int cells = row.getPhysicalNumberOfCells();
				for(int columnIndex=2; columnIndex <= cells+3; columnIndex++)
				{
					//���� �����͸� �޾ƿ�
					XSSFCell cell = row.getCell(columnIndex);
					//������ Ÿ�� ����
					if(cell == null)
					{
						continue;
					}
					else 
					{
						//�����͸� �з�
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
						
						//���� ����
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