package com.SpringProject.Lovable_Clone.Controller;


import com.SpringProject.Lovable_Clone.DTOs.ProjectDTO.FileContentResponse;
import com.SpringProject.Lovable_Clone.DTOs.ProjectDTO.FileNode;
import com.SpringProject.Lovable_Clone.Services.FileServices;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/projects/{projectId}/files")
@RequiredArgsConstructor
public class FileController {

    private final FileServices fileServices;

    @GetMapping
    public ResponseEntity<List<FileNode>> getFileTree(@PathVariable Long projectId) {
        Long userId = 1L;

        return ResponseEntity.ok(fileServices.getFileTree(projectId , userId));
    }

    @GetMapping("/{*path}")
    public ResponseEntity<FileContentResponse> getFile(@PathVariable Long projectId , @PathVariable String path){

        Long userId = 1L;
        return  ResponseEntity.ok(fileServices.getFileContent(projectId, path , userId ));
    }

}
