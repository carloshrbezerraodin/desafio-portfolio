package com.desafio.portfolio.exception;

import java.util.ResourceBundle;

public enum EnumErrorCode {

	REGRA_STATUS("RULE_STATUS_PROJETO" , 1001, "Se um projeto foi mudado o status para iniciado, em andamento ou encerrado não pode mais ser excluído" );

	private String errorName;
	private int errorCode;
	private String errorMessage;
	
	EnumErrorCode( String i_errorName, int i_errorCode, String i_errorMessage ) {
		this.errorName = i_errorName;
		this.errorCode = i_errorCode;
		this.errorMessage = i_errorMessage;
	}

	public int getErrorCode() {
		return errorCode;
	}

	public void setErrorCode( int errorCode ) {
		this.errorCode = errorCode;
	}

	public String getErrorMessage() {
		return errorMessage;
	}

	public void setErrorMessage( String errorMessage ) {
		this.errorMessage = errorMessage;
	}
	
	public String getErrorName() {
		return errorName;
	}

	public void setErrorName( String errorName ) {
		this.errorName = errorName;
	}

	public static String getExceptionMessage( EnumErrorCode i_errorCode ) {
		ResourceBundle bundle = ResourceBundle.getBundle( "com.ea.example.exceptions" );
		return bundle.getString( i_errorCode.getErrorName() );
	}
	
}