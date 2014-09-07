package com.zwb.geekology.parser.abstr.db;

import com.zwb.geekology.parser.api.exception.GkParserException;
import com.zwb.geekology.parser.api.exception.GkParserExceptionFactory;
import com.zwb.geekology.parser.api.exception.GkParserRuntimeException;
import com.zwb.geekology.parser.api.parser.GkParserObjectFactory;
import com.zwb.geekology.parser.api.parser.IGkParser;
import com.zwb.geekology.parser.api.parser.IGkParserQuery;
import com.zwb.geekology.parser.api.parser.IGkParsingEvent;
import com.zwb.geekology.parser.api.parser.IGkParsingResult;
import com.zwb.geekology.parser.api.parser.IGkParsingResultArtist;
import com.zwb.geekology.parser.api.parser.IGkParsingResultSampler;
import com.zwb.geekology.parser.api.parser.IGkParsingSource;
import com.zwb.geekology.parser.enums.GkParsingEventType;
import com.zwb.geekology.parser.enums.GkParsingState;
import com.zwb.geekology.parser.impl.GkParsingEvent;
import com.zwb.geekology.parser.impl.GkParsingResult;
import com.zwb.geekology.parser.impl.GkParsingResultArtist;
import com.zwb.geekology.parser.impl.GkParsingResultSampler;
import com.zwb.geekology.parser.impl.GkParsingSource;

public abstract class AbstrGkParser implements IGkParser
{
	private IGkParsingSource source;
	private IGkParsingEvent constructorEvent;

	@Override
	public IGkParsingSource getSource() 
	{
		return this.source;
	}
	
	protected void setConstructorEvent(IGkParsingEvent event)
	{
		this.constructorEvent = event;
	}
	
	protected void setConstructorEvent(GkParsingEventType type, String message)
	{
		this.constructorEvent = GkParserObjectFactory.createParsingEvent(type, message, this.getSource());
	}
	
	public IGkParsingEvent getConstructorEvent()
	{
		return this.constructorEvent;
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
		
		if(this.getConstructorEvent()!=null)
		{
			this.setResultErrorThrow(result, null);
		}

		result = (GkParsingResult) setResultCheckArgs(result, query);
		if(result.getState()==GkParsingState.UNSPECIFIED)
		{
			result.addEvent(GkParsingEventType.START, "query started");
			result.setState(GkParsingState.RUNNING);
		}
		return result;
	}
	
	private IGkParsingResult setResultCheckArgs(GkParsingResult result, IGkParserQuery query) throws GkParserException
	{
		if(query.isSampler())
		{
			if((query.getRelease()==null)||query.getRelease().isEmpty())
			{
				result.addEvent(GkParsingEventType.ERROR_ARGUMENT, "query for sampler: release name is <"+query.getRelease()+">");
				result.setState(GkParsingState.ERROR);
				setResultErrorThrow(result, null);
			}			
		}
		else
		{
			if((query.getArtist()==null)||query.getArtist().isEmpty())
			{
				result.addEvent(GkParsingEventType.ERROR_ARGUMENT, "query for artist: artist name is <"+query.getArtist()+">");
				result.setState(GkParsingState.ERROR);				
				setResultErrorThrow(result, null);
			}
			if(query.hasRelease())
			{
				if((query.getRelease()==null)||query.getRelease().isEmpty())
				{
					result.addEvent(GkParsingEventType.ERROR_ARGUMENT, "query for artist with relese: artist name is <"+query.getArtist()+">, release name is <"+query.getRelease()+">");
					result.setState(GkParsingState.ERROR);				
					setResultErrorThrow(result, null);
				}				
			}
		}	
		return result;
	}
	
	protected void setResultErrorThrow(GkParsingResult result, Throwable cause) throws GkParserException
	{
		result.addEvent(GkParsingEventType.RETURN_ERROR, "returning with query error");
		result.setState(GkParsingState.ERROR);
		GkParserRuntimeException rex = GkParserExceptionFactory.createRuntimeException(result, cause);
		if(rex!=null)
		{
			throw rex;
		}
		GkParserException ex = GkParserExceptionFactory.createException(result, cause);
		throw ex;
	}
}
