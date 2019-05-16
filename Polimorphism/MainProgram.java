package DocumentType;
import DocumentType.*;
import java.util.Scanner;

public class MainProgram
{
	public static Scanner input = new Scanner(System.in);
	public static void main(String[] args) throws Exception
	{
		switch(input.nextLine())
		{
			case "A":
				ModeA(input.nextLine());
				break;
			case "B":
				ModeB(input.nextLine());
				break;
			case "C":
				ModeC(input.nextLine());
				break;
			default:
				System.out.println("Invalid Input.");
				break;
		}
	}

	public static void ModeA(String documentType)
	{
		Document text = setDocument(documentType);
		System.out.println(text.toString());
	}

	public static void ModeB(String documentType)
	{
		Document text = setDocument(documentType);
		String tag = input.nextLine();
		System.out.println(text.check(tag));
	}

	public static void ModeC(String documentType) throws Exception
	{
		Document text = setDocument(documentType);
		text.changeVarValue(input.nextLine(), input.nextLine());
		System.out.println(text.toString());
	}

	public static Document setDocument(String documentType)
	{
		switch(documentType)
		{
			case "Document":
				Document newDocument = new Document();
				newDocument.setString(input.nextLine());
				return newDocument;
			case "Email":
				Email newEmail = new Email();
				newEmail.setSender(input.nextLine());
				newEmail.setRecipient(input.nextLine());
				newEmail.setTitle(input.nextLine());
				newEmail.setString(input.nextLine());
				return newEmail;
			case "File":
				File newFile = new File();
				newFile.setPathname(input.nextLine());
				newFile.setString(input.nextLine());
				return newFile;
		}
		System.out.println("You dick is small you idiot asshole");
		return (new Document());
	}
}