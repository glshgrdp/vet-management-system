package com.vet.service.impl;

import com.vet.entity.AvailableDate;
import com.vet.exception.NotFoundException;
import com.vet.repository.AvailableDateRepository;
import com.vet.service.AvailableDateService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AvailableDateServiceImpl implements AvailableDateService {

    private final AvailableDateRepository availableDateRepository;

    public AvailableDateServiceImpl(AvailableDateRepository availableDateRepository) {
        this.availableDateRepository = availableDateRepository;
    }

    @Override
    public List<AvailableDate> getAllAvailableDates() {
        return availableDateRepository.findAll();
    }

    @Override
    public AvailableDate getAvailableDateById(Long id) {
        return availableDateRepository.findById(id)
                .orElseThrow(() -> new NotFoundException(id + " id'li uygun tarih bulunamadı."));
    }

    @Override
    public AvailableDate saveAvailableDate(AvailableDate availableDate) {
        return availableDateRepository.save(availableDate);
    }

    @Override
    public AvailableDate updateAvailableDate(Long id, AvailableDate updatedAvailableDate) {
        AvailableDate existing = availableDateRepository.findById(id)
                .orElseThrow(() -> new NotFoundException(id + " id'li uygun tarih bulunamadı."));

        existing.setAvailableDate(updatedAvailableDate.getAvailableDate());
        existing.setDoctor(updatedAvailableDate.getDoctor());

        return availableDateRepository.save(existing);
    }

    @Override
    public void deleteAvailableDate(Long id) {
        if (!availableDateRepository.existsById(id)) {
            throw new NotFoundException(id + " id'li uygun tarih bulunamadı.");
        }
        availableDateRepository.deleteById(id);
    }

    @Override
    public List<AvailableDate> getByDoctorId(Long doctorId) {
        return availableDateRepository.findByDoctorId(doctorId);
    }
}
