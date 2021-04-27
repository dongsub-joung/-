package Init;

public class volume
{
	private static boolean toggle;
	private static int book_volume;
	private static String value;
	static {toggle = false; book_volume= 1; value= "";}

	private int toInt(String str_type) { return Integer.parseInt(str_type); }
	private String toString(int number) { return Character.toString(number); }

	public static boolean isSw() {
		return toggle;
	}

	public static int getBook_volume() {
		return book_volume;
	}

	public static String getValue() {
		return value;
	}

	public static void resetToggle() { volume.toggle = false; }

	public void decrease(String str_type)
	{
		book_volume= toInt(str_type)-1;
		if(book_volume == 0) toggle= true;
	}
	public void increase(String str_type)
	{
		book_volume= toInt((str_type))+1;

	}
}
