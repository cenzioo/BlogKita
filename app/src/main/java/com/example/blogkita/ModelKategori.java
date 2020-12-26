package com.example.blogkita;

public class ModelKategori {

    int kategoriID;

    String kategoriNama;

    public ModelKategori(){

    }

    public ModelKategori(int kategoriID, String kategoriNama){
        this.kategoriID = kategoriID;
        this.kategoriNama = kategoriNama;
    }

    public int getKategoriID() {
        return kategoriID;
    }

    public void setKategoriID(int kategoriID) {
        this.kategoriID = kategoriID;
    }

    public String getKategoriNama() {
        return kategoriNama;
    }

    public void setKategoriNama(String kategoriNama) {
        this.kategoriNama = kategoriNama;
    }
}
