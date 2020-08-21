package ru.appline.logic;

import java.io.Serializable;
import java.util.*;
import java.io.*;

public class Model implements Serializable {

    private static final Model instance = new Model();

    private final Map<Integer, Pet> map;

    public Model() {
        map = new HashMap<Integer, Pet>();
    }

    public static Model getInstance() {
        return instance;
    }

    public void add(int id, Pet pet) {
        map.put(id, pet);
    }

    public Pet getList(int id) {
       return  map.get(id);
    }

    public Map<Integer, Pet> getAll() {
        return map;
    }

    public void delete(int id) {
        map.remove(id);
    }

}
