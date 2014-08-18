package com.zwb.geekology.parser.api.parser;

public interface IGkParsingEvent 
{
	public enum GkParsingEventType { ERROR_INITIALISATION }
	
	public GkParsingEventType getType();
	public String getMessage();
	public IGkParsingSource getSource();

}
