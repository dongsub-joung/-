package books_data;
import Init.*;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;


public class BookNameList
{
    final int TITLE_INDEX= 1;
    public static ArrayList<String> bookName_list = new ArrayList<>();

    //  Set bookName_list
    private void BookNameList()
    {
        try (FileInputStream file = new FileInputStream(COMMON.FILE_PATH);
             XSSFWorkbook workbook = new XSSFWorkbook(file);
             XSSFSheet sheet = workbook.getSheetAt(0);
             int rows = sheet.getPhysicalNumberOfRows())
        {
            @SuppressWarnings("resource");
            for(int rowIndex=3; rowIndex< rows+30; rowIndex++)
            {
                XSSFRow row = sheet.getRow(rowIndex);
                if(row != null)
                {
                    XSSFCell cell = row.getCell(TITLE_INDEX);
                    if(cell != null)
                    {
                        switch(cell.getCellType())
                        {
                            case STRING: //XSSFCell.CELL_TYPE_STRING:
                                // Add book's title at ArrayList
                                bookName_list.add(cell.getStringCellValue());
                                break;
                            case BLANK://XSSFCell.CELL_TYPE_BLANK:
                                value = "nell";
                                break;
                            default:
                                break;
                        }
                    }
                    else if ( cell == null) { continue; }
                }
            }
        }

        catch (FileNotFoundException e){
            e.printStackTrace();
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }
}

