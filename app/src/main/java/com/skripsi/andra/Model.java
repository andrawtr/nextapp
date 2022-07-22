package com.skripsi.andra;

public class Model {
    public String noevent;
    public String jenis;
    public String lokasi;
    public String tamu;
    public String tanggal;
    public String jam;
    public String status;
    public String uuid;
    public String nope;

    public Model(){

    }

    public Model(String jenis, String lokasi, String tamu, String tanggal, String jam, String status, String uuid, String nope, String noevent) {
        this.jenis = jenis;
        this.lokasi = lokasi;
        this.tamu = tamu;
        this.tanggal = tanggal;
        this.jam = jam;
        this.status = status;
        this.uuid = uuid;
        this.nope = nope;
        this.noevent = noevent;
    }


    public String getJenis() {
        return jenis;
    }

    public String getLokasi() {
        return lokasi;
    }

    public String getTamu() {
        return tamu;
    }

    public String getTanggal() {
        return tanggal;
    }

    public String getJam() {
        return jam;
    }

    public String getStatus() {
        return status;
    }

    public String getUuid() {
        return uuid;
    }

    public String getNope() {
        return nope;
    }
    public String getNoevent() {
        return noevent;
    }

}