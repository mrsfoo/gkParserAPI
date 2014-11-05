package com.zwb.geekology.parser.api.db;

import java.util.List;

import com.zwb.geekology.parser.api.parser.IGkParsingEvent;
import com.zwb.geekology.parser.api.parser.IGkParsingSource;
import com.zwb.stringutil.ComparisonAlgorithm;

public interface IGkDbItem 
{	
    	public String getName();
	public IGkParsingSource getSource();
	public List<IGkParsingEvent> getEvents();
	public String printFormatted(PrintDetailLevel level);
	public void writeToFile(String path, PrintDetailLevel level, boolean append);
	
	public String getNameSantised();
	public double calculateSimilarity(IGkDbItem item, ComparisonAlgorithm comparisonAlgorithm);
	public double calculateSimilarity(String name, ComparisonAlgorithm comparisonAlgorithm);
}
