package com.SpringProject.Lovable_Clone.Mapper;

import com.SpringProject.Lovable_Clone.DTOs.ProjectDTO.ProjectResponse;
import com.SpringProject.Lovable_Clone.Entities.Project;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ProjectMapper {

    ProjectResponse toProjectResponse(Project project);
}
