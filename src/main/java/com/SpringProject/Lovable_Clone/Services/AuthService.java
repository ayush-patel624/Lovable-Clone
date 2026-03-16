package com.SpringProject.Lovable_Clone.Services;

import com.SpringProject.Lovable_Clone.DTOs.AuthDTO.AuthResponse;
import com.SpringProject.Lovable_Clone.DTOs.AuthDTO.LoginRequest;
import com.SpringProject.Lovable_Clone.DTOs.AuthDTO.SignupRequest;

public interface AuthService {
    AuthResponse signup(SignupRequest signupRequest);

    AuthResponse login(LoginRequest loginRequest);
}
