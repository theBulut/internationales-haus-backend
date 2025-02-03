package com.international_house.backend.domain;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

import java.util.UUID;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.UuidGenerator;


@Entity
@Getter
@Setter
public class Employee {

    @Id
    @Column(nullable = false, updatable = false)
    @GeneratedValue
    @UuidGenerator
    private UUID employeeNumber;

    @Column(nullable = false)
    private String employeeName;


    @Column(nullable = false, columnDefinition = "text")
    private String passwordHash;

    public Employee(String employeeName, String passwordHash) {
        this.employeeName = employeeName;
        this.passwordHash = passwordHash;
    }

    public Employee() {
    }

}
