package com.SpringProject.Lovable_Clone.Repository;

import com.SpringProject.Lovable_Clone.Entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}
