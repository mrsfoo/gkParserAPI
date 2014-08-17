package com.zwb.geekology.parser.api.parser;

import com.zwb.geekology.parser.api.parser.IGkParsingEvent.GkParsingEventType;

public class GkParsingEventFactory
{
	public IGkParsingEvent createParsingEvent(GkParsingEventType type, String message, IGkParsingSource source)
	{
		return new GkParsingEvent(type, message, source);
	}
}

class GkParsingEvent implements IGkParsingEvent
{
	private GkParsingEventType type;
	private String message;
	private IGkParsingSource source; 
	
	public GkParsingEvent(GkParsingEventType type, String message, IGkParsingSource source)
	{
		this.type = type;
		this.message = message;
		this.source = source;
	}
	
	@Override
	public GkParsingEventType getType() 
	{
		return this.type;
	}
	
	@Override
	public String getMessage() 
	{
		return this.message;
	}

	@Override
	public IGkParsingSource getSource()
	{
		return this.source;
	}
}