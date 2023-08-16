package com.GurpinarHaber;

public class BildirimlerUstalarConstructor {

    String id, ustaismi, ustabilgisi, ustaninfotografi;

    public BildirimlerUstalarConstructor() {
    }

    public BildirimlerUstalarConstructor(String id, String ustaismi, String ustabilgisi, String ustaninfotografi) {
        this.id = id;
        this.ustaismi = ustaismi;
        this.ustabilgisi = ustabilgisi;
        this.ustaninfotografi = ustaninfotografi;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUstaismi() {
        return ustaismi;
    }

    public void setUstaismi(String ustaismi) {
        this.ustaismi = ustaismi;
    }

    public String getUstabilgisi() {
        return ustabilgisi;
    }

    public void setUstabilgisi(String ustabilgisi) {
        this.ustabilgisi = ustabilgisi;
    }

    public String getUstaninfotografi() {
        return ustaninfotografi;
    }

    public void setUstaninfotografi(String ustaninfotografi) {
        this.ustaninfotografi = ustaninfotografi;
    }
}
