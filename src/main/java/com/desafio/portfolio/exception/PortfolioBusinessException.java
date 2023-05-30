package com.desafio.portfolio.exception;

import java.io.PrintStream;
import java.io.PrintWriter;
import java.util.Map;
import java.util.TreeMap;

public class PortfolioBusinessException  extends RuntimeException {

	private static final long serialVersionUID = 6849822435769060596L;

	private EnumErrorCode errorCode;

	private final Map<String, Object> properties = new TreeMap<String, Object>();

	public PortfolioBusinessException() {
	}

	public PortfolioBusinessException( EnumErrorCode errorCode ) {
		this.errorCode = errorCode;
	}

	public PortfolioBusinessException( String message ) {
		super( message );
	}

	public PortfolioBusinessException( String message, EnumErrorCode errorCode ) {
		super( message );
		this.errorCode = errorCode;
	}

	public PortfolioBusinessException( Throwable cause, EnumErrorCode errorCode ) {
		super( cause );
		this.errorCode = errorCode;
	}

	public PortfolioBusinessException( String message, Throwable cause, EnumErrorCode errorCode ) {
		super( message, cause );
		this.errorCode = errorCode;
	}

	public EnumErrorCode getErrorCode() {
		return errorCode;
	}

	public PortfolioBusinessException setErrorCode( EnumErrorCode errorCode ) {
		this.errorCode = errorCode;
		return this;
	}

	public Map<String, Object> getProperties() {
		return properties;
	}
	@SuppressWarnings( "unchecked" )
	public <T> T get( String name ) {
		return ( T ) properties.get( name );
	}

	public PortfolioBusinessException set( String name, Object value ) {
		properties.put( name, value );
		return this;
	}

	public void printStackTrace( PrintStream s ) {
		synchronized( s ) {
			printStackTrace( new PrintWriter( s ) );
		}
	}

	public void printStackTrace( PrintWriter s ) {
		synchronized( s ) {
			s.println( this );
			s.println( "\t-------------------------------" );
			if( errorCode != null ) {
				s.println( "\t" + errorCode + ":" + errorCode.getClass().getName() );
			}
			for( String key : properties.keySet() ) {
				s.println( "\t" + key + "=[" + properties.get( key ) + "]" );
			}
			s.println( "\t-------------------------------" );
			StackTraceElement[] trace = getStackTrace();
			for( int i = 0; i < trace.length; i++ )
				s.println( "\tat " + trace[i] );

			Throwable ourCause = getCause();
			if( ourCause != null ) {
				ourCause.printStackTrace( s );
			}
			s.flush();
		}
	}

}