package test;
import java.util.Scanner;

public class input //implements function
{
	static String inputText="";
	
	public static void inputString (String text)
	{
		System.out.println("�Է��� ���ڿ�:" + text);
	}
	
	
	public static void main(String[] args) 
	{
		// TODO Auto-generated method stub
		Scanner sc= new Scanner(System.in);
		inputText= sc.next();
		inputString(inputText);
	}

}