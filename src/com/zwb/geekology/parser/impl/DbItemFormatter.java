package com.zwb.geekology.parser.impl;

import java.net.InterfaceAddress;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.zwb.geekology.parser.api.db.IGkDbArtist;
import com.zwb.geekology.parser.api.db.IGkDbItem;
import com.zwb.geekology.parser.api.db.IGkDbRelease;
import com.zwb.geekology.parser.api.db.IGkDbTag;
import com.zwb.geekology.parser.api.db.IGkDbTrack;
import com.zwb.geekology.parser.api.exception.GkParserExceptionIllegalArgument;
import com.zwb.tab.Tab;

public class DbItemFormatter
{
    private static final int WIDTH = 100;
    
    public static String printFormatted(IGkDbItem item)
    {
	Class<?> clazz = item.getClass();
	if(IGkDbArtist.class.isAssignableFrom(clazz))
	{
	    return printFormatted((IGkDbArtist)item);
	}
	else if(IGkDbRelease.class.isAssignableFrom(clazz))
	{
	    return printFormatted((IGkDbRelease)item);	    
	}
	else if(IGkDbTrack.class.isAssignableFrom(clazz))
	{
	    return printFormatted((IGkDbTrack)item);
	}
	else if(IGkDbTag.class.isAssignableFrom(clazz))
	{
	    return printFormatted((IGkDbTag)item);
	}
	throw new GkParserExceptionIllegalArgument(null, "db item <"+item.getName()+"> is of unapplicable type <"+item.getClass().getCanonicalName()+">");
    }
    
    public static String printFormatted(IGkDbItem item, int depth)
    {
	Class<?> clazz = item.getClass();
	if(IGkDbArtist.class.isAssignableFrom(clazz))
	{
	    return printFormatted((IGkDbArtist)item, depth);
	}
	else if(IGkDbRelease.class.isAssignableFrom(clazz))
	{
	    return printFormatted((IGkDbRelease)item, depth);	    
	}
	else if(IGkDbTrack.class.isAssignableFrom(clazz))
	{
	    return printFormatted((IGkDbTrack)item, depth);
	}
	else if(IGkDbTag.class.isAssignableFrom(clazz))
	{
	    return printFormatted((IGkDbTag)item, depth);
	}
	throw new GkParserExceptionIllegalArgument(null, "db item <"+item.getName()+"> is of unapplicable type <"+item.getClass().getCanonicalName()+">");
    }

    private static String printFormatted(IGkDbArtist item, int depth)
    {
	if(depth<=0)
	{
	    return printFormatted(item);
	}
	Tab tab = new Tab("","","");
	tab.addRow(printFormatted(item), "");
	int i = 1;
	for(IGkDbRelease r: item.getReleases())
	{
	    tab.addRow("release<"+i+">", printFormatted(r, depth-1));
	    i++;
	}
	return tab.printHeadless();
    }

    private static String printFormatted(IGkDbRelease item, int depth)
    {
	if(depth<=0)
	{
	    return printFormatted(item);
	}
	Tab tab = new Tab("","","");
	tab.addRow(printFormatted(item), "");
	int i = 1;
	for(IGkDbTrack t: item.getTracks())
	{
	    tab.addRow("track<"+i+">", printFormatted(t, depth-1));
	    i++;
	}
	return tab.printHeadless();
    }

    private static String printFormatted(IGkDbTrack item, int depth)
    {
	// here no more depth is applicable
	return printFormatted(item);
    }
    
    private static String printFormatted(IGkDbArtist item)
    {
	Tab tab = new Tab("", "", "");
	tab.addRow("type:", item.getClass().getName());
	tab.addRow("datasource:", item.getSource().getId());
	tab.addRow("artist name:", item.getName());
	tab.addRow("summary:", breakdown(item.getDescriptionSummary(), WIDTH));
	tab.addRow("description:", breakdown(item.getDescription(), WIDTH));
	tab.addRow("style tags [" + item.getStyleTagNames().size() + "]:", breakdown(item.getStyleTagNames(), WIDTH));
	tab.addRow("releases [" + item.getReleases().size() + "]:", breakdown(formatReleaseList(item.getReleases()), WIDTH));
	tab.addRow("similar artists [" + item.getSimilarsNames().size() + "]:", breakdown(item.getSimilarsNames(), WIDTH));
	return tab.printHeadless();
    }
    
