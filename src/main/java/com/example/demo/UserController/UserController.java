package com.example.demo.UserController;

import com.example.demo.User.UserDto;
import com.example.demo.UserService.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/api")
public class UserController {

    private final UserService userService;

    @Autowired
    public UserController(UserService userService){
        this.userService = userService;
    }

    @PostMapping("/users")
    public UserDto addName(@RequestBody UserDto userDto) {
        return userService.addName(userDto);
    }

    @GetMapping(path = "/users")
    public List<UserDto> getNamesStartingWith(@RequestParam(name = "name", required = false) String name,
                                              @RequestParam(name = "gender", required = false) String gender ) {
        return userService.getNamesStartingWith(name, gender);
    }

    @GetMapping(path = "/id/{prefix2}")
    public UserDto getUserById(@PathVariable("prefix2") Long id) {
        return userService.getUserById(id);
    }

    @DeleteMapping(path = "id/{prefix3}")
    public UserDto deleteUserById(@PathVariable("prefix3") Long id) {
        return userService.deleteUserById(id);
    }

    @PutMapping(path = "/id")
    public UserDto updateUserById(@RequestParam(name = "id") Long id,
                                  @RequestParam(name = "name", required = false)String name,
                                  @RequestParam(name = "gender", required = false)String gender) {
        UserDto user = userService.getUserById(id);
        if (user == null) {
            return null;
        }
        if (name != null) {
            user.setName(name);
        }
        if (gender != null) {
            user.setGender(gender);
        }
        return userService.updateUserById(user);

        /*
        UserDto userDto = new UserDto();
        userDto.setId(id);
        userDto.setName(name);
        userDto.setGender(gender);
        return userService.updateUserById(userDto);
         */
    }
}