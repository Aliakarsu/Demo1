package com.example.demo.User;

public class UserDto {

    private Long id;

    private String name;
    private String gender;

    public UserDto() {
    }

    public UserDto(Long id, String name, String gender) {
        this.id = id;
        this.name = name;
        this.gender = gender;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }
}
