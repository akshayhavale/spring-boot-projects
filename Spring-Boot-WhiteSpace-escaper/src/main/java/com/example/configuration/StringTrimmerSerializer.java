//package com.example.configuration;
//
//import java.io.IOException;
//
//import org.springframework.boot.jackson.JsonComponent;
//import org.springframework.util.StringUtils;
//
//import com.fasterxml.jackson.core.JsonGenerator;
//import com.fasterxml.jackson.databind.JsonSerializer;
//import com.fasterxml.jackson.databind.SerializerProvider;
//
//@JsonComponent
//public class StringTrimmerSerializer extends JsonSerializer<String> {
//
////	@Override
////	public void serialize(String value, JsonGenerator gen, SerializerProvider serializers) throws IOException {
////
////		if (!StringUtils.isEmpty(value)) {
////			value = value.trim();
////		}
////		gen.writeString(value);
////	}
//
//}
