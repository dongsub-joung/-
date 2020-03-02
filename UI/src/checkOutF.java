import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;


//개인정보를 입력받아서 저장

public class checkOutF
{
	//전역 변수
	String personNum;
	String name;
	String phonNum;
	//searchF 객체 생성
	searchF read = new searchF();
	
	//생성자 
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
			//파일을 읽어옴
			String filepath = "C:/Users/ehdtj/OneDrive/바탕 화면/Web/bookControl/UI/info.xlsx";
			FileInputStream xlsxFile = new FileInputStream(filepath);
			
			//엑셀 객체화
			XSSFWorkbook workbook = new XSSFWorkbook(xlsxFile);
			//엑셀 1번째 시트를 받아옴
			XSSFSheet sheet = workbook.getSheetAt(0);
			
			
			//0,1,2,3,4,5,6.. 증가 그렇지만 입력 하나당 한번씩 했으면
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

			try //데이터 저장
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