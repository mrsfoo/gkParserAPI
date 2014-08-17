package com.zwb.geekology.parser.api.parser;

import java.util.List;

import com.zwb.geekology.parser.api.db.IGkDbArtist;

public interface IGkParserResult 
{
	public GkParsingState getState();
	public List<IGkParsingEvent> getEvents();
	public IGkDbArtist getArtist();
	public IGkParsingSource getSource();
	
}
