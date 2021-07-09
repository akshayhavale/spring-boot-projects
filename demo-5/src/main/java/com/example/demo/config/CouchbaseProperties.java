
package com.example.demo.config;

import java.util.Collections;
import java.util.List;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

 
 
@Configuration
// @PropertySource("classpath:couchbase.properties")
@PropertySource(value = "${secrets.filePath}", factory = YamlPropertySourceFactory.class)
public class CouchbaseProperties {
//	private final List<String> bootstrapHosts;
//	private final String bucketName;
//	private final String bucketPassword;
//	private final String username;
//	private final int port;
//
//	public CouchbaseProperties(@Value("${spring.couchbase.bootstrap-hosts}") final List<String> bootstrapHosts,
//	                           @Value("${spring.couchbase.bucket.name}") final String bucketName,
//	                           @Value("${username.couch}") final String userName,
//	                           @Value("${password}") final String bucketPassword,
//	                           @Value("${spring.couchbase.port}") final int port) {
//		this.bootstrapHosts = Collections.unmodifiableList(bootstrapHosts);
//		this.bucketName = bucketName;
//		this.bucketPassword = bucketPassword;
//		this.port = port;
//		this.username = userName;
//	}
//
//	public List<String> getBootstrapHosts() {
//		return bootstrapHosts;
//	}
//
//	public String getBucketName() {
//		return bucketName;
//	}
//
//	public String getUsername() {
//		return username;
//	}
//
//	public String getBucketPassword() {
//		return bucketPassword;
//	}
//
//	public int getPort() {
//		return port;
//	}
}
