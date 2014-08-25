package com.zwb.geekology.parser.impl;

import com.zwb.geekology.parser.api.db.IGkDbRelease;
import com.zwb.geekology.parser.api.parser.IGkParsingResultSampler;
import com.zwb.geekology.parser.api.parser.IGkParsingSource;
import com.zwb.geekology.parser.enums.GkParsingResultType;

public class GkParsingResultSampler extends GkParsingResult implements IGkParsingResultSampler
{
	private IGkDbRelease sampler;

	public GkParsingResultSampler(String title, IGkParsingSource source)
	{
		super(title, source);
	}

	public String toString()
	{
		return "qr(va):"+getTitleFat();
	}

	@Override
	public IGkDbRelease getSampler() 
	{
		return this.sampler;
	}

	public GkParsingResultType getType()
	{
		return GkParsingResultType.ARTIST;
	}

	@Override
	public boolean hasAlbum() 
	{
		return null!=this.sampler;
	}

	@Override
	public boolean hasArtist() 
	{
		return false;
	}


}
