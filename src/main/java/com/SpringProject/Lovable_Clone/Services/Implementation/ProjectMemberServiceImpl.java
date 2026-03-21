package com.SpringProject.Lovable_Clone.Services.Implementation;

import com.SpringProject.Lovable_Clone.DTOs.MemberDTO.InviteMemberRequest;
import com.SpringProject.Lovable_Clone.DTOs.MemberDTO.MemberResponse;
import com.SpringProject.Lovable_Clone.DTOs.MemberDTO.UpdateMemberRoleRequest;
import com.SpringProject.Lovable_Clone.Services.ProjectMemberService;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class ProjectMemberServiceImpl implements ProjectMemberService {
    @Override
    public List<MemberResponse> getProjectMembers(Long projectId, Long userId) {
        return List.of();
    }

    @Override
    public MemberResponse inviteMember(Long projectId, InviteMemberRequest request, Long userId) {
        return null;
    }

    @Override
    public MemberResponse updateMemberRole(Long projectId, Long memberId, UpdateMemberRoleRequest request, Long userId) {
        return null;
    }

    @Override
    public MemberResponse deleteProjectMember(Long projectId, Long memberId, Long userId) {
        return null;
    }
}
