/*	//���� ���⿡ ���� Ŭ����	
{	
	//���������� �Է¹޾Ƽ� ����
	//���� ������ �˷���
	//���� ������ ����
	//���� ��Ȱ��ȭ
	//������ ���������� ���� �ǿ� ���
}
*/



class checkOutF
{
	int personNum;
	String name;
	int phonNum;
	searchF read = new searchF();
	
	//����ġ ����
	boolean sw= false;
	
	//���������� �Է¹޾Ƽ� ����
	public checkOutF (int ID, String name, int PH)
	{
		super();
		this.personNum = ID;
		this.name = name;
		this.phonNum = PH;
	}
	
	
	//���� ������ �˷���
	public String volum()
	{
		read.getData();
		String volum = read.amount;
		return volum;
	}
	
	//���� ������ ����
	public void decrease (String volum)
	{
		int i = Integer.parseInt(volum);
		i = i-1;
		if(i == 0) sw = true;
	}
	
}