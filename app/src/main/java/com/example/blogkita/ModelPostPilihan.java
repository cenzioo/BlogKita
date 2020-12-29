package com.example.blogkita;

public class ModelPostPilihan {

    String
            postinganNama,
            postinganIsi,
            postinganGambar;

    public ModelPostPilihan(){

    }

    public ModelPostPilihan(String postinganNama, String postinganIsi, String postinganGambar){
        this.postinganGambar = postinganGambar;
        this.postinganIsi = postinganIsi;
        this.postinganNama = postinganNama;
    }

    public String getPostinganNama() {
        return postinganNama;
    }

    public void setPostinganNama(String postinganNama) {
        this.postinganNama = postinganNama;
    }

    public String getPostinganIsi() {
        return postinganIsi;
    }

    public void setPostinganIsi(String postinganIsi) {
        this.postinganIsi = postinganIsi;
    }

    public String getPostinganGambar() {
        return postinganGambar;
    }

    public void setPostinganGambar(String postinganGambar) {
        this.postinganGambar = postinganGambar;
    }
}
