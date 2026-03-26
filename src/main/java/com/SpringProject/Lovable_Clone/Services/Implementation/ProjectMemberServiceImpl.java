package com.SpringProject.Lovable_Clone.Services.Implementation;

import com.SpringProject.Lovable_Clone.DTOs.MemberDTO.InviteMemberRequest;
import com.SpringProject.Lovable_Clone.DTOs.MemberDTO.MemberResponse;
import com.SpringProject.Lovable_Clone.DTOs.MemberDTO.UpdateMemberRoleRequest;
import com.SpringProject.Lovable_Clone.Entities.Project;
import com.SpringProject.Lovable_Clone.Entities.ProjectMember;
import com.SpringProject.Lovable_Clone.Entities.ProjectMemberId;
import com.SpringProject.Lovable_Clone.Entities.User;
import com.SpringProject.Lovable_Clone.Mapper.ProjectMemberMapper;
import com.SpringProject.Lovable_Clone.Repository.ProjectMemberRepository;
import com.SpringProject.Lovable_Clone.Repository.ProjectRepository;
import com.SpringProject.Lovable_Clone.Repository.UserRepository;
import com.SpringProject.Lovable_Clone.Security.AuthUtil;
import com.SpringProject.Lovable_Clone.Services.ProjectMemberService;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.Instant;
import java.util.List;


@Service
@FieldDefaults(makeFinal = true, level = AccessLevel.PRIVATE)
@RequiredArgsConstructor
@Transactional
public class ProjectMemberServiceImpl implements ProjectMemberService {

    ProjectMemberRepository projectMemberRepository;
    ProjectRepository projectRepository;
    ProjectMemberMapper projectMemberMapper;
    UserRepository userRepository;
    AuthUtil authUtil;

    @Override
    public List<MemberResponse> getProjectMembers(Long projectId) {

        Long userId = authUtil.getCurrentUserId();


        return projectMemberRepository.findByIdProjectId(projectId)
                .stream()
                .map(projectMemberMapper::toProjectMemberResponseFromMember)
                .toList();
    }

    @Override
    public MemberResponse inviteMember(Long projectId, InviteMemberRequest request) {

        Long userId = authUtil.getCurrentUserId();

        Project project = getAccessibleProjectById(projectId, userId);

        User invitee = userRepository.findByUsername(request.username()).orElseThrow();

        if(invitee.getId().equals(userId)){
            throw new RuntimeException("Can't invite yourself");
        }

        ProjectMemberId projectMemberID = new ProjectMemberId(projectId, invitee.getId());

        if(projectMemberRepository.existsById(projectMemberID)){
            throw new RuntimeException("Can't invite once again");
        }

        ProjectMember projectMember = ProjectMember.builder()
                .Id(projectMemberID)
                .project(project)
                .user(invitee)
                .projectRole(request.role())
                .invitedAt(Instant.now())
                .build();

        projectMemberRepository.save(projectMember);

        return projectMemberMapper.toProjectMemberResponseFromMember(projectMember);
    }

    @Override
    public MemberResponse updateMemberRole(Long projectId, Long memberId, UpdateMemberRoleRequest request) {

        ProjectMemberId projectMemberID = new ProjectMemberId(projectId, memberId);
        ProjectMember projectMember = projectMemberRepository.findById(projectMemberID).orElseThrow();

        projectMember.setProjectRole(request.role());
        projectMemberRepository.save(projectMember);
        return projectMemberMapper.toProjectMemberResponseFromMember(projectMember);
    }

    @Override
    public void removeProjectMember(Long projectId, Long memberId) {

        ProjectMemberId projectMemberID = new ProjectMemberId(projectId, memberId);
        if(!projectMemberRepository.existsById(projectMemberID)){
            throw new RuntimeException("Can't find member to remove");
        }
        projectMemberRepository.deleteById(projectMemberID);

    }

    /// INTERNAL FUNCTIONS

    public Project getAccessibleProjectById(Long id, Long userId) {
        return projectRepository.findAccessibleProjectById(id, userId).orElseThrow();
    }
}
