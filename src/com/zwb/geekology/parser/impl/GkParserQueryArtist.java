package com.zwb.geekology.parser.impl;

import com.zwb.geekology.parser.api.parser.IGkParserQuery;
import com.zwb.geekology.parser.impl.util.GeneralConfig;
import com.zwb.geekology.parser.impl.util.GkParserStringUtils;
import com.zwb.lazyload.ILoader;
import com.zwb.lazyload.LazyLoader;
import com.zwb.lazyload.Ptr;

public class GkParserQueryArtist implements IGkParserQuery
{
    private String artistName;
    private String releaseName;
    
    public GkParserQueryArtist(String artistName)
    {
	this.artistName = artistName;
    }
    
    public GkParserQueryArtist(String artistName, String releaseName)
    {
	this.artistName = artistName;
	this.releaseName = releaseName;
    }
    
    public String toString()
    {
	String s = "q(a):" + this.artistName;
	if (this.hasRelease())
	{
	    s += "/" + this.releaseName;
	}
	return s;
    }
    
    @Override
    public String getArtist()
    {
	/** query objects always return the santised release because they are used to query web apis */
	return this.artistName;
    }
    
    @Override
    public String getRelease()
    {
	return this.releaseName;
    }
    
    @Override
    public boolean hasRelease()
    {
	return this.releaseName != null;
    }
    
    @Override
    public boolean isSampler()
    {
	return false;
    }
}
