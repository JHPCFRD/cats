package com.example.demo;

import java.io.File;
import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import java.util.Collections;

import com.fasterxml.jackson.databind.ObjectMapper;

@Service
public class CatService {

    @Autowired
    private CatRepository catRepository;

    public Object getAllCats() {
        return catRepository.findAll();
}

    public Cat getCatById(@PathVariable Long catId) {
        return catRepository.findById(catId).orElse(null);
    }

    public Object getCatByBreed(String breed) {
        if(breed == null || breed.isEmpty()) {
            return Collections.emptyList();
        }
        return catRepository.getCatByBreed(breed);
    }

    public Object getCatByName(String name) {
        if (name == null || name.isEmpty()) {
            return Collections.emptyList();
        }
        return catRepository.getCatByDescription(name);
    }
    
    public Object getCatByDescription(String description) {
        if (description == null || description.isEmpty()) {
            return Collections.emptyList();
        }
        return catRepository.getCatByDescription(description);
    }

    public Object getCatByAge(int age) {
        return catRepository.findAll().stream().filter(b -> b.getAge() == age).toList();
    }

    public Cat addCat(Cat cat) {
        return catRepository.save(cat);
    }

    public Cat updateCat(Long catId, Cat cat) {
        return catRepository.save(cat);
    }

    public void deleteCat(Long catId) {
        catRepository.deleteById(catId);
    }
}