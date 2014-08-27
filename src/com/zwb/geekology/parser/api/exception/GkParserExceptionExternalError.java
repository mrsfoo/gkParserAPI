package com.zwb.geekology.parser.api.exception;

import com.zwb.geekology.parser.api.parser.IGkParsingResult;

public class GkParserExceptionExternalError extends GkParserRuntimeException
{
	public GkParserExceptionExternalError(IGkParsingResult result, String message)
	{
		super(result, message);
	}

	public GkParserExceptionExternalError(IGkParsingResult result, String message, Throwable cause)
	{
		super(result, message, cause);
	}


}
