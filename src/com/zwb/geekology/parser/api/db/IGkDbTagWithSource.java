package com.zwb.geekology.parser.api.db;

import com.zwb.geekology.parser.api.parser.IGkParsingSource;

public interface IGkDbTagWithSource extends IGkDbTag
{
	public IGkParsingSource getSource();
}
