package com.zwb.geekology.parser.impl;

import com.zwb.geekology.parser.api.db.IGkDbArtist;
import com.zwb.geekology.parser.api.db.IGkDbItem;
import com.zwb.geekology.parser.api.parser.IGkParsingResultArtist;
import com.zwb.geekology.parser.api.parser.IGkParsingResultSampler;
import com.zwb.geekology.parser.api.parser.IGkParsingSource;
import com.zwb.geekology.parser.enums.GkParsingResultType;

public class GkParsingResultArtist extends GkParsingResult implements IGkParsingResultArtist
{
	private IGkDbArtist artist;

	public GkParsingResultArtist(String title, IGkParsingSource source)
	{
		super(title, source);
	}
	
	public String toString()
	{
		return "qr(a):"+getTitleFat();
	}

	@Override
	public IGkDbArtist getArtist() 
	{
		return this.artist;
	}
	
	public void setArtist(IGkDbArtist artist) 
	{
		this.artist = artist;
	}
	
	public GkParsingResultType getType()
	{
		return GkParsingResultType.ARTIST;
	}

	@Override
	public boolean hasAlbum()
	{
		return false;
	}

	@Override
	public boolean hasArtist()
	{
		return null!=this.artist;
	}

	@Override
	public IGkDbItem getData()
	{
	    return this.artist;
	}

}
