package com.SpringProject.Lovable_Clone.DTOs.MemberDTO;


import com.SpringProject.Lovable_Clone.Enums.ProjectRole;

public record InviteMemberRequest(
        String email,
        ProjectRole role
) {
}
