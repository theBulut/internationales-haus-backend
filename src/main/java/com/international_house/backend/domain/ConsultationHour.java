package com.international_house.backend.domain;

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
    private String type;

    @Column
    private Boolean isCanceled;

    @Column
    private String reason;

    @Column
    private String repeat;

    @Column
    private String room;




    public ConsultationHour(Long startTime, Long endTime, String description, String type, Boolean isCanceled, String reason, String repeat, String room) {
        this.startTime = startTime;
        this.endTime = endTime;
        this.description = description;
        this.type = type;
        this.isCanceled = isCanceled;
        this.repeat = repeat;
        this.reason = reason;
        this.room = room;
    }


}
