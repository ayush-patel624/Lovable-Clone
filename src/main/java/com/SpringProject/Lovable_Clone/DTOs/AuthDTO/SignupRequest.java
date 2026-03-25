package com.SpringProject.Lovable_Clone.DTOs.AuthDTO;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public record SignupRequest(
       @Size(min=1, max = 50) String name ,
       @Email @NotBlank String email ,
       @Size (min=4 , max=30) String password
) {

}
