package com.example.DiagnoShare.Service;

import com.example.DiagnoShare.Repository.UserRepository;
import com.example.DiagnoShare.Security.JwtService;
import com.example.DiagnoShare.dtos.AuthResponseDTO;
import com.example.DiagnoShare.dtos.LoginRequestDTO;
import com.example.DiagnoShare.exceptions.ResourceNotFoundException;
import com.example.DiagnoShare.models.User;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;
    private final JwtService jwtService;


    public AuthResponseDTO login(LoginRequestDTO request) {
        User user = userRepository.findByEmail(request.getEmail()).orElseThrow(()->new RuntimeException("Invalid email or password"));
        if(!user.getPassword().equals(request.getPassword())){
            throw new RuntimeException("Invalid email or password");
        }
        String jwtToken = jwtService.generateJwtToken(user.getEmail());
        return new AuthResponseDTO(jwtToken);
    }

    public User registerUser(User user) {
        return userRepository.save(user);
    }
    public User getUserById(Long Id) {
        return userRepository.findById(Id).orElseThrow(()->new ResourceNotFoundException("User id "+Id+" not exists in our system."));
    }
}
