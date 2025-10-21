package org.example.service;

import org.example.model.SinhVien;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SinhVienService {
    List<SinhVien> sinhVienList = new ArrayList<>();

    public List<SinhVien> getSinhVienList() {
        return sinhVienList;
    }

    public SinhVien getSinhVienById(String id) {
        for (SinhVien sinhVien : sinhVienList) {
            if(sinhVien.getId().equals(id)){
                return sinhVien;
            }
        }
        return null;
    }

    public boolean addSinhVien(SinhVien sinhVien) {
        if(sinhVien.getTuoi() < 18 || sinhVien.getTuoi() > 30){
            throw new IllegalArgumentException("tuoi phai nam trong khoang tu 18 - 30");
        }
        if(sinhVien.getDiem() < 0 || sinhVien.getDiem() > 10){
            throw new IllegalArgumentException("diem phai trong khoang tu 0 - 10");
        }
        if(sinhVien.getTen().isEmpty() || !sinhVien.getTen().matches("^[a-zA-Z\\s]+$")){
            throw new IllegalArgumentException("ten khong hop le");
        }
        sinhVienList.add(sinhVien);
        return true;
    }

    public boolean updateSinhVien(SinhVien sinhVien) {

        int index = -1;
        for(int i = 0; i<sinhVienList.size();i++){
            if(sinhVienList.get(i).getId().equals(sinhVien.getId())){
                if(sinhVien.getTuoi() < 18 || sinhVien.getTuoi() > 30){
                    throw new IllegalArgumentException("tuoi phai nam trong khoang tu 18 - 30");
                }
                if(sinhVien.getDiem() < 0 || sinhVien.getDiem() > 10){
                    throw new IllegalArgumentException("diem phai trong khoang tu 0 - 10");
                }
                if(sinhVien.getTen().isEmpty()){
                    throw new IllegalArgumentException("ten trong");
                }
                index = i;
            }
        }
        if(index == -1){
            throw new IllegalArgumentException("khong tim thay sinh vien");
        }
        sinhVienList.set(index, sinhVien);
        return true;
    }

    public void deleteSinhVien(String id) {
        sinhVienList.remove(getSinhVienById(id));
    }
}
