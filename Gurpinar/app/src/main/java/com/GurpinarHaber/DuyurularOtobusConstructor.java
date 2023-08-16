package com.GurpinarHaber;

public class DuyurularOtobusConstructor {

    String id, isim, resim;

    public DuyurularOtobusConstructor() {
    }

    public DuyurularOtobusConstructor(String id, String isim, String resim) {
        this.id = id;
        this.isim = isim;
        this.resim = resim;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getIsim() {
        return isim;
    }

    public void setIsim(String isim) {
        this.isim = isim;
    }

    public String getResim() {
        return resim;
    }

    public void setResim(String resim) {
        this.resim = resim;
    }
}
