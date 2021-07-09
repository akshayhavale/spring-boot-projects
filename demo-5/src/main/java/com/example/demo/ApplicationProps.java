/*
 **************************************************************
Copyright (C) Lowe's Companies,
Inc. All rights reserved. This file is for internal use only at Lowe's Companies, Inc.
 **************************************************************
 */
package com.example.demo;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

 

import lombok.Data;

@ConfigurationProperties
@Configuration
@Data
//@PropertySource(value = "${secrets.sslFilePath}")
public class ApplicationProps {
//
//	private Kafka kafka;
//	private ExcelHeaders excelHeader;
//
//	@Value("${secretkey}")
//	private String secretKey;
//
//	@Data
//	public static class Kafka {
//		private KafkaProducerProps producer;
//		private boolean sslEnabled;
//		private String keyStoreLocation;
//		private String trustStoreLocation;
//	}
//
//	@Data
//	public static class KafkaProducerProps {
//		private String groupId;
//		private String topic;
//		private String bootstrapServers;
//		private Integer maxRequestSize;
//		private Integer bufferMemory;
//		private String acks;
//	}

	@Data
	public static class ExcelHeaders {
		private String[] resetId;
		private String[] storeNumber;
		private String[] modelNumber;
		private String[] instanceId;
		private String[] aile;
		private String[] pogFlow;
		private String[] mpogId;
		private String[] mpogName;
		private String[] fixtureHwd;
		private String[] multiprogram;
		private String[] mpogFuture;
		private String[] pogFlowFuture;
	}

}
