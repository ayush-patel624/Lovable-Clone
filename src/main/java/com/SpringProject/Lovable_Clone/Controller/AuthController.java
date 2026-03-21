package com.SpringProject.Lovable_Clone.Controller;

import com.SpringProject.Lovable_Clone.DTOs.AuthDTO.AuthResponse;
import com.SpringProject.Lovable_Clone.DTOs.AuthDTO.LoginRequest;
import com.SpringProject.Lovable_Clone.DTOs.AuthDTO.SignupRequest;
import com.SpringProject.Lovable_Clone.DTOs.AuthDTO.UserProfileResponse;
import com.SpringProject.Lovable_Clone.Services.AuthService;
import com.SpringProject.Lovable_Clone.Services.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/auth")
public class AuthController {

     private final AuthService authService;
     private final UserService userService;

    @PostMapping("/signup")
    public ResponseEntity<AuthResponse> signup(@RequestBody SignupRequest signupRequest){
        return ResponseEntity.ok(authService.signup(signupRequest));
    }

    @PostMapping("/login")
    public ResponseEntity<AuthResponse> login(@RequestBody LoginRequest loginRequest){
        return ResponseEntity.ok(authService.login(loginRequest));
    }

    @GetMapping("/me")
    public ResponseEntity<UserProfileResponse> getProfile(){
        Long userID = 1L;
        return ResponseEntity.ok(userService.getProfile(userID));
    }




}
