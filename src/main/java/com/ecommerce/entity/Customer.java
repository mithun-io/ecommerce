package com.ecommerce.entity;

import com.ecommerce.enums.Gender;
import com.ecommerce.enums.UserRole;
import com.ecommerce.enums.UserStatus;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Data
@Entity
@Builder
@Table(name = "customers")
@AllArgsConstructor
@NoArgsConstructor
public class Customer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String customerName;

    @Column(nullable = false, unique = true)
    private String email;

    @Column(nullable = false, unique = true)
    private String mobile;

    @Column(nullable = false)
    private String password;

    @Enumerated(EnumType.STRING)
    private Gender gender;

    @Column(nullable = false)
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate dateOfBirth;

    @Column(nullable = false)
    private String address;

    @Enumerated(EnumType.STRING)
    private UserRole customerRole;

    @Enumerated(EnumType.STRING)
    private UserStatus customerStatus;

    @Column(nullable = false)
    private LocalDateTime createdAt;

    @OneToOne
    private User user;
}
