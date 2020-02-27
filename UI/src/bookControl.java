import java.io.FileInputStream;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;


public class bookControl {


	public static void main (String[] args) {
		// TODO Auto-generated method stub
		
		try {
            FileInputStream file = new FileInputStream("C:/Users/82109/Documents/GitHub/bookControl/UI/bookList.xlsx");
            XSSFWorkbook workbook = new XSSFWorkbook(file);
            
            //�Ű� ���� ����
            int rowindex=0;
            int columnindex=0;

            //��Ʈ ��üȭ, ��Ʈ �� (ù��°���� �����ϹǷ� 0�� �ش�)
            XSSFSheet sheet = workbook.getSheetAt(0);
            
            //��Ʈ ���� �� ��üȭ
            int rows = sheet.getPhysicalNumberOfRows();
            
            for(rowindex=0; rowindex<rows+30; rowindex++){	//�޾ƿ� �ุŭ �ݺ�
            	
                //rowindex�� °�� ��Ʈ ���� �� val ������
                XSSFRow row = sheet.getRow(rowindex);
                if(row !=null){	//val�� null�� �ƴ� ��
                    //���� �� �޾ƿͼ� ����ȭ
                    int cells = row.getPhysicalNumberOfCells();
                    
                    for(columnindex=0; columnindex<=cells+3; columnindex++){ //�޾ƿ� cloumn ��ŭ �ݺ�
                        //������ �д´�
                        XSSFCell cell = row.getCell(columnindex); //���� column val�� ������
                        
                        String value=""; //����
                        //���� ���ϰ�츦 ���� ��üũ
                        if(cell == null){ //���� cloumn val�� null�̸�
                            continue;	//�ش� if,else�� Ż���ض�
                        }
                        else{	//���� cloumn val�� �����Ѵٸ�
                            //Ÿ�Ժ��� ���� �б�
                            switch (cell.getCellType()){
                            case XSSFCell.CELL_TYPE_FORMULA:
                                value=cell.getCellFormula();
                                break;
                            case XSSFCell.CELL_TYPE_NUMERIC:
                                value=cell.getNumericCellValue()+"";
                                break;
                            case XSSFCell.CELL_TYPE_STRING:
                                value=cell.getStringCellValue()+"";
                                break;
                            case XSSFCell.CELL_TYPE_BLANK:
                                value=cell.getBooleanCellValue()+"";
                                break;
                            case XSSFCell.CELL_TYPE_ERROR:
                                value=cell.getErrorCellValue()+"";
                                break;
                            }
                        }
                        System.out.println(value);
                    }
 
                }
            }
		}
		catch(Exception e) {
			e.printStackTrace();
		}

	} //main �� ��

}
