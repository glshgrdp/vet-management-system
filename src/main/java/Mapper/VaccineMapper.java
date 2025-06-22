package com.vet.mapper;

import com.vet.dto.VaccineDto;
import com.vet.entity.Animal;
import com.vet.entity.Vaccine;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;

@Mapper(componentModel = "spring")
public interface VaccineMapper {

    @Mapping(source = "animal", target = "animalId", qualifiedByName = "animalToId")
    VaccineDto toDto(Vaccine vaccine);

    @Mapping(source = "animalId", target = "animal", qualifiedByName = "idToAnimal")
    Vaccine toEntity(VaccineDto vaccineDto);

    @Named("animalToId")
    static Long mapAnimalToId(Animal animal) {
        return animal != null ? animal.getId() : null;
    }

    @Named("idToAnimal")
    static Animal mapIdToAnimal(Long id) {
        if (id == null) return null;
        Animal animal = new Animal();
        animal.setId(id);
        return animal;
    }
}
