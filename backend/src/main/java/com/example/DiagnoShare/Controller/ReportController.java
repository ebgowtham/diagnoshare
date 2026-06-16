package com.example.DiagnoShare.Controller;

import com.example.DiagnoShare.Service.ReportService;
import com.example.DiagnoShare.dtos.ReportResponseDTO;
import com.example.DiagnoShare.models.Report;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/reports")
@RequiredArgsConstructor
public class ReportController {
    private final ReportService reportService;

    @PostMapping("/add")
    public Report addReport(@RequestBody Report report) {
        return reportService.saveReport(report);
    }

    @GetMapping("/patient/{patientId}")
    public List<ReportResponseDTO> getReportsForPatient(@PathVariable Long patientId) {
        return reportService.getReportsForPatient(patientId);
    }

    @GetMapping("/doctor/{doctorId}")
    public List<ReportResponseDTO> getReportsForDoctor(@PathVariable Long doctorId) {
        return reportService.getReportsForDoctor(doctorId);
    }
}
