package com.grb.abihelper.backendend.AbiHelper.main;

import com.grb.abihelper.backendend.AbiHelper.model.PdfFile;
import org.springframework.stereotype.Service;

import java.util.Map;
import java.util.Set;

@Service
public class FileService {

     Map<String, PdfFile> files = Map.of(
            "One", new PdfFile("One", "One".getBytes()),
            "Two", new PdfFile("Two", "Two".getBytes()),
            "Three", new PdfFile("Three", "Three".getBytes())
    );

    public PdfFile getFile(String name) {
        return files.get(name);
    }

    public Set<String> getFiles() {
        return files.keySet();
    }

}
