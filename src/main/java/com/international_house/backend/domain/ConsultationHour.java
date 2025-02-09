package com.international_house.backend.domain;

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
public class ConsultationHour {

    @Id
    @GeneratedValue
    @UuidGenerator
    @Column(nullable = false, updatable = false, unique = true)
    private UUID id;

    @Column
    private Long startTime;

    @Column
    private Long endTime;

    @Column
    private String description;

    @Column
    private String type;

    @Column
    private Boolean isCanceled = false;

    @Column
    private String reason;

    @Column
    private String repeat;

    @Column
    private String room;
}
