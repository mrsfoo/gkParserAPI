package com.zwb.geekology.parser.impl;

import com.zwb.geekology.parser.api.parser.IGkParserQuery;

public class GkParserQuerySampler implements IGkParserQuery
{
	private String releaseName;
	
	public GkParserQuerySampler(String releaseName) 
	{
		this.releaseName = releaseName;
	}
	
	public String toString()
	{
		String s = "q(va):"+this.releaseName;
		if(this.hasRelease())
		{
			s += "/"+this.releaseName;
		}
		return s;
	}
	
	@Override
	public String getArtist() 
	{
		return "V.A.";
	}

	@Override
	public String getRelease() 
	{
		return this.releaseName;
	}

	@Override
	public boolean hasRelease()
	{
		return true;
	}

	@Override
	public boolean isSampler() 
	{
		return true;
	}
}
