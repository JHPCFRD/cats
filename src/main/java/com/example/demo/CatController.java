package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CatController {

    @Autowired
    private CatService catService;

    @GetMapping("/cats")   
    public Object getAllCats() {
        return catService.getAllCats();
    }

    @GetMapping("/cats/{catId}")
    public Cat getCatById(@PathVariable Long catId) {
        return catService.getCatById(catId);
    }

    @GetMapping("/cats/name/{name}")
    public Object getCatByName(@PathVariable String name) {    
        return catService.getCatByName(name);
    }

    @GetMapping("/cats/description/{description}")
    public Object getCatByDescription(@PathVariable String description) {
        return catService.getCatByDescription(description);
    }

    @GetMapping("/cats/breed/{breed}")
    public Object getCatByBreed(@PathVariable String breed) {
        return catService.getCatByBreed(breed);
    }

    @GetMapping("/cats/age/{age}")
    public Object getCatByAge(@PathVariable int age) {
        return catService.getCatByAge(age);
    }

    @PostMapping("/cats")
    public Object addCat(@RequestBody Cat cat) {
        return catService.addCat(cat);
    }

    @PutMapping("/cats/{catId}")
    public Cat updateCat(@PathVariable Long catId, @RequestBody Cat cat) {
        return catService.updateCat(catId, cat);
    }

    @DeleteMapping("/cats/{catId}")
    public Object deleteCat(@PathVariable Long catId) {
        catService.deleteCat(catId);
        return catService.getAllCats();
    }

    @PostMapping("/cats/write")    
    public Object writeJson(@RequestBody Cat cat) {
        catService.writeJson(cat);
        return catService.writeJson(cat);
    }

    @GetMapping("/cats/read")
    public Object readJson() {
        return catService.readJson();
    }  
}