package thjava.thbuoi2.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import thjava.thbuoi2.models.SinhVien;

@Repository
public interface SinhVienRepository extends JpaRepository<SinhVien, Long> {
}
