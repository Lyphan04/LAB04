package thjava.thbuoi2.services;

import thjava.thbuoi2.models.SinhVien;
import thjava.thbuoi2.repository.SinhVienRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
@Transactional
public class SinhVienService {
    private final SinhVienRepository sinhVienRepository;

    public List<SinhVien> getAllSinhVien() {
        return sinhVienRepository.findAll();
    }

    public Optional<SinhVien> getSinhVienById(Long id) {
        return sinhVienRepository.findById(id);
    }

    public void addSinhVien(SinhVien sinhVien) {
        sinhVienRepository.save(sinhVien);
    }

    public void updateSinhVien(SinhVien sinhVien) {
        SinhVien existing = sinhVienRepository.findById(sinhVien.getId())
                .orElseThrow(() -> new IllegalStateException("Sinh viên ID " + sinhVien.getId() + " không tồn tại."));
        existing.setMaSv(sinhVien.getMaSv());
        existing.setHoTen(sinhVien.getHoTen());
        existing.setEmail(sinhVien.getEmail());
        existing.setSoDienThoai(sinhVien.getSoDienThoai());
        existing.setDiaChi(sinhVien.getDiaChi());
        sinhVienRepository.save(existing);
    }

    public void deleteSinhVienById(Long id) {
        if (!sinhVienRepository.existsById(id)) {
            throw new IllegalStateException("Sinh viên ID " + id + " không tồn tại.");
        }
        sinhVienRepository.deleteById(id);
    }
}
