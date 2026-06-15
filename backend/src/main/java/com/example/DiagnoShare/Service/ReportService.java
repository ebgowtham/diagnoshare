package com.example.DiagnoShare.Service;

import com.example.DiagnoShare.Repository.ReportRepository;
import com.example.DiagnoShare.models.Report;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ReportService {
    private final ReportRepository reportRepository;

    public Report saveReport(Report report) {
        return reportRepository.save(report);
    }

    public List<Report> getReportsForPatient(Long patientId) {
        return reportRepository.findByPatientId(patientId);
    }

    public List<Report> getReportsForDoctor(Long doctorId) {
        return reportRepository.findByDoctorId(doctorId);
    }
}
