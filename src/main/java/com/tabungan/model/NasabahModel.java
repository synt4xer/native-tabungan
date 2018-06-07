package com.tabungan.model;

import java.io.Serializable;
import java.util.Date;

/**
 * Created by IntelliJ IDEA.
 * User: FERREL JOHN FERNANDO
 * Date: 05/06/2018.
 * Time: 15:28.
 * To change this template use File | Settings | File Templates.
 */
public class NasabahModel implements Serializable {
    private String id;
    private String noTabungan;
    private String namaNasabah;
    private Date tglLahir;
    private String tmptLahir;
    private String alamat;
    private String email;
    private String noHp;
    private String tipeTabungan;

    public NasabahModel() {

    }

    public NasabahModel(String id) {
        this.id = id;
    }

    public NasabahModel(String id, String noTabungan, String namaNasabah, Date tglLahir, String tmptLahir,
                        String alamat, String email, String noHp, String tipeTabungan) {
        this(noTabungan, namaNasabah, tglLahir, tmptLahir, alamat, email, noHp, tipeTabungan);
        this.id = id;
    }

    public NasabahModel(String noTabungan, String namaNasabah, Date tglLahir, String tmptLahir,
                        String alamat, String email, String noHp, String tipeTabungan) {
        this.noTabungan = noTabungan;
        this.namaNasabah = namaNasabah;
        this.tglLahir = tglLahir;
        this.tmptLahir = tmptLahir;
        this.alamat = alamat;
        this.email = email;
        this.noHp = noHp;
        this.tipeTabungan = tipeTabungan;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNoTabungan() {
        return noTabungan;
    }

    public void setNoTabungan(String noTabungan) {
        this.noTabungan = noTabungan;
    }

    public String getNamaNasabah() {
        return namaNasabah;
    }

    public void setNamaNasabah(String namaNasabah) {
        this.namaNasabah = namaNasabah;
    }

    public Date getTglLahir() {
        return tglLahir;
    }

    public void setTglLahir(Date tglLahir) {
        this.tglLahir = tglLahir;
    }

    public String getTmptLahir() {
        return tmptLahir;
    }

    public void setTmptLahir(String tmptLahir) {
        this.tmptLahir = tmptLahir;
    }

    public String getAlamat() {
        return alamat;
    }

    public void setAlamat(String alamat) {
        this.alamat = alamat;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getNoHp() {
        return noHp;
    }

    public void setNoHp(String noHp) {
        this.noHp = noHp;
    }

    public String getTipeTabungan() {
        return tipeTabungan;
    }

    public void setTipeTabungan(String tipeTabungan) {
        this.tipeTabungan = tipeTabungan;
    }
}
