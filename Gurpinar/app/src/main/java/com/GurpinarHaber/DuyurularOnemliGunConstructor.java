package com.GurpinarHaber;

public class DuyurularOnemliGunConstructor {

    String id, duyuru_adi, duyuru_iletisim, duyuru_fotografi;

    public DuyurularOnemliGunConstructor() {
    }

    public DuyurularOnemliGunConstructor(String id, String duyuru_adi, String duyuru_iletisim, String duyuru_fotografi) {
        this.id = id;
        this.duyuru_adi = duyuru_adi;
        this.duyuru_iletisim = duyuru_iletisim;
        this.duyuru_fotografi = duyuru_fotografi;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getDuyuru_adi() {
        return duyuru_adi;
    }

    public void setDuyuru_adi(String duyuru_adi) {
        this.duyuru_adi = duyuru_adi;
    }

    public String getDuyuru_iletisim() {
        return duyuru_iletisim;
    }

    public void setDuyuru_iletisim(String duyuru_iletisim) {
        this.duyuru_iletisim = duyuru_iletisim;
    }

    public String getDuyuru_fotografi() {
        return duyuru_fotografi;
    }

    public void setDuyuru_fotografi(String duyuru_fotografi) {
        this.duyuru_fotografi = duyuru_fotografi;
    }
}
