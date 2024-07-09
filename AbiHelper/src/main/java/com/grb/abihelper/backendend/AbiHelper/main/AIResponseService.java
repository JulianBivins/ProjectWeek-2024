package com.grb.abihelper.backendend.AbiHelper.main;

import com.grb.abihelper.backendend.AbiHelper.model.AIResponseCallback;
import org.springframework.stereotype.Service;

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
