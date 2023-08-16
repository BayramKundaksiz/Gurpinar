package com.GurpinarHaber;

public class BildirimlerAlimSatimConstructor {

    String id, urunadi, urundetaylari, urunfotografi;

    public BildirimlerAlimSatimConstructor(String id, String urunadi, String urundetaylari, String urunfotografi) {
        this.id = id;
        this.urunadi = urunadi;
        this.urundetaylari = urundetaylari;
        this.urunfotografi = urunfotografi;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUrunadi() {
        return urunadi;
    }

    public void setUrunadi(String urunadi) {
        this.urunadi = urunadi;
    }

    public String getUrundetaylari() {
        return urundetaylari;
    }

    public void setUrundetaylari(String urundetaylari) {
        this.urundetaylari = urundetaylari;
    }

    public String getUrunfotografi() {
        return urunfotografi;
    }

    public void setUrunfotografi(String urunfotografi) {
        this.urunfotografi = urunfotografi;
    }
}
