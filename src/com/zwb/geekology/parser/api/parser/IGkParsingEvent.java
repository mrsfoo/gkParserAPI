package com.zwb.geekology.parser.api.parser;

import java.sql.Timestamp;

import com.zwb.geekology.parser.enums.GkParsingEventType;

public interface IGkParsingEvent extends Comparable<IGkParsingEvent>
{	
	public GkParsingEventType getType();
	public String getMessage();
	public IGkParsingSource getSource();
	public Timestamp getTimestamp();

}
