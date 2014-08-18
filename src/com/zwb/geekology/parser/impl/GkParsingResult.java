package com.zwb.geekology.parser.impl;

import java.util.ArrayList;
import java.util.List;

import com.zwb.geekology.parser.api.db.IGkDbArtist;
import com.zwb.geekology.parser.api.parser.GkParsingState;
import com.zwb.geekology.parser.api.parser.IGkParserResult;
import com.zwb.geekology.parser.api.parser.IGkParsingEvent;
import com.zwb.geekology.parser.api.parser.IGkParsingSource;

public class GkParsingResult implements IGkParserResult
{
	private GkParsingState state = GkParsingState.UNSPECIFIED;
	private List<IGkParsingEvent> events = new ArrayList<>();
	private IGkParsingSource source;
	
	public GkParsingResult(IGkParsingSource source)
	{
		this.source = source;
	}

	@Override
	public GkParsingState getState() 
	{
		return this.state;
	}
	
	public void setState(GkParsingState state)
	{
		this.state = state;
	}

	@Override
	public List<IGkParsingEvent> getEvents() 
	{
		return this.events;
	}
	
	@Override
	public IGkDbArtist getArtist() 
	{
		// TODO Auto-generated method stub
		return null;
	}
	
	@Override
	public IGkParsingSource getSource() 
	{
		return this.source;
	}
}
