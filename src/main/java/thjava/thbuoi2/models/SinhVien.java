package thjava.thbuoi2.models;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "sinhvien")
@Getter @Setter
@NoArgsConstructor @AllArgsConstructor
public class SinhVien {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "ma_sv", nullable = false, unique = true, length = 20)
    private String maSv;

    @Column(name = "ho_ten", nullable = false, length = 100)
    private String hoTen;

    @Column(length = 100)
    private String email;

    @Column(name = "so_dien_thoai", length = 15)
    private String soDienThoai;

    @Column(length = 200)
    private String diaChi;
}
