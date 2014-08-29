package com.zwb.geekology.parser.api.db;

import java.util.Date;
import java.util.List;

public interface IGkDbRelease extends IGkDbItemWithDesc, IGkDbItemWithStyleTags
{
	public boolean isSampler();
	public IGkDbArtist getArtist();
	public List<IGkDbTrack> getTracks();
	public List<String> getTrackNames();
	public Date getReleaseDate();
	public boolean hasReleaseDate();
}
