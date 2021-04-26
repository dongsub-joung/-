package user_data;

import Init.COMMON;
import static Init.COMMON.commint;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;


public class User
{
    final String USER_PATH= COMMON.USER_PATH;


    public void saveUserData(UserDate_Object obj)
    {
        // Recive obj replaced First sheet
        final int SHEET_BOOKS= 0;
        final int jMax = 5;

        try (FileInputStream user_file = new FileInputStream(USER_PATH);
             XSSFWorkbook workbook = new XSSFWorkbook(user_file);
             XSSFSheet sheet = workbook.getSheetAt(SHEET_BOOKS);
             int rowMax = sheet.getPhysicalNumberOfRows();
             @SuppressWarnings("resource")
             XSSFRow row = sheet.createRow(rowMax))
        {
            for(int j=0; j<=jMax; j++)
            {
                final int jPERSON_NUMBER= 0; final int jNAME= 1;
                final int jPH= 2;            final int jTITLE=3;
                switch (j)
                {
                    case jPERSON_NUMBER:
                        row.createCell(j).setCellValue(obj.getPersonNum());
                        break;
                    case jNAME:
                        row.createCell(j).setCellValue(obj.getName());
                        break;
                    case jPH:
                        row.createCell(j).setCellValue(obj.getPhonNum());
                        break;
                    case jTITLE:
                        row.createCell(j).setCellValue(obj.getBookTitle());
                        break;
                    default:
                        break;
                }
            }
            commint(workbook, USER_PATH);
        }
        catch (FileNotFoundException e) { e.printStackTrace(); }
        catch (IOException e) { e.printStackTrace(); }
        catch (Exception e) { System.out.println(e + "etc exception"); }
    }
}

