import java.io.*;
import java.util.ArrayList;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;


public class COMMON
{
//    Global Valiable
    public static final String FILE_PATH= "/Users/dongsub/gits/Sociology_bookList/src/books_data/bookList.xlsx";
    public static final String USER_PATH= "/Users/dongsub/gits/Sociology_bookList/Main/src/user_data/info.xlsx";
    public static ArrayList<String> bookName_list = new ArrayList<>();

//    Save File and close
    public static void commint(XSSFWorkbook workbook, String filepath)
    {
        try ( FileOutputStream outFile = new FileOutputStream(new File(filepath)) )
        {
            workbook.write(outFile);
        }
        catch (Exception e)
        {
            e.printStackTrace();
            System.out.println("Commit err");
        }
    }


//  Set bookName_list
    private void LoadListAndSaveBookNameList()
    {
        try
        {
            FileInputStream file = new FileInputStream(COMMON.FILE_PATH);
            @SuppressWarnings("resource")

            XSSFWorkbook workbook = new XSSFWorkbook(file);
            XSSFSheet sheet = workbook.getSheetAt(0);

            int rows = sheet.getPhysicalNumberOfRows();
            for(int rowIndex=3; rowIndex< rows+30; rowIndex++)
            {
                XSSFRow row = sheet.getRow(rowIndex);
                if(row != null)
                {
                    XSSFCell cell = row.getCell(1);
                    if(cell != null)
                    {
                        switch(cell.getCellType())
                        {
                            case STRING: //XSSFCell.CELL_TYPE_STRING:
                                // Add book's title at ArrayList
                                bookName_list.add(cell.getStringCellValue();
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

    public  void saveData(String personNum, String name, String PH, String bookTitle)
    {
        // Recive obj replaced First sheet
        final int SHEET_BOOKS= 0;
        final int jMax = 5;

        try ( FileInputStream user_file = new FileInputStream(USER_PATH);
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