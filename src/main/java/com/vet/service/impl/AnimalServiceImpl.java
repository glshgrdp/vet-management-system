package com.vet.service.impl;

import com.vet.entity.Animal;
import com.vet.repository.AnimalRepository;
import com.vet.service.AnimalService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AnimalServiceImpl implements AnimalService {

    private final AnimalRepository animalRepository;

    public AnimalServiceImpl(AnimalRepository animalRepository) {
        this.animalRepository = animalRepository;
    }

    @Override
    public List<Animal> getAllAnimals() {
        return animalRepository.findAll();
    }

    @Override
    public Optional<Animal> getAnimalById(Long id) {
        return animalRepository.findById(id);
    }

    @Override
    public Animal getById(Long id) {
        return animalRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Animal bulunamadı: " + id));
    }

    @Override
    public Animal saveAnimal(Animal animal) {
        return animalRepository.save(animal);
    }

    @Override
    public Optional<Animal> updateAnimal(Long id, Animal updatedAnimal) {
        return animalRepository.findById(id).map(existing -> {
            existing.setName(updatedAnimal.getName());
            existing.setSpecies(updatedAnimal.getSpecies());
            existing.setBreed(updatedAnimal.getBreed());
            existing.setGender(updatedAnimal.getGender());
            existing.setColour(updatedAnimal.getColour());
            existing.setDateOfBirth(updatedAnimal.getDateOfBirth());
            return animalRepository.save(existing);
        });
    }

    @Override
    public boolean deleteAnimal(Long id) {
        if (animalRepository.existsById(id)) {
            animalRepository.deleteById(id);
            return true;
        }
        return false;
    }
}
