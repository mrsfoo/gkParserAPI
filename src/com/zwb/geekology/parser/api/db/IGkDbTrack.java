package com.zwb.geekology.parser.api.db;


public interface IGkDbTrack extends IGkDbItemWithDesc, IGkDbItemWithStyleTags, Comparable<IGkDbTrack>
{
	public Integer getTrackNo();
	public Integer getDiscNo();
	public IGkDbRelease getRelease();
	public IGkDbArtist getArtist();
	public Long getDuration();
	public boolean hasDuration();
	public Integer getAbsolutePosition();
}
