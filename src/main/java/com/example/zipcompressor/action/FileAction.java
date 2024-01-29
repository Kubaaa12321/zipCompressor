package com.example.zipcompressor.action;

import java.util.List;

import com.example.zipcompressor.service.ZipCompressService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.io.InputStreamResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.context.annotation.RequestScope;
import org.springframework.web.multipart.MultipartFile;

@Service
@RequestScope
public class FileAction {

    private final Logger logger = LoggerFactory.getLogger(this.getClass().getSimpleName());
    private final ZipCompressService zipCompressService;

    public FileAction(ZipCompressService zipCompressService) {
        this.zipCompressService = zipCompressService;
    }

    public ResponseEntity<InputStreamResource> execute(List<MultipartFile> files) {
        try {
            HttpHeaders headers = new HttpHeaders();
            headers.add(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=compressed.zip");

            return ResponseEntity
                    .ok()
                    .headers(headers)
                    .contentType(MediaType.APPLICATION_OCTET_STREAM)
                    .body(new InputStreamResource(zipCompressService.execute(files)));

        } catch (Exception e) {
            logger.error(e.getMessage(), e);
            return ResponseEntity.internalServerError().build();
        }
    }
}
