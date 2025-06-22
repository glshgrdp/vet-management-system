package com.vet.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.Objects;

@Entity
@Table(name = "vaccines")
public class Vaccine {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false, unique = true)
    private String code;

    @Column(name = "protection_start_date", nullable = false)
    private LocalDate protectionStartDate;

    @Column(name = "protection_finish_date", nullable = false)
    private LocalDate protectionFinishDate;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "animal_id", nullable = false)
    @JsonIgnore
    private Animal animal;

    public Vaccine() {
    }

    public Vaccine(String name, String code, LocalDate protectionStartDate, LocalDate protectionFinishDate, Animal animal) {
        this.name = name;
        this.code = code;
        this.protectionStartDate = protectionStartDate;
        this.protectionFinishDate = protectionFinishDate;
        this.animal = animal;
    }

    public Vaccine(Long id, String name, String code, LocalDate protectionStartDate, LocalDate protectionFinishDate, Animal animal) {
        this.id = id;
        this.name = name;
        this.code = code;
        this.protectionStartDate = protectionStartDate;
        this.protectionFinishDate = protectionFinishDate;
        this.animal = animal;
    }

    public void assignToAnimal(Animal animal) {
        this.animal = animal;
        if (animal != null && !animal.getVaccines().contains(this)) {
            animal.addVaccine(this);
        }
    }

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public String getCode() { return code; }
    public void setCode(String code) { this.code = code; }

    public LocalDate getProtectionStartDate() { return protectionStartDate; }
    public void setProtectionStartDate(LocalDate protectionStartDate) { this.protectionStartDate = protectionStartDate; }

    public LocalDate getProtectionFinishDate() { return protectionFinishDate; }
    public void setProtectionFinishDate(LocalDate protectionFinishDate) { this.protectionFinishDate = protectionFinishDate; }

    public Animal getAnimal() { return animal; }
    public void setAnimal(Animal animal) { this.animal = animal; }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Vaccine vaccine)) return false;
        return Objects.equals(getId(), vaccine.getId());
    }

    @Override
    public int hashCode() {
        return getId() != null ? getId().hashCode() : 0;
    }

    @Override
    public String toString() {
        return "Vaccine{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", code='" + code + '\'' +
                ", protectionStartDate=" + protectionStartDate +
                ", protectionFinishDate=" + protectionFinishDate +
                '}';
    }
}
