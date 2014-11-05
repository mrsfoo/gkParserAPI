package com.zwb.geekology.parser.impl.util;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Collection;
import java.util.List;

import com.zwb.geekology.parser.api.db.IGkDbItem;
import com.zwb.geekology.parser.api.db.PrintDetailLevel;
import com.zwb.geekology.parser.api.exception.GkParserExceptionIllegalArgument;
import com.zwb.geekology.parser.api.parser.IGkParsingResult;
import com.zwb.tab.Tab;

public class DbItemFileWriter
{
    public static void writeItemToFile(String path, IGkDbItem item, PrintDetailLevel level, boolean append)
    {
	Tab tab = new Tab("");
	tab.addRow(item.printFormatted(level));
	writeToFile(path, tab.printFormatted(), append);
    }
    
    public static void writeResultToFile(String path, IGkParsingResult result, PrintDetailLevel level, boolean append)
    {
	Tab tab = new Tab("", "");
	IGkDbItem item = result.getData();
	String data = item.printFormatted(level);
	String eventProt = result.getEventProtocol();
	tab.addRow(eventProt);
	tab.addSeparator();
	tab.addRow(data);
	writeToFile(path, tab.printFormatted(), append);
    }
    
    public static void writeItemsToFile(String path, Collection<IGkDbItem> items, PrintDetailLevel level, boolean append)
    {
	Tab tab = new Tab("");
	boolean sep = false;
	for (IGkDbItem i : items)
	{
	    if (sep)
	    {
		tab.addSeparator();
	    }
	    sep = true;
	    tab.addRow(i.printFormatted(level));
	}
	writeToFile(path, tab.printFormatted(), append);
    }
    
    public static void writeResultsToFile(String path, Collection<IGkParsingResult> results, PrintDetailLevel level, boolean append)
    {
	Tab tab = new Tab("","","");
	boolean sep = false;
	for (IGkParsingResult r : results)
	{
	    if (sep)
	    {
		tab.addSeparator();
	    }
	    sep = true;
	    if(r.getData()!=null)
	    {
		tab.addRow(r.getEventProtocol(), r.getData().printFormatted(level));
	    }
	    else
	    {
		tab.addRow(r.getEventProtocol(), "NULL");		
	    }
	}
	writeToFile(path, tab.printFormatted(), append);
    }
    
    private static void writeToFile(String path, String s, boolean append)
    {
	try
	{
	    File f = new File(path);
	    FileWriter fw = new FileWriter(f);
	    if (append)
	    {
		fw.append(s);
	    }
	    else
	    {
		fw.write(s);
	    }
	    fw.close();
	}
	catch (IOException e)
	{
	    throw new GkParserExceptionIllegalArgument(null, "path <" + path + "> not corret file to write to");
	}
    }
    
}
