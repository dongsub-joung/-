import java.io.*;

public class COMMON
{
//    Global Valiable
    public static final String FILE_PATH= "/Users/dongsub/gits/Sociology_bookList/src/books_data/bookList.xlsx";
    public static final String USER_PATH= "/Users/dongsub/gits/Sociology_bookList/Main/src/user_data/info.xlsx";

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
}