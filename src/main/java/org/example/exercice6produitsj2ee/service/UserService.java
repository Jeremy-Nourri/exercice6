package org.example.exercice6produitsj2ee.service;

import org.example.exercice6produitsj2ee.exeption.NotFoundException;
import org.example.exercice6produitsj2ee.exeption.UserAlreadyExists;
import org.example.exercice6produitsj2ee.exeption.WrongPasswordException;
import org.example.exercice6produitsj2ee.model.User;
import org.example.exercice6produitsj2ee.repository.UserRepository;

import java.util.List;

public class UserService {

    private UserRepository userRepository = new UserRepository();

    public User signUp (String email, String password, String name) {

        User user = new User(email, password, name);
        User userFound = userRepository.findByEmail(email);
        System.out.println(userFound);
        if (userFound == null) {
            return userRepository.add(user);
        } else {
            throw new UserAlreadyExists("User already exists");
        }
    }

    public User findById(int id) {
        User userFound = userRepository.findById(id);
        if (userFound != null) {
            return userFound;
        } else {
            throw new NotFoundException("User not found");
        }
    }

    public User signin(String email, String password) {
        User userFound = userRepository.findByEmail(email);
        if (userFound != null) {
            if (password.equals(userFound.getPassword())){
                return userFound;
            } else {
              throw new WrongPasswordException("Wrong password");
            }
        } else {
            throw new NotFoundException("User not found");
        }
    }


}
