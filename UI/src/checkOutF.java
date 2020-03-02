import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFCell;
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
	//searchF ��ü ����
	searchF read = new searchF();
	
	//������ 
	public checkOutF()
	{
		
	}
	
	public checkOutF (String ID, String name, String PH)
	{
		super();
		this.personNum = ID;
		this.name = name;
		this.phonNum = PH;
	}
	

	public  void saveData(String personNum, String name, String PH)
	{
		XSSFRow row;
		//XSSFCell cell;
		try 
		{
			//������ �о��
			String filepath = "C:/Users/ehdtj/OneDrive/���� ȭ��/Web/bookControl/UI/info.xlsx";
			FileInputStream xlsxFile = new FileInputStream(filepath);
			
			//���� ��üȭ
			XSSFWorkbook workbook = new XSSFWorkbook(xlsxFile);
			//���� 1��° ��Ʈ�� �޾ƿ�
			XSSFSheet sheet = workbook.getSheetAt(0);
			
			
			//0,1,2,3,4,5,6.. ���� �׷����� �Է� �ϳ��� �ѹ��� ������
			int rowMax = sheet.getPhysicalNumberOfRows();
			
			row = sheet.createRow(rowMax);
			
			int jMax = 3;
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