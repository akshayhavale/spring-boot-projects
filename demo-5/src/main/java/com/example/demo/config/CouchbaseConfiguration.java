
package com.example.demo.config;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.convert.converter.Converter;
import org.springframework.data.convert.ReadingConverter;
import org.springframework.data.convert.WritingConverter;
import org.springframework.data.couchbase.config.AbstractReactiveCouchbaseConfiguration;
import org.springframework.data.couchbase.config.BeanNames;
import org.springframework.data.couchbase.core.convert.CouchbaseCustomConversions;
import org.springframework.data.couchbase.core.convert.MappingCouchbaseConverter;
import org.springframework.data.couchbase.core.mapping.CouchbaseDocument;
import org.springframework.data.couchbase.core.mapping.CouchbasePersistentEntity;
import org.springframework.data.couchbase.core.mapping.CouchbasePersistentProperty;
import org.springframework.data.couchbase.repository.config.EnableReactiveCouchbaseRepositories;
import org.springframework.data.mapping.context.MappingContext;

import com.couchbase.client.java.Bucket;
import com.couchbase.client.java.cluster.ClusterInfo;
import com.example.demo.ExcelBulkUpload;
 
@Configuration
@EnableReactiveCouchbaseRepositories
public class CouchbaseConfiguration {
//extends AbstractReactiveCouchbaseConfiguration {
//
//	private CouchbaseProperties couchbaseProperties;
//
//	public CouchbaseConfiguration(final CouchbaseProperties couchbaseProperties) {
//		this.couchbaseProperties = couchbaseProperties;
//	}
//
//	@Override
//	protected List<String> getBootstrapHosts() {
//		return couchbaseProperties.getBootstrapHosts();
//	}
//
//	@Override
//	protected String getBucketName() {
//		return couchbaseProperties.getBucketName();
//	}
//
//	@Override
//	protected String getBucketPassword() {
//		return couchbaseProperties.getBucketPassword();
//	}
//
//	@Override
//	protected String getUsername() {
//		return couchbaseProperties.getUsername();
//	}
//
//	/*
//	 * @Override
//	 * public CouchbaseEnvironment couchbaseEnvironment() {
//	 * return DefaultCouchbaseEnvironment.builder()
//	 * .bootstrapHttpDirectPort(couchbaseProperties.getPort())
//	 * .build();
//	 * }
//	 */
//	@Override
//	@Bean(name = BeanNames.COUCHBASE_CLUSTER_INFO)
//	public ClusterInfo couchbaseClusterInfo() throws Exception {
//		return couchbaseCluster().authenticate(getUsername(), getBucketPassword())
//		        .clusterManager()
//		        .info();
//	}
//
//	@Override
//	@Bean(destroyMethod = "close", name = BeanNames.COUCHBASE_BUCKET)
//	public Bucket couchbaseClient() throws Exception {
//		return couchbaseCluster().openBucket(getBucketName());
//	}
//	/*
//	 * @Bean(name = BeanNames.COUCHBASE_INDEX_MANAGER)
//	 * public IndexManager couchbaseIndexManager() {
//	 * return new IndexManager(true, true, false);
//	 * }
//	 */
//
//	@Override
//	public CouchbaseCustomConversions customConversions() {
//		return new CouchbaseCustomConversions(Arrays.asList(BigDecimalToString.INSTANCE,
//		                                                    StringToBigDecimalConverter.INSTANCE));
//	}
//
//	@WritingConverter
//	public enum BigDecimalToString implements Converter<BigDecimal, String> {
//		INSTANCE;
//
//		@Override
//		public String convert(BigDecimal source) {
//			return source.toString();
//		}
//	}
//
//	@ReadingConverter
//	public enum StringToBigDecimalConverter implements Converter<String, BigDecimal> {
//		INSTANCE;
//
//		@Override
//		public BigDecimal convert(String source) {
//			return new BigDecimal(source);
//		}
//	}
//
//	class ExpiringDocumentCouchbaseConverter extends MappingCouchbaseConverter {
//
//		/**
//		 * Create a new {@link MappingCouchbaseConverter}.
//		 *
//		 * @param mappingContext the mapping context to use.
//		 */
//		public ExpiringDocumentCouchbaseConverter(MappingContext<? extends CouchbasePersistentEntity<?>,
//		                                                         CouchbasePersistentProperty> mappingContext) {
//			super(mappingContext);
//		}
//
//		/**
//		 * Setting custom TTL on documents.
//		 *
//		 * @param source
//		 * @param target
//		 */
//		@Override
//		public void write(final Object source, final CouchbaseDocument target) {
//			super.write(source, target);
//			if (source instanceof ExcelBulkUpload) {
//				target.setExpiration(((ExcelBulkUpload) source).getTimeToLive());
//			}
//
//		}
//	}
}

