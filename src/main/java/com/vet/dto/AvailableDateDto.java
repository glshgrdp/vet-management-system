package com.vet.dto;

import java.time.LocalDate;
import java.time.LocalTime;

public class AvailableDateDto {
    private Long id;
    private LocalDate availableDate;
    private LocalTime startTime;
    private LocalTime endTime;
    private Long doctorId;

    // Getters
    public Long getId() {
        return id;
    }

    public LocalDate getAvailableDate() {
        return availableDate;
    }

    public LocalTime getStartTime() {
        return startTime;
    }

    public LocalTime getEndTime() {
        return endTime;
    }

    public Long getDoctorId() {
        return doctorId;
    }

    // Setters
    public void setId(Long id) {
        this.id = id;
    }

    public void setAvailableDate(LocalDate availableDate) {
        this.availableDate = availableDate;
    }

    public void setStartTime(LocalTime startTime) {
        this.startTime = startTime;
    }

    public void setEndTime(LocalTime endTime) {
        this.endTime = endTime;
    }

    public void setDoctorId(Long doctorId) {
        this.doctorId = doctorId;
    }
}
