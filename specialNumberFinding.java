public class specialNumberFinding
{
	public static void main(String[] args)
	{
		switch((args[0].split("="))[0])
		{
		case "X":
			System.out.println(DetermineSpecNum(Integer.parseInt(args[0].split("=")[1])));
			break;
		case "Y":
			System.out.println(GetSpecNum(Integer.parseInt(args[0].split("=")[1])));
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