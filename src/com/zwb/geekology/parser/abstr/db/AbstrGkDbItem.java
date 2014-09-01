package com.zwb.geekology.parser.abstr.db;

import java.util.ArrayList;
import java.util.List;

import com.zwb.geekology.parser.api.db.IGkDbItem;
import com.zwb.geekology.parser.api.parser.IGkParsingEvent;
import com.zwb.geekology.parser.api.parser.IGkParsingSource;

public abstract class AbstrGkDbItem implements IGkDbItem
{
	private String name;
	private IGkParsingSource source;
	private List<IGkParsingEvent> events = new ArrayList<>();
	
	public AbstrGkDbItem(String name, IGkParsingSource source)
	{
		this.name = name;
		this.source = source;
	}
	
	public String getName()
	{
		return this.name;
	}
	
	public IGkParsingSource getSource()
	{
		return this.source;
	}
	
	public void setName(String name)
	{
		this.name = name;
	}
	
	public List<IGkParsingEvent> getEvents()
	{
		return this.events;
	}
	
	protected void addEvent(IGkParsingEvent event)
	{
		this.events.add(event);
	}
}
