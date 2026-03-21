package com.SpringProject.Lovable_Clone.Services.Implementation;

import com.SpringProject.Lovable_Clone.DTOs.AuthDTO.AuthResponse;
import com.SpringProject.Lovable_Clone.DTOs.AuthDTO.LoginRequest;
import com.SpringProject.Lovable_Clone.DTOs.AuthDTO.SignupRequest;
import com.SpringProject.Lovable_Clone.Services.AuthService;
import org.springframework.stereotype.Service;


@Service
public class AuthServiceImpl implements AuthService {
    @Override
    public AuthResponse signup(SignupRequest signupRequest) {
        return null;
    }

    @Override
    public AuthResponse login(LoginRequest loginRequest) {
        return null;
    }
}
