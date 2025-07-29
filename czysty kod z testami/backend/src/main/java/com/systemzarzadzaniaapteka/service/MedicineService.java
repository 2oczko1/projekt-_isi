package com.systemzarzadzaniaapteka.service;

import com.systemzarzadzaniaapteka.model.Medicine;
import com.systemzarzadzaniaapteka.repository.MedicineRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MedicineService {

    private final MedicineRepository medicineRepository;

    @Autowired
    public MedicineService(MedicineRepository medicineRepository) {
        this.medicineRepository = medicineRepository;
    }

    public List<Medicine> getAll() {
        return medicineRepository.findAll();
    }

    public Medicine getById(Long id) {
        return medicineRepository.findById(id).orElse(null);
    }

    public Medicine save(Medicine medicine) {
        return medicineRepository.save(medicine);
    }

    public Medicine update(Long id, Medicine medicineDetails) {
        Medicine medicine = medicineRepository.findById(id).orElse(null);
        if (medicine == null) return null;
        medicine.setName(medicineDetails.getName());
        medicine.setDescription(medicineDetails.getDescription());
        medicine.setPrice(medicineDetails.getPrice());
        medicine.setQuantity(medicineDetails.getQuantity());
        // Dodaj inne pola jesli istnieja w modelu Medicine
        return medicineRepository.save(medicine);
    }

    public void delete(Long id) {
        medicineRepository.deleteById(id);
    }
}
