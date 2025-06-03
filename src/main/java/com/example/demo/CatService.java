package com.example.demo;

import java.io.File;
import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

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

    public Object getCatByName(String name) {
        if(name == null) return null;
        return catRepository.getCatByName(name);
    }

    public Object getCatByDescription(String description) {
        if(description == null) return null;
        return catRepository.getCatByDescription(description);
    }

    public Object getCatByBreed(String breed) {
        return catRepository.getCatByBreed(breed);
    }

    public Cat getCatByAge(int age) {
        return catRepository.findAll().stream()
                .filter(b -> b.getAge() == age)
                .findFirst()
                .orElse(null);
    }

      public Cat addCat(Cat cat) {
        return catRepository.save(cat);
    }

    public Cat updateCat(Long catId, Cat cat) {
        if (!catRepository.existsById(catId)) {
            return null;
        }
        cat.setCatId(catId);
        return catRepository.save(cat);
    }

    public void deleteCat(Long catId) {
        catRepository.deleteById(catId);
    }

    public String writeJson(Cat cat) {
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            objectMapper.writeValue(new File("cats.json"), cat);
            return "Cat written to JSON file successfully";
        } catch (IOException e) {
            return "Error writing cat to JSON file";
        }
    }

    public Cat readJson() {
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            return objectMapper.readValue(new File("cats.json"), Cat.class);
        } catch (IOException e) {
            return null;
        }
    }

}