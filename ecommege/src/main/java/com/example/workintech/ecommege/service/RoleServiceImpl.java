package com.example.workintech.ecommege.service;
import java.util.List;
import org.springframework.stereotype.Service;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import com.example.workintech.ecommege.repository.RoleRepository;
import com.example.workintech.ecommege.mapper.RoleMapper;
import com.example.workintech.ecommege.dto.RoleResponse;


@Service
@RequiredArgsConstructor
public class RoleServiceImpl implements RoleService {
    @Autowired
    private final RoleRepository roleRepository;

    @Autowired
    private final RoleMapper roleMapper;

    @Override
    public List<RoleResponse> getRoles() {
        return roleRepository.findAll().stream().map(roleMapper::toResponse).toList();

    }


}

