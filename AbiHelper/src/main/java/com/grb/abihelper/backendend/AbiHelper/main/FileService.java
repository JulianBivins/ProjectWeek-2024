package com.grb.abihelper.backendend.AbiHelper.main;

import com.grb.abihelper.backendend.AbiHelper.model.PdfFile;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Collection;
import java.util.Map;
import java.util.UUID;

@Service
public class FileService {

    //private final FileRepository fileRepository;
    @Autowired
    DatabaseService databaseService;

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

    public PdfFile getFile(String uuid) throws SQLException {

        Connection con = databaseService.getConnection();
        PreparedStatement statement = con.prepareStatement("SELECT * FROM Dateien WHERE UUID = ?");
        statement.setString(1, uuid);
        ResultSet set = statement.executeQuery();

        return new PdfFile(set, true);

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
