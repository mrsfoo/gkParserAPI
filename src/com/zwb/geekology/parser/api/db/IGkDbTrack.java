package com.zwb.geekology.parser.api.db;

import java.util.List;

public interface IGkDbTrack extends IGkDbItemWithDesc, IGkDbItemWithStyleTags
{
	public int getTrackNo();
	public IGkDbRelease getRelease();
	public IGkDbRelease getArtist();
	public int getDuration();

}
