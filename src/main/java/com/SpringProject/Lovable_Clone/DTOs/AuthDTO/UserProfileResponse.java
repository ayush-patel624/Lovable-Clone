package com.SpringProject.Lovable_Clone.DTOs.AuthDTO;

public record UserProfileResponse(
        Long id ,
        String email ,
        String name ,
        String avatarUrl) {

}
