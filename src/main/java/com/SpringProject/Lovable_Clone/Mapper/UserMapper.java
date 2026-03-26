package com.SpringProject.Lovable_Clone.Mapper;


import com.SpringProject.Lovable_Clone.DTOs.AuthDTO.SignupRequest;
import com.SpringProject.Lovable_Clone.DTOs.AuthDTO.UserProfileResponse;
import com.SpringProject.Lovable_Clone.Entities.User;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface UserMapper {

    User toUserEntity(SignupRequest signupRequest);

    UserProfileResponse toUserProfileResponse(User user);
}
