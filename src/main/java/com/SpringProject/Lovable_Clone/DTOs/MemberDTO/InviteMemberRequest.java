package com.SpringProject.Lovable_Clone.DTOs.MemberDTO;


import com.SpringProject.Lovable_Clone.Enums.ProjectRole;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record InviteMemberRequest(
        @Email
        @NotBlank
        String username,
        @NotNull
        ProjectRole role
) {
}