    private static String printFormatted(IGkDbRelease item)
    {
	Tab tab = new Tab("", "", "");
	tab.addRow("type:", item.getClass().getName());
	tab.addRow("datasource:", item.getSource().getId());
	tab.addRow("release name:", item.getName());
	tab.addRow("by artist:", item.getArtist().getName());
	tab.addRow("release date:", breakdown(item.getReleaseDate(), WIDTH));
	tab.addRow("summary:", breakdown(item.getDescriptionSummary(), WIDTH));
	tab.addRow("description:", breakdown(item.getDescription(), WIDTH));
	tab.addRow("style tags [" + item.getStyleTagNames().size() + "]:", breakdown(item.getStyleTagNames(), WIDTH));
	tab.addRow("formats [" + item.getFormats().size() + "]:", breakdown(item.getFormats(), WIDTH));
	tab.addRow("labels [" + item.getLabels().size() + "]:", breakdown(item.getLabels(), WIDTH));
	tab.addRow("track count:", Integer.toString(item.getTrackCount()));
	tab.addRow("disc count:", Integer.toString(item.getDiscCount()));
	tab.addRow("tracks [" + item.getTracks().size() + "]:", breakdown(formatTrackList(item.getTracks()), WIDTH));
	return tab.printHeadless();
    }
    
    private static String printFormatted(IGkDbTrack item)
    {
	Tab tab = new Tab("", "", "");
	tab.addRow("type:", item.getClass().getName());
	tab.addRow("datasource:", item.getSource().getId());
	tab.addRow("track name:", item.getName());
	tab.addRow("by artist:", item.getArtist().getName());
	tab.addRow("on release:", item.getRelease().getName());
	tab.addRow("track #:", item.getTrackNo().toString());
	tab.addRow("disc #:", item.getDiscNo().toString());
	tab.addRow("absolute #:", item.getAbsolutePosition().toString());
	tab.addRow("duration:", item.getDuration().toString());
	tab.addRow("summary:", breakdown(item.getDescriptionSummary(), WIDTH));
	tab.addRow("description:", breakdown(item.getDescription(), WIDTH));
	tab.addRow("style tags [" + item.getStyleTagNames().size() + "]:" + breakdown(item.getStyleTagNames(), WIDTH));
	return tab.printHeadless();
    }
    
    private static String printFormatted(IGkDbTag item)
    {
	Tab tab = new Tab("", "", "");
	tab.addRow("type:", item.getClass().getName());
	tab.addRow("datasource:", item.getSource().getId());
	tab.addRow("tag name:", item.getName());
	tab.addRow("weight:", item.getWeight().toString());
	tab.addRow("summary:", breakdown(item.getDescriptionSummary(), WIDTH));
	tab.addRow("description:", breakdown(item.getDescription(), WIDTH));
	tab.addRow("similar tags [" + item.getSimilarsNames().size() + "]:", breakdown(item.getSimilarsNames(), WIDTH));
	return tab.printHeadless();
    }
    
    private static String breakdown(String in, int width)
    {
	if(in==null)
	{
	    return null;
	}
	String[] tokens = in.split(" ");
	String out = "";
	int linewid = 0;
	for (String s : tokens)
	{
	    out += s + " ";
	    linewid += s.length();
	    if (linewid >= width)
	    {
		out += "\n";
		linewid = 0;
	    }
	}
	return out;
    }
    
    private static String breakdown(Object in, int width)
    {
	if(in==null)
	{
	    return null;
	}
	return breakdown(in.toString(), width);
    }
    
    private static List<String> formatReleaseList(List<IGkDbRelease> releases)
    {
	List<String> out = new ArrayList<>();
	for (IGkDbRelease r : releases)
	{
	    out.add(r.getName() + " (" + r.getReleaseDate() + ")");
	}
	return out;
    }
    
    private static List<String> formatTrackList(List<IGkDbTrack> tracks)
    {
	List<String> out = new ArrayList<>();
	for (IGkDbTrack t : tracks)
	{
	    out.add(t.getTrackNo().toString() + ". " + t.getName() + " (" + t.getDuration() + ")");
	}
	return out;
    }
}
