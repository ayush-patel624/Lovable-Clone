package com.SpringProject.Lovable_Clone.Services;

import com.SpringProject.Lovable_Clone.DTOs.ProjectDTO.FileContentResponse;
import com.SpringProject.Lovable_Clone.DTOs.ProjectDTO.FileNode;

import java.util.List;

public interface FileServices {
    List<FileNode> getFileTree(Long projectId, Long userId);

    FileContentResponse getFileContent(Long projectId, String path, Long userId);
}
