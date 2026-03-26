package com.SpringProject.Lovable_Clone.Services.Implementation;

import com.SpringProject.Lovable_Clone.DTOs.ProjectDTO.ProjectRequest;
import com.SpringProject.Lovable_Clone.DTOs.ProjectDTO.ProjectResponse;
import com.SpringProject.Lovable_Clone.DTOs.ProjectDTO.ProjectSummaryResponse;
import com.SpringProject.Lovable_Clone.Entities.Project;
import com.SpringProject.Lovable_Clone.Entities.ProjectMember;
import com.SpringProject.Lovable_Clone.Entities.ProjectMemberId;
import com.SpringProject.Lovable_Clone.Entities.User;
import com.SpringProject.Lovable_Clone.Enums.ProjectRole;
import com.SpringProject.Lovable_Clone.Error.ResourceNotFoundException;
import com.SpringProject.Lovable_Clone.Mapper.ProjectMapper;
import com.SpringProject.Lovable_Clone.Repository.ProjectMemberRepository;
import com.SpringProject.Lovable_Clone.Repository.ProjectRepository;
import com.SpringProject.Lovable_Clone.Repository.UserRepository;
import com.SpringProject.Lovable_Clone.Security.AuthUtil;
import com.SpringProject.Lovable_Clone.Services.ProjectService;
import jakarta.transaction.Transactional;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.util.List;


@Service
@RequiredArgsConstructor
@FieldDefaults(makeFinal = true , level = AccessLevel.PRIVATE)
@Transactional
public class ProjectServiceImpl implements ProjectService {

    ProjectRepository projectRepository;
    UserRepository  userRepository;
    ProjectMapper projectMapper;
    ProjectMemberRepository projectMemberRepository;
    AuthUtil  authUtil;

    @Override
    public List<ProjectSummaryResponse> getUserProjects() {
        Long userId = authUtil.getCurrentUserId();
        return projectMapper.toListOfProjectSummaryResponse(projectRepository.findAllAccessibleByUser(userId));

    }

    @Override
    public ProjectResponse getUserProjectById(Long id) {
        Long userId = authUtil.getCurrentUserId();
        Project project =  getAccessibleProjectById(id,userId);
        return projectMapper.toProjectResponse(project);
    }

    @Override
    public ProjectResponse createProject(ProjectRequest request) {
        Long userId = authUtil.getCurrentUserId();

//      User owner = userRepository.findById(userId).orElseThrow(
//      ()-> new ResourceNotFoundException("User" , userId.toString())
//      );

        User owner = userRepository.getReferenceById(userId);

       Project project = Project.builder()
               .name(request.name())
               .isPublic(false)
               .build();

       project = projectRepository.save(project);

       ProjectMemberId projectMemberID = new ProjectMemberId(project.getId(), owner.getId());
       ProjectMember projectMember = ProjectMember.builder()
                .Id(projectMemberID)
                .projectRole(ProjectRole.OWNER)
                .user(owner)
                .acceptedAt(Instant.now())
                .invitedAt(Instant.now())
                .project(project)
                .build();


       projectMemberRepository.save(projectMember);

       return projectMapper.toProjectResponse(project);

    }

    @Override
    public ProjectResponse updateProject(Long id, ProjectRequest request) {
        Long userId = authUtil.getCurrentUserId();
        Project project = getAccessibleProjectById(id,userId);
        project.setName(request.name());
        project = projectRepository.save(project);
        return projectMapper.toProjectResponse(project);

    }

    @Override
    public void softDelete(Long id) {
        Long userId = authUtil.getCurrentUserId();
        Project project = getAccessibleProjectById(id,userId);


        project.setDeletedAt(Instant.now());
        projectRepository.save(project);
    }

    /// INTERNAL FUNCTIONS

    public Project getAccessibleProjectById(Long id, Long userId) {
        return projectRepository.findAccessibleProjectById(id,userId)
                .orElseThrow(() -> new ResourceNotFoundException("Project" , "id"));
    }
}
