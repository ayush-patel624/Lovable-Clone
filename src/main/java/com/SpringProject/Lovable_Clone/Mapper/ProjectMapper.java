package com.SpringProject.Lovable_Clone.Mapper;

import com.SpringProject.Lovable_Clone.DTOs.ProjectDTO.ProjectResponse;
import com.SpringProject.Lovable_Clone.DTOs.ProjectDTO.ProjectSummaryResponse;
import com.SpringProject.Lovable_Clone.Entities.Project;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface ProjectMapper {

    ProjectResponse toProjectResponse(Project project);

    ProjectSummaryResponse toProjectSummaryResponse(Project project);

    List<ProjectSummaryResponse>  toListOfProjectSummaryResponse(List<Project> projects);
}
