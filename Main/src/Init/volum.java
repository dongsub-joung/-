package Init;
/*	//���� ���⿡ ���� Ŭ����	
{	
	//���� ������ �˷���
	//���� ������ ����
	//���� ��Ȱ��ȭ
	//������ ���������� ���� �ǿ� ���
}
*/

public class volum 
{
	static boolean sw = false;
	static public int book_volum;
	static String value;

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
