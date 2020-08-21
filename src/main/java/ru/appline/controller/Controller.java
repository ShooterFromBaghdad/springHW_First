package ru.appline.controller;

import org.springframework.web.bind.annotation.*;
import ru.appline.logic.*;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.*;
import java.io.*;

@RestController
public class Controller {
    private static final Model model = Model.getInstance();
    private static final AtomicInteger id = new AtomicInteger(1);

    @PostMapping(value = "/createPet", consumes = "application/json", produces = "text/html")
    public String createPet(@RequestBody Pet pet) {
        model.add(id.getAndIncrement(), pet);
        return ("Питомец успешно создан!:)");
    }

    @GetMapping(value = "/getAll", produces = "application/json")
    public Map<Integer, Pet>  getAll() {
        return model.getAll();
    }

    @GetMapping(value = "/getPet", produces = "application/json")
    public Pet getPet(@RequestBody Map<String, Integer> id) {
        return model.getList(id.get("id"));
    }

    @PutMapping(value = "/editPet",consumes = "application/json",produces = "text/html")
    public String editPet(@RequestBody Map<String,String> map) {
        Integer id = Integer.parseInt(map.get("id"));
        String name = map.get("name");
        String type = map.get("type");
        Integer age = Integer.parseInt(map.get("age"));
        Pet pet1 = new Pet(name, type, age);
        model.add(id, pet1);

        return ("Пет успешно изменен!:)");
    }

    @DeleteMapping(value = "/deletePet", consumes = "application/json", produces = "text/html")
    public String deletePet(@RequestBody Map<String, String> map) {
        Integer id = Integer.parseInt(map.get("id"));
        model.delete(id);

        return ("Питомец удален:(, больше не нужно");
    }




}
