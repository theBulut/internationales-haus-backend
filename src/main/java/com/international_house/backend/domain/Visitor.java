package com.international_house.backend.domain;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

import java.time.LocalDateTime;
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

    @Column(nullable =false)
    private boolean isBeingCalled = false;

    @Column
    private Long timeStamp;

    @Column
    private String consultationHour;

    public Visitor(boolean isBeingCalled, Long timeStamp, String consultationHour) {
        this.isBeingCalled = isBeingCalled;
        this.timeStamp = timeStamp;
        this.consultationHour = consultationHour;
    }


}
