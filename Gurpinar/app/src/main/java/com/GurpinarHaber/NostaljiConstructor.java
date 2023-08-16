package com.GurpinarHaber;




public class NostaljiConstructor {

    String id, kisinin_ismi, fotografin_aciklamasi, fotografin_tarihi, fotograf;

    public NostaljiConstructor() {
    }

    public NostaljiConstructor(String id, String kisinin_ismi, String fotografin_aciklamasi, String fotografin_tarihi, String fotograf) {
        this.id = id;
        this.kisinin_ismi = kisinin_ismi;
        this.fotografin_aciklamasi = fotografin_aciklamasi;
        this.fotografin_tarihi = fotografin_tarihi;
        this.fotograf = fotograf;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getKisinin_ismi() {
        return kisinin_ismi;
    }

    public void setKisinin_ismi(String kisinin_ismi) {
        this.kisinin_ismi = kisinin_ismi;
    }

    public String getFotografin_aciklamasi() {
        return fotografin_aciklamasi;
    }

    public void setFotografin_aciklamasi(String fotografin_aciklamasi) {
        this.fotografin_aciklamasi = fotografin_aciklamasi;
    }

    public String getFotografin_tarihi() {
        return fotografin_tarihi;
    }

    public void setFotografin_tarihi(String fotografin_tarihi) {
        this.fotografin_tarihi = fotografin_tarihi;
    }

    public String getFotograf() {
        return fotograf;
    }

    public void setFotograf(String fotograf) {
        this.fotograf = fotograf;
    }
}
