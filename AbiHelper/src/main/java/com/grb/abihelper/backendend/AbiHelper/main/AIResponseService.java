package com.grb.abihelper.backendend.AbiHelper.main;

import com.grb.abihelper.backendend.AbiHelper.model.AIResponseCallback;
import org.springframework.stereotype.Service;


import  java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.UUID;


@Service
public class AIResponseService {
    AIResponseCallback[] callbacks = new AIResponseCallback[200]; //Maximal 200 Request zwischenspeichern. Kann eig kleiner angesetzt werden.
    int index = 0;
    public  AIResponseCallback RegisterRequest(byte[] data) {
        UUID uuid = UUID.randomUUID();
        AIResponseCallback callback = new AIResponseCallback(uuid.toString(), UUID.randomUUID().toString());
        RequestResponse(data, callback);
        callbacks[index] = callback;
        index = (index + 1) % 200;
        return callback;
    }
    public void RequestResponse(byte[] data, AIResponseCallback callback) {
        try {
            URL url = new URL("localhost:8151/aiInput"); //Habe ich jetzt entschieden.
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("POST");
            conn.setRequestProperty("ID", callback.getUuid());
            conn.setRequestProperty("Authorization", "Bearer " + callback.getToken());
            conn.setRequestProperty("Content-Type", "application/octet-stream");
            conn.setDoOutput(true);

            OutputStream os = conn.getOutputStream();
            os.write(data);
            os.flush();

            if (conn.getResponseCode() != HttpURLConnection.HTTP_OK) {
                //Alles außer ok ist schlecht.
                //Bitte bitte bitte, lass das AI Team den code 200 implementieren.
                callback.setStatus(AIResponseCallback.AIResponseStatus.Aborted);
            }
        }
        catch (Exception e) {
            callback.setStatus(AIResponseCallback.AIResponseStatus.Aborted);
        }

        //Der Code von Manvir.
        //Wenn die Anfrage irgendwie fehlschlägt müssen wir callback.status auf aborted setzen.
        //Ganz unten auf der Prio Liste
    }
    public AIResponseCallback getCallback(String id) {
            for (int i = 0; i < 200; i++) {
                AIResponseCallback callback = callbacks[(200 + index - i) % 200]; //Das letzte Elemt wird das Erste sein. Wenn es irgendwie hakt mach den Code weg.
                if (callback == null) return  null; //NullWert bedeutet wir sind am Ende der Liste
                else if (callback.getUuid().toString() == id) return callback;
            }
            return null;
    }
}
