package com.vet.service;

import com.vet.entity.Animal;

import java.util.List;
import java.util.Optional;

public interface AnimalService {

    List<Animal> getAllAnimals();

    Optional<Animal> getAnimalById(Long id);

    Animal getById(Long id); // 🌟 Buraya eklendi

    Animal saveAnimal(Animal animal);

    Optional<Animal> updateAnimal(Long id, Animal updatedAnimal);

    boolean deleteAnimal(Long id);
}
