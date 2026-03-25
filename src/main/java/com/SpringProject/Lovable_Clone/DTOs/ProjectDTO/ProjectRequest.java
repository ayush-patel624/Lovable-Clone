package com.SpringProject.Lovable_Clone.DTOs.ProjectDTO;

import jakarta.validation.constraints.NotBlank;

public record ProjectRequest(
        @NotBlank String name
) {

}
