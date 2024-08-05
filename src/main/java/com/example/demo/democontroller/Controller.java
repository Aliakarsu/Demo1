package com.example.demo.democontroller;

import com.example.demo.model.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping(path = "/api")
public class Controller {
    private static List<Model> names = new ArrayList<>();


    @PostMapping("/users")
    public Model addName(@RequestBody Model model) {
        names.add(model);
        return model;
    }

    @GetMapping
    public List<Model> getNames() {
        return names;
    }

    @GetMapping(path = "/bas-harf/{prefix}")
    public List<Model> getNamesStartingWith(@PathVariable("prefix") String prefix) {
        String lowerCasePrefix = prefix.toLowerCase();
        return names.stream().filter(model -> model.getName().toLowerCase().startsWith(lowerCasePrefix)).collect(Collectors.toList());
    }
    @GetMapping(path = "/id/{prefix2}")
    public Model getNameById (@PathVariable("prefix2") Long id) {
        return names.stream().filter(model -> id.equals(model.getId())).findFirst().orElse(null);
    }
}
