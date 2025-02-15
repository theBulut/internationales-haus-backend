package com.international_house.backend.entity;

import jakarta.persistence.*;

import java.util.UUID;

import lombok.*;

import org.hibernate.annotations.UuidGenerator;


@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
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
    // @JoinColumn(name = "id") // join with Type Entity
    private UUID department;

    @Column
    private Boolean isCanceled;

    @Column
    private String reason;

    @Column
    private String repeat;

    @Column
    private String room;
}
