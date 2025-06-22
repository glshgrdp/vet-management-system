package com.vet.service.impl;

import com.vet.entity.Doctor;
import com.vet.repository.DoctorRepository;
import com.vet.service.DoctorService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DoctorServiceImpl implements DoctorService {

    private final DoctorRepository doctorRepository;

    public DoctorServiceImpl(DoctorRepository doctorRepository) {
        this.doctorRepository = doctorRepository;
    }

    @Override
    public Doctor saveDoctor(Doctor doctor) {
        return doctorRepository.save(doctor);
    }

    @Override
    public Optional<Doctor> updateDoctor(Long id, Doctor updatedDoctor) {
        return doctorRepository.findById(id)
                .map(doctor -> {
                    doctor.setName(updatedDoctor.getName());
                    doctor.setPhone(updatedDoctor.getPhone());
                    doctor.setEmail(updatedDoctor.getEmail());
                    doctor.setAddress(updatedDoctor.getAddress());
                    doctor.setCity(updatedDoctor.getCity());
                    return doctorRepository.save(doctor);
                });
    }

    @Override
    public boolean deleteDoctor(Long id) {
        if (doctorRepository.existsById(id)) {
            doctorRepository.deleteById(id);
            return true;
        }
        return false;
    }

    @Override
    public Optional<Doctor> getDoctorById(Long id) {
        return doctorRepository.findById(id);
    }

    @Override
    public Doctor getById(Long id) {
        return doctorRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Doctor bulunamadı: " + id));
    }

    @Override
    public List<Doctor> getAllDoctors() {
        return doctorRepository.findAll();
    }

    @Override
    public List<Doctor> getByName(String name) {
        return doctorRepository.findByNameContainingIgnoreCase(name);
    }

    @Override
    public List<Doctor> getByEmail(String email) {
        return doctorRepository.findByEmailContainingIgnoreCase(email);
    }
}
