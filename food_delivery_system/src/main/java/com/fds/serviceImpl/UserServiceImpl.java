package com.fds.serviceImpl;

import com.fds.entity.User;
import com.fds.repository.UserRepository;
import com.fds.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public User saveUser(User user) {
        // Validate user before saving if needed
        return userRepository.save(user);
    }

    @Override
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    @Override
    public User getUserById(Long id) {
        Optional<User> user = userRepository.findById(id);
        if (user.isPresent()) {
            return user.get();
        } else {
            // Handle user not found case, maybe log it or throw a custom exception
            System.out.println("User not found with id: " + id);
            return null; // or throw a custom exception
        }
    }

    @Override
    public User updateUser(Long id, User user) {
        if (userRepository.existsById(id)) {
            user.setId(id);
            return userRepository.save(user);
        } else {
            // Handle user not found case, maybe log it or throw a custom exception
            System.out.println("Cannot update. User not found with id: " + id);
            return null; // or throw a custom exception
        }
    }

    @Override
    public void deleteUser(Long id) {
        if (userRepository.existsById(id)) {
            userRepository.deleteById(id);
        } else {
            // Handle user not found case
            System.out.println("Cannot delete. User not found with id: " + id);
        }
    }
}
