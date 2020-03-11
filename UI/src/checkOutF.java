import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;


//���������� �Է¹޾Ƽ� ����

public class checkOutF
{
	//���� ����
	String personNum;
	String name;
	String phonNum;
	String bookTitle;
	
	public boolean returnBook;
	//searchF ��ü ����
	
	public checkOutF() {
		returnBook = false;
	}
	
	public checkOutF (String ID, String name, String PH, String bookName)
	{
		super();
		this.personNum = ID;
		this.name = name;
		this.phonNum = PH;
		this.bookTitle = bookName;
	}
	
	public boolean sw_returnBook()
	{
		return returnBook = true;
	}
	
	//�ش� �࿡ "�ݳ�"���ڿ��� �߰�
	public void write_RE(int selectedIndex)
	{
			//XSSFRow row;
			//XSSFCell cell;
			try 
			{
				//������ �о��
				String filepath = "C:/Users/ehdtj/OneDrive/���� ȭ��/Web/bookControl/UI/info.xlsx";
				FileInputStream xlsxFile = new FileInputStream(filepath);
				
				//���� ��üȭ
				@SuppressWarnings("resource")
				XSSFWorkbook workbook = new XSSFWorkbook(xlsxFile);
				//���� 1��° ��Ʈ�� �޾ƿ�
				XSSFSheet sheet = workbook.getSheetAt(0);
				//�� ����
				XSSFRow row = sheet.getRow(selectedIndex+1);
				//5�࿡ �ݳ��� �߰�
				row.createCell(4).setCellValue("�ݳ�");
				
				//������ ����
				try 
				{
					FileOutputStream outFile = new FileOutputStream(new File(filepath));
					workbook.write(outFile);
					outFile.close();
				} 
				
				catch (Exception e) 
				{
					// TODO: handle exception
				}
			}
			
			
			catch (FileNotFoundException e)
			{
				e.printStackTrace();
			}
			catch (IOException e)
			{
				e.printStackTrace();
			}
			catch (Exception e) 
			{
				// TODO: handle exception
			}
		
	}
	

	public  void saveData(String personNum, String name, String PH, String bookTitle)
	{
		XSSFRow row;
		//XSSFCell cell;
		try 
		{
			//������ �о��
			String filepath = "C:/Users/ehdtj/OneDrive/���� ȭ��/Web/bookControl/UI/info.xlsx";
			FileInputStream xlsxFile = new FileInputStream(filepath);
			
			//���� ��üȭ
			@SuppressWarnings("resource")
			XSSFWorkbook workbook = new XSSFWorkbook(xlsxFile);
			//���� 1��° ��Ʈ�� �޾ƿ�
			XSSFSheet sheet = workbook.getSheetAt(0);
			
			
			//0,1,2,3,4,5,6.. ���� �׷����� �Է� �ϳ��� �ѹ��� ������
			int rowMax = sheet.getPhysicalNumberOfRows();
			
			row = sheet.createRow(rowMax);
			
			int jMax = 5;
			for(int j=0; j<=jMax; j++)
			{
				switch (j) 
				{
				case 0:
					row.createCell(j).setCellValue(personNum);
					break;
				case 1:
					row.createCell(j).setCellValue(name);
					break;
				case 2:
					row.createCell(j).setCellValue(PH);
					break;
				case 3:
					row.createCell(j).setCellValue(bookTitle);
					break;
				default:
					break;
				}	
			}

			try //������ ����
			{
				FileOutputStream outFile = new FileOutputStream(new File(filepath));
				workbook.write(outFile);
				outFile.close();
			} 
			
			catch (Exception e) 
			{
				// TODO: handle exception
			}
		}
		
		
		catch (FileNotFoundException e)
		{
			e.printStackTrace();
		}
		catch (IOException e)
		{
			e.printStackTrace();
		}
		catch (Exception e) 
		{
			// TODO: handle exception
		}
		
		
	}

}