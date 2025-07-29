package com.systemzarzadzaniaapteka.controller;

import com.systemzarzadzaniaapteka.model.Medicine;
import com.systemzarzadzaniaapteka.service.MedicineService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import jakarta.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/medicines")
public class MedicineController {

    @Autowired
    private MedicineService medicineService;

    @GetMapping
    public List<Medicine> getAll() {
        return medicineService.getAll();
    }

    @GetMapping("/{id}")
    public Medicine getById(@PathVariable Long id) {
        return medicineService.getById(id);
    }

    @PostMapping
    public Medicine create(@RequestBody @Valid Medicine medicine) {
        return medicineService.save(medicine);
    }

    @PutMapping("/{id}")
    public Medicine update(@PathVariable Long id, @RequestBody @Valid Medicine medicine) {
        return medicineService.update(id, medicine);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        medicineService.delete(id);
    }
}
