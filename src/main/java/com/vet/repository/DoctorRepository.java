package com.vet.repository;

import com.vet.entity.Doctor;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface DoctorRepository extends JpaRepository<Doctor, Long> {

    List<Doctor> findByNameContainingIgnoreCase(String name);

    List<Doctor> findByEmailContainingIgnoreCase(String email);
}
