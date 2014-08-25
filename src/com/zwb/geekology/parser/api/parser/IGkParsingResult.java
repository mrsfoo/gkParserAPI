package com.zwb.geekology.parser.api.parser;

import java.util.List;

import com.zwb.geekology.parser.api.db.IGkDbArtist;
import com.zwb.geekology.parser.api.db.IGkDbRelease;
import com.zwb.geekology.parser.enums.GkParsingResultType;
import com.zwb.geekology.parser.enums.GkParsingState;

public interface IGkParsingResult 
{
	public GkParsingState getState();
	public List<IGkParsingEvent> getEvents();
	public IGkParsingSource getSource();
	public GkParsingResultType getType();
	public String getEventProtocol();
	public String getEventList();
	public String getTitle();
	public String getTitleFat();
	public IGkParsingEvent getLastEvent();
	public boolean hasAlbum();
	public boolean hasArtist();
	
}
