package com.SpringProject.Lovable_Clone.Services.Implementation;

import com.SpringProject.Lovable_Clone.DTOs.ProjectDTO.FileContentResponse;
import com.SpringProject.Lovable_Clone.DTOs.ProjectDTO.FileNode;
import com.SpringProject.Lovable_Clone.Services.FileServices;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FileServiceImpl implements FileServices {
    @Override
    public List<FileNode> getFileTree(Long projectId, Long userId) {
        return List.of();
    }

    @Override
    public FileContentResponse getFileContent(Long projectId, String path, Long userId) {
        return null;
    }
}
