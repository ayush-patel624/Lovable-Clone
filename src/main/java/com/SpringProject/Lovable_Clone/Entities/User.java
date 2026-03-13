package com.SpringProject.Lovable_Clone.Entities;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.FieldDefaults;

import java.time.Instant;

@FieldDefaults(level = AccessLevel.PRIVATE)
@Getter
@Setter
public class User {

     Long id;

     String email;
     String passwordHash;
     String name;
     String avatarUrl;

     Instant createdAt;
     Instant updatedAt;
     Instant deletedAt; // soft delete

}
