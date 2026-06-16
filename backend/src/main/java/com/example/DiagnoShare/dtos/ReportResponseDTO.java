package com.example.DiagnoShare.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ReportResponseDTO {
    private Long id;
    private String title;
    private String description;
    private LocalDateTime uploadDate;
    private String filePath;

    private UserResponseDTO patient;
    private UserResponseDTO doctor;
}
