package com.zwb.geekology.parser.api.db;

import java.util.List;
import java.util.Set;

public interface IGkDbTag extends IGkDbItemWithDesc
{
	public static final double defaultWeight = 50;
	public Double getWeight();
	public List<IGkDbTag> getSimilar();
	public List<String> getSimilarsNames();

}
