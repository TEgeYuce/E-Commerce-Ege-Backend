package com.example.workintech.ecommege.controller;
import java.util.List;
import org.springframework.web.bind.annotation.RestController;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import com.example.workintech.ecommege.service.RoleService;
import com.example.workintech.ecommege.dto.RoleResponse;


@RestController
@RequiredArgsConstructor
public class RoleController {

    private final RoleService roleService;

    @GetMapping("/roles")
    public List<RoleResponse> getRoles() {
        return roleService.getRoles();

    }


}

