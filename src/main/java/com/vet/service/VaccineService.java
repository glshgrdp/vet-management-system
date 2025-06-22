package com.vet.service;

import com.vet.dto.VaccineDto;

import java.time.LocalDate;
import java.util.List;

public interface VaccineService {

    List<VaccineDto> getAll();

    VaccineDto getById(Long id);

    VaccineDto save(VaccineDto vaccineDto);

    VaccineDto update(Long id, VaccineDto updatedVaccineDto);

    void delete(Long id);

    List<VaccineDto> getByAnimalId(Long animalId);

    List<VaccineDto> getByProtectionFinishDateBetween(LocalDate startDate, LocalDate endDate);
}