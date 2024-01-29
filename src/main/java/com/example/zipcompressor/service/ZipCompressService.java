package com.example.zipcompressor.service;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.List;
import java.util.Objects;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

@Service
public class ZipCompressService {

    public ByteArrayInputStream execute(List<MultipartFile> files) throws IOException {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        ZipOutputStream zipOutputStream = new ZipOutputStream(byteArrayOutputStream);

        for (MultipartFile file : files) {
            ZipEntry zipEntry = new ZipEntry(Objects.requireNonNull(file.getOriginalFilename()));
            zipOutputStream.putNextEntry(zipEntry);
            zipOutputStream.write(file.getBytes());
            zipOutputStream.closeEntry();
        }

        zipOutputStream.close();

        return new ByteArrayInputStream(byteArrayOutputStream.toByteArray());
    }
}
