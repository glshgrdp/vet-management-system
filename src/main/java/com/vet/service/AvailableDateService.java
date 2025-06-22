package com.vet.service;

import com.vet.entity.AvailableDate;
import java.util.List;

public interface AvailableDateService {
    List<AvailableDate> getAllAvailableDates();
    AvailableDate getAvailableDateById(Long id);
    AvailableDate saveAvailableDate(AvailableDate availableDate);
    AvailableDate updateAvailableDate(Long id, AvailableDate availableDate);
    void deleteAvailableDate(Long id);
    List<AvailableDate> getByDoctorId(Long doctorId);
}
