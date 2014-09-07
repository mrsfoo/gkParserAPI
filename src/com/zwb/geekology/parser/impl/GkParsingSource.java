package com.zwb.geekology.parser.impl;

import com.zwb.geekology.parser.api.parser.IGkParsingSource;

public class GkParsingSource implements IGkParsingSource
{
	String id;
	
	public GkParsingSource(String id) 
	{
		this.id = id;
	}

	@Override
	public String getId()
	{
		return this.id;
	}
	
	public String toString()
	{
	    return this.id;
	}
	
	public boolean equals(Object o)
	{
		if(o==null)
		{
			return false;
		}
		if(!o.getClass().equals(this.getClass()))
		{
			return false;
		}
		return this.getId().equals(((GkParsingSource)o).getId());
	}

	public int hashCode()
	{
		return this.getId().hashCode();
	}

}
