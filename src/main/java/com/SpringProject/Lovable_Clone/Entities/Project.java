package com.SpringProject.Lovable_Clone.Entities;

import lombok.*;
import lombok.experimental.FieldDefaults;

import java.time.Instant;

@Getter
@Setter
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Project {

    Long id;

    String name;

    User user;

    Boolean isPublic;

    Instant createdAt;
    Instant updatedAt;
    Instant deletedAt;
}
