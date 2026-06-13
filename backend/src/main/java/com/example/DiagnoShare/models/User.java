package com.example.DiagnoShare.models;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import lombok.Data;

@Entity
@Table(name="users")
@Data
public class User {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private Long id;
    private String name;
    private String number;
    @Email
    @Column(unique = true)
    private String email;
    private String password;
    private String role;
}
