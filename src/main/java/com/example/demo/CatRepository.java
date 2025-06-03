package com.example.demo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface CatRepository extends JpaRepository<Cat, Long> {

    List<Cat> getCatByBreed(String breed);

    @Query(value = "select * from cats c where c.name like %?1%", nativeQuery = true)
    List<Cat> getCatByName(String name);

    @Query(value = "select * from cats c where c.description like %?1%", nativeQuery = true)
    List<Cat> getCatByDescription(String description);

    @Query(value = "select * from cats c where c.age like %?1%", nativeQuery = true)
    List<Cat> getCatByAge(int age);
}