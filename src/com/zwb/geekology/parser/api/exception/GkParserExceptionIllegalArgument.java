package com.zwb.geekology.parser.api.exception;

import com.zwb.geekology.parser.api.parser.IGkParsingResult;

public class GkParserExceptionIllegalArgument extends GkParserException
{
	public GkParserExceptionIllegalArgument(IGkParsingResult result, String message)
	{
		super(result, message);
	}

	public GkParserExceptionIllegalArgument(IGkParsingResult result, String message, Throwable cause)
	{
		super(result, message, cause);
	}

}
