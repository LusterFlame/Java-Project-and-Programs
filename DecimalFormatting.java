import java.util.Scanner;
import java.lang.Math;
import java.text.*;

public class DecimalFormatting
{	
	public static Scanner input = new Scanner(System.in);
	public static void main(String[] args)
	{
		double a = Double.parseDouble(input.nextLine());
		double b = Double.parseDouble(input.nextLine());
		double c = Double.parseDouble(input.nextLine());
		String[] formatCounting = (input.nextLine()).split("\\.");
		String temp = "";
		for (int temp2 = 0;temp2 < formatCounting[0].length();++temp2)
			temp += "0";
		temp += ".";
		for (int temp2 = 0;temp2 < formatCounting[1].length();++temp2)
			temp += "0";

		double resultPos = (-b + Math.sqrt(b * b - 4 * a * c)) / (2 * a);
		double resultNeg = (-b - Math.sqrt(b * b - 4 * a * c)) / (2 * a);
		DecimalFormat df = new DecimalFormat(temp);
		System.out.println(df.format(resultPos));
		System.out.println(df.format(resultNeg));
	}
}