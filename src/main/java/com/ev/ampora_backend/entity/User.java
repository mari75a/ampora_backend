package com.ev.ampora_backend.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter @Setter
@NoArgsConstructor @AllArgsConstructor @Builder
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String userId;

    private String fullName;

    @Column(unique = true)
    private String email;

    private String password;

    private String phone;

    @Enumerated(EnumType.STRING)
    private Role role;

    // One user → One vehicle
    @OneToOne(mappedBy = "user", cascade = CascadeType.ALL)
    private Vehicle vehicle;

    // Subscription
    @OneToOne(mappedBy = "user", cascade = CascadeType.ALL)
    private Subscription subscription;

    @OneToOne(mappedBy = "user", cascade = CascadeType.ALL)
    private RFIDCard rfidCard;
}
