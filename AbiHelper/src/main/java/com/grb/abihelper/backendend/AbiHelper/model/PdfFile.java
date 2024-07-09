package com.grb.abihelper.backendend.AbiHelper.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

public class PdfFile {
//    private static int idCounter = 0;

//    private int id;
    private String name;
    private String teil;
    private  String option;
    private  String fach;
    private int jahr;
    private boolean isLK;
    //private String uuid; //Das was wir bisher als Dateiname benutzt haben.
    @JsonIgnore
    private byte[] bytes;


    public PdfFile(String name, byte[] bytes) {
        this.name = name;
        this.teil = "a";
        this.option = "1";
        this.fach = "Informatik";
        this.isLK = true;
        this.jahr = 2025;
        this.bytes = bytes;
    }
    public  String generateName() {
        //Generiert einen Dateinamen aus allen Metadaten.
        return fach + ( isLK ? "LK" : "") + jahr + teil + option;

    }
    public String getTeil() {
        return teil;
    }

    public String getOption() {
        return option;
    }

    public String getFach() {
        return fach;
    }

    public boolean isLK() {
        return isLK;
    }
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public byte[] getBytes() {
        return bytes;
    }

    public void setBytes(byte[] bytes) {
        this.bytes = bytes;
    }
}
