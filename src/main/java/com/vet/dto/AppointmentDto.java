package com.vet.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.vet.entity.Animal;
import com.vet.entity.Appointment;
import com.vet.entity.Doctor;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

public class AppointmentDto {

    private Long id;

    @JsonFormat(pattern = "yyyy-MM-dd")
    private LocalDate appointmentDate;

    @JsonFormat(pattern = "HH:mm:ss")
    private LocalTime appointmentTime;

    private Long doctorId;
    private Long animalId;

    public AppointmentDto() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LocalDate getAppointmentDate() {
        return appointmentDate;
    }

    public void setAppointmentDate(LocalDate appointmentDate) {
        this.appointmentDate = appointmentDate;
    }

    public LocalTime getAppointmentTime() {
        return appointmentTime;
    }

    public void setAppointmentTime(LocalTime appointmentTime) {
        this.appointmentTime = appointmentTime;
    }

    public Long getDoctorId() {
        return doctorId;
    }

    public void setDoctorId(Long doctorId) {
        this.doctorId = doctorId;
    }

    public Long getAnimalId() {
        return animalId;
    }

    public void setAnimalId(Long animalId) {
        this.animalId = animalId;
    }

    public Appointment toEntity(Animal animal, Doctor doctor) {
        LocalDateTime dateTime = LocalDateTime.of(appointmentDate, appointmentTime);
        Appointment appointment = new Appointment();
        appointment.setId(this.id);
        appointment.setAppointmentDate(dateTime);
        appointment.setAnimal(animal);
        appointment.setDoctor(doctor);
        return appointment;
    }

    public static AppointmentDto fromEntity(Appointment appointment) {
        AppointmentDto dto = new AppointmentDto();
        dto.setId(appointment.getId());
        LocalDateTime dateTime = appointment.getAppointmentDate();
        dto.setAppointmentDate(dateTime.toLocalDate());
        dto.setAppointmentTime(dateTime.toLocalTime());
        dto.setAnimalId(appointment.getAnimal() != null ? appointment.getAnimal().getId() : null);
        dto.setDoctorId(appointment.getDoctor() != null ? appointment.getDoctor().getId() : null);
        return dto;
    }
}
