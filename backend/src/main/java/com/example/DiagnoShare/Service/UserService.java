package com.example.DiagnoShare.Service;

import com.example.DiagnoShare.Repository.UserRepository;
import com.example.DiagnoShare.exceptions.ResourceNotFoundException;
import com.example.DiagnoShare.models.User;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;
    public User registerUser(User user) {
        return userRepository.save(user);
    }
    public User getUserById(Long Id) {
        return userRepository.findById(Id).orElseThrow(()->new ResourceNotFoundException("User id "+Id+" not exists in our system."));
    }
}
