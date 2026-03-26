package com.SpringProject.Lovable_Clone.Services;

import com.SpringProject.Lovable_Clone.DTOs.ProjectDTO.ProjectRequest;
import com.SpringProject.Lovable_Clone.DTOs.ProjectDTO.ProjectResponse;
import com.SpringProject.Lovable_Clone.DTOs.ProjectDTO.ProjectSummaryResponse;

import java.util.List;

public interface ProjectService {

    List<ProjectSummaryResponse> getUserProjects();

    ProjectResponse getUserProjectById(Long id );

    ProjectResponse createProject(ProjectRequest request );

    ProjectResponse updateProject(Long id, ProjectRequest request );

    void softDelete(Long id );
}
