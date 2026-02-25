package com.example.workintech.ecommege.mapper;
import org.springframework.stereotype.Component;
import com.example.workintech.ecommege.entity.Role;
import com.example.workintech.ecommege.dto.RoleResponse;


@Component
public class RoleMapper {

    public RoleResponse toResponse(Role role) {

        return new RoleResponse(role.getId(), role.getName(), role.getCode());
    }


}

