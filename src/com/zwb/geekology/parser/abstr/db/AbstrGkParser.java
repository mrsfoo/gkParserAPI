package com.zwb.geekology.parser.abstr.db;

import com.zwb.geekology.parser.api.exception.GkParserException;
import com.zwb.geekology.parser.api.parser.GkParserObjectFactory;
import com.zwb.geekology.parser.api.parser.IGkParser;
import com.zwb.geekology.parser.api.parser.IGkParserQuery;
import com.zwb.geekology.parser.api.parser.IGkParsingResult;
import com.zwb.geekology.parser.api.parser.IGkParsingResultArtist;
import com.zwb.geekology.parser.api.parser.IGkParsingResultSampler;
import com.zwb.geekology.parser.api.parser.IGkParsingSource;
import com.zwb.geekology.parser.enums.GkParsingEventType;
import com.zwb.geekology.parser.enums.GkParsingState;
import com.zwb.geekology.parser.impl.GkParsingResult;
import com.zwb.geekology.parser.impl.GkParsingResultArtist;
import com.zwb.geekology.parser.impl.GkParsingResultSampler;
import com.zwb.geekology.parser.impl.GkParsingSource;

public abstract class AbstrGkParser implements IGkParser
{
	private IGkParsingSource source;

	@Override
	public IGkParsingSource getSource() 
	{
		return this.source;
	}
	
	public void setSource(String sourceID)
	{
		this.source = GkParserObjectFactory.createSource(sourceID);
	}

	protected IGkParsingResult setResultSuccess(GkParsingResult result)
	{
		result.addEvent(GkParsingEventType.RETURN_SUCCESS, "returning with query success");
		result.setState(GkParsingState.SUCCESS);
		return result;
	}
	
	protected IGkParsingResult setResultStart(IGkParserQuery query, IGkParsingSource source) throws GkParserException
	{
		String title = source.getId()+"-query, "+query;
		GkParsingResult result;
		if(query.isSampler())
		{
			result = (GkParsingResultSampler)GkParserObjectFactory.createResultSampler(title, source);
		}
		else
		{
			result = (GkParsingResultArtist)GkParserObjectFactory.createResultArtist(title, source);			
		}
		
		result = (GkParsingResult) setResultCheckArgs(result, query);
		if(result.getState()==GkParsingState.UNSPECIFIED)
		{
			result.addEvent(GkParsingEventType.START, "query started");
			result.setState(GkParsingState.RUNNING);
		}
		return result;
	}
	
	protected IGkParsingResult setResultCheckArgs(GkParsingResult result, IGkParserQuery query) throws GkParserException
	{
		if(query.isSampler())
		{
			if((query.getRelease()==null)||query.getRelease().isEmpty())
			{
				result.addEvent(GkParsingEventType.ERROR_ARGUMENT, "query for sampler: release name is <"+query.getRelease()+">");
				result.setState(GkParsingState.ERROR);
				setResultErrorThrow(result);
			}			
		}
		else
		{
			if((query.getArtist()==null)||query.getArtist().isEmpty())
			{
				result.addEvent(GkParsingEventType.ERROR_ARGUMENT, "query for artist: artist name is <"+query.getArtist()+">");
				result.setState(GkParsingState.ERROR);				
				setResultErrorThrow(result);
			}
			if(query.hasRelease())
			{
				if((query.getRelease()==null)||query.getRelease().isEmpty())
				{
					result.addEvent(GkParsingEventType.ERROR_ARGUMENT, "query for artist with relese: artist name is <"+query.getArtist()+">, release name is <"+query.getRelease()+">");
					result.setState(GkParsingState.ERROR);				
					setResultErrorThrow(result);
				}				
			}
		}	
		return result;
	}
	
	protected void setResultErrorThrow(GkParsingResult result) throws GkParserException
	{
		result.addEvent(GkParsingEventType.RETURN_ERROR, "returning with query error");
		result.setState(GkParsingState.ERROR);
		GkParserException ex = GkParserException.createException(result);
		throw ex;
	}
	

}
