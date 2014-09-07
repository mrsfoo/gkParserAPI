package com.zwb.geekology.parser.impl;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import com.zwb.geekology.parser.api.db.PrintDetailLevel;
import com.zwb.geekology.parser.api.parser.GkParserObjectFactory;
import com.zwb.geekology.parser.api.parser.IGkParsingEvent;
import com.zwb.geekology.parser.api.parser.IGkParsingResult;
import com.zwb.geekology.parser.api.parser.IGkParsingSource;
import com.zwb.geekology.parser.enums.GkParsingEventType;
import com.zwb.geekology.parser.enums.GkParsingResultType;
import com.zwb.geekology.parser.enums.GkParsingState;
import com.zwb.tab.Tab;

public abstract class GkParsingResult implements IGkParsingResult
{
	private GkParsingState state = GkParsingState.UNSPECIFIED;
	private List<IGkParsingEvent> events = new ArrayList<>();
	private IGkParsingSource source;
	private String title;
	
	public GkParsingResult(String title, IGkParsingSource source)
	{
		this.source = source;
		this.title = title;
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
	
	public void addEvent(IGkParsingEvent event) 
	{
		this.events.add(event);
		Collections.sort(this.events);
	}
	
	public void addEvent(GkParsingEventType type, String message) 
	{
		this.events.add(GkParserObjectFactory.createParsingEvent(type, message, this.getSource()));
		Collections.sort(this.events);
	}
	
	@Override
	public IGkParsingSource getSource() 
	{
		return this.source;
	}

	@Override
	public abstract GkParsingResultType getType();

	@Override
	public String getEventProtocol() 
	{
		Tab tab = new Tab("EvProtocol for "+toString(), "timestamp", "diff [ms]", "type", "message");
		long start = 0;
		boolean first = true;
		for(IGkParsingEvent e: this.events)
		{
			long diff = e.getTimestamp().getTime()-start;
			start = e.getTimestamp().getTime();
			String diffS = Long.toString(diff);
			if(first)
			{
				diffS = "--";
				first = false;
			}
			tab.addRow(e.getTimestamp().toString(), diffS, e.getType().toString(), e.getMessage());
		}
		return tab.printFormatted();
	}

	@Override
	public String getEventList()
	{
		String s = toString()+"->";
		String sep = "";
		for(IGkParsingEvent e: this.events)
		{
			s += sep+e.getType();
			sep = ",";
		}
		return s;
	}

	@Override
	public String getTitle() 
	{
		return this.title;
	}

	@Override
	public String getTitleFat() 
	{
		return this.title+", src="+this.getSource().getId()+"/st="+this.getState()+"";
	}
	
	@Override
	public IGkParsingEvent getLastEvent()
	{
		return this.events.get(this.events.size()-1);
	}
	
	public void writeToFile(String path, PrintDetailLevel level, boolean append)
	{
	    DbItemFileWriter.writeResultToFile(path, this, level, append);
	}
}
