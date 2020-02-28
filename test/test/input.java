package test;
import java.util.Scanner;

public class input //implements function
{
	static String inputText="";
	
	public static void inputString (String text)
	{
		System.out.println("입력한 문자열:" + text);
	}
	
	
	public static void main(String[] args) 
	{
		// TODO Auto-generated method stub
		Scanner sc= new Scanner(System.in);
		inputText= sc.next();
		inputString(inputText);
	}

}