package com.example.demo.democontroller;

import com.example.demo.DemoService.DemoService;
import com.example.demo.model.Model;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/api")
public class Controller {

    private final DemoService demoService;

    @Autowired
    public Controller(DemoService demoService){
        this.demoService = demoService;
    }

    @PostMapping("/users")
    public Model addName(@RequestBody Model model) {
        return demoService.addName(model);
    }

    @GetMapping(path = "/users")
    public List<Model> getUsers(@RequestParam(name = "name", required = false) String prefix,
                                @RequestParam(name = "gender", required = false) String gender ) {
        return demoService.getNamesStartingWith(prefix, gender);
    }

    @GetMapping(path = "/id/{prefix2}")
    public Model getNameById (@PathVariable("prefix2") Long id) {
        return demoService.getNameById(id);
    }
}
