package com.example.blogkita;

import android.media.Image;

public class ModelPostingan {

    String
            postinganNama,
            postinganTanggal,
            postinganGambar;

    public ModelPostingan(){

    }

    public ModelPostingan(String kategoriNama, String postinganTanggal, String postinganGambar){
        this.postinganNama = kategoriNama;
        this.postinganTanggal = postinganTanggal;
        this.postinganGambar = postinganGambar;
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
}
