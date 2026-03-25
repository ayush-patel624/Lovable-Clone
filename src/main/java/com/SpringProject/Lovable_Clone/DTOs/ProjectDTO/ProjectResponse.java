package com.SpringProject.Lovable_Clone.DTOs.ProjectDTO;

import com.SpringProject.Lovable_Clone.DTOs.AuthDTO.UserProfileResponse;

import java.time.Instant;

public record ProjectResponse(
        Long id,
        String name,
        Instant createdAt,
        Instant updatedAt
) {
}
