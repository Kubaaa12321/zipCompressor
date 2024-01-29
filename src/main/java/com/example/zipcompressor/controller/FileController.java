package com.example.zipcompressor.controller;

import com.example.zipcompressor.action.FileAction;
import org.springframework.core.io.InputStreamResource;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@CrossOrigin("http://localhost:3000")
@RestController
public class FileController {

    private final FileAction fileAction;

    public FileController(FileAction fileAction) {
        this.fileAction = fileAction;
    }

    @PostMapping("/compress")
    public ResponseEntity<InputStreamResource> compressFiles(@RequestParam("myFiles") List<MultipartFile> files) throws IOException {
        return fileAction.execute(files);
    }
}
