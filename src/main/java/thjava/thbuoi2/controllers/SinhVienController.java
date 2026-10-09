package thjava.thbuoi2.controllers;

import thjava.thbuoi2.models.SinhVien;
import thjava.thbuoi2.services.SinhVienService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/sinhvien")
@RequiredArgsConstructor
public class SinhVienController {
    private final SinhVienService sinhVienService;

    @GetMapping
    public String showSinhVienList(Model model) {
        model.addAttribute("sinhviens", sinhVienService.getAllSinhVien());
        return "sinhvien/sinhvien-list";
    }

    @GetMapping("/add")
    public String showAddForm(Model model) {
        model.addAttribute("sinhvien", new SinhVien());
        return "sinhvien/add-sinhvien";
    }

    @PostMapping("/add")
    public String addSinhVien(@Valid SinhVien sinhVien, BindingResult result) {
        if (result.hasErrors()) {
            return "sinhvien/add-sinhvien";
        }
        sinhVienService.addSinhVien(sinhVien);
        return "redirect:/sinhvien";
    }

    @GetMapping("/edit/{id}")
    public String showEditForm(@PathVariable Long id, Model model) {
        SinhVien sinhVien = sinhVienService.getSinhVienById(id)
                .orElseThrow(() -> new IllegalArgumentException("ID sinh viên không hợp lệ: " + id));
        model.addAttribute("sinhvien", sinhVien);
        return "sinhvien/update-sinhvien";
    }

    @PostMapping("/update/{id}")
    public String updateSinhVien(@PathVariable Long id, @Valid SinhVien sinhVien, BindingResult result) {
        if (result.hasErrors()) {
            sinhVien.setId(id);
            return "sinhvien/update-sinhvien";
        }
        sinhVienService.updateSinhVien(sinhVien);
        return "redirect:/sinhvien";
    }

    @GetMapping("/delete/{id}")
    public String deleteSinhVien(@PathVariable Long id) {
        sinhVienService.deleteSinhVienById(id);
        return "redirect:/sinhvien";
    }
}
