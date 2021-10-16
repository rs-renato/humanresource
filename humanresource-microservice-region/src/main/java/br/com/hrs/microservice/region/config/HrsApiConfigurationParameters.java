package br.com.hrs.microservice.region.config;

public class HrsApiConfigurationParameters {

	private HrsApiConfigurationParameters() {

	}
	
	public static final String PACKAGE_CONTROLLER							= "br.com.hrs.microservice.region.v**.controller";
	public static final String PACKAGE_MAPPER								= "br.com.hrs.microservice.region.v**.mapper";
	public static final String PACKAGE_ERROR_HANDLER	 					= "br.com.hrs.microservice.region.error";
	public static final String PACKAGE_SUPPORT 								= "br.com.hrs.microservice.region.support";


	// SWAGGER
	public static final String SWAGGER_DOCS_AUTHORIZATION_HEADER_NAME 		= "Authorization";
	public static final String SWAGGER_DOCS_AUTHORIZATION_HEADER_DESC		= "JWT Authorizaton Token";
	public static final String SWAGGER_DOCS_AUTHORIZATION_TYPE 				= "header";
	
}
