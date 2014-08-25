package com.zwb.geekology.parser.api.parser;

import com.zwb.geekology.parser.api.exception.GkParserException;

public interface IGkParser 
{

	public IGkParsingResultArtist parseArtist(IGkParserQuery query) throws GkParserException;
	public IGkParsingResultSampler parseSampler(IGkParserQuery query) throws GkParserException;
	public IGkParsingSource getSource();
}
