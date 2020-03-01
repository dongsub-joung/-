import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;


import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.util.ArrayList;


/*
{ //�˻� ��ư�� ����

	getData();	������ ���̽����� �����͸� ����, �迭�� ����
	returnIndex(String bookName); �Էµ� String�� ��, �����Ͱ� �ִ� �� ���� ��ȯ
	serchResult (); �Էµ� ���� �ִ� ���� �������� �迭�� ����

} //��� ���
*/


class searchF{
	//���� ���� ����
			String value;
			String bookName;
			boolean compareIndex = false;
			int resultIndex;
			
			String publishingCompany;
			String author;
			String translator;
			String amount;
			
			ArrayList<String> list = new ArrayList<String>();
			
	
//������ �����͸� �������� �޼ҵ�
//value�� ���� �������� �޼ҵ�
			public  void getData()
			{
				try 
				{
					FileInputStream file = new FileInputStream("C:/Users/ehdtj/OneDrive/���� ȭ��/Web/bookControl/UI/bookList.xlsx");
					@SuppressWarnings("resource")
					XSSFWorkbook workbook = new XSSFWorkbook(file);
					
					int rowIndex;
					int columnIndex;

					value="";
					
					XSSFSheet sheet = workbook.getSheetAt(0);
					int rows = sheet.getPhysicalNumberOfRows();
					
					for(rowIndex=1; rowIndex< rows+30; rowIndex++)
					{
		                // ������ ������ ����Ʈ
		                

						//�� ��+30��ŭ ��Ʈ������ rowIndex�� �����͸� �о��
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
								}//for��
		
								//value���� list�� ����
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
			
					
//�Էµ� String�� ��, �����Ͱ� �ִ� �� ���� ��ȯ
	public void returnIndex (String bookName)
	{
		int resultIndex = list.indexOf(bookName);
		String result = list.get(resultIndex);
		if(bookName == result) this.compareIndex = true;
		this.resultIndex = resultIndex;
	}
	
//resultIndex+7 ������ ����Ʈ�� ���� ���ϴ� ������ =ý�� ���� ����
//å�� �ش��ϴ� �����͸� ��ȯ
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
			
			//���� ���ϴ°� list�� �ִ� �����͸� first~ +7������ �����͸� �������� ��.
		}
		//���� ���������� �ٽ� ����
		this.compareIndex = false;
	}
}

