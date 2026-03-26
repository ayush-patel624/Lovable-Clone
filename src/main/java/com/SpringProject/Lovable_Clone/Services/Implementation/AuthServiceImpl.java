package com.SpringProject.Lovable_Clone.Services.Implementation;

import com.SpringProject.Lovable_Clone.DTOs.AuthDTO.AuthResponse;
import com.SpringProject.Lovable_Clone.DTOs.AuthDTO.LoginRequest;
import com.SpringProject.Lovable_Clone.DTOs.AuthDTO.SignupRequest;
import com.SpringProject.Lovable_Clone.Entities.User;
import com.SpringProject.Lovable_Clone.Error.BadRequestException;
import com.SpringProject.Lovable_Clone.Mapper.UserMapper;
import com.SpringProject.Lovable_Clone.Repository.UserRepository;
import com.SpringProject.Lovable_Clone.Security.AuthUtil;
import com.SpringProject.Lovable_Clone.Services.AuthService;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;


@Service
@RequiredArgsConstructor
@FieldDefaults(makeFinal = true , level = AccessLevel.PRIVATE)
public class AuthServiceImpl implements AuthService {

    UserRepository userRepository;
    UserMapper userMapper;
    PasswordEncoder passwordEncoder;
    AuthUtil authUtil;
    AuthenticationManager authenticationManager;

    @Override
    public AuthResponse signup(SignupRequest signupRequest) {
        userRepository.findByUsername(signupRequest.username()).ifPresent(user ->{
                throw new BadRequestException("Username is already in use");
        });

        User user = userMapper.toUserEntity(signupRequest);
        user.setPassword(passwordEncoder.encode(signupRequest.password()));
        user = userRepository.save(user);

        String token = authUtil.generateAccessToken(user);

        return new AuthResponse(token , userMapper.toUserProfileResponse(user));
    }

    @Override
    public AuthResponse login(LoginRequest loginRequest) {

        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(loginRequest.username(), loginRequest.password() )
        );

        User user = (User) authentication.getPrincipal();

        String token = authUtil.generateAccessToken(user);

        return new AuthResponse(token , userMapper.toUserProfileResponse(user));
    }
}
