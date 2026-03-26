package com.SpringProject.Lovable_Clone.Repository;

import com.SpringProject.Lovable_Clone.Entities.User;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {

    Optional<User> findByUsername(@Email @NotBlank String username);
}
