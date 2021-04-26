import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;

public class searchF_bookName
{

//	Constructor
	searchF_bookName(){}

//	Method
	public String return_bookName(int resultIndex) { return COMMON.bookName_list.get(resultIndex); }
	public int return_ResultIndex(String bookName) { return COMMON.bookName_list.indexOf(bookName); }
}