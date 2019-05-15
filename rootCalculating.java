import java.text.*;

public class rootCalculating
{
	public static void main(String[] args)
	{
		double initial = Double.parseDouble(args[0]);
		double guess = initial / 2.0f;
		DecimalFormat df = new DecimalFormat("#.##");
		while (true)
		{
			double lastGuess = guess;
			double temp = initial / guess;
			guess = (guess + temp) / 2.0f;
			if(guess / lastGuess >= 0.99f && guess / lastGuess <=1.01f)
				break;
		}
		System.out.printf(df.format(guess));
	}
}