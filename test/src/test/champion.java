package test;

class champion{
	
	String name;
	int power;
	int Def;
	
	//������ ����
	public champion() 
	{
		
	}
	
	//�޼ҵ� ����
	
	public void powerUp()
	{
		power += 5;
	}
	
	public void powerDown()
	{
		power =- 10;
	}
	
	public int powerState() 
	{
		return power;
	}
	
}