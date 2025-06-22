package com.vet.repository;

import com.vet.entity.AvailableDate;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface AvailableDateRepository extends JpaRepository<AvailableDate, Long> {

    // 🔹 Bir doktorun tüm müsait günlerini getirir
    List<AvailableDate> findByDoctorId(Long doctorId);

    // 🔹 Belirli bir doktorun belirli bir günde çalışıp çalışmadığını kontrol eder
    boolean existsByDoctorIdAndAvailableDate(Long doctorId, LocalDate date);
}
