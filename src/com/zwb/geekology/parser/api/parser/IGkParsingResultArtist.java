package com.zwb.geekology.parser.api.parser;

import com.zwb.geekology.parser.api.db.IGkDbArtist;

public interface IGkParsingResultArtist extends IGkParsingResult
{
	public IGkDbArtist getArtist();
}
