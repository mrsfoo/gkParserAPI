package com.zwb.geekology.parser.api.exception;

import com.zwb.geekology.parser.api.parser.IGkParsingEvent;
import com.zwb.geekology.parser.api.parser.IGkParsingResult;

public class GkParserExceptionFactory 
{
	public static GkParserRuntimeException createRuntimeException(IGkParsingResult result, Throwable cause)
	{
		for(int i=result.getEvents().size()-1; i>=0; i--)
		{
			IGkParsingEvent event = result.getEvents().get(i);
			switch(event.getType())
			{
			case EXTERNAL_ERROR:
				return new GkParserExceptionExternalError(result, event.getMessage(), cause);
			}
		}
		return null;
	}
	
	public static GkParserException createException(IGkParsingResult result, Throwable cause)
	{
		for(int i=result.getEvents().size()-1; i>=0; i--)
		{
			IGkParsingEvent event = result.getEvents().get(i);
			switch(event.getType())
			{
			case ERROR_ARGUMENT:
				return new GkParserExceptionIllegalArgument(result, event.getMessage(), cause);
			case NO_ENTRY_FOUND:
				return new GkParserExceptionNoResultFound(result, event.getMessage(), cause);
			}
		}
		return new GkParserException(result, "unknwon error!", cause);
	}
}
