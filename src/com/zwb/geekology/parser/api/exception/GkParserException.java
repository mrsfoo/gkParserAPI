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
}
