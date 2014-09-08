package com.zwb.geekology.parser.impl;

import com.zwb.geekology.parser.api.parser.IGkParserQuery;

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
	return this.artistName;
    }
    
    @Override
    public String getRelease()
    {
	if (GeneralConfig.ST_IDENTIFIERS.contains(this.releaseName))
	{
	    return this.artistName;
	}
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
