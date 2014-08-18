package com.zwb.geekology.parser.api.db;

import java.util.Set;

public interface IGkDbArtist extends IGkDbItem
{
	public Set<IGkDbRelease> getReleases();
	public Set<IGkDbTagWithSource> getStyleTags();
	//Herkunftsland, Sprache(n)
}
