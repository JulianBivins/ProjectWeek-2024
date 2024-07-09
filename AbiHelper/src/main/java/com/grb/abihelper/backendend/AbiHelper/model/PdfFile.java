package com.grb.abihelper.backendend.AbiHelper.model;

public class PdfFile {
//    private static int idCounter = 0;

//    private int id;
    private String name;
    private byte[] bytes;


    public PdfFile(String name, byte[] bytes) {
//        this.id = ++idCounter;
        this.name = name;
        this.bytes = bytes;
    }

//    public int getId() {
//        return id;
//    }
//
//    public void setId(int id) {
//        this.id = id;
//    }

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
