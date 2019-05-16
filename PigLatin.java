import java.util.Scanner;

public class PigLatin
{
	static public void main(String[] args)
	{
		String Result = new String();

		for(String word : args)
		{
			char[] CharArray = word.toCharArray();
			switch (CharArray[0])
			{
				case 'A':
				case 'E':
				case 'I':
				case 'O':
				case 'U':
				case 'a':
				case 'e':
				case 'i':
				case 'o':
				case 'u':
					if(CharArray[0] > 'Z')
						CharArray[0] -= 32;
					Result += (new String(CharArray) + "ay ");
					break;
				default:
					boolean WordTooShort = (2 > word.length());
					CharArray[WordTooShort ? 0 : 1] = (CharArray[WordTooShort ? 0 : 1] >= 'Z' ? 
						(char)(CharArray[WordTooShort ? 0 : 1] - (char)32) : CharArray[WordTooShort ? 0 : 1]);
					for(int temp = 1;temp < word.length();++temp)
						Result += Character.toString(CharArray[temp]);
					Result += Character.toString(CharArray[0]) + "ay ";
			}
		}

		System.out.println(Result);
	}
}