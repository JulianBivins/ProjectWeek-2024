package com.grb.abihelper.backendend.AbiHelper.main;

import com.grb.abihelper.backendend.AbiHelper.model.PdfFile;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.util.Collection;
import java.util.Collections;
import java.util.Map;
import java.util.Set;

@Service
public class FileService {

    //private final FileRepository fileRepository;
    public  String uploadedMessage;
     Map<String, PdfFile> files = Map.of(
            "One", new PdfFile("One", "One".getBytes()),
            "Two", new PdfFile("Two", "Two".getBytes()),
            "Three", new PdfFile("Three", "Three".getBytes())
    );
/*
    public FileService(FileRepository fileRepository) {
        this.fileRepository = fileRepository;
    }
*/

    public PdfFile getFile(String name) {
        return files.get(name);
    }

    public Collection<PdfFile> getFiles() {

        return files.values();
    }

    /*
    Dateien werden nicht gesaved, sondern weitergeleitet.
    public PdfFile save(String fileName, byte[] data) {
        PdfFile file = new PdfFile(fileName, data);
//        file.setName(fileName);
//        file.setBytes(data);
        fileRepository.save(file);
        return file;
    }*/

}
