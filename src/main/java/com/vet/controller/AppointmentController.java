package com.vet.controller;

import com.vet.dto.AppointmentDto;
import com.vet.entity.Animal;
import com.vet.entity.Appointment;
import com.vet.entity.Doctor;
import com.vet.service.AnimalService;
import com.vet.service.AppointmentService;
import com.vet.service.DoctorService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/appointments")
public class AppointmentController {

    private final AppointmentService appointmentService;
    private final AnimalService animalService;
    private final DoctorService doctorService;

    public AppointmentController(AppointmentService appointmentService, AnimalService animalService, DoctorService doctorService) {
        this.appointmentService = appointmentService;
        this.animalService = animalService;
        this.doctorService = doctorService;
    }

    @GetMapping
    public ResponseEntity<List<Appointment>> getAllAppointments() {
        return ResponseEntity.ok(appointmentService.getAllAppointments());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Appointment> getAppointmentById(@PathVariable Long id) {
        return appointmentService.getAppointmentById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<?> createAppointment(@RequestBody AppointmentDto dto) {
        try {
            System.out.println("DTO geldi: " + dto);
            Animal animal = animalService.getById(dto.getAnimalId());
            Doctor doctor = doctorService.getById(dto.getDoctorId());
            Appointment appointment = dto.toEntity(animal, doctor);
            Appointment saved = appointmentService.saveAppointment(appointment);
            return ResponseEntity.status(201).body(saved);
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.badRequest().body("Hata: " + e.getMessage());
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<Appointment> updateAppointment(@PathVariable Long id, @RequestBody Appointment updatedAppointment) {
        return appointmentService.updateAppointment(id, updatedAppointment)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteAppointment(@PathVariable Long id) {
        boolean deleted = appointmentService.deleteAppointment(id);
        return deleted ? ResponseEntity.noContent().build() : ResponseEntity.notFound().build();
    }
}
