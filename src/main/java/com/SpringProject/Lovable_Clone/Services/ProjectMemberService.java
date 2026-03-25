package com.SpringProject.Lovable_Clone.Services;

import com.SpringProject.Lovable_Clone.DTOs.MemberDTO.InviteMemberRequest;
import com.SpringProject.Lovable_Clone.DTOs.MemberDTO.MemberResponse;
import com.SpringProject.Lovable_Clone.DTOs.MemberDTO.UpdateMemberRoleRequest;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface ProjectMemberService {

    List<MemberResponse> getProjectMembers(Long projectId, Long userId);

    MemberResponse inviteMember(Long projectId, InviteMemberRequest request, Long userId);

    MemberResponse updateMemberRole(Long projectId, Long memberId, UpdateMemberRoleRequest request, Long userId);

    void removeProjectMember(Long projectId, Long memberId, Long userId);
}
