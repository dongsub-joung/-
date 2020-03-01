import java.io.FileInputStream;
import java.io.FileOutputStream;

import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;



/*	//���� ���⿡ ���� Ŭ����	
{	
	//���������� �Է¹޾Ƽ� ����
	//���� ������ �˷���
	//���� ������ ����
	//���� ��Ȱ��ȭ
	//������ ���������� ���� �ǿ� ���
}
*/



class checkOutF
{
	String personNum;
	String name;
	String phonNum;
	searchF read = new searchF();
	
	//����ġ ����
	boolean sw= false;
	
	public checkOutF()
	{
		
	}
	
	//���������� �Է¹޾Ƽ� ����
	public checkOutF (String ID, String name, String PH)
	{
		super();
		this.personNum = ID;
		this.name = name;
		this.phonNum = PH;
	}
	
	
	//���� ������ �˷���
	public String volum()
	{
		read.getData();
		String volum = read.amount;
		return volum;
	}
	
	
	//���� ������ ����
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
			//������ �о��
			String filepath = "C:/Users/ehdtj/OneDrive/���� ȭ��/Web/bookControl/UI/info.xlsx";
			FileInputStream xlsxFile = new FileInputStream(filepath);
			//���� ��üȭ
			XSSFWorkbook workbook = new XSSFWorkbook(xlsxFile);
			//���� 1��° ��Ʈ�� �޾ƿ�
			XSSFSheet sheet = workbook.getSheetAt(0);
			//��Ʈ ��ü���� row ���� �޾ƿ�
			int row = sheet.getPhysicalNumberOfRows();
			
			for(int rowNum=0; rowNum<5; rowNum++)
			{
				XSSFRow xlsxRow = sheet.getRow(rowNum);
				
				//�� ��
				int cells = xlsxRow.getPhysicalNumberOfCells();
				for(int cellNum=0; cellNum<5; cellNum++)
				{
					//�� ���� �ҷ���
					String cell = xlsxRow.getCell(cellNum).toString();
					if(cell == null)
					{
						int a = cellNum%3;
						if(a == 1) xlsxRow.createCell(cellNum).setCellValue(personNum);
						if(a == 2) xlsxRow.createCell(cellNum).setCellValue(name);
						if(a == 0) xlsxRow.createCell(cellNum).setCellValue(PH);
					}
				}
			} //�ݺ� ��
			
			outStream = new FileOutputStream(filepath);
			workbook.write(outStream);
		
			xlsxFile.close();
			
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		
	}

}