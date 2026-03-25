package com.SpringProject.Lovable_Clone.Services.Implementation;

import com.SpringProject.Lovable_Clone.DTOs.ProjectDTO.ProjectRequest;
import com.SpringProject.Lovable_Clone.DTOs.ProjectDTO.ProjectResponse;
import com.SpringProject.Lovable_Clone.DTOs.ProjectDTO.ProjectSummaryResponse;
import com.SpringProject.Lovable_Clone.Entities.Project;
import com.SpringProject.Lovable_Clone.Entities.User;
import com.SpringProject.Lovable_Clone.Error.ResourceNotFoundException;
import com.SpringProject.Lovable_Clone.Mapper.ProjectMapper;
import com.SpringProject.Lovable_Clone.Repository.ProjectRepository;
import com.SpringProject.Lovable_Clone.Repository.UserRepository;
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

    @Override
    public List<ProjectSummaryResponse> getUserProjects(Long userId) {

        return projectMapper.toListOfProjectSummaryResponse(projectRepository.findAllAccessibleByUser(userId));

//        return projectRepository.findAllAccessibleByUser(userId)
//                .stream()
//                .map(projectMapper::toProjectSummaryResponse)
//                .collect(Collectors.toList());
    }

    @Override
    public ProjectResponse getUserProjectById(Long id, Long userId) {
        Project project =  getAccessibleProjectById(id,userId);
        return projectMapper.toProjectResponse(project);
    }

    @Override
    public ProjectResponse createProject(ProjectRequest request, Long userId) {
       User owner = userRepository.findById(userId).orElseThrow();

       Project project = Project.builder()
               .name(request.name())
               .owner(owner)
               .isPublic(false)
               .build();

       project = projectRepository.save(project);

       return projectMapper.toProjectResponse(project);

    }

    @Override
    public ProjectResponse updateProject(Long id, ProjectRequest request, Long userId) {
        Project project = getAccessibleProjectById(id,userId);
        project.setName(request.name());
        project = projectRepository.save(project);
        return projectMapper.toProjectResponse(project);

    }

    @Override
    public void softDelete(Long id, Long userId) {
        Project project = getAccessibleProjectById(id,userId);

        if(!project.getOwner().getId().equals(userId)) {
            throw new RuntimeException("You are not allowed to delete this project");
        }

        project.setDeletedAt(Instant.now());
        projectRepository.save(project);
    }

    /// INTERNAL FUNCTIONS

    public Project getAccessibleProjectById(Long id, Long userId) {
        return projectRepository.findAccessibleProjectById(id,userId)
                .orElseThrow(() -> new ResourceNotFoundException("Project" , id));
    }
}
