package UserData;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class User
{
    public  void saveData(String personNum, String name, String PH, String bookTitle)
    {
        // Recive obj replaced First sheet
        final int SHEET_BOOKS= 0;
        final int jMax = 5;

        try (FileInputStream user_file = new FileInputStream(USER_PATH);
             XSSFWorkbook workbook = new XSSFWorkbook(user_file) )
        {
            @SuppressWarnings("resource")
            XSSFSheet sheet = workbook.getSheetAt(SHEET_BOOKS);
//			Incrasing count per a click
            int rowMax = sheet.getPhysicalNumberOfRows();
            XSSFRow row = sheet.createRow(rowMax);

            for(int j=0; j<=jMax; j++)
            {
                final int jPERSON_NUMBER= 0; final int jNAME= 1;
                final int jPH= 2;            final int jTITLE=3;

                switch (j)
                {
                    case jPERSON_NUMBER:
                        row.createCell(j).setCellValue(personNum);
                        break;
                    case jNAME:
                        row.createCell(j).setCellValue(name);
                        break;
                    case jPH:
                        row.createCell(j).setCellValue(PH);
                        break;
                    case jTITLE:
                        row.createCell(j).setCellValue(bookTitle);
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

