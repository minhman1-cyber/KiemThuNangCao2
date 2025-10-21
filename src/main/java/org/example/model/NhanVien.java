package org.example.model;

public class NhanVien {
    private Integer ma;
    private String ten;
    private Integer tuoi;
    private Double luong;
    private String phongBan;

    public NhanVien() {
    }

    public NhanVien(Integer ma, String ten, Integer tuoi, Double luong, String phongBan) {
        this.ma = ma;
        this.ten = ten;
        this.tuoi = tuoi;
        this.luong = luong;
        this.phongBan = phongBan;
    }

    public String getPhongBan() {
        return phongBan;
    }

    public void setPhongBan(String phongBan) {
        this.phongBan = phongBan;
    }

    public Double getLuong() {
        return luong;
    }

    public void setLuong(Double luong) {
        this.luong = luong;
    }

    public Integer getTuoi() {
        return tuoi;
    }

    public void setTuoi(Integer tuoi) {
        this.tuoi = tuoi;
    }

    public String getTen() {
        return ten;
    }

    public void setTen(String ten) {
        this.ten = ten;
    }

    public Integer getMa() {
        return ma;
    }

    public void setMa(Integer ma) {
        this.ma = ma;
    }
}
