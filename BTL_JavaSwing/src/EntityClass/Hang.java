/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package EntityClass;

import java.sql.Date;

/**
 *
 * @author Admin
 */
public class Hang {
    private String maSP;
    private String tenSP;
    private String phanLoai;
    private String viTriKho;
    private String viTriGianHang;
    private int giaNhap;
    private int giaBan;
    private float khuyenMai;
    private int soLuongTonKho;
    private int soLuongGianHang;
    private String donVi;
    private Date hanSuDung;

    public Hang() {
    }

    public String getMaSP() {
        return maSP;
    }

    public void setMaSP(String maSP) {
        this.maSP = maSP;
    }

    public String getTenSP() {
        return tenSP;
    }

    public void setTenSP(String tenSP) {
        this.tenSP = tenSP;
    }

    public String getPhanLoai() {
        return phanLoai;
    }

    public void setPhanLoai(String phanLoai) {
        this.phanLoai = phanLoai;
    }

    public String getViTriKho() {
        return viTriKho;
    }

    public void setViTriKho(String viTriKho) {
        this.viTriKho = viTriKho;
    }

    public String getViTriGianHang() {
        return viTriGianHang;
    }

    public void setViTriGianHang(String viTriGianHang) {
        this.viTriGianHang = viTriGianHang;
    }

    public int getGiaNhap() {
        return giaNhap;
    }

    public void setGiaNhap(int giaNhap) {
        this.giaNhap = giaNhap;
    }

    public int getGiaBan() {
        return giaBan;
    }

    public void setGiaBan(int giaBan) {
        this.giaBan = giaBan;
    }

    public float getKhuyenMai() {
        return khuyenMai;
    }

    public void setKhuyenMai(float khuyenMai) {
        this.khuyenMai = khuyenMai;
    }

    public int getSoLuongTonKho() {
        return soLuongTonKho;
    }

    public void setSoLuongTonKho(int soLuongTonKho) {
        this.soLuongTonKho = soLuongTonKho;
    }

    public int getSoLuongGianHang() {
        return soLuongGianHang;
    }

    public void setSoLuongGianHang(int soLuongGianHang) {
        this.soLuongGianHang = soLuongGianHang;
    }

    public String getDonVi() {
        return donVi;
    }

    public void setDonVi(String donVi) {
        this.donVi = donVi;
    }

    public Date getHanSuDung() {
        return hanSuDung;
    }

    public void setHanSuDung(Date hanSuDung) {
        this.hanSuDung = hanSuDung;
    }
    
    
}
