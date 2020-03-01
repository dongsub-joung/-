import java.io.FileInputStream;
import java.io.FileOutputStream;

import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;



/*	//도서 대출에 관한 클래스	
{	
	//개인정보를 입력받아서 저장
	//도서 수량을 알려줌
	//도서 수량을 감소
	//대출 비활성화
	//대출자 개인정보를 대출 탭에 출력
}
*/



class checkOutF
{
	String personNum;
	String name;
	String phonNum;
	searchF read = new searchF();
	
	//스위치 변수
	boolean sw= false;
	
	public checkOutF()
	{
		
	}
	
	//개인정보를 입력받아서 저장
	public checkOutF (String ID, String name, String PH)
	{
		super();
		this.personNum = ID;
		this.name = name;
		this.phonNum = PH;
	}
	
	
	//도서 수량을 알려줌
	public String volum()
	{
		read.getData();
		String volum = read.amount;
		return volum;
	}
	
	
	//도서 수량을 감소
	public void decrease (String volum)
	{
		int i = Integer.parseInt(volum);
		i = i-1;
		if(i == 0) sw = true;
	}
	
	
	public  void saveData(String personNum, String name, String PH)
	{
		FileOutputStream outStream = null;

		try {
			//파일을 읽어옴
			String filepath = "C:/Users/ehdtj/OneDrive/바탕 화면/Web/bookControl/UI/info.xlsx";
			FileInputStream xlsxFile = new FileInputStream(filepath);
			//엑셀 객체화
			XSSFWorkbook workbook = new XSSFWorkbook(xlsxFile);
			//엑셀 1번째 시트를 받아옴
			XSSFSheet sheet = workbook.getSheetAt(0);
			//시트 객체에서 row 수를 받아옴
			int row = sheet.getPhysicalNumberOfRows();
			
			for(int rowNum=0; rowNum<5; rowNum++)
			{
				XSSFRow xlsxRow = sheet.getRow(rowNum);
				
				//셀 값
				int cells = xlsxRow.getPhysicalNumberOfCells();
				for(int cellNum=0; cellNum<5; cellNum++)
				{
					//셀 값을 불러옴
					String cell = xlsxRow.getCell(cellNum).toString();
					if(cell == null)
					{
						int a = cellNum%3;
						if(a == 1) xlsxRow.createCell(cellNum).setCellValue(personNum);
						if(a == 2) xlsxRow.createCell(cellNum).setCellValue(name);
						if(a == 0) xlsxRow.createCell(cellNum).setCellValue(PH);
					}
				}
			} //반복 끝
			
			outStream = new FileOutputStream(filepath);
			workbook.write(outStream);
		
			xlsxFile.close();
			
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		
	}

}