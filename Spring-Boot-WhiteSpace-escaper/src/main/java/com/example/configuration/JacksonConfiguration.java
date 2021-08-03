//package com.salesmanager.shop.application.config;
//
//import java.util.List;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.http.converter.HttpMessageConverter;
//import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
//import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;
//
//import com.fasterxml.jackson.databind.ObjectMapper;
//
//@Configuration
//public class JacksonConfiguration extends WebMvcConfigurationSupport {
//
//	@Autowired
//	private ObjectMapper objectMapper;
//
//	public MappingJackson2HttpMessageConverter mappingJackson2HttpMessageConverter() {
//		MappingJackson2HttpMessageConverter converter = new MappingJackson2HttpMessageConverter();
//		objectMapper.registerModule(new SimpleTrimModule());
//		converter.setObjectMapper(objectMapper);
//		return converter;
//	}
//
//	@Override
//	protected void configureMessageConverters(List<HttpMessageConverter<?>> converters) {
//		converters.add(mappingJackson2HttpMessageConverter());
//		super.configureMessageConverters(converters);
//	}
//
//}
