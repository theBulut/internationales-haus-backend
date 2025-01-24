package com.international_house.backend.domain;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import java.util.Set;
import java.util.UUID;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.UuidGenerator;


@Entity
@Getter
@Setter
public class Admin {

    @Id
    @Column(nullable = false, updatable = false)
    @GeneratedValue
    @UuidGenerator
    private UUID adminNumber;

    @Column(nullable = false)
    private String firstName;

    @Column(nullable = false)
    private String lastName;

    @Column(nullable = false, columnDefinition = "text")
    private String passwordHash;

    @OneToMany(mappedBy = "createdBy")
    private Set<Room> rooms;

    @OneToMany(mappedBy = "updatedBy")
    private Set<StaffLog> staffLogs;

    @OneToMany(mappedBy = "addedBy")
    private Set<ConsultingArea> consultingAreas;

}
