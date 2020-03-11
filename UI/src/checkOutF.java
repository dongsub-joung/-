import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
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
	String bookTitle;
	
	public boolean returnBook;
	//searchF 객체 생성
	
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
	
	//해당 행에 "반납"문자열을 추가
	public void write_RE(int selectedIndex)
	{
			//XSSFRow row;
			//XSSFCell cell;
			try 
			{
				//파일을 읽어옴
				String filepath = "C:/Users/ehdtj/OneDrive/바탕 화면/Web/bookControl/UI/info.xlsx";
				FileInputStream xlsxFile = new FileInputStream(filepath);
				
				//엑셀 객체화
				@SuppressWarnings("resource")
				XSSFWorkbook workbook = new XSSFWorkbook(xlsxFile);
				//엑셀 1번째 시트를 받아옴
				XSSFSheet sheet = workbook.getSheetAt(0);
				//행 지정
				XSSFRow row = sheet.getRow(selectedIndex+1);
				//5행에 반납을 추가
				row.createCell(4).setCellValue("반납");
				
				//데이터 저장
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
			//파일을 읽어옴
			String filepath = "C:/Users/ehdtj/OneDrive/바탕 화면/Web/bookControl/UI/info.xlsx";
			FileInputStream xlsxFile = new FileInputStream(filepath);
			
			//엑셀 객체화
			@SuppressWarnings("resource")
			XSSFWorkbook workbook = new XSSFWorkbook(xlsxFile);
			//엑셀 1번째 시트를 받아옴
			XSSFSheet sheet = workbook.getSheetAt(0);
			
			
			//0,1,2,3,4,5,6.. 증가 그렇지만 입력 하나당 한번씩 했으면
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