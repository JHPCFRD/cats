package com.example.demo;

import io.micrometer.common.lang.NonNull;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "cats") 
public class Cat {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long catId;

    @NonNull
    @Column(nullable = false)
    private String name;

    @NonNull
    @Column(nullable = false)
    private String description;

    private String breed;
    private int age;

    public Cat() {
    }

    public Cat(Long catId, String name, String description, String breed, int age) {
        this.catId = catId;
        this.name = name;
        this.description = description;
        this.breed = breed;
        this.age = age;
    }

    public Cat(String name, String description, String breed, int age) {
        this.name = name;
        this.description = description;
        this.breed = breed;
        this.age = age;
    }

    public Long getCatId() {
        return catId;
    }

    public void setCatId(Long id) {
        this.catId = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getBreed() {
        return breed;
    }

    public void setBreed(String breed) {
        this.breed = breed;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}