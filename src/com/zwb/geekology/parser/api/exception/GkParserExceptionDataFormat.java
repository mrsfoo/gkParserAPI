package com.zwb.geekology.parser.api.exception;

import com.zwb.geekology.parser.api.parser.IGkParsingResult;

public class GkParserExceptionDataFormat extends GkParserRuntimeException
{
	public GkParserExceptionDataFormat(IGkParsingResult result, String message)
	{
		super(result, message);
	}

	public GkParserExceptionDataFormat(IGkParsingResult result, String message, Throwable cause)
	{
		super(result, message, cause);
	}
}
