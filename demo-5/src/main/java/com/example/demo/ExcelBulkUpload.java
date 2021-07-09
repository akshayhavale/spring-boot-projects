package com.example.demo;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.couchbase.core.mapping.Document;
import org.springframework.data.couchbase.core.mapping.id.GeneratedValue;
import org.springframework.data.couchbase.core.mapping.id.GenerationStrategy;

import com.couchbase.client.java.repository.annotation.Field;
import com.couchbase.client.java.repository.annotation.Id;
import com.example.demo.domain.CategoryType;
import com.fasterxml.jackson.annotation.JsonInclude;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Document
@Data
@Builder
@JsonInclude(JsonInclude.Include.NON_NULL)
@NoArgsConstructor
@AllArgsConstructor
@Slf4j
public class ExcelBulkUpload {
    
    @Id
    @GeneratedValue(strategy = GenerationStrategy.USE_ATTRIBUTES)
    private String id ;
    @Field
    private Long sellerId;
    @Field
    private LocalDate createdDate;
    @Field
    private LocalDate updatedDate;
    
    @Field
    List<BulkUploadData> bulkUploadDataList;
    @Field
    private CategoryType category;
    
    @Field
    private Integer timeToLive;
    
}
