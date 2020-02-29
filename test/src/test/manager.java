package test;

public class manager {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		champion Ari = new champion();
		Ari.name = "Ari";
		Ari.power = 50;
		Ari.Def = 0;
		
		System.out.println(Ari.powerState());
		Ari.powerUp();
		System.out.println(Ari.powerState());
	}

}
