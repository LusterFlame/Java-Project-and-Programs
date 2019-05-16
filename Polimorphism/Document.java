package DocumentType;

public class Document
{
	protected String text;
	public String toString()
	{
		return this.text;
	}

	public void setString(String text)
	{
		this.text = text;
	}

	public boolean check(String tag)
	{
		return this.text.contains(tag);
	}

	public void changeVarValue(String varName, String newValue)
	{
		this.text = newValue;
	}
}