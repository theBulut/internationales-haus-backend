package com.international_house.backend.domain;

import java.util.HexFormat;

import jakarta.persistence.*;
import lombok.*;


@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Consultation {

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

    @Column
    private String description;

    @Column
    private String shortVersion;

    @Column
    private HexFormat color;
}
