import org.example.model.SinhVien;
import org.example.service.SinhVienService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class SinhVienTest {
    private SinhVienService sinhVienService;
    @BeforeEach
    public void setUp(){
        sinhVienService = new SinhVienService();
    }

    @Test
    public void themSinhVienHopLe(){
        SinhVien sinhVien = new SinhVien("4", "Nguyen Van A", 5.6d, "sd3", 19);
        assertTrue(sinhVienService.addSinhVien(sinhVien));
    }

    @Test
    public void themSinhVienKhongHopLeVoiTenTrong(){
        SinhVien sinhVien = new SinhVien("4", "", 5.6d, "sd3", 19);
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> {
            sinhVienService.addSinhVien(sinhVien);
        });
        assertEquals(exception.getMessage(), "ten khong hop le");
    }

    @Test
    public void themSinhVienHopLeVoiTenCo1KyTu(){
        SinhVien sinhVien = new SinhVien("4", "A", 5.6d, "sd3", 19);
        assertTrue(sinhVienService.addSinhVien(sinhVien));
    }

    @Test
    public void themSinhVienKhongHopLeVoiTenCoKyTuDacBiet(){
        SinhVien sinhVien = new SinhVien("4", "A$", 5.6d, "sd3", 19);
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> {
            sinhVienService.addSinhVien(sinhVien);
        });
        assertEquals(exception.getMessage(), "ten khong hop le");
    }

    @Test
    public void themSinhVienKhongHopLeVoiTenCoChuaSo(){
        SinhVien sinhVien = new SinhVien("4", "3", 5.6d, "sd3", 19);
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> {
            sinhVienService.addSinhVien(sinhVien);
        });
        assertEquals(exception.getMessage(), "ten khong hop le");
    }

    @Test
    public void themSinhVienKhongHopLeVoiTenCoChuaSoVaKyTuDacBiet(){
        SinhVien sinhVien = new SinhVien("4", "3$A", 5.6d, "sd3", 19);
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> {
            sinhVienService.addSinhVien(sinhVien);
        });
        assertEquals(exception.getMessage(), "ten khong hop le");
    }
}
