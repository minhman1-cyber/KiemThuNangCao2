import org.example.model.NhanVien;
import org.example.service.NhanVienService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class NhanVienTest {
    NhanVienService nhanVienService;
    @BeforeEach
    public void setUp() {
        nhanVienService = new NhanVienService();
    }

    @Test
    public void addNhanVien_luongHopLe() {
        NhanVien nhanVien = new NhanVien(1, "nhan vien mot", 20, 67555d, "phong hanh chinh");
        assertTrue(nhanVienService.themNhanVien(nhanVien));
    }

    @Test
    public void addNhanVien_luongKhongHopLe1() {
        NhanVien nhanVien = new NhanVien(1, "nhan vien mot", 20, 67555000000d, "phong hanh chinh");
        IllegalArgumentException ex = assertThrows(IllegalArgumentException.class, () -> {
            nhanVienService.themNhanVien(nhanVien);
        });
        assertEquals(ex.getMessage(), "Luong phai trong khoang tu 0 - 100000000");
    }

    @Test
    public void addNhanVien_luongKhongHopLe2() {
        NhanVien nhanVien = new NhanVien(1, "nhan vien mot", 20, -5d, "phong hanh chinh");
        IllegalArgumentException ex = assertThrows(IllegalArgumentException.class, () -> {
            nhanVienService.themNhanVien(nhanVien);
        });
        assertEquals(ex.getMessage(), "Luong phai trong khoang tu 0 - 100000000");
    }

    @Test
    public void addNhanVien_luongHopLe_bien1() {
        NhanVien nhanVien = new NhanVien(1, "nhan vien mot", 20, 100000000d, "phong hanh chinh");
        assertTrue(nhanVienService.themNhanVien(nhanVien));
    }

    @Test
    public void addNhanVien_luongHopLe_bien2() {
        NhanVien nhanVien = new NhanVien(1, "nhan vien mot", 20, 0d, "phong hanh chinh");
        IllegalArgumentException ex = assertThrows(IllegalArgumentException.class, () -> {
            nhanVienService.themNhanVien(nhanVien);
        });
        assertEquals(ex.getMessage(), "Luong phai trong khoang tu 0 - 100000000");
    }


}
