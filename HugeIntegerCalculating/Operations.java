package hugeInteger;

interface IOperation
{
	public String perform(String num1, String num2);
}

class Worker
{
	protected int num1len;
	protected int num2len;
	protected char[] convert(String fullNum)
	{
		char[] result = fullNum.toCharArray();
		return result;
	}

	protected char[] extendZero(String num, int extendValue, boolean isNegetive)
	{
		String buffer = new String("");
		for (int temp = 0;temp < extendValue;++temp)
		{
			buffer += "0";
		}

		if(isNegetive)
		{
			buffer = "-" + buffer + num.substring(1, num.length());
		}else
		{
			buffer = buffer + num.substring(0, num.length());
		}

		return convert(buffer);
	}

	protected String deleteLeadingZero(char[] num)
	{
		int startIndex = 0;
		while(num[startIndex] == '0' && startIndex != num.length - 1)
		{
			++startIndex;
		}

		return new String(num, startIndex, num.length - startIndex);
	}
}

class Addition extends Worker implements IOperation
{
	public String perform(String num1, String num2)
	{
		char[] charNum1, charNum2;
		num1len = (convert(num1))[0] == '-' ? num1.length() - 1 : num1.length();
		num2len = (convert(num2))[0] == '-' ? num2.length() - 1 : num2.length();

		if(num1len > num2len)
		{
			charNum2 = extendZero(num2, num1len - num2len, convert(num2)[0] == '-');
			charNum1 = convert(num1);
		}else
		{
			charNum1 = extendZero(num1, num2len - num1len, convert(num1)[0] == '-');
			charNum2 = convert(num2);
		}

		num1len = charNum1.length;
		num2len = charNum2.length;

		String result = new String("");
		switch(num1len - num2len)
		{
			case 1:
			{
				Subtraction sub = new Subtraction();
				result = sub.perform((new String(charNum2)),
									 (new String(charNum1)).substring(1, num1len));
				break;
			}
			case -1:
			{
				Subtraction sub = new Subtraction();
				result = sub.perform((new String(charNum1)),
									 (new String(charNum2)).substring(1, num2len));
				break;
			}
			case 0:
				if(charNum1[0] == '-')
				{
					result = "-" + addNumberPart(convert(new String(charNum1, 1, num1len - 1)),
										   		 convert(new String(charNum2, 1, num2len - 1)));
				}else
				{
					result = addNumberPart(convert(new String(charNum1, 0, num1len)),
										   convert(new String(charNum2, 0, num2len)));
				}
				break;
		}

		return result;
	}

	private String addNumberPart(char[] num1, char[] num2)
	{
		int carry = 0;
		String result = new String("");
		for(int temp = num1.length - 1;temp >= 0;--temp)
		{
			char buffer = (char)((num1[temp] - '0') + (num2[temp] - '0') + '0');
			if(carry > 0)
			{
				++buffer;
				carry = 0;
			}

			if(buffer > '9')
			{
				carry = 1;
				buffer -= 10;
			}
			result = Character.toString(buffer) + result;
		}
		if(carry > 0)
		{
			result = "1" + result;
		}

		return result;
	}
}

