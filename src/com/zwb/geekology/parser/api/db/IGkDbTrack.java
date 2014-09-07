package com.zwb.geekology.parser.api.db;


public interface IGkDbTrack extends IGkDbItemWithDesc, IGkDbItemWithStyleTags
{
	public Integer getTrackNo();
	public IGkDbRelease getRelease();
	public IGkDbArtist getArtist();
	public Integer getDuration();
	public boolean hasDuration();
}
