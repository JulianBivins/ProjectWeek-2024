package com.grb.abihelper.backendend.AbiHelper.main;

import com.grb.abihelper.backendend.AbiHelper.model.AIResponseCallback;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.io.IOException;
import java.nio.charset.StandardCharsets;

@Controller
public class AIResponseController {

    @Autowired
    AIResponseService aiService;

    @PostMapping ("/AI/upload")
    public String UploadFile(@RequestParam("file") MultipartFile file, RedirectAttributes redirectAttributes) throws IOException {
        AIResponseCallback callback = aiService.RegisterRequest(file.getBytes());
        redirectAttributes.addFlashAttribute("message", "You uploaded your file. I will give it back to you");

        return "redirect:./Responsesite.html?order=" + callback.getUuid();
    }
    @PostMapping("/ai/response")
    public  String uploadResponse(@RequestParam String id, @RequestParam String token, @RequestBody String result) { //Könnte auch ein void sein. Vielleicht hilft es dem ai team
        AIResponseCallback callback = aiService.getCallback(id);
        if (callback == null) return "haram bro";
        callback.setStatus(AIResponseCallback.AIResponseStatus.Done);
        callback.setResponse(result);
        return "danke bro";
    }
    @GetMapping("/ai/response")
    public  AIResponseCallback respond(@RequestParam String id) {
        AIResponseCallback callback = aiService.getCallback(id);
        if (callback == null) {
            AIResponseCallback emptyCallback;
            emptyCallback = new AIResponseCallback(id, "0");
            emptyCallback.setStatus(AIResponseCallback.AIResponseStatus.Aborted);
            emptyCallback.setResponse("Feedback wurde noch nicht bestellt!");
            return emptyCallback;
        } else return callback;
    }
}