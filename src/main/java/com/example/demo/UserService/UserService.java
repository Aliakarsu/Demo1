package com.example.demo.UserService;

import com.example.demo.IUser.IUser;
import com.example.demo.User.UserDto;
import com.example.demo.UserRepository.UserRepository;
import com.example.demo.User.UserEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserService implements IUser {

    private final UserRepository UserRepository;
    public List<UserDto> names = new ArrayList<>();

    @Autowired
    public UserService(UserRepository UserRepository) {
        this.UserRepository = UserRepository;
    }

    @Override
    public UserDto addName(UserDto userDto) {

        UserEntity userEntity = new UserEntity();
        userEntity.setName(userDto.getName());
        userEntity.setGender(userDto.getGender());

        UserEntity savedUserEntity = UserRepository.save(userEntity);

        UserDto userDto1 = new UserDto();

        userDto1.setId(savedUserEntity.getId());
        userDto1.setName(savedUserEntity.getName());
        userDto1.setGender(savedUserEntity.getGender());

        names.add(userDto1);
        return userDto1;
    }

    @Override
    public List<UserDto> getNamesStartingWith(String name, String gender) {
        if (name != null) {
            name = name.toLowerCase();
        }
        if (gender != null) {
            gender = gender.toLowerCase();
        }

        List<UserEntity> users = UserRepository.findAll();

        List<UserDto> filteredNames = new ArrayList<>();

        for (UserEntity userEntity : users) {
            String userName = userEntity.getName();
            String userGender = userEntity.getGender();

            if ((name == null || userName.toLowerCase().startsWith(name))
                    &&
                    (gender == null || userGender.toLowerCase().startsWith(gender))) {

                UserDto userDto = new UserDto();
                userDto.setId(userEntity.getId());
                userDto.setName(userName);
                userDto.setGender(userGender);
                filteredNames.add(userDto);
            }
        }
        return filteredNames;
    }

    @Override
    public UserDto getUserById(Long id) {
        UserEntity userEntity = UserRepository.findById(id).orElse(null);
        if (userEntity != null) {

            UserDto userDto = new UserDto();

            userDto.setId(userEntity.getId());
            userDto.setName(userEntity.getName());
            userDto.setGender(userEntity.getGender());

            return userDto;
        }
        return null;
    }

    @Override
    public UserDto deleteUserById(Long id){
        UserEntity userEntity = UserRepository.findById(id).orElse(null);
        if (userEntity != null) {
            UserRepository.delete(userEntity);
            UserDto userDto = new UserDto();
            userDto.setId(userEntity.getId());
            userDto.setName(userEntity.getName());
            userDto.setGender(userEntity.getGender());
            return userDto;
        }
        return null;
    }

    public UserDto updateUserById(UserDto userDto) {
        UserEntity userEntity = UserRepository.findById(userDto.getId()).orElse(null);
        if (userEntity != null) {
            userEntity.setName(userDto.getName());
            userEntity.setGender(userDto.getGender());

            UserRepository.save(userEntity);

            UserDto userDto2 = new UserDto();
            userDto2.setId(userEntity.getId());
            userDto2.setName(userEntity.getName());
            userDto2.setGender(userEntity.getGender());

            return userDto2;
        }
        return null;
    }
}