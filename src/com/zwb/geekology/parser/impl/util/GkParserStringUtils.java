package com.zwb.geekology.parser.impl.util;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.tools.DocumentationTool.Location;

import com.zwb.geekology.parser.abstr.db.AbstrGkDbItem;
import com.zwb.stringutil.FilterArray;
import com.zwb.stringutil.ISatiniseFilter;
import com.zwb.stringutil.ISatiniseFilterArray;
import com.zwb.stringutil.RemovalFilter;
import com.zwb.stringutil.ReplacementFilter;

public class GkParserStringUtils
{
    public static final List<String> ST_IDENTIFIERS = Arrays.asList("st");
    public static final List<String> RELEASE_IDENTIFIERS = Arrays.asList("ep", "lp", "7''", "12''", "cds", "cdr", "cd", "\\(live\\)", "\\[live\\]");
    public static final List<String> THEDAS_IDENTIFIERS = Arrays.asList("the", "der", "die", "das", "le", "la", "les");
    
    public static ISatiniseFilterArray getGeneralArtistNameFilters()
    {
	List<ISatiniseFilter> list = new ArrayList<ISatiniseFilter>();
	for(String s: THEDAS_IDENTIFIERS)
	{
	    list.add(new RemovalFilter(s, ISatiniseFilter.Location.ALL));
	}
	list.add(new RemovalFilter("[\\.]+", ISatiniseFilter.Location.END));
	return new FilterArray(list);
    }

    public static ISatiniseFilterArray getGeneralReleaseNameFilters(String artistName)
    {
	List<ISatiniseFilter> list = new ArrayList<ISatiniseFilter>();
	for(String s: RELEASE_IDENTIFIERS)
	{
	    list.add(new RemovalFilter(s, ISatiniseFilter.Location.ALL));
	}
	for(String s: ST_IDENTIFIERS)
	{
	    list.add(new ReplacementFilter(s, artistName, ISatiniseFilter.Location.EXCLUSIVE));
	}
	list.add(new RemovalFilter("[\\.]+", ISatiniseFilter.Location.END));
	return new FilterArray(list);
    }
    
    public static ISatiniseFilterArray getGeneralTrackNameFilters()
    {
	return new FilterArray();
    }

    public static ISatiniseFilterArray getGeneralTagNameFilters()
    {
	return new FilterArray();
    }


}
