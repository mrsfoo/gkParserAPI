package com.zwb.geekology.parser.abstr.db;

import com.zwb.geekology.parser.api.db.IGkDbItem;

public abstract class AbstrGkDbItem implements IGkDbItem
{
	private String name;
	
	public AbstrGkDbItem(String name)
	{
		this.name = name;
	}
	
	public String getName()
	{
		return this.name;
	}
	
	public void setName(String name)
	{
		this.name = name;
	}
}
