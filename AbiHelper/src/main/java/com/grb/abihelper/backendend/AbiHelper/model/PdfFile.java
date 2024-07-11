package com.grb.abihelper.backendend.AbiHelper.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import java.sql.ResultSet;
import java.sql.SQLException;

public class PdfFile {
//    private static int idCounter = 0;

//    private int id;

    private String teil;
    private  String option;
    private  String fach;
    private int jahr;
    private String kursArt;
    private  boolean isSolution;
    //private String uuid; //Das was wir bisher als Dateiname benutzt haben.
    @JsonIgnore
    private byte[] bytes;

    public PdfFile(ResultSet resultSet, boolean usingData) {
        try {
            int row = resultSet.getRow();
            resultSet.next();
            row = resultSet.getRow();
            this.teil = resultSet.getString("Teil");
            this.fach = resultSet.getString("Fach");
            this.jahr = resultSet.getInt("Jahr");
            this.option = resultSet.getString("Variante");
            this.kursArt = resultSet.getString("Kursart");
            this.isSolution = resultSet.getBoolean("Lösung");
            if (usingData) this.bytes = resultSet.getBytes("DATA");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    public PdfFile(String name, byte[] bytes) {

        this.teil = "a";
        this.option = "1";
        this.fach = "Informatik";
        //this.isLK = true;
        this.jahr = 2025;
        this.bytes = bytes;
    }
    public  String getName() {
        //Generiert einen Dateinamen aus allen Metadaten.

        return fach + kursArt + jahr + teil + option + (isSolution ? "Lösung" : "Fragen");

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


    public byte[] getBytes() {
        return bytes;
    }

    public void setBytes(byte[] bytes) {
        this.bytes = bytes;
    }

    public int getJahr() {
        return jahr;
    }

    public String getKursArt() {
        return kursArt;
    }

    public boolean isLösung() {
        return isSolution;
    }
}
