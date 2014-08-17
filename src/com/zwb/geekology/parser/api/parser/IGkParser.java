package com.zwb.geekology.parser.api.parser;

public interface IGkParser 
{

	public IGkParserResult parse(IGkParserQuery query);
	public IGkParsingSource getSource();
}
