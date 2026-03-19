package com.SpringProject.Lovable_Clone.DTOs.MemberDTO;


import com.SpringProject.Lovable_Clone.Enums.ProjectRole;

import java.time.Instant;

public record MemberResponse(
        Long userId,
        String email,
        String name,
        String avatarUrl,
        ProjectRole role,
        Instant invitedAt
) {
}
