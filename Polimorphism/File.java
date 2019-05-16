package DocumentType;

import DocumentType.Document;

public class File extends Document
{
	private String pathname;

	@Override
	public String toString()
	{
		return ("Path: " + this.pathname + "\n" + this.text);
	}

	public void setPathname(String pathname)
	{
		this.pathname = pathname;
	}

	public String getPathname()
	{
		return this.pathname;
	}

	@Override
	public boolean check(String tag)
	{
		return (this.pathname.contains(tag) || this.text.contains(tag));
	}

	@Override
	public void changeVarValue(String varName, String newValue)
	{
		switch(varName)
		{
			case "pathname":
				pathname = newValue;
				break;
			case "text":
				text = newValue;
				break;
		}
	}
}