package hugeInteger;

import java.util.Scanner;
import java.util.List;
import java.util.ArrayList;

import hugeInteger.*;

public class MainProgram
{
	private static Scanner input = new Scanner(System.in);
	public static void main(String[] args)
	{
		String num1;
		String num2;

		List<String> allElements = seperateAllElements(input.nextLine());
		num1 = allElements.get(0);
		allElements.remove(0);

		while(!(allElements.isEmpty()))
		{
			num2 = allElements.get(1);
			IOperation operation = specifyOperation(allElements.get(0));
			num1 = operation.perform(num1, num2);
			allElements.remove(0);
			allElements.remove(0);
		}

		if(num1.substring(0, 1).equals("-"))
		{
			boolean isZero = true;
			char[] temp = num1.substring(1, num1.length()).toCharArray();
			for(char digit : temp)
			{
				if(digit != '0')
				{
					isZero = false;
					break;
				}
			}

			if(isZero)
			{
				num1 = "0";
			}
		}
		System.out.println(num1);
	}

	public static ArrayList<String> seperateAllElements(String rawInputLine)
	{
		ArrayList<String> allElements = new ArrayList<String>();
		for(String element : rawInputLine.split(" "))
		{
			allElements.add(element);
		}
		return allElements;
	}

	public static IOperation specifyOperation(String operator)
	{
		switch (operator)
		{
			case "+":
				return new Addition();
			case "-":
				return new Subtraction();
			case "<":
			case ">":
			case "=":
				return new Comparison(operator);
			default:
				System.exit(-1);
		}

		return new Addition();
	}
}