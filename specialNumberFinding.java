import java.util.Scanner;

public class SpecialNumberFinding
{
	public static Scanner input = new Scanner(System.in);
	public static void main(String[] args)
	{
		String input = this.input.nextLine();
		switch(input.split("=")[0])
		{
		case "X":
			System.out.println(DetermineSpecNum(Integer.parseInt(input.split("=")[1])));
			break;
		case "Y":
			System.out.println(GetSpecNum(Integer.parseInt(input.split("=")[1])));
			break;
		default:
			System.out.println("Unavailable Input. Exiting...");
			System.exit(0);
		}
	}

	public static boolean DetermineSpecNum(long subject)
	{
		subject = Decay(subject, 2);
		subject = Decay(subject, 3);
		subject = Decay(subject, 5);
		if(subject == 1)
			return true;
		return false;
	}

	public static long Decay(long subject, int dividor)
	{
		while(subject % dividor < 1)
			subject /= dividor;
		return subject;
	}

	public static long GetSpecNum(int index)
	{
		long target = 1;
		for(;;++target)
		{
			if(DetermineSpecNum(target))
				index--;
			if(index <= 0)
				break;
		}
		return target;
	}
}