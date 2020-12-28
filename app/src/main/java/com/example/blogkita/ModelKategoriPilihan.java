package com.example.blogkita;

public class ModelKategoriPilihan {

    String
            postinganNama,
            postinganTanggal,
            postinganGambar,
            kategoriNama;

    public ModelKategoriPilihan(){

    }

    public ModelKategoriPilihan(String postinganNama, String postinganTanggal, String postinganGambar, String kategoriNama){
        this.postinganNama = postinganNama;
        this.postinganTanggal = postinganTanggal;
        this.postinganGambar = postinganGambar;
        this.kategoriNama = kategoriNama;
    }

    public String getPostinganNama() {
        return postinganNama;
    }

    public void setPostinganNama(String postinganNama) {
        this.postinganNama = postinganNama;
    }

    public String getPostinganTanggal() {
        return postinganTanggal;
    }

    public void setPostinganTanggal(String postinganTanggal) {
        this.postinganTanggal = postinganTanggal;
    }

    public String getPostinganGambar() {
        return postinganGambar;
    }

    public void setPostinganGambar(String postinganGambar) {
        this.postinganGambar = postinganGambar;
    }

    public String getKategoriNama() {
        return kategoriNama;
    }

    public void setKategoriNama(String kategoriNama) {
        this.kategoriNama = kategoriNama;
    }
}
