package com.vet.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;

import java.time.LocalDateTime;
import java.util.Objects;

@Entity
@Table(name = "appointments")
public class Appointment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "appointment_date", nullable = false)
    private LocalDateTime appointmentDate;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "animal_id", nullable = false)
    @JsonIgnore  // İstersen kaldırabilirsin, JSON'da hayvan görünür
    private Animal animal;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "doctor_id", nullable = false)
    @JsonBackReference  // JSON döngü sorunu yaşarsan kaldırabilirsin
    private Doctor doctor;

    public Appointment() {
    }

    public Appointment(LocalDateTime appointmentDate, Animal animal, Doctor doctor) {
        this.appointmentDate = appointmentDate;
        this.animal = animal;
        this.doctor = doctor;
    }

    public Appointment(Long id, LocalDateTime appointmentDate, Animal animal, Doctor doctor) {
        this.id = id;
        this.appointmentDate = appointmentDate;
        this.animal = animal;
        this.doctor = doctor;
    }

    public void assignToAnimal(Animal animal) {
        this.animal = animal;
        if (animal != null && !animal.getAppointments().contains(this)) {
            animal.addAppointment(this);
        }
    }

    public void assignToDoctor(Doctor doctor) {
        this.doctor = doctor;
        // Eğer Doctor entity'sinde appointments listesi varsa burada da ilişki kurulabilir
    }

    // Getter & Setter'lar

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LocalDateTime getAppointmentDate() {
        return appointmentDate;
    }

    public void setAppointmentDate(LocalDateTime appointmentDate) {
        this.appointmentDate = appointmentDate;
    }

    public Animal getAnimal() {
        return animal;
    }

    public void setAnimal(Animal animal) {
        this.animal = animal;
    }

    public Doctor getDoctor() {
        return doctor;
    }

    public void setDoctor(Doctor doctor) {
        this.doctor = doctor;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Appointment that)) return false;
        return Objects.equals(getId(), that.getId());
    }

    @Override
    public int hashCode() {
        return getId() != null ? getId().hashCode() : 0;
    }

    @Override
    public String toString() {
        return "Appointment{" +
                "id=" + id +
                ", appointmentDate=" + appointmentDate +
                '}';
    }
}
