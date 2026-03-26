package com.SpringProject.Lovable_Clone.Mapper;

import com.SpringProject.Lovable_Clone.DTOs.MemberDTO.MemberResponse;
import com.SpringProject.Lovable_Clone.Entities.ProjectMember;
import com.SpringProject.Lovable_Clone.Entities.User;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface ProjectMemberMapper {

    @Mapping(target = "userId" , source = "id")
    @Mapping(target = "role" , constant = "OWNER")
    MemberResponse toProjectMemberResponseFromOwner(User user);

    @Mapping(target="userId" , source = "user.id")
    @Mapping(target="username" , source = "user.username")
    @Mapping(target="name" , source = "user.name")
    @Mapping(target="role" , source="projectRole")
    MemberResponse toProjectMemberResponseFromMember(ProjectMember projectMember);
}
