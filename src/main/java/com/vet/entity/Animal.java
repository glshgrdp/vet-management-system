package com.vet.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "animals")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString(onlyExplicitlyIncluded = true)
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class Animal {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @EqualsAndHashCode.Include
    @ToString.Include
    private Long id;

    @Column(nullable = false)
    @ToString.Include
    private String name;

    @Column(nullable = false)
    private String species;

    @Column(nullable = false)
    private String breed;

    @Column(nullable = false)
    private String gender;

    @Column(nullable = false)
    private String colour;

    private LocalDate dateOfBirth;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "customer_id", nullable = false)
    @JsonBackReference
    private Customer customer;

    @OneToMany(mappedBy = "animal", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.LAZY)
    @JsonManagedReference
    @Builder.Default
    private Set<Vaccine> vaccines = new HashSet<>();

    @OneToMany(mappedBy = "animal", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.LAZY)
    @JsonManagedReference
    @Builder.Default
    private Set<Appointment> appointments = new HashSet<>();

    public void addVaccine(Vaccine vaccine) {
        if (vaccine != null && !vaccines.contains(vaccine)) {
            vaccines.add(vaccine);
            vaccine.setAnimal(this);
        }
    }

    public void removeVaccine(Vaccine vaccine) {
        if (vaccine != null && vaccines.contains(vaccine)) {
            vaccines.remove(vaccine);
            vaccine.setAnimal(null);
        }
    }

    public void addAppointment(Appointment appointment) {
        if (appointment != null && !appointments.contains(appointment)) {
            appointments.add(appointment);
            appointment.setAnimal(this);
        }
    }

    public void removeAppointment(Appointment appointment) {
        if (appointment != null && appointments.contains(appointment)) {
            appointments.remove(appointment);
            appointment.setAnimal(null);
        }
    }
}
