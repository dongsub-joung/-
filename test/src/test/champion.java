package test;

class champion{
	
	String name;
	int power;
	int Def;
	
	//생성자 정의
	public champion() 
	{
		
	}
	
	//메소드 정의
	
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