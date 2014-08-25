package com.zwb.geekology.parser.api.db;

import java.util.List;

public interface IGkDbItemWithStyleTags extends IGkDbItem
{
	public List<IGkDbTag> getStyleTags();
	public List<String> getStyleTagNames();

}
