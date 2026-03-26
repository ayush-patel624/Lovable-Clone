package com.SpringProject.Lovable_Clone.DTOs.AuthDTO;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public record LoginRequest(
        @Email @NotBlank String username ,
        @Size(min=4 , max = 50) String password
) {

}
