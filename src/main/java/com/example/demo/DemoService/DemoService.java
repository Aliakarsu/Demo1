package com.example.demo.DemoService;

import com.example.demo.DemoInterface.DemoInterface;
import com.example.demo.model.Model;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class DemoService implements DemoInterface {

    private static List<Model> names = new ArrayList<>();
    static {
        Model model = new Model();
        model.setId(1);
        model.setName("A1");
        model.setGender("male");

        Model model2 = new Model();
        model2.setId(1);
        model2.setName("B1");
        model2.setGender("female");

        Model model3 = new Model();
        model3.setId(3);
        model3.setName("A2");
        model3.setGender("female");

        names.add(model);
        names.add(model2);
        names.add(model3);

    }

    public Model addName(Model model) {
        names.add(model);
        return model;
    }

    public List<Model> getNamesStartingWith(String name, String gender) {
        if (name != null) {
            name = name.toLowerCase();
        }

        List<Model> filteredNames = new ArrayList<>();

        /*
        String finalName = name;
        return names.stream()
                .filter(model -> (finalName == null || model.getName().toLowerCase().startsWith(finalName.toLowerCase())))
                .filter(model -> (gender == null || model.getGender().equals(gender)))
                .collect(Collectors.toList());
                */

        /*
        for (Model model : names) {
            boolean matchesName = (name == null || model.getName().toLowerCase().startsWith(name));
            boolean matchesGender = (gender == null || model.getGender().equals(gender));

            if (matchesName && matchesGender) {
                filteredNames.add(model);
            }
        }
        */

        for (Model model : names) {
            if ((name == null || model.getName().toLowerCase().startsWith(name))
                    &&
                    (gender == null || model.getGender().equals(gender))) {
                filteredNames.add(model);
            }
        }

        return filteredNames;
    }

    public Model getNameById (Long id) {
        return names.stream().filter(model -> id.equals(model.getId())).findFirst().orElse(null);
    }

}
