package com.example.demo.repos;

import org.springframework.data.couchbase.core.query.N1qlPrimaryIndexed;
import org.springframework.data.couchbase.core.query.Query;
import org.springframework.data.couchbase.repository.ReactiveCouchbaseRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.ExcelBulkUpload;

import reactor.core.publisher.Mono;

@Repository
@N1qlPrimaryIndexed
public interface ProductInventoryReactiveRepository {
//extends ReactiveCouchbaseRepository<ExcelBulkUpload, String>{ 
	
//	@Query("select sellerId, data, META().id AS _ID, META().cas AS _CAS from #{#n1ql.bucket} where sellerId = $1 ")
//	Mono<ExcelBulkUpload> findBySellerId(String sellerId);
}
