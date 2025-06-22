package com.vet.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "customers")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString(onlyExplicitlyIncluded = true)
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class Customer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @EqualsAndHashCode.Include
    @ToString.Include
    private Long id;

    @Column(nullable = false)
    @ToString.Include
    private String name;

    @Column(nullable = false)
    @ToString.Include
    private String phone;

    @Column(nullable = false)
    @ToString.Include
    private String email;

    @Column(nullable = false)
    private String address;

    @Column(nullable = false)  // city alanı eklendi
    @ToString.Include
    private String city;

    // Hayvan listesi (bir müşteri birden fazla hayvana sahip olabilir)
    @OneToMany(mappedBy = "customer", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.LAZY)
    @JsonIgnore // Burada ekledik, JSON dönüşümünde bu alan gözardı edilir
    @Builder.Default
    private List<Animal> animals = new ArrayList<>();
}
