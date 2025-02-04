package com.international_house.backend.domain;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;

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
public class ConsultationHour {

    @Id
    @GeneratedValue
    @UuidGenerator
    @Column(nullable = false, updatable = false, unique = true)

    private UUID consultationNumber;

    @Column(nullable = false)
    private LocalDateTime startTime;

    @Column(nullable = false)
    private LocalDateTime endTime;

    @Column
    private String explanation;


    public ConsultationHour(LocalDateTime startTime, LocalDateTime endTime, String explanation, ConsultingArea consultingArea) {
        this.startTime = startTime;
        this.endTime = endTime;
        this.explanation = explanation;
    }


}
