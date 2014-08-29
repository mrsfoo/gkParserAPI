package com.zwb.geekology.parser.impl;

import java.sql.Timestamp;

import com.zwb.geekology.parser.api.parser.IGkParsingEvent;
import com.zwb.geekology.parser.api.parser.IGkParsingSource;
import com.zwb.geekology.parser.enums.GkParsingEventType;

public class GkParsingEvent implements IGkParsingEvent
{
	private GkParsingEventType type;
	private String message;
	private IGkParsingSource source; 
	private Timestamp timestamp;
	
	public GkParsingEvent(GkParsingEventType type, String message, IGkParsingSource source)
	{
		this.timestamp = new Timestamp(System.currentTimeMillis());
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

	@Override
	public Timestamp getTimestamp() 
	{
		return this.timestamp;
	}

	@Override
	public int compareTo(IGkParsingEvent o)
	{
		return this.getTimestamp().compareTo(o.getTimestamp());
	}
}