package com.vet.controller;

import com.vet.entity.AvailableDate;
import com.vet.service.AvailableDateService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/available-dates")
public class AvailableDateController {

    private final AvailableDateService availableDateService;

    public AvailableDateController(AvailableDateService availableDateService) {
        this.availableDateService = availableDateService;
    }

    @GetMapping
    public ResponseEntity<List<AvailableDate>> getAll() {
        return ResponseEntity.ok(availableDateService.getAllAvailableDates());
    }

    @GetMapping("/{id}")
    public ResponseEntity<AvailableDate> getById(@PathVariable Long id) {
        return ResponseEntity.ok(availableDateService.getAvailableDateById(id));
    }

    @PostMapping
    public ResponseEntity<AvailableDate> create(@RequestBody AvailableDate availableDate) {
        return ResponseEntity.ok(availableDateService.saveAvailableDate(availableDate));
    }

    @PutMapping("/{id}")
    public ResponseEntity<AvailableDate> update(@PathVariable Long id, @RequestBody AvailableDate updated) {
        return ResponseEntity.ok(availableDateService.updateAvailableDate(id, updated));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        availableDateService.deleteAvailableDate(id);
        return ResponseEntity.ok().build();
    }
}
