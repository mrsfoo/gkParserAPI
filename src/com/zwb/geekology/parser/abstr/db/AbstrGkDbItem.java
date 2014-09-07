package com.zwb.geekology.parser.abstr.db;

import java.util.ArrayList;
import java.util.List;

import com.zwb.geekology.parser.api.db.IGkDbItem;
import com.zwb.geekology.parser.api.db.PrintDetailLevel;
import com.zwb.geekology.parser.api.parser.IGkParsingEvent;
import com.zwb.geekology.parser.api.parser.IGkParsingSource;
import com.zwb.geekology.parser.impl.DbItemFileWriter;
import com.zwb.geekology.parser.impl.DbItemFormatter;

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
    
    @Override
    public List<IGkParsingEvent> getEvents()
    {
	return this.events;
    }
    
    protected void addEvent(IGkParsingEvent event)
    {
	this.events.add(event);
    }
    
    @Override
    public String toString()
    {
	return this.getName()+" [src:"+this.getSource()+"]";
    }
    
    @Override
    public String printFormatted(PrintDetailLevel level)
    {
	switch(level)
	{
	    case LOW:
		return DbItemFormatter.printFormatted(this);
	    case MED:
		return DbItemFormatter.printFormatted(this, 1);
	    case HIGH:
		return DbItemFormatter.printFormatted(this, 2);
	}
	return "";
    }
    
	public void writeToFile(String path, PrintDetailLevel level, boolean append)
	{
	    DbItemFileWriter.writeItemToFile(path, this, level, append);
	}

    
}
