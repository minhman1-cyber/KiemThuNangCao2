package org.example.service;

import org.example.model.NhanVien;

import java.util.ArrayList;
import java.util.List;

public class NhanVienService {
    List<NhanVien> listNhanVien = new ArrayList<>();
    
    public boolean themNhanVien(NhanVien nhanVien) {
        if(nhanVien.getTuoi() < 18 || nhanVien.getTuoi() > 30){
            throw new IllegalArgumentException("tuoi phai nam trong khoang tu 18 - 30");
        }
        if(nhanVien.getLuong() <= 0 || nhanVien.getLuong() > 100000000){
            throw new IllegalArgumentException("Luong phai trong khoang tu 0 - 100000000");
        }
        if(nhanVien.getTen().isEmpty() || !nhanVien.getTen().matches("^[a-zA-Z\\s]+$")){
            throw new IllegalArgumentException("ten khong hop le");
        }
        listNhanVien.add(nhanVien);
        return true;
    }
    
}
