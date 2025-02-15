package com.international_house.backend.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.international_house.backend.enums.Role;
import jakarta.persistence.*;

import java.util.UUID;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.UuidGenerator;


@Entity
@Getter
@Setter
public class Employee {

    @Id
    @Column(nullable = false, updatable = false)
    @GeneratedValue
    @UuidGenerator
    private UUID id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false, columnDefinition = "text")
    private String password;

    @Column
    @Enumerated(EnumType.STRING)
    private Role role = Role.USER;
}
