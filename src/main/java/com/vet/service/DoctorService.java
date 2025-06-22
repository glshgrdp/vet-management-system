package com.vet.service;

import com.vet.entity.Doctor;
import java.util.List;
import java.util.Optional;

public interface DoctorService {

    Doctor saveDoctor(Doctor doctor);

    Optional<Doctor> updateDoctor(Long id, Doctor updatedDoctor);

    boolean deleteDoctor(Long id);

    Optional<Doctor> getDoctorById(Long id);

    Doctor getById(Long id);

    List<Doctor> getAllDoctors();

    List<Doctor> getByName(String name);

    List<Doctor> getByEmail(String email);
}
