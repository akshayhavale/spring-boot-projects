package com.example.configuration;

import java.io.IOException;

import org.springframework.context.annotation.Configuration;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.deser.std.StdScalarDeserializer;
import com.fasterxml.jackson.databind.module.SimpleModule;

@Configuration
public class SimpleTrimModule extends SimpleModule {

	/**
	 * 
	 */
	private static final long serialVersionUID = 6197809771542148459L;

	public SimpleTrimModule() {
		addDeserializer(String.class, new StdScalarDeserializer<String>(String.class) {
			/**
			 * 
			 */
			private static final long serialVersionUID = -2018303857691958414L;

			@Override
			public String deserialize(JsonParser jsonParser, DeserializationContext ctx) throws IOException {
				return jsonParser.getValueAsString().trim();
			}
		});
	}

}
