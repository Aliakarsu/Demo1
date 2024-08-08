package com.example.demo.DemoInterface;

import com.example.demo.model.Model;

import java.util.List;

public interface DemoInterface {

    Model addName(Model model);
    List<Model> getNamesStartingWith(String name, String gender);
    Model getNameById (Long id);

}
