package com.zwb.geekology.parser.api.parser;

public class GkParserQueryFactory 
{
	public static IGkParserQuery createQueryForArtist(String artistName)
	{
		return new GkParserQueryArtist(artistName);
	}
	
	public static IGkParserQuery createQueryForArtist(String artistName, String releaseName)
	{
		return new GkParserQueryArtist(artistName, releaseName);
	}

	public static IGkParserQuery createQueryForSampler(String releaseName)
	{
		return new GkParserQuerySampler(releaseName);
	}
	
}

class GkParserQueryArtist implements IGkParserQuery
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
	
	@Override
	public String getArtist() 
	{
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
		return this.releaseName!=null;
	}

	@Override
	public boolean isSampler()
	{
		return false;
	}
}

class GkParserQuerySampler implements IGkParserQuery
{
	private String releaseName;
	
	public GkParserQuerySampler(String releaseName) 
	{
		this.releaseName = releaseName;
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
