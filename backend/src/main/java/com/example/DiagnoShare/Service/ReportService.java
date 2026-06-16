package com.example.DiagnoShare.Service;

import com.example.DiagnoShare.Repository.ReportRepository;
import com.example.DiagnoShare.dtos.ReportResponseDTO;
import com.example.DiagnoShare.dtos.UserResponseDTO;
import com.example.DiagnoShare.models.Report;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ReportService {
    private final ReportRepository reportRepository;

    public Report saveReport(Report report) {
        return reportRepository.save(report);
    }

    public List<ReportResponseDTO> getReportsForPatient(Long patientId) {
        List<Report> reports = reportRepository.findByPatientId(patientId);

        return reports.stream().map(this::convertToDTO).toList();
    }

    public List<ReportResponseDTO> getReportsForDoctor(Long doctorId) {
        List<Report> reports = reportRepository.findByDoctorId(doctorId);
        return reports.stream().map(this::convertToDTO).toList();
    }

    private ReportResponseDTO convertToDTO(Report report) {
        UserResponseDTO patientDTO = new UserResponseDTO(
                report.getPatient().getId(),
                report.getPatient().getName(),
                report.getPatient().getEmail(),
                report.getPatient().getRole()
        );
        UserResponseDTO doctorDTO = null;
        if(report.getDoctor() != null) {
                    doctorDTO = new UserResponseDTO(
                    report.getDoctor().getId(),
                    report.getDoctor().getEmail(),
                    report.getDoctor().getName(),
                    report.getDoctor().getRole()
            );
        }
            return new ReportResponseDTO(
                    report.getId(),
                    report.getTitle(),
                    report.getDescription(),
                    report.getUploadDate(),
                    report.getFilePath(),
                    patientDTO,
                    doctorDTO
            );

    }
}
