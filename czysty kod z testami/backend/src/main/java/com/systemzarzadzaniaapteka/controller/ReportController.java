package com.systemzarzadzaniaapteka.controller;

import com.systemzarzadzaniaapteka.model.Report;
import com.systemzarzadzaniaapteka.model.ReportRequest;
import com.systemzarzadzaniaapteka.service.ReportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/reports")
public class ReportController {

    @Autowired
    private ReportService reportService;

    @GetMapping
    public List<Report> getAllReports() {
        return reportService.getAll();
    }

    @GetMapping("/{id}")
    public Report getById(@PathVariable Long id) {
        return reportService.getById(id);
    }

    @PostMapping
    public Report generate(@RequestBody ReportRequest request) {
        return reportService.generate(request);
    }
}
