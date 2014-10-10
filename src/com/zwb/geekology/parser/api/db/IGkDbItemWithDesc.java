package com.zwb.geekology.parser.api.db;

public interface IGkDbItemWithDesc extends IGkDbItem
{
	public String getDescriptionSummary();
	public String getDescription();
	public boolean hasDescriptionSummary();
	public boolean hasDescription();
}
