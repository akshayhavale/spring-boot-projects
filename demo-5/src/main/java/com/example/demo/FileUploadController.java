package com.example.demo;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.codec.multipart.FilePart;
import org.springframework.http.codec.multipart.Part;
import org.springframework.http.server.reactive.ServerHttpResponse;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Slf4j
@RestController
@RequestMapping("multipart-file")
@RequiredArgsConstructor
public class FileUploadController {

    private final FileUploadService fileUploadService;

    // use Flux<FilePart> for multiple file upload
    @PostMapping(value = "/upload-flux", consumes = MediaType.MULTIPART_FORM_DATA_VALUE, produces = MediaType.APPLICATION_STREAM_JSON_VALUE)
    @ResponseStatus(value = HttpStatus.OK)
    public Mono<List<String>> upload(@RequestPart("files") Flux<FilePart> filePartFlux) {

        /*
          To see the response beautifully we are returning strings as Mono List
          of String. We could have returned Flux<String> from here.
          If you are curious enough then just return Flux<String> from here and
          see the response on Postman
         */
        return fileUploadService.getLines(filePartFlux).collectList();
    }

    // use single Mono<FilePart> for single file upload
    @PostMapping(value = "/upload-mono", consumes = MediaType.MULTIPART_FORM_DATA_VALUE, produces = MediaType.APPLICATION_STREAM_JSON_VALUE)
    @ResponseStatus(value = HttpStatus.OK)
    public Mono<List<String>> upload(@RequestPart("file") Mono<FilePart> filePartMono) {

        /*
          To see the response beautifully we are returning strings as Mono List
          of String. We could have returned Flux<String> from here.
          If you are curious enough then just return Flux<String> from here and
          see the response on Postman
         */
        return fileUploadService.getLines(filePartMono).collectList();
    }

    // use single FilePart for single file upload
    @PostMapping(value = "/upload-filePart", 
    		consumes = MediaType.MULTIPART_FORM_DATA_VALUE, produces = MediaType.APPLICATION_STREAM_JSON_VALUE)
    @ResponseStatus(value = HttpStatus.OK)
    public Flux<String> upload(@RequestPart("file") FilePart filePart,ServerHttpResponse response ,@RequestParam String type,@RequestParam long sellerId) {
    		
    	System.out.println("***************");
        /*
          To see the response beautifully we are returning strings as Mono List
          of String. We could have returned Flux<String> from here.
          If you are curious enough then just return Flux<String> from here and
          see the response on Postman
         */ 
       // return fileUploadService.getLines(filePart).collectList();
//    	return fileUploadService.uploadFileandGetreponse(filePart,response,type,sellerId);
    	return null;
    }

    // use Mono<MultiValueMap<String, Part>> for both single and multiple file upload under `files` param key
    @PostMapping(value = "/upload-multiValueMap", consumes = MediaType.MULTIPART_FORM_DATA_VALUE, produces = MediaType.APPLICATION_STREAM_JSON_VALUE)
    @ResponseStatus(value = HttpStatus.OK)
    public Mono<List<String>> uploadFileMap(@RequestBody Mono<MultiValueMap<String, Part>> filePartMap) {
    	
        /*
          To see the response beautifully we are returning strings as Mono List
          of String. We could have returned Flux<String> from here.
          If you are curious enough then just return Flux<String> from here and
          see the response on Postman
         */
        return fileUploadService.getLinesFromMap(filePartMap).collectList();
    }
}
