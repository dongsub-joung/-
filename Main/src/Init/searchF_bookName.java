package Init;

import books_data.BookNameList;

public class searchF_bookName
{

//	Constructor
	searchF_bookName(){}

//	Method
	public String return_bookName(int resultIndex) { return BookNameList.bookName_list.get(resultIndex); }
	public int return_ResultIndex(String bookName) { return BookNameList.bookName_list.indexOf(bookName); }
}