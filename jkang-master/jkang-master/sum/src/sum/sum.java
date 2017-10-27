package sum;

public class sum 
{
	public static void main(String[] args)
	{
		System.out.println(toNumber("3ac4"));
		System.out.println(toNumber("123abc"));
		System.out.println(toNumber("xyz"));
		System.out.println(stutter("hello"));
	}
	public static int toNumber(String input)
	{
		if(input.length() == 0)
		{
			return 0;
		}
		else
		{
			int x;
			if(Character.isDigit(input.charAt(0)))
			{
				x = Character.getNumericValue(input.charAt(0));
				
			}
			else
			{
				x = 0;
			}
			return x + toNumber(input.substring(1));
		}
	}
	
	public static String stutter(String str){
		if(str.length() == 0){
			return "";
		}
		else{
			String head = str.substring(0,1);
			return head + head + stutter(str.substring(1));
		}
	}
}
