package com.example.demo;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PipedInputStream;
import java.io.PipedOutputStream;
import java.io.PrintStream;
import java.math.BigInteger;
import java.nio.charset.StandardCharsets;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.buffer.DataBuffer;
import org.springframework.core.io.buffer.DataBufferUtils;
import org.springframework.http.codec.multipart.FilePart;
import org.springframework.http.codec.multipart.Part;
import org.springframework.http.server.reactive.ServerHttpResponse;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.util.MultiValueMap;

import com.example.demo.domain.CategoryType;
import com.example.demo.domain.ProductInventoryId;
import com.example.demo.repos.ProductInventoryIdRepository;
import com.example.demo.utility.reader.ReadableWorkbook;
import com.example.demo.utility.reader.Row;
import com.example.demo.utility.reader.Sheet;

import lombok.extern.slf4j.Slf4j;
import reactor.core.Disposable;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import reactor.core.scheduler.Scheduler;
import reactor.core.scheduler.Schedulers;

@Slf4j
@Component
public class FileUploadServiceImpl implements FileUploadService {

    @Autowired  
    ExcelReportGenerationServiceImpl  excelReportGeneration; 

    @Autowired
    BulkUploadAdapter bulkUploadCateory;
//
//    @Autowired
//    ProductInventoryIdRepository productInventoryIdRepository;


    // this is for multiple file upload
    @Override
    public Flux<String> getLines(Flux<FilePart> filePartFlux) {

        return filePartFlux.flatMap(this::getLines);
    }

    // this is for single file upload
    @Override
    public Flux<String> getLines(Mono<FilePart> filePartMono) {

        return filePartMono.flatMapMany(this::getLines);
    }

    // this is for single file upload
    @Override
    public Flux<String> getLines(FilePart filePart) {
        return filePart.content()
                .map(dataBuffer -> {
                    byte[] bytes = new byte[dataBuffer.readableByteCount()];
                    dataBuffer.read(bytes);
                    DataBufferUtils.release(dataBuffer);

                    return new String(bytes, StandardCharsets.UTF_8);
                })
                .map(this::processAndGetLinesAsList)
                .flatMapIterable(Function.identity());
    }

    // this is for both single and multiple file upload under `files` param key
    @Override
    public Flux<String> getLinesFromMap(Mono<MultiValueMap<String, Part>> filePartMap) {
        return filePartMap.flatMapIterable(map ->
        map.keySet().stream()
        .filter(key -> key.equals("files"))
        .flatMap(key -> map.get(key).stream().filter(part -> part instanceof FilePart))
        .collect(Collectors.toList()))
                .flatMap(part -> getLines((FilePart) part));
    }

    private List<String> processAndGetLinesAsList(String string) {
        return Arrays.asList(string);

        //        Supplier<Stream<String>> streamSupplier = string::lines;
        //        var isFileOk = streamSupplier.get().allMatch(line -> line.matches(MultipartFileUploadUtils.REGEX_RULES));
        //
        //        return isFileOk ? streamSupplier.get().filter(s -> !s.isBlank()).collect(Collectors.toList()) : new ArrayList<>();
    }

    private Stream<String> lines() {
        return null;
    } 

//    public Flux<String> uploadFileandGetreponse(FilePart filePart,ServerHttpResponse response,String type,long sellerId) {
//        List<BulkUploadData> list =  new ArrayList<BulkUploadData>();
//        try {
//            InputStream inputStream =  getInputStreamFromFluxDataBuffer(filePart.content());
//            ReadableWorkbook wb = new  ReadableWorkbook(inputStream);
//            Sheet sheet = wb.getFirstSheet();
//
//            try (Stream<Row> rows = sheet.openStream()) {
//                rows.forEach(r -> {
//                    if(r.getRowNum() !=1 && r.getRowNum() !=2 && r.getRowNum() !=3) {
//                        list.add(createBulkUploadData(r, type));
//                    }
//                });
//            }
//            String value ="";
//            Mono<ProductInventoryId> mapperFlu =     getProductInventoryId();
//            
//            
//
//            ExcelBulkUpload bulkUpload =   ExcelBulkUpload.builder().category(checkCategory(type))
//                    .sellerId(sellerId).createdDate(LocalDate.now()).updatedDate(LocalDate.now()).bulkUploadDataList(list).build();
//
//            updateResult(mapperFlu,bulkUpload);
//            System.out.println(bulkUpload);
//        }catch (Exception e) {
//            e.printStackTrace();
//        }	
//        return null;
//    }

    
 

    private String  updateResult( Mono<ProductInventoryId> mapperFlu, ExcelBulkUpload bulkUpload) {
      //  ByteArrayOutputStream newConsole = new ByteArrayOutputStream();
       // mapperFlu.flux().map(mre -> mre.getProductInvtId()).subscribe(update -> System.out.print(update) );
        
       //System.setOut(new PrintStream(newConsole))
       // System.out.println(newConsole);
        // return null;
    List<ProductInventoryId> lst  = mapperFlu.flux().publishOn(Schedulers.elastic()).collectList().block();
     return null;
    }

//    public Mono<ProductInventoryId> getProductInventoryId() {
//        return   productInventoryIdRepository.findById("productInventoryId").flatMap(stre -> productInventoryIdRepository.save(ProductInventoryId.builder()
//                .productInvtId(new BigInteger(stre.getProductInvtId()).add(BigInteger.ONE).toString()).id(stre.getId()).build()));
//    }

 
    private BulkUploadData createBulkUploadData(Row r,String type) {
        switch (checkCategory(type)) {
        case SNEAKERS:
            return (BulkUploadData) bulkUploadCateory.apply(CategoryType.SNEAKERS.name(),r);
        default: 
            break;
        }

        return null;
    }
    private CategoryType  checkCategory(String type) {
        return CategoryType.fromText(type).get();
    }


    public InputStream getInputStreamFromFluxDataBuffer(Flux<DataBuffer> data) throws IOException {
        PipedOutputStream osPipe = new PipedOutputStream();
        PipedInputStream isPipe = new PipedInputStream(osPipe);

        DataBufferUtils.write(data, osPipe)
        .subscribeOn(Schedulers.parallel())
        .doOnComplete(() -> {
            try {
                osPipe.close();
            } catch (IOException ignored) {
            }
        })
        .subscribe(DataBufferUtils.releaseConsumer());
        return isPipe;
    }


}
