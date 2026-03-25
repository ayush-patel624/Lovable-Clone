package com.SpringProject.Lovable_Clone.DTOs.MemberDTO;


import com.SpringProject.Lovable_Clone.Enums.ProjectRole;
import jakarta.validation.constraints.NotNull;

public record UpdateMemberRoleRequest(
        @NotNull ProjectRole role) {
}
