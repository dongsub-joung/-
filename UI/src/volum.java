
/*	//도서 대출에 관한 클래스	
{	
	//도서 수량을 알려줌
	//도서 수량을 감소
	//대출 비활성화
	//대출자 개인정보를 대출 탭에 출력
}
*/

public class volum 
{
	static boolean sw = false;
	static public int book_volum;
	static String value;
	
	
	//도서 수량을 감소
	public void decrease(String input)
	{
		int result = Integer.parseInt(input);
		result = result-1;
		
		if(book_volum == 0) sw=true;
	}
	
	public int reVolum() {
		return book_volum;
	}
	public boolean reSW() {
		return sw;
	}
}
