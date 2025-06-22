package com.vet.repository;

import com.vet.entity.Appointment;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDateTime;
import java.util.List;

public interface AppointmentRepository extends JpaRepository<Appointment, Long> {

    // 🔹 Girilen tarih ve saatte doktorun başka randevusu var mı?
    boolean existsByDoctorIdAndAppointmentDate(Long doctorId, LocalDateTime appointmentDate);

    // 🔹 Belirli doktora ait, tarih aralığındaki randevuları getir
    List<Appointment> findByDoctorIdAndAppointmentDateBetween(Long doctorId, LocalDateTime start, LocalDateTime end);

    // 🔹 Belirli hayvana ait, tarih aralığındaki randevuları getir
    List<Appointment> findByAnimalIdAndAppointmentDateBetween(Long animalId, LocalDateTime start, LocalDateTime end);
}
