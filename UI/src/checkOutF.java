/*	//도서 대출에 관한 클래스	
{	
	//개인정보를 입력받아서 저장
	//도서 수량을 알려줌
	//도서 수량을 감소
	//대출 비활성화
	//대출자 개인정보를 대출 탭에 출력
}
*/



class checkOutF
{
	int personNum;
	String name;
	int phonNum;
	searchF read = new searchF();
	
	//스위치 변수
	boolean sw= false;
	
	//개인정보를 입력받아서 저장
	public checkOutF (int ID, String name, int PH)
	{
		super();
		this.personNum = ID;
		this.name = name;
		this.phonNum = PH;
	}
	
	
	//도서 수량을 알려줌
	public String volum()
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