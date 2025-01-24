package com.international_house.backend.domain;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import java.util.Set;
import java.util.UUID;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.UuidGenerator;


@Entity
@Getter
@Setter
public class Staff {

    @Id
    @Column(nullable = false, updatable = false)
    @GeneratedValue
    @UuidGenerator
    private UUID staffNumber;

    @Column(nullable = false)
    private String firstName;

    @Column(nullable = false)
    private String lastName;

    @Column(nullable = false, columnDefinition = "text")
    private String passwordHash;

    @OneToMany(mappedBy = "updatedBy")
    private Set<ConsultationLog> meetingLogs;

    @OneToMany(mappedBy = "staffId")
    private Set<StaffLog> staffLogs;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "assigned_consulting_area_id", nullable = false)
    private ConsultingArea assignedConsultingArea;

}
