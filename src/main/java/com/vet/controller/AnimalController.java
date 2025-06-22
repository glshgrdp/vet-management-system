package com.vet.controller;

import com.vet.dto.AnimalDto;
import com.vet.entity.Animal;
import com.vet.entity.Customer;
import com.vet.service.AnimalService;
import com.vet.service.CustomerService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/animals")
public class AnimalController {

    private final AnimalService animalService;
    private final CustomerService customerService;

    public AnimalController(AnimalService animalService, CustomerService customerService) {
        this.animalService = animalService;
        this.customerService = customerService;
    }

    @GetMapping
    public ResponseEntity<List<Animal>> getAllAnimals() {
        return ResponseEntity.ok(animalService.getAllAnimals());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Animal> getAnimalById(@PathVariable Long id) {
        return animalService.getAnimalById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<Animal> createAnimal(@RequestBody AnimalDto animalDto) {
        return customerService.getCustomerById(animalDto.getCustomerId())
                .map(customer -> {
                    Animal animal = Animal.builder()
                            .name(animalDto.getName())
                            .species(animalDto.getSpecies())
                            .breed(animalDto.getBreed())
                            .gender(animalDto.getGender()) // eğer DTO'da yoksa ekle!
                            .colour(animalDto.getColour()) // eğer DTO'da yoksa ekle!
                            .dateOfBirth(animalDto.getBirthDate())
                            .customer(customer)
                            .build();
                    return ResponseEntity.ok(animalService.saveAnimal(animal));
                })
                .orElse(ResponseEntity.badRequest().build());
    }

    @PutMapping("/{id}")
    public ResponseEntity<Animal> updateAnimal(@PathVariable Long id, @RequestBody AnimalDto animalDto) {
        return customerService.getCustomerById(animalDto.getCustomerId())
                .map(customer -> {
                    Animal updatedAnimal = Animal.builder()
                            .id(id)
                            .name(animalDto.getName())
                            .species(animalDto.getSpecies())
                            .breed(animalDto.getBreed())
                            .gender(animalDto.getGender())
                            .colour(animalDto.getColour())
                            .dateOfBirth(animalDto.getBirthDate())
                            .customer(customer)
                            .build();
                    return animalService.updateAnimal(id, updatedAnimal)
                            .map(ResponseEntity::ok)
                            .orElse(ResponseEntity.notFound().build());
                })
                .orElse(ResponseEntity.badRequest().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteAnimal(@PathVariable Long id) {
        if (animalService.deleteAnimal(id)) {
            return ResponseEntity.ok().build();
        }
        return ResponseEntity.notFound().build();
    }
}
