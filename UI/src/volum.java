
/*	//���� ���⿡ ���� Ŭ����	
{	
	//���� ������ �˷���
	//���� ������ ����
	//���� ��Ȱ��ȭ
	//������ ���������� ���� �ǿ� ���
}
*/

public class volum extends checkOutF {
	
	boolean sw= false;
	
	//���� ������ �˷���
	public String bringVolum()
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
