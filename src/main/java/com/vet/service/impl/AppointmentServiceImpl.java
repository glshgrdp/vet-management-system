package com.vet.service.impl;

import com.vet.entity.Appointment;
import com.vet.repository.AppointmentRepository;
import com.vet.repository.AvailableDateRepository;
import com.vet.service.AppointmentService;
import com.vet.exception.DoctorNotAvailableException;
import com.vet.exception.AppointmentConflictException;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class AppointmentServiceImpl implements AppointmentService {

    private final AppointmentRepository appointmentRepository;
    private final AvailableDateRepository availableDateRepository;

    public AppointmentServiceImpl(AppointmentRepository appointmentRepository,
                                  AvailableDateRepository availableDateRepository) {
        this.appointmentRepository = appointmentRepository;
        this.availableDateRepository = availableDateRepository;
    }

    @Override
    public List<Appointment> getAllAppointments() {
        return appointmentRepository.findAll();
    }

    @Override
    public Optional<Appointment> getAppointmentById(Long id) {
        return appointmentRepository.findById(id);
    }

    @Override
    public Appointment saveAppointment(Appointment appointment) {
        Long doctorId = appointment.getDoctor().getId();
        LocalDate appointmentDay = appointment.getAppointmentDate().toLocalDate();
        LocalDateTime appointmentDateTime = appointment.getAppointmentDate();

        // ✅ 1. Doktor o gün müsait mi?
        boolean isAvailable = availableDateRepository.existsByDoctorIdAndAvailableDate(doctorId, appointmentDay);
        if (!isAvailable) {
            throw new DoctorNotAvailableException("Doktor bu tarihte çalışmamaktadır.");
        }

        // ✅ 2. Aynı tarih ve saatte başka randevu var mı?
        boolean hasConflict = appointmentRepository.existsByDoctorIdAndAppointmentDate(doctorId, appointmentDateTime);
        if (hasConflict) {
            throw new AppointmentConflictException("Girilen saatte başka bir randevu mevcuttur.");
        }

        // ✅ 3. Her şey uygunsa kayıt et
        return appointmentRepository.save(appointment);
    }

    @Override
    public Optional<Appointment> updateAppointment(Long id, Appointment updatedAppointment) {
        return appointmentRepository.findById(id)
                .map(existingAppointment -> {
                    existingAppointment.setAppointmentDate(updatedAppointment.getAppointmentDate());
                    existingAppointment.setAnimal(updatedAppointment.getAnimal());
                    existingAppointment.setDoctor(updatedAppointment.getDoctor());
                    return appointmentRepository.save(existingAppointment);
                });
    }

    @Override
    public boolean deleteAppointment(Long id) {
        if (appointmentRepository.existsById(id)) {
            appointmentRepository.deleteById(id);
            return true;
        }
        return false;
    }

    @Override
    public List<Appointment> getAppointmentsByDoctorAndDateRange(Long doctorId, LocalDate startDate, LocalDate endDate) {
        return appointmentRepository.findByDoctorIdAndAppointmentDateBetween(doctorId, startDate.atStartOfDay(), endDate.atTime(23, 59, 59));
    }

    @Override
    public List<Appointment> getAppointmentsByAnimalAndDateRange(Long animalId, LocalDate startDate, LocalDate endDate) {
        return appointmentRepository.findByAnimalIdAndAppointmentDateBetween(animalId, startDate.atStartOfDay(), endDate.atTime(23, 59, 59));
    }
}
