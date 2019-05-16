import java.util.Arrays;
import java.util.List;
import java.util.ArrayList;

public class PermutationList
{
	public static void main(String[] args)
	{
		char[] allDigits = args[0].toCharArray();
		List<Character> digitList = new ArrayList<Character>();
		for(char digit : allDigits)
		{
			digitList.add(digit);
		}
		permute("", 0, allDigits.length, (ArrayList<Character>)digitList, new ArrayList<Character>());
		
	}

	private static void permute(String permutation, int currentDigit, int totalDigit, ArrayList<Character> digitList, ArrayList<Character> usedDigit)
	{
		if(currentDigit == totalDigit)
		{
			System.out.print(permutation + "\n");
		}
		else
		{
			for(char digit : digitList)
			{
				if(!usedDigit.contains(digit))
				{
					permutation += digit;
					usedDigit.add(digit);
					permute(permutation, currentDigit + 1, totalDigit, digitList, usedDigit);
					usedDigit.remove(usedDigit.size() - 1);
					permutation = permutation.substring(0, permutation.length() - 1);
				}
			}
		}
	}
}