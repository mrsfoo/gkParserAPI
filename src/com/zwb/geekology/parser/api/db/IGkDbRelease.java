package com.zwb.geekology.parser.api.db;

public interface IGkDbRelease  extends IGkDbItem
{
	public boolean isSampler();
	public IGkDbArtist getArtist();
}
