package com.zwb.geekology.parser.api.parser;

import com.zwb.geekology.parser.api.db.IGkDbRelease;

public interface IGkParsingResultSampler extends IGkParsingResult
{
	public IGkDbRelease getSampler();
}
