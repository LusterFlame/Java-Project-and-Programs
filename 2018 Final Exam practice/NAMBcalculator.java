import java.util.Scanner;
import java.util.List;
import java.util.ArrayList;

public class NAMBcalculator
{
	private static Scanner input = new Scanner(System.in);
	public static void main(String[] args)
	{
		char[] n1 = input.nextLine().toCharArray();
		char[] n2 = input.nextLine().toCharArray();

		int A = 0;
		int B = 0;
		List<Integer> usedDigit = new ArrayList<Integer>();
		for(int temp = 0;temp < n1.length;++temp)
		{
			if(n1[temp] == n2[temp])
			{
				if(!usedDigit.contains(temp))
				{
					++A;
					usedDigit.add(temp);
				}
			}else
			{
				for(int temp2 = 0;temp2 < n1.length;++temp2)
				{
					if(n1[temp] == n2[temp2])
					{
						if(!usedDigit.contains(temp2))
						{
							++B;
							usedDigit.add(temp2);
							break;
						}
					}
				}
			}
		}

		System.out.println(A + "A" + B + "B");
	}
}