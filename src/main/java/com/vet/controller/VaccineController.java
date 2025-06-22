package com.vet.controller;

import com.vet.dto.VaccineDto;
import com.vet.service.VaccineService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/api/vaccines")
public class VaccineController {

    private final VaccineService vaccineService;

    @Autowired
    public VaccineController(VaccineService vaccineService) {
        this.vaccineService = vaccineService;
    }

    @GetMapping
    public List<VaccineDto> getAllVaccines() {
        return vaccineService.getAll();
    }

    @GetMapping("/{id}")
    public VaccineDto getVaccineById(@PathVariable Long id) {
        return vaccineService.getById(id);
    }

    @PostMapping
    public VaccineDto createVaccine(@RequestBody VaccineDto vaccineDto) {
        return vaccineService.save(vaccineDto);
    }

    @PutMapping("/{id}")
    public VaccineDto updateVaccine(@PathVariable Long id, @RequestBody VaccineDto vaccineDto) {
        return vaccineService.update(id, vaccineDto);
    }

    @DeleteMapping("/{id}")
    public void deleteVaccine(@PathVariable Long id) {
        vaccineService.delete(id);
    }

    @GetMapping("/animal/{animalId}")
    public List<VaccineDto> getVaccinesByAnimalId(@PathVariable Long animalId) {
        return vaccineService.getByAnimalId(animalId);
    }

    @GetMapping("/protection-between")
    public List<VaccineDto> getVaccinesByProtectionFinishDateBetween(
            @RequestParam String startDate,
            @RequestParam String endDate) {

        LocalDate start = LocalDate.parse(startDate);
        LocalDate end = LocalDate.parse(endDate);
        return vaccineService.getByProtectionFinishDateBetween(start, end);
    }
}
