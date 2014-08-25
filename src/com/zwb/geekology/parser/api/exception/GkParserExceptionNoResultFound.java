package com.zwb.geekology.parser.api.exception;

import com.zwb.geekology.parser.api.parser.IGkParsingResult;

public class GkParserExceptionNoResultFound extends GkParserException
{
	public GkParserExceptionNoResultFound(IGkParsingResult result, String message)
	{
		super(result, message);
	}

	public GkParserExceptionNoResultFound(IGkParsingResult result, String message, Throwable cause)
	{
		super(result, message, cause);
	}


}
