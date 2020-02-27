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
            
            //매개 변수 선언
            int rowindex=0;
            int columnindex=0;

            //시트 객체화, 시트 수 (첫번째에만 존재하므로 0을 준다)
            XSSFSheet sheet = workbook.getSheetAt(0);
            
            //시트 안의 행 객체화
            int rows = sheet.getPhysicalNumberOfRows();
            
            for(rowindex=0; rowindex<rows+30; rowindex++){	//받아온 행만큼 반복
            	
                //rowindex번 째의 시트 안의 행 val 가져옴
                XSSFRow row = sheet.getRow(rowindex);
                if(row !=null){	//val이 null이 아닐 때
                    //셀의 수 받아와서 변수화
                    int cells = row.getPhysicalNumberOfCells();
                    
                    for(columnindex=0; columnindex<=cells+3; columnindex++){ //받아온 cloumn 만큼 반복
                        //셀값을 읽는다
                        XSSFCell cell = row.getCell(columnindex); //행의 column val을 가져옴
                        
                        String value=""; //선언
                        //셀이 빈값일경우를 위한 널체크
                        if(cell == null){ //행의 cloumn val가 null이면
                            continue;	//해당 if,else를 탈출해라
                        }
                        else{	//행의 cloumn val가 존재한다면
                            //타입별로 내용 읽기
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

	} //main 의 끝

}
