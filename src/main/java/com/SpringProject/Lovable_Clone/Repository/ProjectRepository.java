package com.SpringProject.Lovable_Clone.Repository;

import com.SpringProject.Lovable_Clone.Entities.Project;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ProjectRepository extends JpaRepository<Project, Long> {

    @Query("""
            SELECT pm.project
            FROM ProjectMember pm
            WHERE pm.user.id = :userId
            AND pm.project.deletedAt IS NULL
            ORDER BY pm.project.updatedAt DESC
""")
    List<Project> findAllAccessibleByUser(@Param("userId") Long userId);

    @Query("""
           SELECT pm.project
           FROM ProjectMember pm
           WHERE pm.project.id = :projectId
           AND pm.user.id = :userId
           AND pm.project.deletedAt IS NULL
""")
    Optional<Project> findAccessibleProjectById(@Param("projectId") Long projectId,
                                                @Param("userId") Long userId);
}
