package com.grb.abihelper.backendend.AbiHelper.model;

public class AIResponseCallback {

    public  enum AIResponseStatus {
        Pending,
        Done,
        Aborted
    }
    private String uuid;
    private String token;
    private String response;
    private AIResponseStatus status;

    public void setStatus(AIResponseStatus status) {
        this.status = status;
    }

    public AIResponseStatus getStatus() {
        return status;
    }

    public String getResponse() {
        return response;
    }
    public void setResponse(String response) {
        this.response = response;
    }
    public String getToken() {
        return token;
    }
    public String getUuid() {
        return uuid;
    }



    public AIResponseCallback(String uuid, String token) {
        this.uuid = uuid;
        this.token = token;
        this.status = AIResponseStatus.Pending;
    }
}
