import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;


import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.util.ArrayList;


/*
{ //검색 버튼을 누름

	getData();	데이터 베이스에서 데이터를 읽음, 배열로 저장
	returnIndex(String bookName); 입력된 String과 비교, 데이터가 있는 행 값을 반환
	serchResult (); 입력된 값에 있던 행의 데이터의 배열을 리턴

} //결과 출력
*/


class searchF{
	//전역 변수 선언
			String value;
			String bookName;
			boolean compareIndex = false;
			int resultIndex;
			
			String publishingCompany;
			String author;
			String translator;
			String amount;
			
			ArrayList<String> list = new ArrayList<String>();
			
	
//엑셀의 데이터를 가지오는 메소드
//value의 값을 가져오는 메소드
			public  void getData()
			{
				try 
				{
					FileInputStream file = new FileInputStream("C:/Users/ehdtj/OneDrive/바탕 화면/Web/bookControl/UI/bookList.xlsx");
					@SuppressWarnings("resource")
					XSSFWorkbook workbook = new XSSFWorkbook(file);
					
					int rowIndex;
					int columnIndex;

					value="";
					
					XSSFSheet sheet = workbook.getSheetAt(0);
					int rows = sheet.getPhysicalNumberOfRows();
					
					for(rowIndex=1; rowIndex< rows+30; rowIndex++)
					{
		                // 셀값을 저장할 리스트
		                

						//행 수+30만큼 시트에서의 rowIndex행 데이터를 읽어옴
						XSSFRow row = sheet.getRow(rowIndex);
						
						if(row != null)
						{
							int cells = row.getPhysicalNumberOfCells();
							
							for(columnIndex=1; columnIndex <= cells+3; columnIndex++)
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
									case FORMULA://XSSFCell.CELL_TYPE_FORMULA:
										value = cell.getCellFormula();
										break;
									case NUMERIC://XSSFCell.CELL_TYPE_NUMERIC:
										value = cell.getNumericCellValue()+"";
										break;
									case STRING://XSSFCell.CELL_TYPE_STRING:
										value = cell.getStringCellValue()+"";
										break;
									case BLANK://XSSFCell.CELL_TYPE_BLANK:
										value = cell.getBooleanCellValue()+"";
										break;
									case ERROR://XSSFCell.CELL_TYPE_ERROR:
										value = cell.getErrorCellValue()+"";
										break;
									default:
										break;
									}
								}//for문
		
								//value들을 list에 넣음
								this.list.add(value);
						}
					}	 
				}
				}
					catch (FileNotFoundException e)
					{
					// TODO Auto-generated catch block
					e.printStackTrace();
					} 
				catch (IOException e) 
				{
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
				
				
			}
			
					
//입력된 String과 비교, 데이터가 있는 행 값을 반환
	public void returnIndex (String bookName)
	{
		int resultIndex = list.indexOf(bookName);
		String result = list.get(resultIndex);
		if(bookName == result) this.compareIndex = true;
		this.resultIndex = resultIndex;
	}
	
//resultIndex+7 까지의 리스트가 내가 원하는 데이터 =첵에 대한 정보
//책에 해당하는 데이터를 반환
	public void serchResult ()
	{
		int first = this.resultIndex;
		int i;
		for(i=0; i<=7; i++)
		{
			String data = list.get(first);
			first++;
			if(i==0) this.bookName = data;
			if(i==1) this.publishingCompany= data;
			if(i==2) this.author = data;
			if(i==3) this.translator = data;
			if(i==6) this.amount = data;
			
			//내가 원하는건 list에 있는 데이터를 first~ +7까지의 데이터를 가져오는 것.
		}
		//값을 전달했으니 다시 돌림
		this.compareIndex = false;
	}
}

