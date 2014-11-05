package com.zwb.geekology.parser.abstr.db;

import java.util.ArrayList;
import java.util.List;

import com.zwb.geekology.parser.api.db.IGkDbItem;
import com.zwb.geekology.parser.api.db.PrintDetailLevel;
import com.zwb.geekology.parser.api.parser.IGkParsingEvent;
import com.zwb.geekology.parser.api.parser.IGkParsingSource;
import com.zwb.geekology.parser.impl.util.DbItemFileWriter;
import com.zwb.geekology.parser.impl.util.DbItemFormatter;
import com.zwb.geekology.parser.impl.util.MyLogger;
import com.zwb.lazyload.Ptr;
import com.zwb.stringutil.ComparisonAlgorithm;
import com.zwb.stringutil.ISatiniseFilter;
import com.zwb.stringutil.ISatiniseFilterArray;
import com.zwb.stringutil.StringReformat;

public abstract class AbstrGkDbItem implements IGkDbItem
{
    private String name;
    private Ptr<String> nameSantised = new Ptr<>();
    private IGkParsingSource source;
    private List<IGkParsingEvent> events = new ArrayList<>();
    private MyLogger log = new MyLogger(this.getClass());
    
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
    
    @Override
    public String getNameSantised()
    {
	return getFilters().filter(this.getName(), true);
    }

    @Override
    public double calculateSimilarity(IGkDbItem item, ComparisonAlgorithm comparisonAlgorithm)
    {
	return calculateSimilarity(item.getName(), comparisonAlgorithm);
    }

    @Override
    public double calculateSimilarity(String name, ComparisonAlgorithm comparisonAlgorithm)
    {
	ISatiniseFilter f = getFilters();
	String string0 = f.filter(name, true);
	String string1 = getNameSantised();
	log.trace("comparing <"+string0+"> +++ <"+string1+"> with filters <"+f+">");
	return StringReformat.compare(string0, string1, comparisonAlgorithm);
    }
    
    public abstract ISatiniseFilterArray getFilters();
    
} 
