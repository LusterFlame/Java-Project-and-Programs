import java.util.Scanner;
import java.util.List;
import java.util.ArrayList;

public class PolynomialSum
{
	private static Scanner input = new Scanner(System.in);
	public static void main(String[] args)
	{
		int totalElement = Integer.parseInt(input.nextLine());
		int power = Integer.parseInt(input.nextLine());
		List<Integer> bases = new ArrayList<Integer>();
		String[] buffer = input.nextLine().split(" ");
		for (String base : buffer)
			bases.add(Integer.parseInt(base));
		int sum = 0;
		for(int base : bases)
			sum += (power(base, power));
		System.out.println(sum);
	}

	public static int power(int base, int pow)
	{
		int sum = base;
		for (int temp = 1;temp < pow;++temp)
			sum *= base;
		return sum;
	}
}