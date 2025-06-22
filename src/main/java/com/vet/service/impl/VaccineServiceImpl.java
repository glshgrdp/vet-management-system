package com.vet.service.impl;

import com.vet.dto.VaccineDto;
import com.vet.entity.Animal;
import com.vet.entity.Vaccine;
import com.vet.mapper.VaccineMapper;
import com.vet.repository.AnimalRepository;
import com.vet.repository.VaccineRepository;
import com.vet.service.VaccineService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.stream.Collectors;

@Service
public class VaccineServiceImpl implements VaccineService {

    private final VaccineRepository vaccineRepository;
    private final AnimalRepository animalRepository;
    private final VaccineMapper vaccineMapper;

    @Autowired
    public VaccineServiceImpl(VaccineRepository vaccineRepository,
                              AnimalRepository animalRepository,
                              VaccineMapper vaccineMapper) {
        this.vaccineRepository = vaccineRepository;
        this.animalRepository = animalRepository;
        this.vaccineMapper = vaccineMapper;
    }

    @Override
    public List<VaccineDto> getAll() {
        return vaccineRepository.findAll()
                .stream()
                .map(vaccineMapper::toDto)
                .collect(Collectors.toList());
    }

    @Override
    public VaccineDto getById(Long id) {
        Vaccine vaccine = vaccineRepository.findById(id)
                .orElseThrow(() -> new NoSuchElementException("Vaccine not found with id: " + id));
        return vaccineMapper.toDto(vaccine);
    }

    @Override
    public VaccineDto save(VaccineDto vaccineDto) {
        Animal animal = animalRepository.findById(vaccineDto.getAnimalId())
                .orElseThrow(() -> new NoSuchElementException("Animal not found with id: " + vaccineDto.getAnimalId()));
        Vaccine vaccine = vaccineMapper.toEntity(vaccineDto);
        vaccine.setAnimal(animal);
        Vaccine saved = vaccineRepository.save(vaccine);
        return vaccineMapper.toDto(saved);
    }

    @Override
    public VaccineDto update(Long id, VaccineDto updatedDto) {
        Vaccine vaccine = vaccineRepository.findById(id)
                .orElseThrow(() -> new NoSuchElementException("Vaccine not found with id: " + id));

        Animal animal = animalRepository.findById(updatedDto.getAnimalId())
                .orElseThrow(() -> new NoSuchElementException("Animal not found with id: " + updatedDto.getAnimalId()));

        vaccine.setName(updatedDto.getName());
        vaccine.setCode(updatedDto.getCode());
        vaccine.setProtectionStartDate(updatedDto.getProtectionStartDate());
        vaccine.setProtectionFinishDate(updatedDto.getProtectionFinishDate());
        vaccine.setAnimal(animal);

        Vaccine updated = vaccineRepository.save(vaccine);
        return vaccineMapper.toDto(updated);
    }

    @Override
    public void delete(Long id) {
        if (!vaccineRepository.existsById(id)) {
            throw new NoSuchElementException("Vaccine not found with id: " + id);
        }
        vaccineRepository.deleteById(id);
    }

    @Override
    public List<VaccineDto> getByAnimalId(Long animalId) {
        return vaccineRepository.findByAnimalId(animalId)
                .stream()
                .map(vaccineMapper::toDto)
                .collect(Collectors.toList());
    }

    @Override
    public List<VaccineDto> getByProtectionFinishDateBetween(LocalDate startDate, LocalDate endDate) {
        return vaccineRepository.findByProtectionFinishDateBetween(startDate, endDate)
                .stream()
                .map(vaccineMapper::toDto)
                .collect(Collectors.toList());
    }
}
