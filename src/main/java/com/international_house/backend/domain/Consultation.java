package com.international_house.backend.domain;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import java.time.LocalDateTime;
import java.util.Set;
import java.util.UUID;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.UuidGenerator;


@Entity
@Getter
@Setter
public class Consultation {

    @Id
    @Column(nullable = false, updatable = false)
    @GeneratedValue
    @UuidGenerator
    private UUID consultationNumber;

    @Column(nullable = false)
    private LocalDateTime startTime;

    @Column(nullable = false)
    private LocalDateTime endTime;

    @OneToOne(
            mappedBy = "consultationId",
            fetch = FetchType.LAZY
    )
    private Queue queue;

    @OneToMany(mappedBy = "consultationId")
    private Set<ConsultationLog> consultationLog;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "assigned_room_id", nullable = false)
    private Room assignedRoom;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "consulting_area_id", nullable = false)
    private ConsultingArea consultingArea;

}
