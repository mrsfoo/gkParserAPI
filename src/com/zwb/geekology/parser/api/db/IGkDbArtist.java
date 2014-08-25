package com.zwb.geekology.parser.api.db;

import java.util.List;
import java.util.Set;

public interface IGkDbArtist extends IGkDbItemWithDesc, IGkDbItemWithStyleTags
{
	public List<IGkDbRelease> getReleases();
	public List<String> getReleaseNames();
	public List<IGkDbArtist> getSimilar();
	public List<String> getSimilarsNames();
	//Herkunftsland, Sprache(n)
}
