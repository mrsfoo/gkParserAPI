package com.zwb.geekology.parser.api.exception;

import com.zwb.geekology.parser.api.parser.IGkParsingEvent;
import com.zwb.geekology.parser.api.parser.IGkParsingResult;

public class GkParserException extends Exception
{
	private IGkParsingResult result;
	
	public GkParserException(IGkParsingResult result, String message)
	{
		super(message);
		this.result = result;
	}
	
	public GkParserException(IGkParsingResult result, String message, Throwable cause)
	{
		super(message, cause);
		this.result = result;
	}
	
	public IGkParsingResult getResult()
	{
		return this.result;
	}
	
	public static GkParserException createException(IGkParsingResult result)
	{
		for(int i=result.getEvents().size()-1; i>=0; i--)
		{
			IGkParsingEvent event = result.getEvents().get(i);
			switch(event.getType())
			{
			case ERROR_ARGUMENT:
				return new GkParserExceptionIllegalArgument(result, event.getMessage());
			case NO_ENTRY_FOUND:
				return new GkParserExceptionNoResultFound(result, event.getMessage());
			}
		}
		return new GkParserException(result, "unknwon error!");
	}
}
