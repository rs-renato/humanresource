package br.com.hrs.microservice.region.config.init;

import br.com.hrs.microservice.region.config.HrsApiInfraConfiguration;
import br.com.hrs.microservice.region.config.HrsApiJwtSecurityConfiguration;
import br.com.hrs.microservice.region.config.HrsApiSwaggerConfiguration;
import br.com.hrs.microservice.region.config.HrsApiWebMvcConfiguration;
import org.apache.commons.lang3.ArrayUtils;
import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

public class HrsApiApplicationInitializer extends AbstractAnnotationConfigDispatcherServletInitializer  {
	
	@Override
	protected Class<?>[] getRootConfigClasses() {
		
		/*** Carrega classes de configuração da aplicação ***/
		Class<?>[] rootConfigClasses = new Class[0];

		rootConfigClasses = ArrayUtils.add(rootConfigClasses, HrsApiInfraConfiguration.class);
		rootConfigClasses = ArrayUtils.add(rootConfigClasses, HrsApiJwtSecurityConfiguration.class);
		
		return rootConfigClasses;
	}

	@Override
	protected Class<?>[] getServletConfigClasses() {
		return new Class<?>[]{HrsApiWebMvcConfiguration.class, HrsApiSwaggerConfiguration.class};
	}

	@Override
	protected String[] getServletMappings() {
		return new String[]{"/"};
	}
}