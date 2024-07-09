package com.grb.abihelper.backendend.AbiHelper.main;

import com.grb.abihelper.backendend.AbiHelper.model.PdfFile;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.server.ResponseStatusException;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.sound.sampled.AudioFormat;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.Collection;

@RestController
public class FileController {

    @Autowired
    private FileService fileService;



/*    @PostMapping("/pdfUpload")
    public PdfFile postLoesung(@RequestParam("File") MultipartFile file) throws IOException {
        return fileService.save(file.getOriginalFilename(), file.getContentType(), file.getBytes());
    }
*/

    @GetMapping("/files")
    public Collection<PdfFile> getFiles() {
        return fileService.getFiles();
    }


    @GetMapping("/files/{id}")
    public ResponseEntity<byte[]> downloadFiles(@PathVariable String id){
        PdfFile file = fileService.getFile(id);
        if( file == null) throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        byte[] data = file.getBytes();
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.valueOf("application/txt"));
        ContentDisposition build = ContentDisposition
                .builder("attachment")
                .filename(file.generateName() + ".txt") //Noch in pdf umändern.
                .build();
        headers.setContentDisposition(build);
        return new ResponseEntity<>(data, headers, HttpStatus.OK);
    }

    @PostMapping("/fileEchoIn")
    public String UploadFile(@RequestParam("file") MultipartFile  file, RedirectAttributes redirectAttributes) throws IOException {
       fileService.uploadedMessage = new String(file.getBytes(), StandardCharsets.UTF_8);
        redirectAttributes.addFlashAttribute("message", "You uploaded your file. I will give it back to you");

        return "redirect:./FileEchoOut";
    }
    @GetMapping("/fileEchoOut")
    public ResponseEntity<byte[]> OutputFile() throws  IOException {

        String message = fileService.uploadedMessage;
        byte[] data = message.getBytes();
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.valueOf("application/txt"));
        ContentDisposition build = ContentDisposition
                .builder("attachment")
                .filename("echo.txt")
                .build();
        headers.setContentDisposition(build);
        return new ResponseEntity<byte[]>(data, headers, HttpStatus.OK);

    }
}