package com.international_house.backend.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;



@Entity
@Getter
@Setter
//@ToString(exclude = {"consultationHours", "staffSet",})
@EqualsAndHashCode(of = {"consultingAreaId", "name"})
public class ConsultingArea {

    public static final String PRIMARY_SEQUENCE = "primary_sequence";

    @Id
    @Column(nullable = false, updatable = false)
    @SequenceGenerator(
            name = PRIMARY_SEQUENCE,
            sequenceName = PRIMARY_SEQUENCE,
            allocationSize = 1,
            initialValue = 1000
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = PRIMARY_SEQUENCE
    )
    private Integer consultingAreaId;

    @Column(nullable = false, columnDefinition = "text")
    private String name;


    @OneToMany(mappedBy = "consultingArea", cascade = CascadeType.ALL, orphanRemoval = true)
    @JsonIgnore
    private List<ConsultationHour> consultationHours = new ArrayList<>();

    // Convenience method
    public void addConsultationHour(ConsultationHour consultationHour) {
        consultationHours.add(consultationHour);
        consultationHour.setConsultingArea(this);
    }

    public ConsultingArea(String name) {
        this.name = name;
    }

    public ConsultingArea() {
    }
}
