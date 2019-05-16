package DocumentType;

import DocumentType.Document;

public class Email extends Document
{
	private String sender;
	private String recipient;
	private String title;

	@Override
	public String toString()
	{
		return ("From: " + this.sender + "\n" + 
				"To: " + this.recipient + "\n" + 
				"Title: " + this.title + "\n" + this.text);
	}

	public void setSender(String sender)
	{
		this.sender = sender;
	}

	public String getSender()
	{
		return this.sender;
	}

	public void setRecipient(String recipient)
	{
		this.recipient = recipient;
	}

	public String getRecipient()
	{
		return this.recipient;
	}

	public void setTitle(String title)
	{
		this.title = title;
	}

	public String getTitle()
	{
		return this.title;
	}

	@Override
	public boolean check(String tag)
	{
		return (this.text.contains(tag) || this.sender.contains(tag) || this.recipient.contains(tag) || this.title.contains(tag));
	}

	@Override
	public void changeVarValue(String varName, String newValue)
	{
		switch(varName)
		{
			case "sender":
				this.sender = newValue;
				break;
			case "recipient":
				this.recipient = newValue;
				break;
			case "title":
				this.title = newValue;
				break;
			case "text":
				this.text = newValue;
				break;
		}
	}
}