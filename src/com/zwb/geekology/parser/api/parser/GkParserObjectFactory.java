package com.zwb.geekology.parser.api.parser;

import com.zwb.geekology.parser.enums.GkParsingEventType;
import com.zwb.geekology.parser.impl.GkParserQueryArtist;
import com.zwb.geekology.parser.impl.GkParserQuerySampler;
import com.zwb.geekology.parser.impl.GkParsingEvent;
import com.zwb.geekology.parser.impl.GkParsingResultArtist;
import com.zwb.geekology.parser.impl.GkParsingResultSampler;
import com.zwb.geekology.parser.impl.GkParsingSource;

public class GkParserObjectFactory 
{	
	public static IGkParserQuery createQueryForArtist(String artistName)
	{
		return new GkParserQueryArtist(artistName.trim());
	}
	
	public static IGkParserQuery createQueryForArtist(String artistName, String releaseName)
	{
		return new GkParserQueryArtist(artistName.trim(), releaseName.trim());
	}

	public static IGkParserQuery createQueryForSampler(String releaseName)
	{
		return new GkParserQuerySampler(releaseName.trim());
	}
	
	public static IGkParsingEvent createParsingEvent(GkParsingEventType type, String message, IGkParsingSource source)
	{
		return new GkParsingEvent(type, message, source);
	}
	
	public static IGkParsingResultArtist createResultArtist(String title, IGkParsingSource source)
	{
		return new GkParsingResultArtist(title, source);
	}
	
	public static IGkParsingResultSampler createResultSampler(String title, IGkParsingSource source)
	{
		return new GkParsingResultSampler(title, source);
	}
	
	public static IGkParsingSource createSource(String id)
	{
		return new GkParsingSource(id);
	}

	public static IGkParsingSource createSourceUnknown()
	{
		return new GkParsingSource("UNKNOWN");
	}

}
