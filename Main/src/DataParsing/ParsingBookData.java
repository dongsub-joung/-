package DataParsing;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.util.ArrayList;

public class ParsingBookData
{
    //	Please check object type when you use.
    public static String dataType(XSSFCell getType, XSSFCell cell)
    {
        String value= "";
        switch(getType)
        {
            case NUMERIC://XSSFCell.CELL_TYPE_NUMERIC:
                value = cell.getStringCellValue()+"";
                break;
            case STRING://XSSFCell.CELL_TYPE_STRING:
                value = cell.getStringCellValue()+"";
                break;
            case BLANK://XSSFCell.CELL_TYPE_BLANK:
                value = "nell";
                break;
            case ERROR://XSSFCell.CELL_TYPE_ERROR:
                value = cell.getErrorCellValue()+"";
                break;
            default:
                value= "null";
                break;
        }
        return value;
    }
}
