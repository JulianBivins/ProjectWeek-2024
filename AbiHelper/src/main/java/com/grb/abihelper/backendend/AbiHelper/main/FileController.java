package com.grb.abihelper.backendend.AbiHelper.main;

import com.grb.abihelper.backendend.AbiHelper.model.PdfFile;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import java.net.http.HttpResponse;
import java.util.Set;
@RestController
public class FileController {

    @Autowired
    private FileService fileService;



    @GetMapping("/files")
    public Set<String> getFiles() {
        return fileService.getFiles();
    }


    @GetMapping("/files/{id}")
    public ResponseEntity<byte[]> downloadFiles(@PathVariable String id){
        PdfFile file = fileService.getFile(id);
        if(file == null) throw new ResponseStatusException(HttpStatus.NOT_FOUND);

        byte[] data = file.getBytes();
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.valueOf("application/txt"));
        ContentDisposition build = ContentDisposition
                .builder("attachment")
                .filename("dummy.txt")
                .build();
        headers.setContentDisposition(build);
        return new ResponseEntity<>(data, headers, HttpStatus.OK);
    }
}