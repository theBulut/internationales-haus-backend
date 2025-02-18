package com.international_house.backend.entity;

import jakarta.persistence.*;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.UuidGenerator;

import java.util.UUID;


@Entity
@Getter
@Setter
public class Department {
    @Id
    @GeneratedValue
    @UuidGenerator
    @Column(nullable = false, updatable = false, unique = true)
    private UUID id;

    @Column(nullable = false, unique = true)
    private String name;

    @Column()
    private String description;

    @Column(nullable = false, unique = true)
    private String abbreviation;
}
