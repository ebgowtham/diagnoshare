package com.example.DiagnoShare.Repository;

import com.example.DiagnoShare.models.Report;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ReportRepository extends JpaRepository<Report,Long> {
    List<Report> findByPatiendId(Long patientId);
    List<Report> findByDoctorId(Long doctorId);
}
