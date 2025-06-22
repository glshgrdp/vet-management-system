package com.vet.dto;

import java.time.LocalDate;

public class AnimalDto {
    private Long id;
    private String name;
    private String species;
    private String breed;
    private String gender;
    private String colour;
    private LocalDate birthDate;
    private Long customerId;

    // Getters
    public Long getId() { return id; }
    public String getName() { return name; }
    public String getSpecies() { return species; }
    public String getBreed() { return breed; }
    public String getGender() { return gender; }
    public String getColour() { return colour; }
    public LocalDate getBirthDate() { return birthDate; }
    public Long getCustomerId() { return customerId; }

    // Setters
    public void setId(Long id) { this.id = id; }
    public void setName(String name) { this.name = name; }
    public void setSpecies(String species) { this.species = species; }
    public void setBreed(String breed) { this.breed = breed; }
    public void setGender(String gender) { this.gender = gender; }
    public void setColour(String colour) { this.colour = colour; }
    public void setBirthDate(LocalDate birthDate) { this.birthDate = birthDate; }
    public void setCustomerId(Long customerId) { this.customerId = customerId; }
}
