package com.vet.service;

import com.vet.entity.Appointment;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

public interface AppointmentService {

    List<Appointment> getAllAppointments();

    Optional<Appointment> getAppointmentById(Long id);

    Appointment saveAppointment(Appointment appointment);

    Optional<Appointment> updateAppointment(Long id, Appointment updatedAppointment);

    boolean deleteAppointment(Long id);

    // 🔍 Belirli doktora ve tarih aralığına göre randevu listeleme
    List<Appointment> getAppointmentsByDoctorAndDateRange(Long doctorId, LocalDate startDate, LocalDate endDate);

    // 🔍 Belirli hayvana ve tarih aralığına göre randevu listeleme
    List<Appointment> getAppointmentsByAnimalAndDateRange(Long animalId, LocalDate startDate, LocalDate endDate);
}
