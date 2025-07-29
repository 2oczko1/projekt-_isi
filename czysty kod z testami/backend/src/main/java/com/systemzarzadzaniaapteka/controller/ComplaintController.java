package com.systemzarzadzaniaapteka.controller;

import com.systemzarzadzaniaapteka.model.Complaint;
import com.systemzarzadzaniaapteka.service.ComplaintService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import jakarta.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/complaints")
public class ComplaintController {

    @Autowired
    private ComplaintService complaintService;

    @GetMapping
    public List<Complaint> getAll() {
        return complaintService.getAll();
    }

    @GetMapping("/{id}")
    public Complaint getById(@PathVariable Long id) {
        return complaintService.getById(id);
    }

    @PostMapping
    public Complaint create(@RequestBody @Valid Complaint complaint) {
        return complaintService.save(complaint);
    }

    @PutMapping("/{id}")
    public Complaint resolve(@PathVariable Long id, @RequestBody Complaint complaint) {
        return complaintService.resolve(id, complaint);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        complaintService.delete(id);
    }
}
