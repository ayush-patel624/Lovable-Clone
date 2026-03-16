package com.SpringProject.Lovable_Clone.Services;

import com.SpringProject.Lovable_Clone.DTOs.AuthDTO.UserProfileResponse;

public interface UserService {

    UserProfileResponse getProfile(Long userID);
}
