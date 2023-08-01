package com.example.BankAccountManager.User;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service

public class UserService {
    private final UserRepository userRepository;
    @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public List<User> getUser(){

        return userRepository.findAll();
//
    }

    public void addNewUser(User user) {
        Optional<User> emailExist = userRepository.findUserByEmail(user.getEmail());
        if(emailExist.isPresent()){
            throw new IllegalStateException("Email Taken");
        }
        userRepository.save(user);
    }

    public void updateUser(Long id, User updatedUser) {
        User existingUser = userRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("User not found with id: " + id));

        // Update the properties of the existing user
        existingUser.setFirstName(updatedUser.getFirstName());
        existingUser.setEmail(updatedUser.getEmail());
        existingUser.setLastName(updatedUser.getLastName());
        existingUser.setUserName(updatedUser.getUserName());
        existingUser.setInstitutionID(updatedUser.getInstitutionID());
        existingUser.setBranchID(updatedUser.getBranchID());
        existingUser.setRoleID(updatedUser.getRoleID());

        userRepository.save(existingUser);
    }

    public void deleteUser(Long id) {
        // Check if the student exists
        if (!userRepository.existsById(id)) {
            throw new IllegalArgumentException("User not found with id: " + id);
        }

        userRepository.deleteById(id);
    }
}
