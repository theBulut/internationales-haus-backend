package com.international_house.backend.domain;

import jakarta.persistence.*;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;


@Entity
@Getter
@Setter
//@ToString(exclude = {"consultationHours", "staffSet",})
@EqualsAndHashCode(of = {"consultingAreaId", "name"})
public class Type {

    public static final String PRIMARY_SEQUENCE = "primary_sequence";

    @Id
    @Column(nullable = false, updatable = false)
    @SequenceGenerator(
            name = PRIMARY_SEQUENCE,
            sequenceName = PRIMARY_SEQUENCE,
            allocationSize = 1,
            initialValue = 100
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = PRIMARY_SEQUENCE
    )
    private Integer id;

    @Column(nullable = false, columnDefinition = "text")
    private String name;


    public Type(String name) {
        this.name = name;
    }

    public Type() {
    }
}
