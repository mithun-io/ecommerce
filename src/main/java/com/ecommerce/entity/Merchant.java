package com.ecommerce.entity;

import com.ecommerce.enums.UserStatus;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@Entity
@Builder
@Table(name = "customers")
@AllArgsConstructor
@NoArgsConstructor
public class Merchant {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String businessName;

    @Column(nullable = false)
    private String ownerName;

    @Column(nullable = false, unique = true)
    private String businessEmail;

    @Column(nullable = false, unique = true)
    private String businessMobile;

    @Column(nullable = false)
    private String businessAddress;

    private String gstNumber;

    private String panNumber;

    private String businessLicense;

    @Enumerated(EnumType.STRING)
    private UserStatus merchantStatus;

    @Column(nullable = false)
    private LocalDateTime createdAt;

    @OneToOne
    private User user;
}