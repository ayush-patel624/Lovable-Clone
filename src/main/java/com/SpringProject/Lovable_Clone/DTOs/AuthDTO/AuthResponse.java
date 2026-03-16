package com.SpringProject.Lovable_Clone.DTOs.AuthDTO;


public record AuthResponse(
        String token ,
        UserProfileResponse user) {

}
