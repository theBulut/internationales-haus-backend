package com.international_house.backend.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;


import java.util.UUID;

import lombok.*;
import org.hibernate.annotations.UuidGenerator;


@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Visitor {

    @Id
    @GeneratedValue
    @UuidGenerator
    @Column(nullable = false, updatable = false, unique = true)
    private UUID id; // Unique identifier for Visitor

    @Column
    private Boolean beingCalled;

    @Column
    private Long timeStamp;

    @Column
    private String consultationHour;
}