class Subtraction extends Worker implements IOperation
{
	public String perform(String num1, String num2)
	{
		char[] charNum1, charNum2;
		num1len = (convert(num1))[0] == '-' ? num1.length() - 1 : num1.length();
		num2len = (convert(num2))[0] == '-' ? num2.length() - 1 : num2.length();

		if(num1len > num2len)
		{
			charNum2 = extendZero(num2, num1len - num2len, convert(num2)[0] == '-');
			charNum1 = convert(num1);
		}else
		{
			charNum1 = extendZero(num1, num2len - num1len, convert(num1)[0] == '-');
			charNum2 = convert(num2);
		}

		num1len = charNum1.length;
		num2len = charNum2.length;

		String result = new String("");
		switch(num1len - num2len)
		{
			case 1:
			{
				Addition add = new Addition();
				result = add.perform((new String(charNum1)),
									 "-" + (new String(charNum2)));
				break;
			}
			case -1:
			{
				Addition add = new Addition();
				result = add.perform((new String(charNum1)),
									 (new String(charNum2, 1, num2len - 1)));
				break;
			}
			case 0:
				if(charNum1[0] == '-')
				{
					Subtraction sub = new Subtraction();
					result = sub.perform(new String(charNum2, 1, num2len - 1),
										 new String(charNum1, 1, num1len - 1));
				}else
				{
					Comparison comp = new Comparison(">");
					if(comp.perform(new String(charNum1), new String(charNum2)) == "true")
					{
						result = minus(charNum1, charNum2);
					}else
					{
						result = "-" + minus(charNum2, charNum1);
					}
				}
		}
		return result;
	}	

	private String minus(char[] num1, char[] num2) // same length, num1 > num2, both positive
	{
		for(int temp = num1.length - 1;temp >= 0;--temp)
		{
			if(num1[temp] < num2[temp])
			{
				--num1[temp - 1];
				num1[temp] = (char)(num1[temp] + 10 - num2[temp] + '0');
			}else
			{
				num1[temp] -= num2[temp];
				num1[temp] += '0';
			}
		}
		return deleteLeadingZero(num1);
	}
}

class Comparison extends Worker implements IOperation
{
	enum CompType{ LESS, SAME, LARGER };
	private CompType compType;

	Comparison() {};
	Comparison(String element)
	{
		setCompType(element);
	}

	void setCompType(String element)
	{
		switch(element)
		{
			case "<":
				this.compType = CompType.LESS;
				break;
			case "=":
				this.compType = CompType.SAME;
				break;
			case ">":
				this.compType = CompType.LARGER;
				break;
			default:
				break;
		}

	}

	public String perform(String num1, String num2)
	{
		boolean result = true;

		char[] charNum1, charNum2;
		num1len = (convert(num1))[0] == '-' ? num1.length() - 1 : num1.length();
		num2len = (convert(num2))[0] == '-' ? num2.length() - 1 : num2.length();

		if(num1len > num2len)
		{
			charNum2 = extendZero(num2, num1len - num2len, convert(num2)[0] == '-');
			charNum1 = convert(num1);
		}else
		{
			charNum1 = extendZero(num1, num2len - num1len, convert(num1)[0] == '-');
			charNum2 = convert(num2);
		}

		num1len = charNum1.length;
		num2len = charNum2.length;

		switch(compType)
		{
			case LESS:
			{
				Subtraction sub = new Subtraction();
				Comparison comp = new Comparison(">");
				if(comp.perform(sub.perform(new String(charNum2), new String(charNum1)), "0") == "true")
				{
					result = true;
				}else
				{
					result = false;
				}
				break;
			}
			case SAME:
			{
				for(int temp = 0;temp < num1len;++temp)
				{
					if(charNum1[temp] == charNum2[temp])
					{
						continue;
					}else
					{
						result = false;
						break;
					}
				}
				break;
			}
			case LARGER:
			{
				if(num1len > num2len)
				{
					result = false;
				}else if(num2len > num1len)
				{
					break;
				}else
				{
					result = false;
					if(charNum1[0] == '-')
					{
						for(int temp = 0;temp < num1len;++temp)
						{
							if(charNum2[temp] > charNum1[temp])
							{
								result = true;
								break;
							}else if(charNum2[temp] < charNum1[temp])
							{
								break;
							}
						}
					}else
					{
						for(int temp = 0;temp < num1len;++temp)
						{
							if(charNum1[temp] > charNum2[temp])
							{
								result = true;
								break;
							}else if(charNum1[temp] < charNum2[temp])
							{
								break;
							}
						}
					}
				}
				break;
			}
			default:
				break;
		}

		return Boolean.toString(result);
	}


}