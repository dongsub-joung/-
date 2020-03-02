
/*	//도서 대출에 관한 클래스	
{	
	//도서 수량을 알려줌
	//도서 수량을 감소
	//대출 비활성화
	//대출자 개인정보를 대출 탭에 출력
}
*/

public class volum extends checkOutF {
	
	boolean sw= false;
	
	//도서 수량을 알려줌
	public String bringVolum()
	{
		read.getData();
		String volum = read.amount;
		return volum;
	}
	
	
	//도서 수량을 감소
	public void decrease (String volum)
	{
		int i = Integer.parseInt(volum);
		i = i-1;
		if(i == 0) sw = true;
	}
	
}
